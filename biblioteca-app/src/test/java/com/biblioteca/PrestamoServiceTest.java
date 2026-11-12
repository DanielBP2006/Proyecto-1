package com.biblioteca;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.PrestamoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoServiceTest {

    private PrestamoService servicio;
    private Libro libro;
    private Usuario usuario;

    // @BeforeEach se ejecuta antes de cada @Test para preparar los datos
    @BeforeEach
    void setUp() {
        servicio = new PrestamoService();
        libro = new Libro("12345", "Cien años de soledad");
        usuario = new Usuario("U002", "Carlos Pérez");
    }

    @Test
    void testRealizarPrestamoExitoso() {
        boolean resultado = servicio.realizarPrestamo(libro, usuario);
        
        assertTrue(resultado, "El préstamo debería ser exitoso");
        assertTrue(libro.isPrestado(), "El estado del libro debe ser 'prestado'");
    }

    @Test
    void testRealizarPrestamoLibroYaPrestado() {
        servicio.realizarPrestamo(libro, usuario); // Lo prestamos la primera vez
        
        boolean segundoIntento = servicio.realizarPrestamo(libro, usuario); // Intentamos prestarlo de nuevo
        
        assertFalse(segundoIntento, "No se debe poder prestar un libro que ya está prestado");
    }

    @Test
    void testDevolverLibroSinRetraso() {
        servicio.realizarPrestamo(libro, usuario);
        
        double sancion = servicio.devolverLibro(libro, 0); // 0 días de retraso

        assertEquals(0.0, sancion, "La sanción debe ser 0.0 si no hay retraso");
        assertFalse(libro.isPrestado(), "El libro debe volver a estar disponible (no prestado)");
    }

    @Test
    void testDevolverLibroConRetrasoCalculaSancionCorrecta() {
        servicio.realizarPrestamo(libro, usuario);
        
        double sancion = servicio.devolverLibro(libro, 4); // 4 días de retraso * 2 € por día

        assertEquals(8.0, sancion, "La sanción por 4 días de retraso debe ser 8.0 €");
        assertFalse(libro.isPrestado(), "El libro debe volver a estar disponible");
    }
}