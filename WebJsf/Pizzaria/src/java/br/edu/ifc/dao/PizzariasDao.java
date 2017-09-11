/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.entidades.Clientes;
import br.edu.ifc.entidades.Pizzarias;

/**
 *
 * @author fabricio
 */
public interface PizzariasDao {

    public void inserir(Pizzarias objeto) throws Exception;

    public void remover(Long objeto) throws Exception;

    public void atualizar(Pizzarias objeto) throws Exception;

    public Pizzarias buscarPorId(Long id) throws Exception;

    public java.util.List<Pizzarias> buscarTodos() throws Exception;
}
