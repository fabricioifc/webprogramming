/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.controller;

import ifc.dao.PizzariaDao;
import ifc.dao.PizzariaDaoImpl;
import ifc.model.Pizzaria;
import ifc.utils.MensagemUtils;
import java.io.Serializable;
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
public class PizzariaBean implements Serializable {

    private Pizzaria pizzaria;
    private List<Pizzaria> pizzarias;
    private final PizzariaDao dao;

    @ManagedProperty("#{msg['mensagem.salvar']}")
    private String mensagemSalvar;
    @ManagedProperty("#{msg['mensagem.excluir']}")
    private String mensagemExcluir;
    @ManagedProperty("#{msg['mensagem.prepararAlterar']}")
    private String mensagemPrepararAlterar;

    public PizzariaBean() {
        pizzaria = new Pizzaria();
        dao = new PizzariaDaoImpl();
    }

    @PostConstruct
    public void init() {
        try {
            buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void prepararAlterar() throws Exception {
        try {
            this.pizzaria = dao.buscarPorId(pizzaria.getId());
            MensagemUtils.adicionarMensagemDeSucesso(mensagemPrepararAlterar);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void buscarTodos() throws Exception {
        try {
            pizzarias = dao.buscarTodos();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }

    }

    public void salvar() throws Exception {
        try {
            if (pizzaria.getId() == null) {
                dao.inserir(pizzaria);
            } else {
                dao.atualizar(pizzaria);
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
            dao.remover(pizzaria.getId());
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso(mensagemExcluir);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Pizzaria buscarPorId(Integer id) throws Exception {
        try {
            return dao.buscarPorId(id);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void limparCampos() {
        try {
            this.pizzaria = new Pizzaria();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Pizzaria getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

    public List<Pizzaria> getPizzarias() {
        return pizzarias;
    }

    public void setPizzarias(List<Pizzaria> pizzarias) {
        this.pizzarias = pizzarias;
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

}
