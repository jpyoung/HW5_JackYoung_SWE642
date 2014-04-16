<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey - Jack Young - 642</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body>

	<div id="header_bar">
		<div id="logo_top_bar">Department of Computer Science</div>

	</div>  <!-- end div header_bar -->
	

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    <%@ taglib prefix="c" uri="/struts-tags"%>

	<div id="wrapper">
		<div id="leftPanel">
			<h4>All StudentIDs</h4>
			<ul>	
	<c:iterator value="allTakenSurveys" var="tt">
  		<li><a href="detailView?uuid=<c:property value="#tt.studentID"/>"><c:property value="#tt.studentID"/></a></li>
	</c:iterator>
			</ul>
		</div>
		
		<div id="contentArea2">
		<div id="b_container">		
		
			<h1>Student Information Page</h1>
		

		<h4>Username: <c:property value="selectedStudent.username"/></h4>
		<h4>Student ID: <c:property value="selectedStudent.studentID"/></h4>
		<table border="1">
			<tr>
				<th>fullName</th>
				<th>street address</th>
				<th>city</th>
				<th>state</th>
				<th>zip</th>
				<th>telephone</th>
				<th>email</th>
				<th>dateOfSurvey</th>
				<th>Grad Month/Year</th>
			</tr>
			<tr>
				<td><c:property value="selectedStudent.fullName"/></td>
				<td><c:property value="selectedStudent.streetAddress"/></td>
				<td><c:property value="selectedStudent.city"/></td>
				<td><c:property value="selectedStudent.state"/></td>
				<td><c:property value="selectedStudent.zip"/></td>
				<td><c:property value="selectedStudent.telephoneNumber"/></td>
				<td><c:property value="selectedStudent.email"/></td>
				<td><c:property value="selectedStudent.dateOfSurvey"/></td>
				<td><c:property value="selectedStudent.gradMonth"/></td>
			</tr>
		</table>
		
		<br/>
		
		<table border="1">
			<tr>
				<th>likedAboutCampus</th>
				<th>Interests</th>
				<th>likelyhoodOfRecommendation</th>
				<th>raffle</th>
				<th>comments</th>
			</tr>
			<tr>
				<td>
					<c:property value="selectedStudent.likedAboutCampus"/>
				</td>
				<td><c:property value="selectedStudent.originOfInterest"/></td>
				<td><c:property value="selectedStudent.likelyhoodOfRecommendation"/></td>
				<td><c:property value="selectedStudent.raffle"/></td>
				<td><c:property value="selectedStudent.comments"/></td>
			</tr>
		</table>

	<br/>

		<a href="index.jsp">Return to Survey Form.</a>
			</div>  <!-- end div b_container -->
		</div>  <!-- end div contentArea2 -->
</div> <!-- end div wrapper -->	

	<div class="footer">
		<span class="creatorName">Site Created By: <b>Jack Young</b></span>
		<a href="http://www.gmu.edu/" title="Please visit http://www.gmu.edu for more information. (Click on the logo to go there now.)"><img id="gmuLogo" width="200px" src="GMU_LOGO.jpg"/></a>
	</div>
</body>
</html>