package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;

public class PrestamoService {
    private static final double SANCION_POR_DIA = 2.0;

    public boolean realizarPrestamo(Libro libro, Usuario usuario) {
        if (libro.isPrestado()) {
            return false;
        }
        libro.setPrestado(true);
        return true;
    }

    public double devolverLibro(Libro libro, int diasRetraso) {
        if (!libro.isPrestado()) {
            throw new IllegalArgumentException("El libro no estaba prestado.");
        }
        libro.setPrestado(false);

        if (diasRetraso > 0) {
            return diasRetraso * SANCION_POR_DIA;
        }
        return 0.0;
    }
}