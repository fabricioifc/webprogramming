/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.bean;

import br.edu.ifc.entidades.Ingredientes;
import br.edu.ifc.entidades.Pizzarias;
import br.edu.ifc.entidades.Pizzas;
import br.edu.ifc.negocio.IngredienteBO;
import br.edu.ifc.negocio.PizzaBO;
import br.edu.ifc.negocio.PizzariaBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author fabricio
 */
@ManagedBean
@ViewScoped
public class PizzaMB implements Serializable {

    private Pizzas pizza;
    private List<Pizzas> pizzas;
    private List<SelectItem> itensPizzarias;
    private final PizzaBO negocio;
    private final PizzariaBO pizzariaNegocio;
    private final IngredienteBO ingredienteNegocio;

    private List<Ingredientes> ingredientes;
    private List<Ingredientes> ingredientesSelecionados;

    public PizzaMB() {
        pizza = new Pizzas();
        negocio = new PizzaBO();
        pizzariaNegocio = new PizzariaBO();
        ingredienteNegocio = new IngredienteBO();
        buscarTodos();

        try {
            ingredientes = ingredienteNegocio.buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void prepararAlterar() {
        try {
            this.pizza = negocio.buscarPorId(pizza.getIdpizza());
            System.out.println(pizza.getIdpizza());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void buscarTodos() {
        try {
            pizzas = negocio.buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void salvar() throws Exception {
        System.out.println(pizza);
        this.pizza.setIngredientes(ingredientesSelecionados);
        if (pizza.getIdpizza() == null) {
            negocio.inserir(pizza);
        } else {
            negocio.atualizar(pizza);
        }
        limparCampos();
        buscarTodos();
    }

    public void remover() throws Exception {
        negocio.remover(pizza.getIdpizza());
        limparCampos();
        buscarTodos();
    }

    public Pizzas buscarPorId(Long id) throws Exception {
        return negocio.buscarPorId(id);
    }

    private void limparCampos() {
        this.pizza = new Pizzas();
    }

    public List<SelectItem> getItensPizzaria() {
        itensPizzarias = new ArrayList<>();
        itensPizzarias.add(new SelectItem(null, "Selecione"));
        try {
            for (Pizzarias c : pizzariaNegocio.buscarTodos()) {
                itensPizzarias.add(new SelectItem(c, c.getNome()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return itensPizzarias;
    }

//    public List<SelectItem> getItensIngredientes() {
//        itensIngredientes = new ArrayList<>();
//        itensIngredientes.add(new SelectItem(null, "Selecione"));
//        try {
//            for (Ingredientes c : ingredienteNegocio.buscarTodos()) {
//                itensIngredientes.add(new SelectItem(c, c.getNome()));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        return itensIngredientes;
//    }
    public Pizzas getPizza() {
        return pizza;
    }

    public void setPizza(Pizzas pizza) {
        this.pizza = pizza;
    }

    public List<Pizzas> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizzas> pizzas) {
        this.pizzas = pizzas;
    }

    public List<SelectItem> getItensPizzarias() {
        return itensPizzarias;
    }

    public void setItensPizzarias(List<SelectItem> itensPizzarias) {
        this.itensPizzarias = itensPizzarias;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Ingredientes> getIngredientesSelecionados() {
        return ingredientesSelecionados;
    }

    public void setIngredientesSelecionados(List<Ingredientes> ingredientesSelecionados) {
        this.ingredientesSelecionados = ingredientesSelecionados;
    }

}
