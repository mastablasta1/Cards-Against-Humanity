<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p>Create account:</p>
<form action="${contextPath}/registration" method="post">
	<p>Email: <input type="email" name="email" /></p>
	<p>Nickname: <input type="text" name="nickname" /></p>
	<p>Password: <input type="password" name="password" /></p>
	<p><input type="submit" value="Submit" /></p>
</form>

</body>
</html>
