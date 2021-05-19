<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String s1=request.getParameter("uname");
String s2=request.getParameter("pwd");
%>
	<h1> Register Form Page 2</h1>
	
	<form action="abcd" method="post">
		<input type="hidden" name="uname" value="<%=s1%>">
		<input type="hidden" name="pwd" value="<%=s2%>">  
	
		Age : <input type="text" name="age"> <br>
		Gender : <input type="text" name="gender"> <br>
		<input type="submit" value="Register">
	
	</form>
</body>
</html>