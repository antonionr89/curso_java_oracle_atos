<%-- 
    Document   : 02_scriptlets
    Created on : 19-feb-2019, 17:01:03
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptlets de JSP</title>
    </head>
    <body>
        <h1>Scriptlet de JSP</h1>
        <% 
            int numero = 7, factorial = 1;
            for(int i = numero; i > 1;i--){
                factorial *= i;
            }
         %>
         <%-- Mostrar en negrita el numero y el resultado --%>
         <p style="font-size: 20px">
             El factorial de <span style="font-weight: bold">
                 <%=numero %>
             </span>
         <%= "es <span style=\"font-weight:bold\">" + factorial + "</span>"%>
         </p>
    </body>
</html>
