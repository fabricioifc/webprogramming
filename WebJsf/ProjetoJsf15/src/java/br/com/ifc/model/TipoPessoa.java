/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.model;

import java.util.Objects;

/**
 *
 * @author fabricio
 */
public class TipoPessoa {

    private Long id;
    private Character tipo;
    private String descricao;

    public TipoPessoa() {
    }

    public TipoPessoa(Long id, Character tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 67 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final TipoPessoa other = (TipoPessoa) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return id.toString();
    }

}
