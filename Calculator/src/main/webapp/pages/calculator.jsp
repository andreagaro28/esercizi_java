<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/style/style.css"/>
</head>
<body>
	<form action="/Calculator/operation">
		<p>CALCULATOR</p>
		<div id="input-number">
			<input type="text" name="in1" class="elements in">
			<input type="text" name="in2" class="elements in">
		</div>
		<div id="button-elements">
			<button name="opr" value="+" class="elements">+</button>
			<button name="opr" value="-" class="elements">-</button>
			<button name="opr" value="x" class="elements">x</button>
			<button name="opr" value="/" class="elements">/</button>
		</div>
	<p>${result}</p>
	<p>${error}</p>
	</form>
	
</body>

</html>