<%-- 
    Document   : error
    Created on : 21-feb-2019, 9:56:53
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
        <h1>Complete los campos</h1>
        <a href="index.html">Volver</a>
        <%
            if(request.getParameter("nombre") == ""){
                out.println("<h2>Falta nombre</h2>");
            }
            if(request.getParameter("edad") == ""){
                out.println("<h2>Falta edad</h2>");
            }
            if(request.getParameter("user") == ""){
                out.println("<h2>Falta usuario</h2>");
            }
            if(request.getParameter("pass") == ""){
                out.println("<h2>Falta password</h2>");
            }
        %>
    </body>
</html>
