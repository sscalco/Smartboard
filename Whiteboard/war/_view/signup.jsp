<html>
	<head>
	<link rel="stylesheet" type="text/css" href="_view/SignUp.css">
	<div id="Title">
		<title>SmartBoard</title>
	</div>
	</head>
	
	<body>
		<h1>Welcome to SmartBoard!</h1>
		<h2>Please Enter Information Below!</h2>
	<div id="SignUpBox">
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
		<input type="hidden" name="signup" id="signup"value="true"/>
		<button type="submit">Sign Up</button>
		</form>
	</div>
	</body>



</html>