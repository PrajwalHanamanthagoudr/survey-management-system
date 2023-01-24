<%@page import="com.ty.dto.Respondent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%Respondent respondent =(Respondent)request.getAttribute("respondent");%>
	<form action="updaterespondent">


	Id : <input type="text" name="id" value="<%=respondent.getId() %>" readonly="readonly"> <br><br>
	Name : <input type="text" name="name" value="<%=respondent.getName() %>"><br><br>
	Email :	<input type="email" name="email" value="<%=respondent.getEmail()%>"><br><br>
	Password :	<input type="tel" name="phone" value="<%=respondent.getPassword()%>"><br><br>
			<input type="submit" value="update">
	</form>

</body>
</html>