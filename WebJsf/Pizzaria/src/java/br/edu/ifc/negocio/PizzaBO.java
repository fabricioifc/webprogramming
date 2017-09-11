/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.negocio;

import br.edu.ifc.dao.PizzasDao;
import br.edu.ifc.dao.PizzasDaoImpl;
import br.edu.ifc.entidades.Pizzas;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class PizzaBO {

    private final PizzasDao dao;

    public PizzaBO() {
        dao = new PizzasDaoImpl();
    }

    public List<Pizzas> buscarTodos() throws Exception {
        return dao.buscarTodos();
    }

    public void inserir(Pizzas objeto) throws Exception {
        dao.inserir(objeto);
    }

    public void atualizar(Pizzas objeto) throws Exception {
        dao.atualizar(objeto);
    }

    public void remover(Long objeto) throws Exception {
        dao.remover(objeto);
    }

    public Pizzas buscarPorId(Long id) throws Exception {
        return dao.buscarPorId(id);
    }

}
