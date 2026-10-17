package edu.rico.tutorial.entity.dtos;

import java.math.BigDecimal;

import edu.rico.tutorial.entity.Fichaje;
import edu.rico.tutorial.entity.enums.PeriodoMercado;
import edu.rico.tutorial.entity.enums.TipoOperacion;

public record FichajeDetalleDTO(
        Long idFichaje,
        String temporada,
        BigDecimal precio,
        boolean clausulaPagada,
        PeriodoMercado mercado,
        TipoOperacion tipo,
        EquipoResumenDTO equipo) {

    public static FichajeDetalleDTO fromEntity(Fichaje f) {
        if (f == null) {
            return null;
        }
        return new FichajeDetalleDTO(
                f.getId_fichaje(),
                f.getTemporada(),
                f.getPrecio(),
                f.isClausula_rescision_pagada(),
                f.getMercado(),
                f.getTipo(),
                EquipoResumenDTO.fromEntity(f.getEquipo()));
    }
}
