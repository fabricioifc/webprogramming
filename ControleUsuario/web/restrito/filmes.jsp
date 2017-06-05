<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <% if (request.getAttribute("mensagens") != null) { %>
            <p class="alert alert-danger">${mensagens}</p>
            <% }%>
            <div class="panel panel-info">
                <div class="panel-heading clearfix">
                    <h3>
                        Lista de Filmes
                        <a href="Filmes?acao=inserir" class="pull-right">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                    </h3>
                </div>
                <div class="panel-body">
                    <c:forEach items="${filmes}" var="u">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img src="${u.imagem}" alt="${u.nome}" class="img-rounded" style="max-height: 250px; width: auto;">
                                <div class="caption">
                                    <h4>${u.nome}</h4>
                                    <p>${u.genero}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
