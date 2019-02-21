<%-- 
    Document   : 06_cookies
    Created on : 20-feb-2019, 16:10:48
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie cookieN = new Cookie("nombre_c", request.getParameter("nombre"));
    Cookie cookieA = new Cookie("apellidos_c", request.getParameter("apellidos"));
    //Tiempos de duración
    cookieN.setMaxAge(60*60*24);
    cookieA.setMaxAge(60*60*24);
    //Añadimos las cookies a la cabecera de la respuesta
    response.addCookie(cookieA);
    response.addCookie(cookieN);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Testeando cookies</title>
    </head>
    <body>
        <h1>Testeando cookies</h1>
        <ul>
            <li><p>Nombre: <%= request.getParameter("nombre") %></p></li>
            <li><p>Nombre: <%= request.getParameter("apellidos") %></p></li>
        </ul> 
        <h2>Leyendo las cookies</h2>
        <%
            Cookie cookie = null;
            Cookie cookies[] = null;
            
            cookies = request.getCookies();
            
            if(cookies != null){
                out.println("<h3>Cookies encontradas y su valor</h3>");
                for(int i = 0; i < cookies.length; i++){
                    cookie = cookies[i];
                    out.print("Nombre: "+cookie.getName() +", ");
                    out.print("Valor: "+cookie.getValue()+"<br/>");
                    
                }
            }else{
                out.println("<h3>No hay cookies</h3>");
            }
            
            
        %>
    </body>
</html>
