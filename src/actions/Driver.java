package actions;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import businessLogic.DataProcessor;
import businessLogic.StudentDAO;
import model.DataBeans;
import model.StudentBeans;

/**
 * @author Jack Young
 * @date April 16, 2014
 * SWE 642
 * 
 * The Driver class is used as the main action class in this struts application.  It is
 * responsible for handling the user interactions; which are simply survey form submission
 * and detailed user view selection. 
 */
@SuppressWarnings("rawtypes")
public class Driver extends ActionSupport implements ModelDriven, ServletContextAware {
	
	private static final long serialVersionUID = 1L;
	private StudentBeans studentBean;
	private DataBeans dataBean;
	private List<StudentBeans> allTakenSurveys;
	private ServletContext servletContext;
	private StudentBeans selectedStudent;

	//no-arg constructor
    public Driver() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * This method is called when a user select a studentID from the list of
	 * ID's in the left column of the page.
	 * 
	 * @return String
	 */
	public String gotoDetailedStudentView() {
		System.out.println("[INFO] :=:  gotoDetailedStudentView() method called in the Driver Action Class");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String uuid = request.getParameter("uuid");
		System.out.println("[INFO] :=: AJAX Delete ID passed in: " + uuid);

		// retrieving all the survey from the DB.
		setAllTakenSurveys(StudentDAO.retrieveAllSurveys());

		if (allTakenSurveys != null) {
			for (int i = 0; i < allTakenSurveys.size(); i++) {
				if (uuid.equals(allTakenSurveys.get(i).getStudentID())) {
					setSelectedStudent(allTakenSurveys.get(i));
				}
			}
		} else {
			return "error";
		}
		return "success";
	}
	
	
	/**
	 * This method is called when a user submits the survey form.
	 * Once the form is submitted, the data is persisted and the user
	 * is then redirected to a acknowledgment page depending on their
	 * raffle average.  
	 * 
	 * @return String
	 */
	public String submit() {
		System.out.println("[INFO] :=:  doGet() method called in the Driver Action Class");
		StudentDAO.FILENAME = servletContext.getRealPath("SurveyData_JackYoung.txt");
		System.out.println("[Text File Location] :=: " + StudentDAO.FILENAME);
		
		System.out.println("Hello Was Called " + studentBean);
		
		//Writing the students information to the text file.
		StudentDAO.writeOutID(studentBean.getStudentID());
		
		boolean succInsert = StudentDAO.insertStudentSurveyRecord(studentBean);
		if (succInsert) {
			System.out.println("[INFO] Student Survey was successfully inserted into the Database");
		} else {
			System.out.println("[ERROR] The Student Survey was not successfully inserted into the Database.");
		}
		
		//Calculating the Mean and STDV and setting the databean
		dataBean = DataProcessor.computeMetrics(studentBean.getRaffle());
		
		//retrieving all the previously taken surveys
		setAllTakenSurveys(StudentDAO.retrieveAllSurveys());
		
		servletContext.setAttribute("compMean", getDataBean().getMean());
		servletContext.setAttribute("compStdv", getDataBean().getStdv());

		if (dataBean.getMean() > 90) {
			return "winner";
		}
		return "success";
	}
	
	//========= GETTERS & SETTERS ==============
	/**
	 * @return the selectedStudent
	 */
	public StudentBeans getSelectedStudent() {
		return selectedStudent;
	}

	/**
	 * @param selectedStudent the selectedStudent to set
	 */
	public void setSelectedStudent(StudentBeans selectedStudent) {
		this.selectedStudent = selectedStudent;
	}
	
	public List<StudentBeans> getAllTakenSurveys() {
		return allTakenSurveys;
	}

	public void setAllTakenSurveys(List<StudentBeans> allTakenSurveys) {
		this.allTakenSurveys = allTakenSurveys;
	}
	
	/**
	 * @return the servletContext
	 */
	public ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * @param servletContext the servletContext to set
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	/**
	 * @return the studentBean
	 */
	public StudentBeans getStudentBean() {
		return studentBean;
	}

	/**
	 * @param studentBean the studentBean to set
	 */
	public void setStudentBean(StudentBeans studentBean) {
		this.studentBean = studentBean;
	}
	
	/**
	 * @return the dataBean
	 */
	public DataBeans getDataBean() {
		return dataBean;
	}

	/**
	 * @param dataBean the dataBean to set
	 */
	public void setDataBean(DataBeans dataBean) {
		this.dataBean = dataBean;
	}
	
	@Override
	public Object getModel() {
		studentBean = new StudentBeans();
		return studentBean;
	}
	
}
