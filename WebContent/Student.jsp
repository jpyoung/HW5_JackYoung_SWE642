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
<c:forEach var="option" items="${idList}" >
  <li><a href="Driver?uid=${option}"><c:out value="${option}"/></a></li>
</c:forEach>
			</ul>
		</div>
		
		<div id="contentArea2">
		<div id="b_container">		
		
			<h1>Student Information Page</h1>
		

		<h4>Username: ${st.username}</h4>
		<h4>Student ID: ${st.studentID}</h4>
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
				<td>${st.fullName}</td>
				<td>${st.streetAddress}</td>
				<td>${st.city}</td>
				<td>${st.state}</td>
				<td>${st.zip}</td>
				<td>${st.telephoneNumber}</td>
				<td>${st.email}</td>
				<td>${st.dateOfSurvey}</td>
				<td>${st.gradMonth}</td>
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
				<c:forEach var="option" items="${st.likedAboutCampus}" >
  					${option}
				</c:forEach>
				
				</td>
				<td>${st.originOfInterest}</td>
				<td>${st.likelyhoodOfRecommendation}</td>
				<td>${st.raffle}</td>
				<td>${st.comments}</td>
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