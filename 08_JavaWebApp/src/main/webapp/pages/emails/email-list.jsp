<%-- 
    Document   : email-list
    Created on : 22 de jun. de 2023, 09:27:00
    Author     : Toled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./assets/email-list.css" rel="stylesheet">
        <link href="http://127.0.0.1:8080/WebAppTest/assets/email-list.css" rel="stylesheet">
        <title>Email List</title>
    </head>
    <body>
        <table >
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Username</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="email" items="${requestScope.emailList}"> 
                    <tr>
                        <td>${email.id}</td>
                        <td>${email.correo}</td>
                        <td>${email.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
    
</html>
