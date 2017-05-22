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
        <title>JSP Page</title>
    </head>
    <body>
        <% Usuarios usuario = (Usuarios) request.getSession().getAttribute("usuarioLogado"); %>
        <h1>Seja bem vindo <%= usuario.getNome() %>!</h1>
    </body>
</html>
