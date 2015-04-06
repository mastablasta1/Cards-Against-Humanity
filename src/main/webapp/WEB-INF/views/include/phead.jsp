<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<c:set var="staticPath" value="${contextPath}/static" scope="request"/>
<c:set var="jsPath" value="${staticPath}/js" scope="request"/>
<c:set var="cssPath" value="${staticPath}/css" scope="request"/>
<c:set var="jQuery" value="${jsPath}/jquery.min.js" scope="request"/>