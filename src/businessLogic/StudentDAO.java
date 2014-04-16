package businessLogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.StudentBeans;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Jack Young
 * @date April 01, 2014
 * SWE 642
 * 
 * Class Purpose:  The purpose of this class is to encapsulate the business logic for storing
 * and reading the Survey data from and to the text file.  In addition, this class contains the
 * method used for calculating the mean and standard deviation based on the users inputed
 * raffle numbers.    
 * 
 */
public class StudentDAO {

	private static final String PERSISTENCE_UNIT_NAME = "studentbeanss";
	private static EntityManagerFactory factory;

	  public static List<StudentBeans> retrieveAllSurveys() {
		  System.out.println("[INFO] - Method Called :=: retrieveAllSurveys");
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin(); 
		    Query q = em.createQuery("select t from StudentBean t");
		    q.setHint("eclipselink.refresh", "true");
		    @SuppressWarnings("unchecked")
			List<StudentBeans> s = q.getResultList();
		    em.close();
		    return s;
	  }


	  public static boolean insertStudentSurveyRecord(StudentBeans newStudent) {
		  	System.out.println("[INFO] - Method Called :=: insertStudentSurveyRecord");
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin(); 
		    em.persist(newStudent);
		    em.getTransaction().commit();
		    em.close();
		    return true;
	  }
	
	  public static List<String> gatherIDs() {
		  System.out.println("[INFO] - Method Called :=: gatherIDs");
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin(); 
		    Query q = em.createQuery("select t from StudentBean t");
		    q.setHint("eclipselink.refresh", "true");
		    @SuppressWarnings("unchecked")
			List<StudentBeans> s = q.getResultList();
		    em.close();
		    
			List<String> temp = new ArrayList<String>();
			if (s.size() > 0) {
			for (int i = 0; i < s.size(); i++) {
				temp.add(s.get(i).getStudentID());
			}
			}
			return temp;
	  }
	 
	public static String FILENAME;
		
	/**
	 * This method is used to write the student object
	 * to the text file. 
	 * 
	 * @param student
	 */
	public static void writeOutID(String s) {
		writeToFile(s);
	}


	/**
	 * This method is used to reads in the data in the txt file,
	 * it then creates the students based on those entries.
	 * Then returns the list of students to the calling method.  
	 * 
	 * @return list of students
	 */
	public static List<String> readIn() {
		List<String> temp = readFromFile();
		List<String> ids = new ArrayList<String>();
		if (temp.size() > 0) {
			for (int i = 0; i < temp.size(); i++) {
				ids.add(temp.get(i));
			}
		} else {
			System.out.println("Error, there was nothing to read in from the text file.");
		}
		return ids;
	}
	
	
	
	/**
	 * This method is used to write the passed in text
	 * to the text file.  
	 * @param txt
	 */
	private static void writeToFile(String txt) {
		try {
			File file = new File(FILENAME);
			if (!file.exists()) {
				System.out.println("File did not exist");
				file.createNewFile();
			}	
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(txt);
			bw.close();
			System.out.println("Done writing to file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method reads in from the Specified Text File and returns
	 * a List<String>.  Each index of that list represents one entry
	 * (i.e. one line) from the text file.  
	 * 
	 * @return list
	 */
	private static List<String> readFromFile() {
		List<String> lines = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(FILENAME);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String fullLine;
			
			while ((fullLine = br.readLine()) != null)   {
				if (!fullLine.isEmpty())
					lines.add(fullLine);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return lines;
	}

	
}
