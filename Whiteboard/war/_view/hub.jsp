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
	<h3><form action="/hub"><button type="submit">My Account</button> | <button type="submit">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>	
	<div id="Links">
		<ul><form action="${pageContext.request.contextPath}/lecture"><button type="submit">Classes</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/schedule"><button type="submit">Schedule</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/calendar"><button type="submit">Calendar</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/grades"><button type="submit">Grades</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/assignments"><button type="submit">Assignments</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/forums"><button type="submit">Forums</button></form></ul>
	</div>
</html>