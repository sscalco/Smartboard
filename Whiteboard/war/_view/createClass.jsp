<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>Create Class</title>
</head>
<body>

</body>

</html>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="_view/createClass.css"/>
	<div id="Title">
		<title>SmartBoard</title>
	</div>
	</head>
<body>
	<h1>Smartboard: Create Class</h1>
	<div id="Options">
		<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit">Home</button> | <button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>
	
	<div id="LectureCreator">
		<form class="lecture" action="${pageContext.request.contextPath}/ClassCreate" method="post">
		<br>
		<h2>Class Name:</h2>
		<input type="text" name="className">

		<h2>Description:</h2>
		<input type="text" name="description">
		
		<h2>Class Size:</h2>
		<input type="number" name="size">
		
		<ul><button type="submit" style="margin-left: -40px;">Submit New Class</button></ul>
		</form>
	</div>
</body>	
		
</html>