/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Pizzaria;


/**
 *
 * @author fabricio
 */
public interface PizzariaDao {

    public void inserir(Pizzaria objeto) throws Exception;

    public void remover(Integer objeto) throws Exception;

    public void atualizar(Pizzaria objeto) throws Exception;

    public Pizzaria buscarPorId(Integer id) throws Exception;

    public java.util.List<Pizzaria> buscarTodos() throws Exception;
}
