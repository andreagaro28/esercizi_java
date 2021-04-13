<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cities</title>
<style>
body{text-align: center;}
	#link-pages{display: flex; flex-direction: row;}
	h4{margin-right: 20px;}
	input {border-radius: 40px;}
</style>
</head>
<body>
	<div id="link-pages">
		<a href="/database_esercizio/pages/country.jsp"><h4>Serach a country</h4></a>
		<a href="/database_esercizio/ContinentServlet"><h4>Serach a continent</h4></a>
	</div>
	<h1>Hi ${userName}</h1>
	<form action="/database_esercizio/cityServlet" >
		<h2>Inserisci una città</h2>
		<input type="text" name="cityInput">
		<input type="submit" value="Search">
	</form>
	<p>Name: ${city.name}</p>
	<p>District: ${city.district}</p>
	<p>Country Code: ${city.countryCode}</p>
	<p>Population: ${city.population}</p>
	<h1>${noCity}</h1>
</body>
</html>

				