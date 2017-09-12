package br.com.ifc.controller;

import br.com.ifc.dao.ClienteDao;
import br.com.ifc.dao.ClienteDaoImpl;
import br.com.ifc.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ClienteBean {

    private Cliente cliente;
    private List<Cliente> clientes;
    private ClienteDao dao;

    public ClienteBean() {
        cliente = new Cliente();
        clientes = new ArrayList<>();
        dao = new ClienteDaoImpl();
    }

    public String salvar() {
        try {
            if (cliente.getId() == null) {
                dao.salvar(cliente);
            } else {
                dao.atualizar(cliente);
            }
            limpar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "confirmacao.xhtml";
    }

    public void limpar() {
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
