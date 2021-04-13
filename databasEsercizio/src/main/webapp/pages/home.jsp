<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
	body{text-align: center;}
	input {border-radius: 40px;}
</style>
</head>
<body>
<h1>Welcome</h1>
	<form action="/database_esercizio/HomeServlet" method="POST">
		<input type="text" name="inputName" placeholder="Insert your name...">
		<input type="submit" value="Confirm">
	</form>
	<h2>${noName}</h2>
</body>
</html>

				