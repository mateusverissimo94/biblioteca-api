package com.fuctura.biblioteca.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuctura.biblioteca.enums.Tamanho;
import com.fuctura.biblioteca.model.Categoria;
import com.fuctura.biblioteca.model.Livro;
import org.hibernate.validator.constraints.Length;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;

public class LivroDTO {

    private Integer id;
    @NotEmpty(message = "O campo TITULO é requerido")
    @Length(min = 5, max = 50, message = "O campo TITULO deve conter entre 5 e 50 caracteres")
    private String titulo;
    @NotEmpty(message = "O campo NOME DO AUTOR é requerido")
    @Length(min = 5, max = 50, message = "O campo NOME DO AUTOR deve conter entre 5 e 50 caracteres")
    private String nomeAutor;
    @NotEmpty(message = "O campo TEXTO é requerido")
    @Length(min = 50, max = 200, message = "O campo TEXTO deve conter entre 5 e 50 caracteres")
    private String texto;
    private Tamanho tamanho;
    private Categoria categoria;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        this.id = livro.getid();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getNomeAutor();
        this.texto = livro.getTexto();
        this.tamanho = livro.getTamanho();
        this.categoria = livro.getCategoria();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
