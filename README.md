# ⚽ TutorialClase: Persistencia con Spring Data JPA y MySQL

Bienvenido al repositorio **TutorialClase**, un proyecto formativo y práctico diseñado para comprender desde cero la arquitectura de persistencia de datos en el ecosistema Java con **Spring Boot**, **Spring Data JPA** y **MySQL**.

---

## 🎯 Propósito del Proyecto

Este repositorio tiene un enfoque **estrictamente educativo** para el aula. Su objetivo principal es aislar y dominar la **capa de acceso a datos**:
* Aprender a estructurar un proyecto Maven limpio sin capas que añadan ruido innecesario (sin controladores web/REST ni capas de seguridad).
* Mapear clases del dominio Java a tablas relacionales mediante anotaciones JPA (`@Entity`, `@Table`, `@Enumerated`).
* Comprender el funcionamiento del patrón **Repository** a través de `JpaRepository`.
* Configurar la creación y sincronización automática del esquema con MySQL.

---

## 🛠️ Tecnologías y Dependencias

El proyecto está construido sobre las siguientes tecnologías:

* **Java 21**
* **Spring Boot** (Gestión de la aplicación y contexto)
* **Apache Maven** (Gestor de dependencias y construcción)
* **MySQL** (Sistema gestor de bases de datos relacional)

### 📦 Starters & Librerías Clave

| Dependencia | Identificador Maven | Rol en el Proyecto |
| :--- | :--- | :--- |
| **Spring Data JPA** | `spring-boot-starter-data-jpa` | Provee Hibernate, EntityManager y las interfaces de repositorio automáticas. |
| **MySQL Connector/J** | `mysql-connector-j` | Driver JDBC oficial para la comunicación binaria con el servidor MySQL. |
| **Spring Boot DevTools** | `spring-boot-devtools` | Herramientas de desarrollo, recarga rápida y reinicio automático de contexto. |

---

## 📂 Estructura del Proyecto

El código fuente sigue las convenciones recomendadas de Spring Boot bajo el paquete base `edu.rico.tutorial`:

```text
TutorialClase/
├── pom.xml                                   # Configuración de dependencias Maven
└── src/
    ├── main/
    │   ├── java/
    │   │   └── edu/rico/tutorial/
    │   │       ├── TutorialClaseApplication.java   # Clase principal (CommandLineRunner)
    │   │       ├── entity/
    │   │       │   ├── Jugador.java                # Entidad JPA (@Entity, @Table)
    │   │       │   └── enums/
    │   │       │       └── Posicion.java           # Enumerado para posiciones de juego
    │   │       └── repository/
    │   │           └── IJugadorRepository.java     # Repositorio (JpaRepository<Jugador, Long>)
    │   └── resources/
    │       └── application.properties              # Configuración de conexión y DDL de Hibernate
    └── test/
        └── java/edu/rico/tutorial/
            └── TutorialClaseApplicationTests.java  # Pruebas de carga de contexto
```text

## Configuración properties

spring.application.name=TutorialClase

# Conexión JDBC (crea el esquema automáticamente si no existe)
spring.datasource.url=jdbc:mysql://localhost:8889/jugadoresfutbol?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Comportamiento JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
