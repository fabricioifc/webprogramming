package br.com.ifc.controller;

import br.com.ifc.model.Cliente;
import br.com.ifc.utils.MensagemUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private List<Cliente> clientes;

    /**
     * Construtor sem parâmetros é obrigatório
     */
    public ClienteBean() {
        cliente = new Cliente();
        clientes = new ArrayList<>();
    }

    /**
     * faces-redirect vai evitar submit ao fazer refresh da página
     *
     * @return
     */
    public String salvar() {
        clientes.add(cliente);
        limpar();
        MensagemUtils.adicionarMensagemDeSucesso("Cliente salvo com sucesso!");
        return "confirmacao?faces-redirect=true";
    }

    public String remover() {
        clientes.remove(cliente);
        limpar();
        MensagemUtils.adicionarMensagemDeSucesso("Cliente removido com sucesso!");
        return "confirmacao?faces-redirect=true";
    }

    public String editar() {
        clientes.remove(cliente);
        return "index?faces-redirect=true";
    }

    public void limpar() {
        cliente = new Cliente();
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

    public String getQuantidadeClientes() {
        return clientes.size() + "";
    }
}
