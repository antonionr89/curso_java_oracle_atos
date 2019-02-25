<%-- 
    Document   : registros
    Created on : 22-feb-2019, 12:39:56
    Author     : USUARIO
--%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.logica.GestionPersona"%>
<%
    Persona p = GestionPersona.getInstance().getPersona();
    String nombre = "";
    String user = "";
    String pass = "";
    int edad = 0;
    if(p != null){
        nombre = p.getNombre();
        edad = p.getEdad();
        user = p.getUser();
        pass = p.getPass();
    }
   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registrate</h1>
        <form name='form1' method='get' action='procesar.do'>
            <table border='1'>
            <tr><td>Nombre:</td><td>
            <input type='text' name='nombre' id='nombre' size='25' value=''/></td></tr>
            <tr><td>Edad:</td><td>
            <input type='number' name='edad' id='edad' value=''/></td></tr>
            <tr><td>Usuario:</td><td>
            <input type='text' size='25' id='user' name='user' /></td></tr>
            <tr><td>Contraseña:</td><td>
            <input type='text' name='pass' id='pass' size='25' value=''/></td></tr>
            </table>
            <input type='submit' value='Enviar'/>
        </form>
    </body>
</html>
