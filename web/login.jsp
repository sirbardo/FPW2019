<%-- 
    Document   : login
    Created on : 6-mag-2019, 9.13.26
    Author     : davide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Autenticati</h1>
        <form method="post" action="login.html">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" ><br/>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" ><br/>
            <button type="submit" name="login">Login</button>
        </form>
    </body>
</html>
