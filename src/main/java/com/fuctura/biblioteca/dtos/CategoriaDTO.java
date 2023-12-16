package com.fuctura.biblioteca.dtos;

import com.fuctura.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO(){}

    public CategoriaDTO(Integer id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
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
}
