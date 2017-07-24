<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>registrar.jsp</h1>
        <p>${mensagens}</p>
        <form method="POST" action="Registrar">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" value="<c:out value="${usuario.nome}" />" />
            <br />
            <label for="email">E-mail:</label>
            <input type="text" name="email" value="<c:out value="${usuario.email}" />" />
            <br />
            <label for="usuario">Usuário:</label>
            <input type="text" name="usuario" value="<c:out value="${usuario.usuario}" />" />
            <br />
            <label for="senha">Senha:</label>
            <input type="text" name="senha" value="<c:out value="${usuario.senha}" />" />
            <br /><br />
            <input type="submit" value="Registrar-se" />
        </form>
    </body>
</html>
