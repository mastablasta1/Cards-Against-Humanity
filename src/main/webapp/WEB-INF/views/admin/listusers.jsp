<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>var ctx = "${contextPath}"</script>
<script src="${contextPath}/static/jquery.min.js" defer></script>
<script type="text/javascript" src="${contextPath}/static/admin.js" defer></script>
<title>Users listing</title>

</head>
<body>
	
<table id="userlist">
</table>

</body>
</html>