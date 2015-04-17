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
		<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>
	<div id="Class">
		<h2>Computer Science</h2>
		<h3>Professor: David Hovemeyer</h3>
		<div id="ClassOptions">
			<p>Schedule</p>
			<p>Assignments</p>
			<p>Forum</p>
			<p>Grades</p>
		</div>
	</div>
	${classHTML}
</body>	
		
</html>