<%@ include file="include/header.jsp" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Cards Against Humanity</title>
    <%@ include file="include/bootstrap.jsp" %>
    ${ctxScript}
    <script src="${staticPath}/js/home.js" defer></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">

            <h2>Cards Against Humanity</h2>

            <div class="row">
                <div class="col-sm-6">
                    <h3>Create account:</h3>

                    <form id="reg-form">
                        <div class="form-group">
                            <label for="reg-email">Email</label>
                            <input id="reg-email" type="email" name="email"/>
                        </div>
                        <div class="form-group">
                            <label for="reg-nickname">Nickname</label>
                            <input id="reg-nickname" type="text" name="nickname"/>
                        </div>
                        <div class="form-group">
                            <label for="reg-password">Password</label>
                            <input id="reg-password" type="password" name="password"/>
                        </div>

                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>

                <div class="col-sm-6">
                    <h3>Log in to your account:</h3>

                    <form action="${contextPath}/" method="post">
                        <div class="form-group">
                            <label for="log-email">Email</label>
                            <input id="log-email" type="email" name="email"/>
                        </div>
                        <div class="form-group">
                            <label for="log-password">Password</label>
                            <input id="log-password" type="password" name="password"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
