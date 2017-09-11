/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fabricio
 */
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idcliente;
    private String nome;
    private String telefone;
    private String endereco;

    public Clientes() {
    }

    public Clientes(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Clientes(Long idcliente, String nome, String endereco) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idcliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clientes other = (Clientes) obj;
        if (!Objects.equals(this.idcliente, other.idcliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idcliente=" + idcliente + '}';
    }

}
