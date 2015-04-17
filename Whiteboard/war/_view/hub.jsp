<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="_view/Hub.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
</head>
<body>
	<h1>SmartBoard: Home</h1>
	<h2> Welcome ${username}:</h2>
	<div id="Options">
	<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>	
	<div id="Links">
		<ul><form action="${pageContext.request.contextPath}/lecture"><button type="submit">Classes</button></form></ul>
		<ul>Schedule</ul>
		<ul>Calendar</ul>
		<ul>Grades</ul>
		<ul>Assignments</ul>
		<ul>Forums</ul>
	</div>
</html>