<%@page import="com.ty.dto.Options"%>
<%@page import="com.ty.dto.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Displaying in table format</h1>
	<% 
	Object o = request.getAttribute("list");
	List<Question> sys = (ArrayList) o;
	%>
	<br>
	<table border="5px solid black">
		<tr>
			<th>Id</th>
			<th>Question</th>
			<th>Type</th>
			<th>option</th>
			<th>edit</th>
			<th>delete</th>

		</tr>
		
		<%
		for (Question s : sys) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getQuestion()%></td>
				<td><%=s.getType()%></td>
				<td>
				<%List<Options> options =  s.getOptions();
					for(Options op:options){
						%>
						<tr>
				            	<td><%=op.getId()%></td>
								<td><%=op.getOptionId()%></td>
								<td><%=op.getOptionDefination()%></td>
						</tr>
						<%
					}		%>
				</td>
				<td><a href="getSurvey?id=<%=s.getId()%>">Edit</a></td>
				<td><a href="deleteSurvey?id=<%=s.getId()%>">delete</a></td>
			</tr>
			<%
		}
		%>
	</table>

</body>
</html>