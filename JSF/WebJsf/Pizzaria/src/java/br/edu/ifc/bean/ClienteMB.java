/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.bean;

import br.edu.ifc.entidades.Clientes;
import br.edu.ifc.negocio.ClienteBO;
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
public class ClienteMB implements Serializable {

    private Clientes cliente;
    private List<Clientes> clientes;
    private final ClienteBO negocio;

    public ClienteMB() {
        cliente = new Clientes();
        negocio = new ClienteBO();
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
            this.cliente = negocio.buscarPorId(cliente.getIdcliente());
            System.out.println(cliente.getIdcliente());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void buscarTodos() {
        try {
            clientes = negocio.buscarTodos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void salvar() throws Exception {
        System.out.println(cliente);
        if (cliente.getIdcliente() == null) {
            negocio.inserir(cliente);
        } else {
            negocio.atualizar(cliente);
        }
        limparCampos();
        buscarTodos();
    }

    public void remover() throws Exception {
        negocio.remover(cliente.getIdcliente());
        limparCampos();
        buscarTodos();
    }

    public Clientes buscarPorId(Long id) throws Exception {
        return negocio.buscarPorId(id);
    }

    private void limparCampos() {
        this.cliente = new Clientes();
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
}
