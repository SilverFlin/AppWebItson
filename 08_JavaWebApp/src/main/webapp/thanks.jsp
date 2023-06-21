<%-- 
    Document   : thanks
    Created on : 15 de jun. de 2023, 09:27:13
    Author     : Toled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>



        <c:if test="${requestScope.email.correo != null}">

            <h1>Thanks Page</h1>
            <p>Email: ${requestScope.email.correo}</p>
            <p>Username: ${requestScope.email.username}</p>
            <p>ID: ${email.id}</p>

        </c:if>

        <c:if test="${requestScope.email.correo == null}">

            <p>AAAAAAAAAAAAAAAA</p>

        </c:if>

        <c:forEach var="email" items="${requestScope.emailList}">
            
            <div>
                <p>Email: ${email.correo}</p>
                <p>Username: ${email.username}</p>
                <p>ID: ${email.id}</p>
            </div>
            <hr>

        </c:forEach>
    </body>
</html>
