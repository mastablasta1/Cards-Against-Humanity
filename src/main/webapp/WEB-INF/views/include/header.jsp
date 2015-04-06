<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="ctxScript" value="<script>var ctx='${contextPath}'</script>" />
<c:set var="staticPath" value="${contextPath}/static"/>
<c:set var="bootstrapCss" value="${staticPath}/css/bootstrap.min.css" />
<c:set var="bootstrapJs" value="${staticPath}/js/bootstrap.min.js" />
<c:set var="jQuery" value="${staticPath}/js/jquery.min.js" />
<!DOCTYPE html>