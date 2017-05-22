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
        <form method="<!-- completar aqui -->" action="<!-- completar aqui -->">
            <label for="nome">Nome:</label>
            <input type="text" name="<!-- completar aqui -->" value="<c:out value="${usuario.<!-- completar aqui -->}" />" />
            <br />
            <label for="email">E-mail:</label>
            <input type="text" name="<!-- completar aqui -->" value="<c:out value="${usuario.<!-- completar aqui -->}" />" />
            <br />
            <label for="usuario">Usuário:</label>
            <input type="text" name="<!-- completar aqui -->" value="<c:out value="${usuario.<!-- completar aqui -->}" />" />
            <br />
            <label for="senha">Senha:</label>
            <input type="text" name="<!-- completar aqui -->" value="<c:out value="${usuario.<!-- completar aqui -->}" />" />
            <br /><br />
            <input type="<!-- completar aqui -->" value="Registrar-se" />
        </form>
    </body>
</html>
