/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.entidades.Pizzarias;
import br.edu.ifc.entidades.Pizzas;

/**
 *
 * @author fabricio
 */
public interface PizzasDao {

    public void inserir(Pizzas objeto) throws Exception;

    public void remover(Long objeto) throws Exception;

    public void atualizar(Pizzas objeto) throws Exception;

    public Pizzas buscarPorId(Long id) throws Exception;

    public java.util.List<Pizzas> buscarTodos() throws Exception;
}
