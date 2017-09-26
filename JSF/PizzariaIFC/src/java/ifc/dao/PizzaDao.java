/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Pizza;


/**
 *
 * @author fabricio
 */
public interface PizzaDao {

    public void inserir(Pizza objeto) throws Exception;

    public void remover(Integer objeto) throws Exception;

    public void atualizar(Pizza objeto) throws Exception;

    public Pizza buscarPorId(Integer id) throws Exception;

    public java.util.List<Pizza> buscarTodos() throws Exception;
}
