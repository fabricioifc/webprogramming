/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.controller;

import br.com.ifc.model.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fabricio
 */
@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean {

    private Cliente cliente;

    /**
     * Construtor sem parâmetros é obrigatório
     */
    public ClienteBean() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
