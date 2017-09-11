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
public class Pizzas implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idpizza;
    private String nome;
    private Date dtcadastro;
    private Pizzarias pizzaria;
    private List<Ingredientes> ingredientes;

    public Pizzas() {
    }

    public Pizzas(Long idpizza) {
        this.idpizza = idpizza;
    }

    public Pizzas(Long idpizza, String nome, Date dtcadastro, Pizzarias pizzaria) {
        this.idpizza = idpizza;
        this.nome = nome;
        this.dtcadastro = dtcadastro;
        this.pizzaria = pizzaria;
    }

    public Long getIdpizza() {
        return idpizza;
    }

    public void setIdpizza(Long idpizza) {
        this.idpizza = idpizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Pizzarias getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Pizzarias pizzaria) {
        this.pizzaria = pizzaria;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpizza != null ? idpizza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizzas)) {
            return false;
        }
        Pizzas other = (Pizzas) object;
        if ((this.idpizza == null && other.idpizza != null) || (this.idpizza != null && !this.idpizza.equals(other.idpizza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.entidades.Pizzas[ idpizza=" + idpizza + " ]";
    }

}
