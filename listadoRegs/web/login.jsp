<%-- 
    Document   : login
    Created on : 22-feb-2019, 12:40:08
    Author     : USUARIO
--%>
<%
    if(session.getAttribute("nombre") !=null){
        request.getRequestDispatcher("exitoLogin.jsp").forward(request, response);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name='form1' method='get' action='procesarLogin.do'>
            <table border='1'>
            <tr><td>Usuario:</td><td>
            <input type='text' size='25' id='user' name='user' /></td></tr>
            <tr><td>Contraseña:</td><td>
            <input type='text' name='pass' id='pass' size='25' value=''/></td></tr>
            </table>
            <input type='submit' value='Enviar'/>
        </form>
    </body>
</html>
