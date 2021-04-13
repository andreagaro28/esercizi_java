<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continents</title>
<style>
body {
	text-align: center;
}

#link-pages {
	display: flex;
	flex-direction: row;
}

.block-element {
	position: -webkit-sticky;
	position: sticky;
	top: 0;
}

h4 {
	margin-right: 20px;
}

input {
	border-radius: 40px;
}
</style>
</head>
<body>
	<div id="link-pages">
		<a href="/database_esercizio/pages/city.jsp"><h4>Serach a
				city</h4></a> <a href="/database_esercizio/pages/country.jsp"><h4>Serach
				a country</h4> </a>
	</div>
	<h1>Hi ${userName}</h1>
	<input type="button" formaction="/database_esercizio/ContinentServlet"
		value="Show continent list">

	<c:forEach items="${continentList}" var="continent">
		<a
			href="/database_esercizio/NationContinentServlet?continentName=${continent}"><h2>${continent}</h2></a>
	</c:forEach>

	<c:forEach items="${countryList}" var="country">
		<p>
			Name: <a
				href="/database_esercizio/CityPopulationListServlet?countryCode=${country.code}">${country.name}</a>
			Population: ${country.population}
		</p>
	</c:forEach>

	<c:forEach items="${cityList}" var="city">
		<p>City: ${city.name} - Population: ${city.population}</p>
	</c:forEach>
</body>
</html>