<%-- 
    Document   : login
    Created on : 21-feb-2019, 9:08:44
    Author     : USUARIO
--%>

<%@page import="com.web.listaRegistros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <h1>Introduce tu login</h1>
        <%  if(session.getAttribute("nombre") == null){
            if(request.getParameter("use") == null && request.getParameter("eda") == null){
                    session = request.getSession();
                
        %>
        <form name='form1' method='post' action='http://localhost:8084/loginRegistroJSP/login.jsp'>
            <table border='1'>
            <tr><td>Usuario:</td><td>
            <input type='text' size='25' id='use' name='use' value='' /></td></tr>
            <tr><td>Contraseña:</td><td>
            <input type='text' name='pas' id='pas' size='25' value=''/></td></tr>
            </table>
            <input type='submit' value='Enviar'/>
        </form>
        <% }else{
                
                //out.println("<p>entro 1</p>");
                /* out.println("<p>Tu sesion ya esta iniciada</p>");
                 session.setMaxInactiveInterval(60);*/
                  //out.println("<p>entro 2</p>");
                 if(request.getParameter("use") == "" || request.getParameter("pas") == ""){
                     out.println("<p>Ningun campo puede estar vacio</p>");
                 }else{
                 for(int i=0;i < listaRegistros.getInstance().getArray().size();i++){
                     if((request.getParameter("use")+request.getParameter("pas")).equals(listaRegistros.getInstance().getArray().get(i))){
                         out.println("<p>Tu usuario en lista es" +listaRegistros.getInstance().getArray().get(i)+"</p>");
                         out.println("<p>Tu usuario es :"+request.getParameter("use")+"</p>");
                         session.setAttribute("nombre", request.getParameter("use"));
                     }else{
                         out.println("<p>Tu usuario no esta registrado</p>");
                         }
                    }
                
                    }
            }
            }else{
                    out.println("<p>Ya estas logeado</p>");
                }
                 
        %>
    </body>
</html>
