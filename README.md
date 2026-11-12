# 📚 Sistema de Gestión de Biblioteca (`biblioteca-app`)

Aplicación de consola desarrollada en **Java 21** y gestionada con **Maven** que simula el funcionamiento básico de una biblioteca: gestión de inventario de libros, registro de socios, realización de préstamos y cálculo automático de sanciones por retraso en la devolución.

El proyecto ha sido planificado y desarrollado siguiendo la metodología ágil **Scrum**, dividido en **2 Sprints de 1 semana** de duración cada uno.

---

## 🛠️ Tecnologías y Herramientas Utilizadas

* **Lenguaje:** Java 21 (LTS)
* **Gestor de Proyecto y Dependencias:** Apache Maven
* **Framework de Pruebas:** JUnit 5 (`junit-jupiter`)
* **IDE:** Visual Studio Code

---

## 📋 Product Backlog (Lista General de Requisitos)

El *Product Backlog* recoge todos los requisitos funcionales y técnicos del proyecto priorizados:

| ID | Historia de Usuario / Tarea | Prioridad | Estado | Sprint |
| :--- | :--- | :---: | :---: | :---: |
| **US-01** | Configurar proyecto base con Maven, Java 21 y JUnit 5. | Alta | ✅ Completado | Sprint 1 |
| **US-02** | Como bibliotecario, quiero registrar libros con ISBN, título y estado de disponibilidad. | Alta | ✅ Completado | Sprint 1 |
| **US-03** | Como bibliotecario, quiero dar de alta usuarios con ID y nombre. | Alta | ✅ Completado | Sprint 1 |
| **US-04** | Como usuario, quiero tomar prestado un libro si está disponible en el catálogo. | Alta | ✅ Completado | Sprint 2 |
| **US-05** | Como bibliotecario, quiero registrar la devolución de un libro y calcular una multa de 2 € por cada día de retraso. | Media | ✅ Completado | Sprint 2 |
| **US-06** | Implementar menú interactivo por consola (`Scanner`) para operar con el sistema. | Media | ✅ Completado | Sprint 2 |
| **US-07** | Desarrollar suite de pruebas unitarias automatizadas para validar la lógica de negocio. | Alta | ✅ Completado | Sprint 2 |
| **US-08** | Limitar a un máximo de 3 libros simultáneos por usuario. | Baja | ⏳ Pendiente | Futuro |
| **US-09** | Guardar los datos en un fichero o base de datos para mantener persistencia. | Baja | ⏳ Pendiente | Futuro |

---

## 📅 Planificación de Sprints (Scrum)

### 🏃‍♂️ Sprint 1 (Semana 1): Cimientos y Modelo de Datos
* **Objetivo del Sprint:** Establecer la arquitectura base del proyecto en Maven y crear las entidades principales del dominio sin lógica compleja.
* **Tareas realizadas:**
  * Generación de la estructura estándar de carpetas (`src/main/java` y `src/test/java`).
  * Configuración del archivo `pom.xml` para compilar con Java 21 e integrar JUnit 5.
  * Creación de la clase `Libro.java` en el paquete `com.biblioteca.model` (controla su estado `prestado`).
  * Creación de la clase `Usuario.java` en el paquete `com.biblioteca.model`.
* **Incremento entregado:** Modelos de datos compilables y listos para ser consumidos.

### 🏃‍♂️ Sprint 2 (Semana 2): Lógica de Negocio, Interacción y Calidad
* **Objetivo del Sprint:** Implementar las reglas de préstamo y devolución, permitir la interacción del usuario por consola y asegurar la calidad mediante pruebas unitarias.
* **Tareas realizadas:**
  * Creación de `PrestamoService.java` en `com.biblioteca.service` con las reglas de negocio (bloqueo de préstamos duplicados y cálculo de sanción a `2.0 €/día`).
  * Creación del menú interactivo por consola en `Main.java` utilizando `java.util.Scanner`.
  * Creación de la clase de pruebas `PrestamoServiceTest.java` en `src/test/java/com/biblioteca/service/` cubriendo casos de éxito y de error.
* **Incremento entregado:** Producto mínimo viable (MVP) funcional, interactivo y verificado por tests automáticos.

---

## 📂 Estructura del Proyecto

```text
biblioteca-app/
├── pom.xml                                      # Configuración de Maven y dependencias
├── README.md                                    # Documentación del proyecto y Scrum
└── src/
    ├── main/
    │   └── java/
    │       └── com/biblioteca/
    │           ├── Main.java                    # Punto de entrada y menú interactivo
    │           ├── model/
    │           │   ├── Libro.java               # Entidad Libro
    │           │   └── Usuario.java             # Entidad Usuario
    │           └── service/
    │               └── PrestamoService.java     # Lógica de préstamos y sanciones
    └── test/
        └── java/
            └── com/biblioteca/
                └── service/
                    └── PrestamoServiceTest.java # Pruebas unitarias con JUnit 5
