<%-- 
    Document   : 00_probando
    Created on : 19-feb-2019, 16:30:21
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Probando JSP</h1>
        <%
         double numero = Math.random();
         if (numero > 0.8){
        %>
        <h2>Que tengas un buen dia!</h2>
        <% 
          } else{
         %>
        <h2>Bueno,la vida continua..</h2>
        <% }       %>
        <p><%=numero%></p>
        <a href="00_probando.jsp"><h3>Prueba de nuevo</h3></a>
    </body>
</html>
