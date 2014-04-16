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
			
		<div class="message">
			<fieldset>
			<h1 class="center"><c:property value="fullName" /></h1>
			<h2 class="center">Thank you for taking the time to fill out the survey!</h2>
				<p>- The information has been successfully stored</p>
					<table border="1">
						<tr>
							<th colspan="2">Raffle Stats</th>
						</tr>
						<tr>
							<th>Mean</th>
							<td class="result">${compMean}</td>
						</tr>
						<tr>
							<th>Standard Deviation</th>
							<td class="result">${compStdv}</td>
						</tr>
					</table>
					<a href="index.jsp"><button id="backToHome" class="green">Return to Home</button></a>
			</fieldset>
		</div>

			
				<a href="index.jsp"></a>
			
			</div>  <!-- end div b_container -->
		</div>  <!-- end div contentArea2 -->
</div> <!-- end div wrapper -->	

	<div class="footer">
		<span class="creatorName">Site Created By: <b>Jack Young</b></span>
		<a href="http://www.gmu.edu/" title="Please visit http://www.gmu.edu for more information. (Click on the logo to go there now.)"><img id="gmuLogo" width="200px" src="GMU_LOGO.jpg"/></a>
	</div>

</body>
</html>