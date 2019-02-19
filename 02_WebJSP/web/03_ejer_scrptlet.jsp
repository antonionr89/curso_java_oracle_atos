<%-- 
    Document   : 03_ejer_scrptlet
    Created on : 19-feb-2019, 17:14:00
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
        <h1>tabla del 10</h1>
        <%-- Muestra una tabla con sus trs,tds, de la tabla de multiplicar del 7 --%>
        <% for(int j=0;j<=10;j++){ %>
        <table style="border-style: double; display: inline-block">
            <% for(int i=0;i<=10;i++){ %>
            <tr> 
                <td> <%= j %> por </td>
                <td><%= i %></td>
                <td>es <%= i*j %></td>
            </tr>
            <%}%>
            <%}%>
            <%--
              for(int i=0;i<=10;i++){ %>
                <%= "<tr><th> 7 * "+i+" = "+i*7+"</th></tr>" %>
             <% }  
            ¡--%>
        </table>
    </body>
</html>
