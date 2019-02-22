<%-- 
    Document   : registro
    Created on : 20-feb-2019, 17:36:23
    Author     : USUARIO
--%>

<%@page import="com.web.listaRegistros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String user = request.getParameter("use");
            String pass = request.getParameter("pas");
            String nombre = request.getParameter("nom");
            String edad = request.getParameter("eda");
            if(user == null || pass == null || nombre == null || edad == null){
        %>
        <h1>Registrate</h1>
        <form name='form1' method='post' action='registro.jsp'>
            <table border='1'>
            <tr><td>Nombre:</td><td>
            <input type='text' name='nom' id='nom' size='25' value=''/></td></tr>
            <tr><td>Edad:</td><td>
            <input type='number' name='eda' id='eda' value=''/></td></tr>
            <tr><td>Usuario:</td><td>
            <input type='text' size='25' id='use' name='use' /></td></tr>
            <tr><td>Contraseña:</td><td>
            <input type='text' name='pas' id='pas' size='25' value=''/></td></tr>
            </table>
            <input type='submit' value='Enviar'/>
        </form>
        <div>
        <% }else{
            if(Integer.parseInt(request.getParameter("eda")) < 18){
               out.println("<p>Eres menor</p>");
                }else{
                    listaRegistros.getInstance().guardarPersona(nombre, Integer.parseInt(edad), user, pass);
                    out.println("Tu usuario es: "+request.getParameter("use")+"<br/>Tu contraseña es: "+request.getParameter("pas")+"<br/>");
                    /*for(int i = 0;i < listaRegistros.getInstance().getArray().size();i++){
                        out.println("los usuarios son: ");
                        out.println(listaRegistros.getInstance().getArray().get(i));
                    }*/
                }
            }
        %>
        </div>
        </body>
</html>
