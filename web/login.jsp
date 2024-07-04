<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="POST">
            Username<input type="text" name="username" value="" /> <br/>
            Password <input type="password" name="password" value="" /><br/>
            <input type="submit" value="Login" name="btAction"/>
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
