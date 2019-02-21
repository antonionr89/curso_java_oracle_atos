<%-- 
    Document   : 05_sesiones
    Created on : 20-feb-2019, 14:04:10
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de sesiones JSP</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <%! int peticiones = 0; //variable estatica %>
        <h1>Gestion de sesiones JSP</h1>
        <h2>Calculo de un factorial</h2>
        <form action="05_sesiones.jsp" method="get">
            <p>Numero: </p>
                <input type="number" id="numero" name="numero">
                <input type="submit" value="Calcular">
        </form>
        <%
          String numeroGet = request.getParameter("numero");
          if(numeroGet != null){
                int numero = 0;
                double factorial = 1;       
                boolean error = false;
             
              try{
                  numero = Integer.valueOf(numeroGet);
                  if(numero < 1){
                      error = true;
                  }else{
                      for(int i = numero;i > 1; i--){
                          factorial = factorial * i;
                      }
                  }
                  
              }catch(Exception e){
                  
              }
              if(error){
                  out.println("Indicar un numero mayor que 0");
              }
              else{
                  out.println("El numero factorial de "+numero+" es: "+factorial);
              }
          }
          Integer contador = (Integer)session.getAttribute("contador");
          if(contador == null){
              contador = 0;
          }else{
              %> <p>Ejecuciones de este JSP en esta sesión: <%=contador %></p><%
          }
          //if(session.isNew()){
              session.setMaxInactiveInterval(60);
          //}
          contador++;
          session.setAttribute("contador", contador);
          peticiones++;
        %>
        <p>Ejecuciones totales de este JSP: <%=peticiones %></p>
    </body>
</html>
