<html>
	<head>
	<link rel="stylesheet" type="text/css" href="_view/Lecture.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
	</head>
<body>
	<h1>Smartboard: Classes</h1>
	<div id="Options">
		<p>Account | Help | Logout</p>
	</div>
	<div id="OptionsBar">
		<ul><form action="${pageContext.request.contextPath}/lecture"><button type="submit">Classes</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/schedule"><button type="submit">Schedule</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/calendar"><button type="submit">Calendar</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/grades"><button type="submit">Grades</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/assignments"><button type="submit">Assignments</button></form></ul>
		<ul><form action="${pageContext.request.contextPath}/forums"><button type="submit">Forums</button></form></ul>
	</div>
	<div id="Class">
		<h2>Computer Science</h2>
		<h3>Professor: David Hovemeyer</h3>
	</div>
	${classHTML}
</body>			
</html>