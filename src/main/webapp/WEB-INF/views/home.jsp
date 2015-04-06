<%@include file="/WEB-INF/views/include/phead.jsp" %>

<c:set var="headTags">
    <script src="${jsPath}/home.js" defer></script>
</c:set>

<c:set var="pageTitle">Welcome to Cards Against Humanity!</c:set>

<t:wrapper pageTitle="${pageTitle}" headTags="${headTags}">
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
                        <div id="reg-msg" class="hidden"></div>
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
</t:wrapper>