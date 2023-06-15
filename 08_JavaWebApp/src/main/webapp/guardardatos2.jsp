<%-- 
    Document   : guardardatos
    Created on : 13 de jun. de 2023, 09:06:00
    Author     : Toled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="/WEB-INF/jspf/header.jspf" %>


        <% 
            Map<String, String[]> reqParams = request.getParameterMap();
            
            for(String param : reqParams.keySet()){
        %>
        <div> 
            <span>Param: </span> <strong><%= param%></strong>
            <span>Datos: </span> <strong><%= String.join("," , reqParams.get(param))%></strong>

        </div>

        <%
          }
        %>

    </body>
</html>
