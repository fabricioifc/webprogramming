<%-- 
    Document   : index
    Created on : 05/12/2016, 11:07:59
    Author     : fabricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <% if (request.getSession().getAttribute("mensagens") != null) {%>
            <p class="well-sm bg-danger"><%= request.getSession().getAttribute("mensagens")%></p>
            <%}%>

            <form method="post" action="Autenticador">
                Adicionar os inputs para usuário e senha e um botão para submit<br />
                Utilize as classes bootstrap para estilos
            </form>
        </div>
    </body>
</html>
