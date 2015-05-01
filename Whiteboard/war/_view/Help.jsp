<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="_view/Help.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
</head>
<body>
	<h1>SmartBoard: Help</h1>
	<div id="Options">
	<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit">Home</button> | <button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>	
	<div id="Help">
		<h2>SmartBoard was made by:</h2>
		<br>
		<p>Scott Fitzpatrick</p>
		<br>
		<p>Todd Leach</p>
		<br>
		<p>Cooper Luetje</p>
		<br>
		<p>Sam Scalco</p>
		<br>
		<p>Brandon Walton</p>
	</div>
</body>
</html>