/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.entidades;

/**
 *
 * @author fabricio
 */
public class Filmes {

    private Integer id;
    private String nome;
    private String genero;
    private String imagem;
    private Integer estrelas;

    public Filmes(Integer id, String nome, String genero, String imagem, Integer estrelas) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.imagem = imagem;
        this.estrelas = estrelas;
    }

    public Filmes() {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    @Override
    public String toString() {
        return "Filmes{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + ", imagem=" + imagem + ", estrelas=" + estrelas + '}';
    }

}
