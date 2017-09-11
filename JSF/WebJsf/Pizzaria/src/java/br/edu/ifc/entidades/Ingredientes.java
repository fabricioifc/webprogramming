/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idingrediente;
    private String nome;
    private Date dthrcadastro;
    private Boolean idativo = true;

    public Ingredientes() {
    }

    public Ingredientes(Long idingrediente) {
        this.idingrediente = idingrediente;
    }

    public Ingredientes(Long idingrediente, String nome, Date dthrcadastro) {
        this.idingrediente = idingrediente;
        this.nome = nome;
        this.dthrcadastro = dthrcadastro;
    }

    public Long getIdingrediente() {
        return idingrediente;
    }

    public void setIdingrediente(Long idingrediente) {
        this.idingrediente = idingrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDthrcadastro() {
        return dthrcadastro;
    }

    public void setDthrcadastro(Date dthrcadastro) {
        this.dthrcadastro = dthrcadastro;
    }

    public Boolean getIdativo() {
        return idativo;
    }

    public void setIdativo(Boolean idativo) {
        this.idativo = idativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idingrediente != null ? idingrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.idingrediente == null && other.idingrediente != null) || (this.idingrediente != null && !this.idingrediente.equals(other.idingrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.entidades.Ingredientes[ idingrediente=" + idingrediente + " ]";
    }

}
