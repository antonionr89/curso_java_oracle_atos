<%-- 
    Document   : modificiar
    Created on : 25-feb-2019, 11:48:38
    Author     : USUARIO
--%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.persistencia.JavaJDPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Datos</title>
    </head>
    <body>
        <h1>Modificar Datos</h1>
         <form name='form2' method='get' action='procesarMod.do'>
         <table border='1'>
        <%  
            Persona p = (Persona)session.getAttribute("nombre");
        %>
         <tr><td>Nombre:</td><td>
         <input type='text' name='nombre' id='nombre' size='25' value='<%= p.getNombre()%>'/></td></tr>
         <tr><td>Edad:</td><td>
         <input type='text' name='edad' id='edad' value='<%= p.getEdad()%>'/></td></tr>
         <tr><td>Usuario:</td><td>
         <input type='text' size='25' id='user' name='user' value='<%= p.getUser()%>'/></td></tr>
         <tr><td>Contraseña:</td><td>
         <input type='text' name='pass' id='pass' size='25' value='<%= p.getPass()%>'/></td></tr>
         </table>  
         <input type='submit' value='Enviar'/>
         </form>
         <a href="index.html"><p>Volver</p></a>
    </body>
</html>
