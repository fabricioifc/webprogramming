/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.model;

import java.io.Serializable;

/**
 *
 * @author fabricio
 */
public class Pizzaria implements Serializable {

    private Integer id;
    private String nome;
    private Double precoPeq;
    private Double precoMed;
    private Double precoGrd;
    private Double precoBorda;

    public Pizzaria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoPeq() {
        return precoPeq;
    }

    public void setPrecoPeq(Double precoPeq) {
        this.precoPeq = precoPeq;
    }

    public Double getPrecoMed() {
        return precoMed;
    }

    public void setPrecoMed(Double precoMed) {
        this.precoMed = precoMed;
    }

    public Double getPrecoGrd() {
        return precoGrd;
    }

    public void setPrecoGrd(Double precoGrd) {
        this.precoGrd = precoGrd;
    }

    public Double getPrecoBorda() {
        return precoBorda;
    }

    public void setPrecoBorda(Double precoBorda) {
        this.precoBorda = precoBorda;
    }

}