/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.controller;

import ifc.dao.IngredienteDao;
import ifc.dao.IngredienteDaoImpl;
import ifc.dao.PizzaDao;
import ifc.dao.PizzaDaoImpl;
import ifc.dao.PizzariaDao;
import ifc.dao.PizzariaDaoImpl;
import ifc.model.Ingrediente;
import ifc.model.Pizza;
import ifc.model.Pizzaria;
import ifc.utils.MensagemUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabricio
 */
@ManagedBean
@ViewScoped
public class PizzaBean implements Serializable {

    private Pizza pizza;
    private List<Pizza> pizzas;
    private List<Pizzaria> pizzarias;
//    private Map<Ingrediente, Boolean> checked;

    private final PizzariaDao pizzariaDao;
    private final IngredienteDao ingredienteDao;
    private final PizzaDao pizzaDao;

    @ManagedProperty("#{msg['mensagem.salvar']}")
    private String mensagemSalvar;
    @ManagedProperty("#{msg['mensagem.excluir']}")
    private String mensagemExcluir;
    @ManagedProperty("#{msg['mensagem.prepararAlterar']}")
    private String mensagemPrepararAlterar;

    public PizzaBean() {
        limparCampos();

        pizzariaDao = new PizzariaDaoImpl();
        ingredienteDao = new IngredienteDaoImpl();
        pizzaDao = new PizzaDaoImpl();
    }

    @PostConstruct
    public void init() {
        try {
            buscarTodos();
            pizzarias = pizzariaDao.buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void prepararAlterar() throws Exception {
        try {
            this.pizza = pizzaDao.buscarPorId(pizza.getId());
            MensagemUtils.adicionarMensagemDeSucesso(mensagemPrepararAlterar);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void buscarTodos() throws Exception {
        try {
            pizzas = pizzaDao.buscarTodos();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }

    }

    public void salvar() throws Exception {
        try {
            if (pizza.getId() == null) {
                pizzaDao.inserir(pizza);
            } else {
                pizzaDao.atualizar(pizza);
            }
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso(mensagemSalvar);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void remover() throws Exception {
        try {
            pizzaDao.remover(pizza.getId());
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso(mensagemExcluir);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Pizza buscarPorId(Integer id) throws Exception {
        try {
            return pizzaDao.buscarPorId(id);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public List<Ingrediente> getIngredientes() throws Exception {
        try {
            return ingredienteDao.buscarTodos();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void limparCampos() {
        try {
            pizza = new Pizza();
            pizza.setPizzaria(new Pizzaria());
            pizza.setIngredientes(new ArrayList<>());
//            checked = new HashMap<>();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getMensagemSalvar() {
        return mensagemSalvar;
    }

    public void setMensagemSalvar(String mensagemSalvar) {
        this.mensagemSalvar = mensagemSalvar;
    }

    public String getMensagemExcluir() {
        return mensagemExcluir;
    }

    public void setMensagemExcluir(String mensagemExcluir) {
        this.mensagemExcluir = mensagemExcluir;
    }

    public String getMensagemPrepararAlterar() {
        return mensagemPrepararAlterar;
    }

    public void setMensagemPrepararAlterar(String mensagemPrepararAlterar) {
        this.mensagemPrepararAlterar = mensagemPrepararAlterar;
    }

    public List<Pizzaria> getPizzarias() {
        return pizzarias;
    }

    public void setPizzarias(List<Pizzaria> pizzarias) {
        this.pizzarias = pizzarias;
    }

//    public Map<Ingrediente, Boolean> getChecked() {
//        return checked;
//    }
//
//    public void setChecked(Map<Ingrediente, Boolean> checked) {
//        this.checked = checked;
//    }
}
