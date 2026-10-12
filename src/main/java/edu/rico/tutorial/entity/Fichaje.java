package edu.rico.tutorial.entity;

import java.math.BigDecimal;

import edu.rico.tutorial.entity.enums.PeriodoMercado;
import edu.rico.tutorial.entity.enums.TipoOperacion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fichajes")
public class Fichaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fichaje;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @Column(nullable = false, length = 5)
    private String temporada;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;
    @Column(nullable = false)
    private boolean clausula_rescision_pagada;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private PeriodoMercado mercado;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoOperacion tipo;

    public Fichaje() {
    }

    public Fichaje(Jugador jugador, Equipo equipo, String temporada, BigDecimal precio,
            boolean clausula_rescision_pagada, PeriodoMercado mercado, TipoOperacion tipo) {
        this.jugador = jugador;
        this.equipo = equipo;
        this.temporada = temporada;
        this.precio = precio;
        this.clausula_rescision_pagada = clausula_rescision_pagada;
        this.mercado = mercado;
        this.tipo = tipo;
    }

    public Long getId_fichaje() {
        return id_fichaje;
    }

    public void setId_fichaje(Long id_fichaje) {
        this.id_fichaje = id_fichaje;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean isClausula_rescision_pagada() {
        return clausula_rescision_pagada;
    }

    public void setClausula_rescision_pagada(boolean clausula_rescision_pagada) {
        this.clausula_rescision_pagada = clausula_rescision_pagada;
    }

    public PeriodoMercado getMercado() {
        return mercado;
    }

    public void setMercado(PeriodoMercado mercado) {
        this.mercado = mercado;
    }

    public TipoOperacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacion tipo) {
        this.tipo = tipo;
    }

}
