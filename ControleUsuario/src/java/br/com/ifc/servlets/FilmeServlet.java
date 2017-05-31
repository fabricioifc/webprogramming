/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import br.com.ifc.services.FilmeService;
import br.com.ifc.services.FilmeServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Filmes")
public class FilmeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
//    private static String INSERIR_OU_EDITAR = "/restrito/usuario.jsp";
    private static String LISTAR_USUARIOS = "/restrito/filmes.jsp";
    private FilmeService service;

    public FilmeServlet() {
        super();
        service = new FilmeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = LISTAR_USUARIOS;

            request.setAttribute("filmes", service.listar());

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getSession().setAttribute("mensagens", ex.getMessage());
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

}
