<%-- 
    Document   : cabecera
    Created on : 20-feb-2019, 16:50:31
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <header>
        <h1>Ejemplos JSP curso nava</h1>
    </header>
    <nav>
        <% String[] url = {"00_probando.jsp","01_expresiones.jsp","02_scriptlets.jsp","03_ejer_scrptlet.jsp",
        "04_req_ses.jsp","05_sesiones.jsp","06_cookies_form.jsp"};
           String[] nombres ={"Probar suerte","Expresiones","Scriptles","Tablas de multiplicar","Peticion,respuesta",
           "Sesiones", "Cookies"};
           for(int i=0;i<url.length;i++){
               %> <a href="<%=url[i] %>"><%= nombres[i]%></a><br/>  
           
       <% }%>
    </nav>
    <%!
    private String dameTitulo(String titulo){
        return "<h2 style='color:purple'>"+titulo+"</h2>";
    
    }
    %>
    </body>
</html>
