<%-- 
    Document   : emailListForm
    Created on : 15 de jun. de 2023, 09:40:30
    Author     : Toled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email List Register</title>
    </head>
    <body>
        <h1>Join to our email list!</h1>
        <form action="email-list" method="post">
            <!--<input disabled >-->
            <div> 
                <label for="email" >Email</label>
                <input type="email" name="email" id="email">
            </div>
            <div> 
                <label for="username" >Username</label>
                <input type="text" name="username" id="username">
            </div>
            <div> 
                <button type="submit">Register</button>
            </div>
        </form>
    </body>
</html>
