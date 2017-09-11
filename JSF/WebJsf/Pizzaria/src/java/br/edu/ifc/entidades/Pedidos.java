/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idpedido;
    private Double valor;
    private Date dthrcadastro;
    private Clientes cliente;
    private List<PedidoItens> itensPedido;

    public Pedidos() {
    }

    public Pedidos(Long idpedido) {
        this.idpedido = idpedido;
    }

    public Pedidos(Long idpedido, Double valor, Date dthrcadastro, Clientes cliente) {
        this.idpedido = idpedido;
        this.valor = valor;
        this.dthrcadastro = dthrcadastro;
        this.cliente = cliente;
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<PedidoItens> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<PedidoItens> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Date getDthrcadastro() {
        return dthrcadastro;
    }

    public void setDthrcadastro(Date dthrcadastro) {
        this.dthrcadastro = dthrcadastro;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.entidades.Pedidos[ idpedido=" + idpedido + " ]";
    }

}
