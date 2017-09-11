/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.entidades;

import java.io.Serializable;

/**
 *
 * @author fabricio
 */
public class PedidoItens implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idpedidoItem;
    private boolean borda;
    private Pizzas pizza;
    private Pedidos pedido;

    public PedidoItens() {
    }

    public PedidoItens(Long idpedidoItem) {
        this.idpedidoItem = idpedidoItem;
    }

    public PedidoItens(Long idpedidoItem, boolean borda, Pizzas pizza, Pedidos pedido) {
        this.idpedidoItem = idpedidoItem;
        this.borda = borda;
        this.pizza = pizza;
        this.pedido = pedido;
    }

    public Long getIdpedidoItem() {
        return idpedidoItem;
    }

    public void setIdpedidoItem(Long idpedidoItem) {
        this.idpedidoItem = idpedidoItem;
    }

    public boolean getBorda() {
        return borda;
    }

    public void setBorda(boolean borda) {
        this.borda = borda;
    }

    public Pizzas getPizza() {
        return pizza;
    }

    public void setPizza(Pizzas pizza) {
        this.pizza = pizza;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedidoItem != null ? idpedidoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoItens)) {
            return false;
        }
        PedidoItens other = (PedidoItens) object;
        if ((this.idpedidoItem == null && other.idpedidoItem != null) || (this.idpedidoItem != null && !this.idpedidoItem.equals(other.idpedidoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.entidades.PedidoItens[ idpedidoItem=" + idpedidoItem + " ]";
    }

}
