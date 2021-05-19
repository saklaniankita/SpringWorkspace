<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert New Student</title>
</head>
<script>
funtion listStudents(){
	
}
</script>
<body>
<form action="Register.abcd" method="POST">
      Name :   <input type="text" name="name" id="name"><br>
      Course: <input type="text" name="course" id="course"><br>
 <input type="submit" name="button" id="button" value="Register">
</Form>
<form action="listStudents.abcd" method="GET">
<input type="submit" name="List all Students" id="button" value="list">
</form>

</body>
</html>