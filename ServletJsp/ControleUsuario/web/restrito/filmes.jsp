<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filmes</title>

        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../resources/estrelas.css" />
    </head>
    <body>
        <jsp:include page="../menu.jsp" />
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
                    <c:forEach items="${filmes}" var="filme">
                        <div class="col-md-4">
                            <div class="thumbnail" style="min-height: 300px;">
                                <a href="Filmes?acao=editar&id=${filme.id}">
                                    <img src="${filme.imagem}" alt="${filme.nome}" class="img-rounded" style="max-height: 300px; width: auto;">
                                </a>
                                <div class="caption">
                                    <h4>${filme.nome}</h4>
                                    <p>${filme.genero}</p>
                                    <p>
                                        <span class="star-rating star-5">
                                            <input type="radio" value="1" disabled ${filme.estrelas == 1 ? 'checked' : ''}><i></i>
                                            <input type="radio" value="2" disabled ${filme.estrelas == 2 ? 'checked' : ''}><i></i>
                                            <input type="radio" value="3" disabled ${filme.estrelas == 3 ? 'checked' : ''}><i></i>
                                            <input type="radio" value="4" disabled ${filme.estrelas == 4 ? 'checked' : ''}><i></i>
                                            <input type="radio" value="5" disabled ${filme.estrelas == 5 ? 'checked' : ''}><i></i>
                                        </span>
                                    </p>
                                    <p>
                                        <a href="Filmes?acao=editar&id=${filme.id}" class="btn btn-xs btn-warning" role="button">Editar</a>
                                        <a href="Filmes?acao=excluir&id=${filme.id}" class="btn btn-xs btn-danger" role="button">Excluir</a>
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
