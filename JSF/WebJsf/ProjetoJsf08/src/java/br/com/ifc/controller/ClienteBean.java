/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.controller;

import br.com.ifc.model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fabricio
 */
@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private List<Cliente> clientes;

    private String mensagem; //Aviso impresso na tela

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
    public String salvarCliente() {
        System.out.println(cliente);
        clientes.add(cliente);
        limpar();
        mensagem = "Cliente salvo com sucesso!";
        return "confirmacao?faces-redirect=true";
    }

    public String removerCliente() {
        clientes.remove(cliente);
        limpar();
        mensagem = "Cliente removido com sucesso!";
        return "confirmacao?faces-redirect=true";
    }

    public String editarCliente() {
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
