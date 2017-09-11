/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.bean;

import br.edu.ifc.entidades.Ingredientes;
import br.edu.ifc.negocio.IngredienteBO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabricio
 */
@ManagedBean
@ViewScoped
public class IngredienteMB implements Serializable {

    private Ingredientes ingrediente;
    private List<Ingredientes> ingredientes;
    private final IngredienteBO negocio;

    public IngredienteMB() {
        ingrediente = new Ingredientes();
        negocio = new IngredienteBO();
        buscarTodos();
    }

    public void prepararAlterar() {
        try {
            this.ingrediente = negocio.buscarPorId(ingrediente.getIdingrediente());
            System.out.println(ingrediente.getIdingrediente());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void buscarTodos() {
        try {
            ingredientes = negocio.buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void salvar() throws Exception {
        System.out.println(ingrediente);
        if (ingrediente.getIdingrediente() == null) {
            negocio.inserir(ingrediente);
        } else {
            negocio.atualizar(ingrediente);
        }
        limparCampos();
        buscarTodos();
    }

    public void remover() throws Exception {
        negocio.remover(ingrediente.getIdingrediente());
        limparCampos();
        buscarTodos();
    }

    public Ingredientes buscarPorId(Long id) throws Exception {
        return negocio.buscarPorId(id);
    }

    private void limparCampos() {
        this.ingrediente = new Ingredientes();
    }

    public Ingredientes getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingredientes ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
