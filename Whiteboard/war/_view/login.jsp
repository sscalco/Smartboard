<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="_view/LoginCSS.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
	</head>
	
	<body>
		<h1>Welcome to SmartBoard!</h1>
	<div id="Login">
		<h2>Please Login Below!</h2>
		<form action="${pageContext.request.contextPath}/login" method="post">
		<p>Username:</p>
		<input type="text" name="username">
		<br>
		
		<p>Password:</p>
		<input type="text" name="password">
		<br>
		<br>
		
		<button type="submit">Login</button>
		</form>
		<form action="signup.jsp" method="get">
		<button type="submit">Sign Up</button>
		</form>
	</div>
	</body>
</html>