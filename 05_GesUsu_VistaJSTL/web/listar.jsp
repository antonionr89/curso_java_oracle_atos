<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
 <sql:setDataSource var = "db" driver = "oracle.jdbc.driver.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:XE"
         user = "system"  password = "oracle"/>   
<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Todos los usuarios</h1>
        <div>
       
        <form action="" method="get"> 
              <input id="num" name="num" type="number" >
              <input type="submit" value="consultar">
              </form>   <br/>
        
           <c:choose>
          <c:when test = "${empty param.num}">
              <sql:query dataSource = "${db}" var = "result">
            SELECT * from usuario
         </sql:query>
         </c:when>
         <c:when test = "${not empty param.num}">
            <sql:query dataSource = "${db}" var = "result">
            SELECT * from usuario where nota > ${param.num}
            
         </sql:query> 
         </c:when>
          </c:choose>
          <c:forEach var = "row" items = "${result.rows}">
              <form action="usuarios.do" method="post" name="">                
                    <input id="id" name="id" type="text"  size="4" readonly value="${row.id}"/>
                    <input id="nombre" name="nombre" type="text" required value="${row.nombre}"/>
                    <input id="edad" name="edad" type="text" required  value="${row.edad}"/>
                    <input id="email" name="email" type="email" required value="${row.email}"/>
                    <input id="password" name="password" type="password" required value="${row.password}"/>
                    <input id="nota" name="nota" type="text" required value="${row.nota}"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly value="PUT"/>
                    <input type="submit" value="EDIT"
                           onclick="Array.from(document.getElementsByClassName('method')).forEach(
                                       (thisInput) => {thisInput.value'PUT';})" />
                    <input type="submit" value="ELIM"
                           onclick="Array.from(document.getElementsByClassName('method')).forEach(
                                       (thisInput) => {thisInput.value'DELETE';})"/><br/>
                </form>
                   
                 </c:forEach>
                
              
              
              
        </div>
    </body>
</html>