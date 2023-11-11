package com.fuctura.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer idCategoria;
    private String nome;
    private String descricao;
    private List<Livro> livros = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nome, String descricao, List<Livro> livros) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.livros = livros;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", livros=" + livros +
                '}';
    }
}
