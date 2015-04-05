<%@ include file="include/header.jsp" %>

<html>
<head>
	<title>Cards Against Humanity</title>
	<script src="${contextPath}/static/jquery.min.js" defer></script>
	<script type="text/javascript" defer>
		$("reg-form").submit(function(e){
			alert("Done!");
			e.preventDefault();
		});
	</script>
</head>
<body>

<h2>Cards Against Humanity</h2>

<h3>Create account:</h3>
<form id="reg-form">
	<div>
		<label for="reg-email">Email:</label> <input id="reg-email" type="email" name="email" />
	</div>
	<div><label for="reg-nickname">Nickname:</label> <input id="reg-nickname" type="text" name="nickname" /></div>
	<div><label for="reg-password">Password:</label> <input id="reg-password" type="password" name="password" /></div>
	<div><input type="submit" value="Submit" /></div>
</form>

<h3>Log in to your account:</h3>
<form action="${contextPath}/" method="post">
	<div>Email: <input type="email" name="email" /></div>
	<div>Password: <input type="password" name="password" /></div>
	<div><input type="submit" value="Log in" /></div>
</form>

</body>
</html>
