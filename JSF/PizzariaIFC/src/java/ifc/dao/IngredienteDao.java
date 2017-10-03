/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Ingrediente;
import ifc.model.PizzaIngrediente;
import java.util.List;


/**
 *
 * @author fabricio
 */
public interface IngredienteDao {

    public void inserir(Ingrediente objeto) throws Exception;

    public void remover(Integer objeto) throws Exception;

    public void atualizar(Ingrediente objeto) throws Exception;

    public Ingrediente buscarPorId(Integer id) throws Exception;

    public java.util.List<Ingrediente> buscarTodos() throws Exception;
}
