package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Jack Young
 * @date April 1, 2014
 * SWE 642
 * 
 * Class Purpose: This class contains the fields/attributes that were
 * specified in the instructions.  These attributes match the fields on
 * the student survey form.  
 * 
 */

@Entity
public class StudentBeans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int s_id;
	private String fullName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String email;
	private String dateOfSurvey;
	private String likedAboutCampus;
	private String originOfInterest;
	private String likelyhoodOfRecommendation;
	private String gradMonth;
	private String GraduationYear;
	private String raffle;
	private String comments;
	private String username;
	private String studentID;
	
	/**
	 * No arg Constructor
	 */
	public StudentBeans() {
		this.fullName = "";
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.telephoneNumber = "";
		this.email = "";
		this.dateOfSurvey = "";
//		this.likedAboutCampus = "";
		this.originOfInterest = "";
		this.likelyhoodOfRecommendation = "";
		this.gradMonth = "";
		this.GraduationYear = "";
		this.raffle = "";
		this.comments = "";
		this.username = "";
		this.studentID = "";
	}


	/**
	 * @param s_id
	 * @param fullName
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param zip
	 * @param telephoneNumber
	 * @param email
	 * @param dateOfSurvey
	 * @param likedAboutCampus
	 * @param originOfInterest
	 * @param likelyhoodOfRecommendation
	 * @param gradMonth
	 * @param graduationYear
	 * @param raffle
	 * @param comments
	 * @param username
	 * @param studentID
	 */
	public StudentBeans(String fullName, String streetAddress,
			String city, String state, String zip, String telephoneNumber,
			String email, String dateOfSurvey, String likedAboutCampus,
			String originOfInterest, String likelyhoodOfRecommendation,
			String gradMonth, String graduationYear, String raffle,
			String comments, String username, String studentID) {
		super();
		this.fullName = fullName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.dateOfSurvey = dateOfSurvey;
		this.likedAboutCampus = likedAboutCampus;
		this.originOfInterest = originOfInterest;
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
		this.gradMonth = gradMonth;
		GraduationYear = graduationYear;
		this.raffle = raffle;
		this.comments = comments;
		this.username = username;
		this.studentID = studentID;
	}


	/**
	 * @return the s_id
	 */
	public int getS_id() {
		return s_id;
	}


	/**
	 * @param s_id the s_id to set
	 */
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}


	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}


	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}


	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	
	

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}


	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}


	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the dateOfSurvey
	 */
	public String getDateOfSurvey() {
		return dateOfSurvey;
	}


	/**
	 * @param dateOfSurvey the dateOfSurvey to set
	 */
	public void setDateOfSurvey(String dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}


	/**
	 * @return the likedAboutCampus
	 */
	public String getLikedAboutCampus() {
		return likedAboutCampus;
	}


	/**
	 * @param likedAboutCampus the likedAboutCampus to set
	 */
	public void setLikedAboutCampus(String likedAboutCampus) {
		this.likedAboutCampus = likedAboutCampus;
	}


	/**
	 * @return the originOfInterest
	 */
	public String getOriginOfInterest() {
		return originOfInterest;
	}


	/**
	 * @param originOfInterest the originOfInterest to set
	 */
	public void setOriginOfInterest(String originOfInterest) {
		this.originOfInterest = originOfInterest;
	}


	/**
	 * @return the likelyhoodOfRecommendation
	 */
	public String getLikelyhoodOfRecommendation() {
		return likelyhoodOfRecommendation;
	}


	/**
	 * @param likelyhoodOfRecommendation the likelyhoodOfRecommendation to set
	 */
	public void setLikelyhoodOfRecommendation(String likelyhoodOfRecommendation) {
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
	}


	/**
	 * @return the gradMonth
	 */
	public String getGradMonth() {
		return gradMonth + " " + getGraduationYear();
	}


	/**
	 * @param gradMonth the gradMonth to set
	 */
	public void setGradMonth(String gradMonth) {
		this.gradMonth = gradMonth;
	}


	/**
	 * @return the graduationYear
	 */
	public String getGraduationYear() {
		return GraduationYear;
	}


	/**
	 * @param graduationYear the graduationYear to set
	 */
	public void setGraduationYear(String graduationYear) {
		GraduationYear = graduationYear;
	}


	/**
	 * @return the raffle
	 */
	public String getRaffle() {
		return raffle;
	}


	/**
	 * @param raffle the raffle to set
	 */
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}


	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}


	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return studentID;
	}


	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentBean [s_id=" + s_id + ", fullName=" + fullName
				+ ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", telephoneNumber="
				+ telephoneNumber + ", email=" + email + ", dateOfSurvey="
				+ dateOfSurvey + ", likedAboutCampus=" + likedAboutCampus
				+ ", originOfInterest=" + originOfInterest
				+ ", likelyhoodOfRecommendation=" + likelyhoodOfRecommendation
				+ ", gradMonth=" + gradMonth + ", GraduationYear="
				+ GraduationYear + ", raffle=" + raffle + ", comments="
				+ comments + ", username=" + username + ", studentID="
				+ studentID + "]";
	}





	

	/**
	 * This method is used to produced a string representation
	 * of the student object, in a specialized storage format
	 * manner.  This string is then returned to the calling
	 * method. 
	 * 
	 * @return String
	 */
//	public String textFileStorageFormat() {
//		String s =  "{" + fullName + "}{" + streetAddress + "}{" + city
//				+ "}{" + state + "}{" + zip + "}{"
//				+ telephoneNumber + "}{" + email + "}{"
//				+ dataOfSurvey + "}{";
//			if (likedAboutCampus != null) {
//			for (int i = 0; i < likedAboutCampus.length; i++) {
//				s += likedAboutCampus[i] + ",";
//			}
//			}
//			s += "}{" + originOfInterest
//				+ "}{" + likelyhoodOfRecommendation
//				+ "}{" + raffle + "}{" + comments + "}{" + username + "}{" + studentId + "}";
//		
//		return s;
//	}
}
