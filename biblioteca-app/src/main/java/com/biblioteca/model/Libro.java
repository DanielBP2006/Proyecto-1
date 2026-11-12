package com.biblioteca.model;

public class Libro {
    private String isbn;
    private String titulo;
    private boolean prestado;

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public boolean isPrestado() { return prestado; }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}