<%@page import="com.ty.dto.Survey"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
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
</style>
</head>
<body>
	<div class="topnav">
		 <a href="create.jsp">respond</a>
		 <a href="logout">Logout</a>
	</div>
	<h1></h1>

	<h1>List of students</h1>
	<%
	Object o = request.getAttribute("myuser");
	ArrayList<Survey> ss = (ArrayList) o;
	%>
	<table border="5px solid black" align="center" cellpadding=20px>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>Description</th>
			<th>Answer_Questions</th>
			<th>edit_Answer</th>
			<th>delete_Answer</th>
		</tr>

		<%
		for (Survey s : ss) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getDescription()%></td>
			<td><a href="saveanswers?id=<%=s.getId()%>">show_questions</a></td>
			<td><a href="editanswers?id=<%=s.getId()%>">edit</a></td>
			<td><a href="deleteanswers?id=<%=s.getId()%>">deleteResponse</a></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>