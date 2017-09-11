/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.negocio;

import br.edu.ifc.dao.IngredientesDao;
import br.edu.ifc.dao.IngredientesDaoImpl;
import br.edu.ifc.entidades.Ingredientes;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class IngredienteBO {

    private final IngredientesDao dao;

    public IngredienteBO() {
        dao = new IngredientesDaoImpl();
    }

    public List<Ingredientes> buscarTodos() throws Exception {
        return dao.buscarTodos();
    }

    public void inserir(Ingredientes objeto) throws Exception {
        dao.inserir(objeto);
    }

    public void atualizar(Ingredientes objeto) throws Exception {
        dao.atualizar(objeto);
    }

    public void remover(Long objeto) throws Exception {
        dao.remover(objeto);
    }

    public Ingredientes buscarPorId(Long id) throws Exception {
        return dao.buscarPorId(id);
    }

}
