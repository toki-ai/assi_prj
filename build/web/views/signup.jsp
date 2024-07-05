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
        <div style="width: 500px; height: 600px; margin-top: 50px;">
            <div class="tab-pane fade show active" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                <h1>Sign Up</h1>
                <form action="/FindingNemo/signup" method="POST">
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input name="username" type="text" id="registerName" class="form-control" />
                        <label class="form-label" for="registerName">Username</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input name="fullname" type="text" id="registerName" class="form-control" />
                        <label class="form-label" for="registerName">Full Name</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input name="address" type="text" id="registerUsername" class="form-control" />
                        <label class="form-label" for="registerUsername">Address</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input name="phone" type="number" id="registerEmail" class="form-control" />
                        <label class="form-label" for="registerEmail">Phone</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input name="password" type="password" id="registerPassword" class="form-control" />
                        <label class="form-label" for="registerPassword">Password</label>
                    </div>
                    <div data-mdb-input-init class="form-outline mb-4">
                        <input name="re_password" type="password" id="registerRepeatPassword" class="form-control" />
                        <label class="form-label" for="registerRepeatPassword">Repeat password</label>
                    </div>
                    <p class="text-danger">${message}</p>
                    <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block mb-3">Sign up</button>
                </form>
            </div>
        </div>
    </body>
</html>
