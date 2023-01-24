<%@page import="com.ty.dto.Survey"%>
<%@page import="com.ty.service.SurveyService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #04AA6D;
	color: white;
}
</style> -->
</head>
<body>

	<div class="topnav">
		<a href="createsurvey.jsp">create survey</a> <a href="reviewsurvey">review
			survey</a> <a href="logout">logout</a>
		<table border="5px solid black">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>edit</th>
				<th>delete</th>
				<th>Create_questions</th>
				<th>view_questions</th>
			</tr>
			<%!SurveyService ss = new SurveyService();
	List<Survey> sys = ss.getAllSurveys();%>

			<%
			for (Survey s : sys) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getDescription()%></td>
				<td><a href="updatesurveyor?id=<%=s.getId()%>">Edit</a></td>
				<td><a href="deletesurveyor?id=<%=s.getId()%>">delete</a></td>
				<td><a href="saveQuestion.jsp?id=<%=s.getId()%>">create</a></td>
				<td><a href="allQuestion?id=<%=s.getId()%>">view</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>
