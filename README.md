# ⚽ TutorialClase

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?logo=springboot)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-Hibernate-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.x-4479A1?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3+-C71A36?logo=apachemaven)
![License](https://img.shields.io/badge/License-Educational-lightgrey)

## Persistencia y Relaciones con Spring Data JPA y MySQL

> Proyecto formativo orientado al aprendizaje de persistencia de datos relacionales utilizando Spring Boot, Spring Data JPA y MySQL.

---

## 📑 Tabla de Contenidos

- [📖 Descripción](#-descripción)
- [🎯 Objetivos de aprendizaje](#-objetivos-de-aprendizaje)
- [🛠️ Tecnologías](#️-tecnologías)
- [📂 Estructura del proyecto](#-estructura-del-proyecto)
- [🗄️ Modelo Relacional](#️-modelo-relacional)
- [⚙️ Configuración](#️-configuración)
- [📊 Datos precargados](#-datos-precargados)
- [🔍 Repositorio JPA](#-repositorio-jpa)
- [🚀 Puesta en marcha](#-puesta-en-marcha)
- [✅ Salida esperada](#-salida-esperada)
- [👨‍🎓 Finalidad académica](#-finalidad-académica)

---

## 📖 Descripción

**TutorialClase** es un proyecto académico diseñado para comprender de forma progresiva cómo modelar entidades, relaciones y repositorios utilizando **Spring Data JPA**.

El proyecto elimina deliberadamente las capas de presentación (REST Controllers) y seguridad (Spring Security) para centrar la atención exclusivamente en el modelado del dominio, la persistencia con JPA/Hibernate, las relaciones entre entidades, las consultas mediante repositorios y la carga inicial de datos usando `data.sql`.

---

## 🎯 Objetivos de aprendizaje

### Entidades JPA

- `@Entity`
- `@Table`
- `@Id`
- `@GeneratedValue`
- `@Column`
- `@Enumerated`

### Relaciones entre entidades

- Relación **1:1**: `Jugador ↔ PerfilEstadistico`
- Relación **1:N / N:1**: `Equipo ↔ Estadio`
- Relación **N:M mediante entidad intermedia**: `Jugador ↔ Fichaje ↔ Equipo`

### Spring Data JPA

- Extensión de `JpaRepository`
- Consultas derivadas por nombre
- Consultas SQL nativas
- Uso de `@Query`

### Carga inicial de datos

Utilización de `data.sql` respetando dependencias y claves foráneas.

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate ORM
- Maven
- MySQL 8.x
- HikariCP
- Spring Boot DevTools
- Spring Boot Actuator

---

## 📂 Estructura del proyecto

```text
TutorialClase/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── src
    ├── main
    │   ├── java
    │   │   └── edu/rico/tutorial
    │   │       ├── TutorialClaseApplication.java
    │   │       ├── entity
    │   │       ├── repository
    │   │       └── enums
    │   └── resources
    │       ├── application.properties
    │       └── data.sql
    └── test
```

---

## 🗄️ Modelo Relacional

```text
PerfilEstadistico (1:1) Jugador
Jugador (1:N) Fichaje (N:1) Equipo
Equipo (1:N) Estadio
```

### Jugador ↔ PerfilEstadistico

```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "id_perfil", unique = true)
```

### Equipo ↔ Estadio

```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_equipo", nullable = false)
```

```java
@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
```

---

## ⚙️ Configuración

```properties
spring.application.name=TutorialClase
spring.datasource.url=jdbc:mysql://localhost:3306/jugadoresfutbol?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
```

---

## 📊 Datos precargados

1. perfiles_estadisticos
2. equipos
3. estadios
4. jugadores
5. fichajes

---

## 🔍 Repositorio JPA

```java
public interface IJugadorRepository extends JpaRepository<Jugador, Long> {
    Optional<Jugador> findByMote(String mote);
    List<Jugador> findByPosicion(Posicion posicion);
    boolean existsByMote(String mote);
}
```

---

## 🚀 Puesta en marcha

```bash
git clone https://github.com/ricoldinho/TutorialClase.git
cd TutorialClase
./mvnw clean spring-boot:run
```

---

## ✅ Salida esperada

```text
Hibernate: create table if not exists perfiles_estadisticos (...)
Hibernate: create table if not exists equipos (...)
Hibernate: select count(*) from jugadores
```

---

## 👨‍🎓 Finalidad académica

Proyecto orientado al aprendizaje práctico de JPA, Hibernate y Spring Data JPA mediante un dominio basado en el fútbol profesional.
