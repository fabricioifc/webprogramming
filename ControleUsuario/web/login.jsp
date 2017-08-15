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

            <form method="post" action="Autenticador" class="form-horizontal">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3>Acessar o sistena</h3>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="nome" class="col-md-3 control-label">Nome:</label>
                            <div class="col-md-9">
                                <input type="text" name="usuario" class="form-control" autofocus="true" placeholder="Usuário"  required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="senha" class="col-md-3 control-label">Senha:</label>
                            <div class="col-md-9">
                                <input type="password" name="senha" class="form-control"placeholder="Informe uma senha" required="true" />
                            </div>
                        </div>

                    </div>
                    <div class="panel-footer">
                        <input type="submit" value="Login" class="btn btn-primary" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
