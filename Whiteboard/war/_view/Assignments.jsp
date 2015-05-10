<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="_view/Assignments.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
<script type="text/javascript">
   function toggle_visibility(id) {
       var e = document.getElementById(id);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
   }
</script>
</head>
<body>
	<h1>SmartBoard: Assignments</h1>
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
	<ul><button onclick="toggle_visibility('AssignmentCreator')">Create New Assignment</button></ul>
	<div id="AssignmentCreator">
		<form action="${pageContext.request.contextPath}/Assignments" method="post">
		<br>
		<h2>Title:</h2>
		<input type="text" name="title">
		
		<h2>Description:</h2>
		<input type="text" name="question">
		
		<h2>Assignment Grade:</h2>
		<input type="number" name="assignmentGrade">
		
		<h2>Point Value: </h2>
		<input type="number" name="pointValue">
		<ul><button type="submit">Finish</button></ul>
		</form>
	</div>
	<div id="CreatedAssignments">
		${classHTML}
	</div>	
</body>
</html>