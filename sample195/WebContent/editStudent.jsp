<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentController" method="get">
<c:forEach items="${student}" var="student">
    <input type ="hidden" name="id" value="${student.id}">
	enter the student Name: <input type="text" name="name" value="${student.name}"/><br/>
	enter the roll: <input type="text" name="roll" value="${student.roll}"/><br/>
	<input name="action" type="submit" value="update"/>
</c:forEach>

<a href="StudentController?action=list">list</a>
</form>
</body>
</html>