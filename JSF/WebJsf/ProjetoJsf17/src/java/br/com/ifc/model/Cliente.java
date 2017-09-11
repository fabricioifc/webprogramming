/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.model;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Cliente {

    private String nome;
    private String email;
    private Integer idade;
    private Double salario;
    private Date dataNascimento;
    private TipoPessoa tipoPessoa;

    public Cliente() {
    }

    public Cliente(String nome, String email, Integer idade, Double salario, Date dataNascimento, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", email=" + email + ", idade=" + idade + ", salario=" + salario + ", dataNascimento=" + dataNascimento + ", tipoPessoa=" + tipoPessoa + '}';
    }

}
