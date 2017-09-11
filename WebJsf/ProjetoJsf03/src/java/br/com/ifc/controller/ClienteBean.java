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

    /**
     * Construtor sem parâmetros é obrigatório
     */
    public ClienteBean() {
        cliente = new Cliente();
        this.clientes = new ArrayList<>();
    }

    public String salvarCliente() {
        this.clientes.add(cliente);
        cliente = new Cliente();
        return "confirmacao";
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
