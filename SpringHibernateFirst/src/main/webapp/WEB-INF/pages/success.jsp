<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
	<h1>Student with following details registered Successfully</h1>
	<h3>Student id = ${student.id}</h3>
	<h3>Student name = ${student.name}</h3>
	<h3>Student Course = ${student.course}</h3>
	<form action="listStudents.abcd" method="GET">
		<input type="submit" name="List all Students" id="button" value="list">
	</form>
</body>
</html>