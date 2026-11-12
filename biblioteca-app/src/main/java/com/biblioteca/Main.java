package com.biblioteca;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.PrestamoService;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro("978-84-376-0494-7", "Don Quijote de la Mancha");
        Usuario usuario = new Usuario("U001", "Ana Gómez");
        PrestamoService servicio = new PrestamoService();

        System.out.println("Realizando préstamo...");
        boolean exito = servicio.realizarPrestamo(libro, usuario);
        System.out.println("¿Préstamo exitoso?: " + exito);

        System.out.println("\nDevolviendo libro con 3 días de retraso...");
        double sancion = servicio.devolverLibro(libro, 3);
        System.out.println("Sanción calculada: " + sancion + " €");
    }
}