<%-- 
    Document   : guardardatos
    Created on : 13 de jun. de 2023, 09:06:00
    Author     : Toled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>aaa</h1>
        <% 
            String correo = request.getParameter("correo");
            String username = request.getParameter("username");
            String genero = request.getParameter("genero");
            
        %>
        <div> 
            <span>Correo: </span> <strong><%=correo%></strong>
        </div>
        <div> 
            <span>Username:</span> <strong><%=username%></strong>
        </div>
        <div> 
            <span>Genero: </span> <strong><%=genero%></strong>
        </div>
        
    </body>
</html>
