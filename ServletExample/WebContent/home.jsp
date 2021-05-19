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
Cookie[] cks=	request.getCookies();

for(Cookie ck:cks)
{
	String cn=ck.getName();
	String cv=ck.getValue();
%>
	The Cookie name is <%=cn %> <br>
	The Cookie value is <%=cv %> <br>
	
<%	
}
%>

	Login Success...........
	<br>
	<%
		String sss=(String)  session.getAttribute("user");
	%>
	My new Http Session is : <%=sss %>
</body>
</html>