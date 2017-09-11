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
public class Pizzarias implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idpizzaria;
    private String nome;
    private double precoPeq;
    private double precoMed;
    private double precoGrd;
    private double precoBorda;
    private Date dtcadastro;
    private Date dthralteracao;

    public Pizzarias() {
    }

    public Pizzarias(Long idpizzaria) {
        this.idpizzaria = idpizzaria;
    }

    public Pizzarias(Long idpizzaria, String nome, double precoPeq, double precoMed, double precoGrd, double precoBorda, Date dtcadastro, Date dthralteracao) {
        this.idpizzaria = idpizzaria;
        this.nome = nome;
        this.precoPeq = precoPeq;
        this.precoMed = precoMed;
        this.precoGrd = precoGrd;
        this.precoBorda = precoBorda;
        this.dtcadastro = dtcadastro;
        this.dthralteracao = dthralteracao;
    }

    public Long getIdpizzaria() {
        return idpizzaria;
    }

    public void setIdpizzaria(Long idpizzaria) {
        this.idpizzaria = idpizzaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoPeq() {
        return precoPeq;
    }

    public void setPrecoPeq(double precoPeq) {
        this.precoPeq = precoPeq;
    }

    public double getPrecoMed() {
        return precoMed;
    }

    public void setPrecoMed(double precoMed) {
        this.precoMed = precoMed;
    }

    public double getPrecoGrd() {
        return precoGrd;
    }

    public void setPrecoGrd(double precoGrd) {
        this.precoGrd = precoGrd;
    }

    public double getPrecoBorda() {
        return precoBorda;
    }

    public void setPrecoBorda(double precoBorda) {
        this.precoBorda = precoBorda;
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Date getDthralteracao() {
        return dthralteracao;
    }

    public void setDthralteracao(Date dthralteracao) {
        this.dthralteracao = dthralteracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpizzaria != null ? idpizzaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizzarias)) {
            return false;
        }
        Pizzarias other = (Pizzarias) object;
        if ((this.idpizzaria == null && other.idpizzaria != null) || (this.idpizzaria != null && !this.idpizzaria.equals(other.idpizzaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifc.entidades.Pizzarias[ idpizzaria=" + idpizzaria + " ]";
    }

}
