<%-- 
    Document   : index
    Created on : 05/12/2016, 11:07:59
    Author     : fabricio
--%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boas vindas</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <% Usuarios usuario = (Usuarios) request.getSession().getAttribute("usuarioLogado");%>
        <div class="container">
            <% if (usuario != null) {%>
            <h1>Seja bem vindo <%= usuario.getNome()%>!</h1>
            <% } else {%>
            <h1>Seja bem vindo!</h1>
            <% }%>
        </div>
    </body>
</html>
