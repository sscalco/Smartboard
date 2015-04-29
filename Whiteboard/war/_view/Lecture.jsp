<html>
	<head>
	<link rel="stylesheet" type="text/css" href="_view/Lecture.css">
	</head>
<body>
	<h1>Smartboard: Classes</h1>
	<div id="Options">
		<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit">Home</button> | <button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>
	<div id="OptionsBar">
		<ul><form action="${pageContext.request.contextPath}/lecture"><button type="submit">Classes</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/Schedule"><button type="submit">Schedule</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/Calendar"><button type="submit">Calendar</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/Grades"><button type="submit">Grades</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/Assignments"><button type="submit">Assignments</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/Forums"><button type="submit">Forums</button></form></ul>
	</div>
	<div id="Class">
		<h2>Computer Science</h2>
		<h3>Professor: David Hovemeyer</h3>
	</div>
	${classHTML}
</body>	
		
</html>
