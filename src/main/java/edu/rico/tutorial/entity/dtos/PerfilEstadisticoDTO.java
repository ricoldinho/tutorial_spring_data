package edu.rico.tutorial.entity.dtos;

import edu.rico.tutorial.entity.PerfilEstadistico;

public record PerfilEstadisticoDTO(
        Long idPerfil,
        int partidosJugados,
        int goles,
        int asistencias,
        double valoracionMedia) {

    public static PerfilEstadisticoDTO fromEntity(PerfilEstadistico p) {
        if (p == null) {
            return null;
        }
        return new PerfilEstadisticoDTO(
                p.getId_perfil(),
                p.getPartidos_jugados(),
                p.getGoles(),
                p.getAsistencias(),
                p.getValoracion_media());
    }
}
