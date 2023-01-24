
<%@page import="com.ty.dto.Survey"%>
<%@page import="com.ty.service.SurveyService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Displaying in table format</h1>
	<br>
	<table border="5px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Questions</th>
			<th>edit</th>
			<th>delete</th>

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
			<td><a href="getQuestions?id=<%=s.getId()%>">view</a></td>
			<td><a href="getSurvey?id=<%=s.getId()%>">Edit</a></td>
			<td><a href="deleteSurvey?id=<%=s.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>