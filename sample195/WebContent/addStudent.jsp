<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentController" method="get">
	enter the Student Name: <input type="text" name="name"/><br/>
	enter the rollNo: <input type="text" name="roll"/><br/>
	<input name="action" type="submit" value="add"/>

<a href="StudentController?action=list">list</a>
</form>

</body>
</html>