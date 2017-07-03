<%@page import="java.util.Date"%>
<%@page import="br.com.ifc.entidades.Atores"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filmes</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <% if (request.getAttribute("mensagens") != null) { %>
            <p class="alert alert-danger">${mensagens}</p>
            <% }%>
            <div class="panel panel-info">
                <div class="panel-heading clearfix">
                    <h3>
                        Lista de Atores
                        <a href="Atores?acao=inserir" class="pull-right">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                    </h3>
                </div>
                <div class="panel-body">
                    <c:forEach items="${atores}" var="u">
                        <div class="col-md-4">
                            <div class="thumbnail" style="min-height: 300px;">
                                <a href="Atores?acao=editar&id=${u.id}">
                                    <img src="${u.foto}" alt="${u.nome}" class="img-rounded" style="max-height: 300px; width: auto;">
                                </a>
                                <div class="caption">
                                    <h4>${u.nome}</h4>
                                    <p>${u.sexo}</p>
                                    <p>${u.dataNascimento}</p>
                                    <p>
                                        <a href="Atores?acao=editar&id=${u.id}" class="btn btn-xs btn-warning" role="button">Editar</a>
                                        <a href="Atores?acao=excluir&id=${u.id}" class="btn btn-xs btn-danger" role="button">Excluir</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
