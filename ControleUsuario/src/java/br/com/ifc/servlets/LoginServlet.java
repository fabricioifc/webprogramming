/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import br.com.ifc.entidades.Usuarios;
import br.com.ifc.services.UsuarioService;
import br.com.ifc.services.UsuarioServiceImpl;
import br.com.ifc.utils.Criptografia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabricio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Autenticador"})
public class LoginServlet extends HttpServlet {

    private UsuarioService service;

    public LoginServlet() {
        service = new UsuarioServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession(); //obtem a sessao do usuario, caso exista

            Usuarios usuario = null;
            String login = request.getParameter("usuario"); // Pega o Login vindo do formulario
            String senha = request.getParameter("senha"); //Pega a senha vinda do formulario

            usuario = service.autenticar(login, Criptografia.criptografar(senha));

            //se nao encontrou usuario no banco, redireciona para a pagina de erro!
            if (usuario == null) {
                sessao.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                //se o dao retornar um usuario, coloca o mesmo na sessao
                sessao.setAttribute("usuarioLogado", usuario);
                //A sessão irá terminar em 2 minutos
                sessao.setMaxInactiveInterval(60 * 2);
                //redireciona para a página de boas vindas
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
