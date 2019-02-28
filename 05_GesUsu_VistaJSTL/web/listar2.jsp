<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<jsp:useBean id="todosUsuarios" type="java.util.ArrayList<Usuario>" scope="session">
                <jsp:getProperty property="*" name="todosUsuarios"/>
</jsp:useBean> 
<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Todos los usuarios</h1>
        <div>
            
            <c:forEach items="${todosUsuarios}" var="usu">
                <form action="usuarios.do" method="post" name="">                 
                    <input id="id" name="id" type="text"  size="4" readonly value="${usu.id}"/>
                    <input id="nombre" name="nombre" type="text" required value="${usu.nombre}"/>
                    <input id="edad" name="edad" type="text" required  value="${usu.edad}"/>
                    <input id="email" name="email" type="email" required value="${usu.email}"/>
                    <input id="password" name="password" type="password" required value="${usu.password}"/>
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