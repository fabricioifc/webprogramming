<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO_8859-1">
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
                <div class="panel-heading">
                    <h3>Cadastro de Filmes</h3>
                </div>
                <div class="panel-body">
                    <form action="Filmes" method="POST" class="form-horizontal">
                        <div class="form-group">
                            <label for="nome" class="control-label col-md-3">Nome: </label>
                            <div class="col-md-9">
                                <input type="text" name="nome" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="genero" class="control-label col-md-3">Gênero: </label>
                            <div class="col-md-9">
                                <input type="text" name="genero" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="imagem" class="control-label col-md-3">Imagem: </label>
                            <div class="col-md-9">
                                <input type="text" name="imagem" value="" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" value="Salvar" class="btn btn-primary" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
