package edu.rico.tutorial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfiles_estadisticos")
public class PerfilEstadistico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perfil;

    @Column(nullable = false)
    private int partidos_jugados;

    @Column(nullable = false)
    private int goles;

    @Column(nullable = false)
    private int asistencias;

    @Column(nullable = false)
    private double valoracion_media;

    public PerfilEstadistico() {
    }

    public PerfilEstadistico(int partidos_jugados, int goles, int asistencias, double valoracion_media) {
        this.partidos_jugados = partidos_jugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.valoracion_media = valoracion_media;
    }

    public Long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public double getValoracion_media() {
        return valoracion_media;
    }

    public void setValoracion_media(double valoracion_media) {
        this.valoracion_media = valoracion_media;
    }

}