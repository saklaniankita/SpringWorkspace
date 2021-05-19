<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%
		String msg = request.getParameter("status");
		if (msg == null) {
			msg = "";
		}
	%>
	<p style="color: red">
		<%=msg%>
	</p>
	<form action="login" method="post">
		Username : <input type="text" name="uname"> <br> 
		Password : <input type="password" name="pass"> <br> 
		<input type="submit" value="Login">

	</form>
</body>
</html>