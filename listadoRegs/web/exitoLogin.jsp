<%-- 
    Document   : exitoLogin
    Created on : 22-feb-2019, 14:46:19
    Author     : USUARIO
--%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.persistencia.JavaJDPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login con exito</title>
    </head>
    <body>
        <%  
            Persona p = (Persona)session.getAttribute("nombre");
            JavaJDPersona db = new JavaJDPersona();
            boolean esUser = db.leerPersonas(request.getParameter("user"),
            request.getParameter("pass"));
            
            out.println("<h1>Bienvenido "+p.getNombre());
            out.println("<p>Tu usuario es :"+p.getNombre()+"</p>");
            out.println("<p>Tu edad es :"+p.getEdad()+"</p>");
            //session.setAttribute("nombre", request.getParameter("user"));
           
        %>
        <a href="index.html"><p>Volver</p></a>
    </body>
</html>
