<html>
	<head>
	<link rel="stylesheet" type="text/css" href="_view/Account.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
	</head>
<body>
	<h1>Smartboard: Account</h1>
	<div id="Options">
		<h3><form action="${pageContext.request.contextPath}/hub" method="post"><button type="submit" name="account" value="true">My Account</button> | <button type="submit" name="help" value="true">Help</button> | <button type="submit" name="logout" value="true">Log Out</button></form></h3>
	</div>
	<div id="Account">
		<form action="${pageContext.request.contextPath}/SignUp" method="get">
		
		<p>First Name:</p>
		<input type="text" name="firstname">
		
		<p>Last Name:</p>
		<input type="text" name="lastname">
		
		<p>E-mail:</p>
		<input type="text" name="email">
		
		<p>Username:</p>
		<input type="text" name="username">
		
		<p>Password:</p>
		<input type="text" name="password">
		<br>
		<br>
		<button type="submit">Update</button>
		</form>
	</div>
	${classHTML}
</body>	
		
</html>