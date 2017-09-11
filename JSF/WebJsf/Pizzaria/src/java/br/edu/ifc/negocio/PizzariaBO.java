/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.negocio;

import br.edu.ifc.dao.PizzariasDao;
import br.edu.ifc.dao.PizzariasDaoImpl;
import br.edu.ifc.entidades.Pizzarias;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class PizzariaBO {

    private final PizzariasDao dao;

    public PizzariaBO() {
        dao = new PizzariasDaoImpl();
    }

    public List<Pizzarias> buscarTodos() throws Exception {
        return dao.buscarTodos();
    }

    public void inserir(Pizzarias objeto) throws Exception {
        dao.inserir(objeto);
    }

    public void atualizar(Pizzarias objeto) throws Exception {
        dao.atualizar(objeto);
    }

    public void remover(Long objeto) throws Exception {
        dao.remover(objeto);
    }

    public Pizzarias buscarPorId(Long id) throws Exception {
        return dao.buscarPorId(id);
    }

}
