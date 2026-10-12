package edu.rico.tutorial.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipo;

    @Column(nullable = false, length = 100)
    private String nombre_equipo;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false)
    private double presupuesto;

    @Column(nullable = false)
    private boolean campeon;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estadio> estadios = new ArrayList<>();

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fichaje> fichajesRealizados = new ArrayList<>();

    // Método de conveniencia para mantener sincronizados ambos lados en memoria:
    public void addEstadio(Estadio estadio) {
        estadios.add(estadio);
        estadio.setEquipo(this);
    }

    public Equipo() {
    }

    public Equipo(String nombre_equipo, String ciudad, double presupuesto, boolean campeon) {
        this.nombre_equipo = nombre_equipo;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
        this.campeon = campeon;
    }

    public Long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public boolean isCampeon() {
        return campeon;
    }

    public void setCampeon(boolean campeon) {
        this.campeon = campeon;
    }

    public List<Estadio> getEstadios() {
        return estadios;
    }

    public void setEstadios(List<Estadio> estadios) {
        this.estadios = estadios;
    }

    public List<Fichaje> getFichajesRealizados() {
        return fichajesRealizados;
    }

    public void setFichajesRealizados(List<Fichaje> fichajesRealizados) {
        this.fichajesRealizados = fichajesRealizados;
    }

}