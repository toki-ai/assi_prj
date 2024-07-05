<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="../assets/login.css"/>
        <%@include file="layout/fontAndIcon.jsp" %>
    </head>
    <body style="display: flex; justify-content: center; align-items: center">
        <div style="width: 500px; height: 600px; margin-top: 100px;">
            <div class="tab-content">
                <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                    <h1>Log in</h1>
                    <form action="login" method="POST">
                        <div data-mdb-input-init class="form-outline mb-4">
                            <label class="form-label" for="loginName">Username</label>
                            <input name="username" type="text" id="loginName" class="form-control" />
                        </div>
                        <div data-mdb-input-init class="form-outline mb-4">
                            <label class="form-label" for="loginPassword">Password</label>
                            <input name="password" type="password" id="loginPassword" class="form-control" />                       
                        </div>
                        <p class="text-danger">${message}</p>
                        <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block mb-4">Sign in</button>
                        <div class="text-center">
                            <p>Not a member? <a href="views/signup.jsp">Register</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
