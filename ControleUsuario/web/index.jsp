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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>index.jsp</h1>
        <h3>
            <a href="Registrar?acao=registrar">Clique aqui</a> 
            para registrar-se ou 
            <a href="Registrar?acao=login">aqui</a> para entrar.
        </h3>
        <hr />
        <a href="Usuarios?acao=listar">Lista de Usuários</a> <br />
        <a href="Filmes?acao=listar">Lista de Filmes</a> <br />
        <a href="Atores?acao=listar">Lista de Atores</a> <br />
    </body>
</html>
