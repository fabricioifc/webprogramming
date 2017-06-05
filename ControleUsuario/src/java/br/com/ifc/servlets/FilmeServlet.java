/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.servlets;

import br.com.ifc.entidades.Filmes;
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
    private static String INSERIR_OU_EDITAR = "/restrito/filme.jsp"; //criar o arquivo jsp
    private static String LISTA_FILMES = "/restrito/filmes.jsp";
    private FilmeService service;

    public FilmeServlet() {
        super();
        service = new FilmeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = null;
            String acao = request.getParameter("acao");
            if (acao.equalsIgnoreCase("listar")) {
                request.setAttribute("filmes", service.listar());
                forward = LISTA_FILMES;
            } else if (acao.equalsIgnoreCase("inserir")) {
                forward = INSERIR_OU_EDITAR;
            } else {
                forward = INSERIR_OU_EDITAR;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensagens", ex.getMessage());
            request.getRequestDispatcher(INSERIR_OU_EDITAR).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");

            //Setar os parâmetros no objeto Filme
            //Salvar o filme utilizando a classe service FilmeService
            response.sendRedirect("Filmes?acao=listar");

        } catch (Exception ex) {
            ex.printStackTrace();
//            response.sendRedirect(request.getHeader("Referer"));
            request.setAttribute("mensagens", ex.getMessage());
            request.getRequestDispatcher(INSERIR_OU_EDITAR).forward(request, response);
        }
    }

}
