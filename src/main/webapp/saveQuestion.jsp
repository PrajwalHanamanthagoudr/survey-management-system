<%@page import="com.ty.service.SurveyorService"%>
<%@page import="com.ty.dto.Surveyor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="createQuestion">
		<%
		int id = Integer.parseInt(request.getParameter("id"));
		%>
		SurveyId : <input type="number" name="s_id" value=<%=id%> > <br>
		Question Tittle : <input type="text" name="question"><br>
		Type : <input type="text" name="type"><br> Option 1 : <input
			type="text" name="option1"> <br> Option 2 : <input
			type="text" name="option2"><br> Option 3 : <input
			type="text" name="option3"><br> Option 4 : <input
			type="text" name="option4"><br> <input type="submit"
			name="create">
	</form>
</body>
</html>