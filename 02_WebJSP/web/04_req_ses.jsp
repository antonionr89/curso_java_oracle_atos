<%-- 
    Document   : 04_req_ses
    Created on : 20-feb-2019, 10:24:13
    Author     : USUARIO
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de peticiones y respuestas JSP</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    </head>
    <body class="container">
        <%@include file="cabecera.jsp" %>
        <h1>Gestión de peticiones y respuestas JSP</h1>
        <%
                String nomApell = request.getParameter("nombre_apell");
                String desc = request.getParameter("descripcion");
                String email = request.getParameter("email");
                if(nomApell == null || desc == null || email == null){
                    
          %> 
          <div class="col-lg-2"></div>
          <div class="col-lg-8">
              <script type="text/javascript">
                  function envio(){
                      
                      if(document.getElementById("nombre_apell").value != ""
                              && document.getElementById("nombre_apell").value.length > 1){
                                     let ventana = window.confirm("Seguro?");
                                     return ventana;
                      }
                      else{
                          alert("nombre > 1");
                          return false;
                      }
                  }
              </script>
              <form action="04_req_ses.jsp" method="get" class="form-inline" onsubmit="return envio()">
            <p>Nombre y apellidos:</p>
            <p><input id="nombre_apell" type="text" name="nombre_apell" autocomplete="true"
                     maxlength="100" required="true" size="100" placeholder="Introduzca nombre y apellidos" class="form-control"></p>
            <p>Descripción</p>
            <p><textarea id="descripcion" name="descripcion" required="true" cols="100" rows="10" 
                         placeholder="Introduzca una descripción detallada"></textarea></p>
            <p>Email:</p>
            <p><input id="email" type="email" name="email" autocomplete="true"
                      maxlength="100" required="true" size="100" placeholder="Introduzca email" class="form-control"></p>
            <input type="submit" value="Enviar" class="btn btn-default">
            </form>
            </div>
            <div class="col-lg-2"></div>
        <%  
            }else{
            if(nomApell != "" && desc != "" && email != ""){
                if(nomApell.length() > 1){
                    if(desc.length() > 5){
                        try{
                        FileWriter fileWriter = new FileWriter("C:/Users/USUARIO/Desktop/solicitudes.txt");
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.printf("Nombre='%s' \r\nDescripcion='%s'\r\nEmail='%s'\r\n",nomApell,desc,email);
                        out.println("he printeado");
                        printWriter.close();
                        }catch(Exception e){
                
                }
                    }else{
                        out.println(desc);
                        out.println("<h3>Pon una descripcion</h3>");
                    }
                }else{
                    %>
                    <h3>Pon un nombre</h3>
                    <%
                 }
               
            
            
            }
        }
           %>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </body>
</html>
