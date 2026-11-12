package com.biblioteca;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.PrestamoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrestamoService servicio = new PrestamoService();

        // 1. Creamos una pequeña base de datos en memoria
        List<Libro> catalogo = new ArrayList<>();
        catalogo.add(new Libro("978-01", "Don Quijote de la Mancha"));
        catalogo.add(new Libro("978-02", "Cien años de soledad"));
        catalogo.add(new Libro("978-03", "El Principito"));

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("U01", "Ana Gómez"));
        usuarios.add(new Usuario("U02", "Carlos Pérez"));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== 📚 BIBLIOTECA MUNICIPAL ===");
            System.out.println("1. Ver catálogo de libros");
            System.out.println("2. Registrar nuevo libro");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Catálogo Actual ---");
                    for (int i = 0; i < catalogo.size(); i++) {
                        Libro l = catalogo.get(i);
                        String estado = l.isPrestado() ? "[PRESTADO]" : "[DISPONIBLE]";
                        System.out.println(i + ". " + l.getTitulo() + " (ISBN: " + l.getIsbn() + ") " + estado);
                    }
                    break;

                case 2:
                    System.out.print("\nIntroduce el ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Introduce el título del libro: ");
                    String titulo = scanner.nextLine();
                    catalogo.add(new Libro(isbn, titulo));
                    System.out.println("✅ Libro añadido al catálogo.");
                    break;

                case 3:
                    System.out.println("\n¿Qué libro quieres prestar? (Introduce el número):");
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println(i + ". " + catalogo.get(i).getTitulo());
                    }
                    int indiceLibroPrestar = scanner.nextInt();

                    System.out.println("¿A qué usuario? (Introduce el número):");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + ". " + usuarios.get(i).getNombre());
                    }
                    int indiceUsuario = scanner.nextInt();

                    if (indiceLibroPrestar >= 0 && indiceLibroPrestar < catalogo.size() &&
                        indiceUsuario >= 0 && indiceUsuario < usuarios.size()) {
                        
                        Libro libroSeleccionado = catalogo.get(indiceLibroPrestar);
                        Usuario usuarioSeleccionado = usuarios.get(indiceUsuario);

                        if (servicio.realizarPrestamo(libroSeleccionado, usuarioSeleccionado)) {
                            System.out.println("✅ Préstamo registrado a nombre de " + usuarioSeleccionado.getNombre());
                        } else {
                            System.out.println("❌ Error: Ese libro ya está prestado.");
                        }
                    } else {
                        System.out.println("❌ Selección no válida.");
                    }
                    break;

                case 4:
                    System.out.println("\n¿Qué libro se va a devolver? (Introduce el número):");
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println(i + ". " + catalogo.get(i).getTitulo());
                    }
                    int indiceLibroDevolver = scanner.nextInt();

                    if (indiceLibroDevolver >= 0 && indiceLibroDevolver < catalogo.size()) {
                        Libro libroDevolver = catalogo.get(indiceLibroDevolver);
                        if (!libroDevolver.isPrestado()) {
                            System.out.println("❌ Ese libro no estaba prestado.");
                        } else {
                            System.out.print("¿Cuántos días de retraso tiene?: ");
                            int dias = scanner.nextInt();
                            double multa = servicio.devolverLibro(libroDevolver, dias);
                            System.out.println("✅ Libro devuelto correctamente.");
                            System.out.println("💰 Sanción a pagar: " + multa + " €");
                        }
                    } else {
                        System.out.println("❌ Selección no válida.");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Cerrando sistema de biblioteca...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        }
        scanner.close();
    }
}