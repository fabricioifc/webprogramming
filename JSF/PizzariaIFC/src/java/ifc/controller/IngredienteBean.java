/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.controller;

import ifc.dao.IngredienteDao;
import ifc.dao.IngredienteDaoImpl;
import ifc.model.Ingrediente;
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
public class IngredienteBean implements Serializable {

    private Ingrediente ingrediente;
    private List<Ingrediente> ingredientes;
    private final IngredienteDao dao;

    @ManagedProperty("#{msg['mensagem.salvar']}")
    private String mensagemSalvar;
    @ManagedProperty("#{msg['mensagem.excluir']}")
    private String mensagemExcluir;
    @ManagedProperty("#{msg['mensagem.prepararAlterar']}")
    private String mensagemPrepararAlterar;

    public IngredienteBean() {
        ingrediente = new Ingrediente();
        dao = new IngredienteDaoImpl();
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
            this.ingrediente = dao.buscarPorId(ingrediente.getId());
            MensagemUtils.adicionarMensagemDeSucesso(mensagemPrepararAlterar);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void buscarTodos() throws Exception {
        try {
            ingredientes = dao.buscarTodos();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }

    }

    public void salvar() throws Exception {
        try {
            if (ingrediente.getId() == null) {
                dao.inserir(ingrediente);
            } else {
                dao.atualizar(ingrediente);
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
            dao.remover(ingrediente.getId());
            limparCampos();
            buscarTodos();
            MensagemUtils.adicionarMensagemDeSucesso(mensagemExcluir);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Ingrediente buscarPorId(Integer id) throws Exception {
        try {
            return dao.buscarPorId(id);
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public void limparCampos() {
        try {
            this.ingrediente = new Ingrediente();
        } catch (Exception ex) {
            MensagemUtils.adicionarMensagemDeErroPadrao(ex);
            throw ex;
        }
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
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
