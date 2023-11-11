package com.fuctura.biblioteca.model;

public class Livro {
    private Integer idLivro;
    private String titulo;
    private String nomeAutor;
    private String texto;
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer idLivro, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", texto='" + texto + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
