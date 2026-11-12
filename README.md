# Product Backlog - Sistema de Gestión de Biblioteca

---

## Lista General de Requisitos (Product Backlog)

| ID | Historia de Usuario | Prioridad | Sprint Asignado | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **HU-01** | Como bibliotecario, quiero registrar un libro con título y autor para tenerlo identificado. | Alta | Sprint 1 | Completado |
| **HU-02** | Como usuario, quiero prestar un libro disponible para llevármelo a casa. | Alta | Sprint 1 | Completado |
| **HU-03** | Como usuario, quiero devolver un libro prestado para que vuelva a estar disponible. | Alta | Sprint 1 | Completado |
| **HU-04** | Como bibliotecario, quiero guardar varios libros en un catálogo central para organizarlos. | Media | Sprint 2 | Completado |
| **HU-05** | Como usuario, quiero buscar un libro por título para saber si existe en la biblioteca. | Media | Sprint 2 | Completado |
| **HU-06** | Como usuario, quiero ejecutar el sistema en consola para interactuar con la biblioteca. | Baja | Sprint 2 | Completado |

---

## Planificación por Sprints

### Sprint 1 (Semana 1): Modelo Base del Libro
**Objetivo:** Construir y validar la entidad principal (`Libro`) y su lógica de estados (disponible/prestado).
- **Tareas:**
  - [x] Configurar proyecto Maven y dependencias de JUnit 5 (`pom.xml`).
  - [x] Implementar clase `Libro.java` (HU-01, HU-02, HU-03).
  - [x] Implementar pruebas unitarias en `LibroTest.java`.

### Sprint 2 (Semana 2): Catálogo y Ejecución
**Objetivo:** Gestionar una colección de libros, permitir búsquedas y crear el punto de entrada ejecutable.
- **Tareas:**
  - [x] Implementar clase `Biblioteca.java` con lista de libros (HU-04).
  - [x] Añadir método de búsqueda por título en `Biblioteca.java` (HU-05).
  - [x] Implementar pruebas unitarias en `BibliotecaTest.java`.
  - [x] Crear clase principal `Main.java` para demostración por consola (HU-06).
