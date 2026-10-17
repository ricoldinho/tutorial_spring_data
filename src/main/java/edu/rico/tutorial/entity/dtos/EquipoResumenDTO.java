package edu.rico.tutorial.entity.dtos;

import edu.rico.tutorial.entity.Equipo;

public record EquipoResumenDTO(
        Long idEquipo,
        String nombre,
        String ciudad,
        double presupuesto,
        boolean campeon) {

    public static EquipoResumenDTO fromEntity(Equipo e) {
        if (e == null) {
            return null;
        }
        return new EquipoResumenDTO(
                e.getId_equipo(),
                e.getNombre_equipo(),
                e.getCiudad(),
                e.getPresupuesto(),
                e.isCampeon());
    }
}
