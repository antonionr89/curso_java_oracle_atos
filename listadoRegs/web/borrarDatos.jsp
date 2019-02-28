<%-- 
    Document   : borrarDatos
    Created on : 25-feb-2019, 13:03:56
    Author     : USUARIO
--%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.persistencia.JavaJDPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar</title>
    </head>
    <body>
        <h1>¿Estas seguro?</h1>
        <form name='form3' method='get' action='procesarBor.do'>
             <%  
            Persona p = (Persona)session.getAttribute("nombre");
        %>
        
         <input type='hidden'  id='user' name='user' value='<%= p.getUser()%>'/>
         <input type='hidden' name='pass' id='pass'  value='<%= p.getPass()%>'/>
        <input type='submit' value='Si'/>
        </form>
        <a href='index.html'><p>Volver</p></a>
    </body>
</html>
