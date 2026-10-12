package edu.rico.tutorial.entity;

import java.util.ArrayList;
import java.util.List;

import edu.rico.tutorial.entity.enums.Posicion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jugador;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false, unique = true)
    private String mote;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Posicion posicion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", unique = true)
    private PerfilEstadistico perfil;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fichaje> historialFichajes = new ArrayList<>();

    public Jugador() {
    }

    public Jugador(String nombre, String mote, Posicion posicion) {
        this.nombre = nombre;
        this.mote = mote;
        this.posicion = posicion;
    }

    public Jugador(String nombre, String mote, Posicion posicion, PerfilEstadistico perfil) {
        this.nombre = nombre;
        this.mote = mote;
        this.posicion = posicion;
        this.perfil = perfil;
    }

    public PerfilEstadistico getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEstadistico perfil) {
        this.perfil = perfil;
    }

    public Long getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Long id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador [id_jugador=" + id_jugador + ", nombre=" + nombre + ", mote=" + mote + ", posicion=" + posicion
                + "]";
    }

    public List<Fichaje> getHistorialFichajes() {
        return historialFichajes;
    }

    public void setHistorialFichajes(List<Fichaje> historialFichajes) {
        this.historialFichajes = historialFichajes;
    }

}
