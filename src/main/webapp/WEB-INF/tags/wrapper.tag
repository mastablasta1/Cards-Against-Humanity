<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@attribute name="headTags" required="false" %>
<%@attribute name="pageTitle" required="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <%@ include file="/WEB-INF/views/include/bootstrap.jsp" %>
    <script>var ctx='${contextPath}'</script>
    ${headTags}
    <title>${pageTitle}</title>
</head>
<body>
<jsp:doBody/>
</body>
</html>