/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.bean;

import br.edu.ifc.entidades.Pizzarias;
import br.edu.ifc.negocio.PizzariaBO;
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
public class PizzariaMB implements Serializable {

    private Pizzarias pizzaria;
    private List<Pizzarias> pizzarias;
    private final PizzariaBO negocio;

    public PizzariaMB() {
        pizzaria = new Pizzarias();
        negocio = new PizzariaBO();
        buscarTodos();
    }

//    @PostConstruct
//    public void init() {
//        try {
//            buscarTodos();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    public void prepararAlterar() {
        try {
            this.pizzaria = negocio.buscarPorId(pizzaria.getIdpizzaria());
            System.out.println(pizzaria.getIdpizzaria());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void buscarTodos() {
        try {
            pizzarias = negocio.buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void salvar() throws Exception {
        System.out.println(pizzaria);
        if (pizzaria.getIdpizzaria() == null) {
            negocio.inserir(pizzaria);
        } else {
            negocio.atualizar(pizzaria);
        }
        limparCampos();
        buscarTodos();
    }

    public void remover() throws Exception {
        negocio.remover(pizzaria.getIdpizzaria());
        limparCampos();
        buscarTodos();
    }

    public Pizzarias buscarPorId(Long id) throws Exception {
        return negocio.buscarPorId(id);
    }

    private void limparCampos() {
        this.pizzaria = new Pizzarias();
    }

    public Pizzarias getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Pizzarias pizzaria) {
        this.pizzaria = pizzaria;
    }

    public List<Pizzarias> getPizzarias() {
        return pizzarias;
    }

    public void setPizzarias(List<Pizzarias> pizzarias) {
        this.pizzarias = pizzarias;
    }

}
