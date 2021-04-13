<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Countries</title>
<style>
body {
	text-align: center;
}

#link-pages {
	display: flex;
	flex-direction: row;
}

h4 {
	margin-right: 20px;
}
input {border-radius: 40px;}

</style>
</head>
<body>
	<div id="link-pages">
		<a href="/database_esercizio/pages/city.jsp">
			<h4>Serach a city</h4>
		</a> 
		<a href="/database_esercizio/ContinentServlet">
			<h4>Serach a continent</h4>
		</a>
	</div>
	<h1>Hi ${userName}</h1>
	<form action="/database_esercizio/CountryServlet">
		<p>Insert name</p>
		<input type="text" name="nameInput">
		<p>Insert continent</p>
		<input type="text" name="continentInput"> 
		<input type="submit">
	</form>
	<c:forEach items="${countryList}" var="element">
		<p>Name: ${element.name} -- Continent: ${element.continent} --
			Surface Area: ${element.surfaceArea} -- Population:
			${element.population} -- Nation Code: ${element.code}</p>
	</c:forEach>
	<h2>${noCountry}</h2>

</body>
</html>