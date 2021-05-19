<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//String name = (String)session.getAttribute("name");
//int age = (Integer)session.getAttribute("age");
//String gender = (String)session.getAttribute("gender");

//These values are fetched from the URL
String name = request.getParameter("uname");
String age =request.getParameter("age");
String gender = request.getParameter("gender");
System.out.println(name+" ========= "+age+"========"+gender);
%>
<h1>
Heyyyyy <%=name %><br>
Your Age is <%=age %><br>
Your gender is <%=gender%><br>
</h1>
</body>
</html>