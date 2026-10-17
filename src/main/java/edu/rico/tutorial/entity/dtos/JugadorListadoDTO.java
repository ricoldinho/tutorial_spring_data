package edu.rico.tutorial.entity.dtos;

import edu.rico.tutorial.entity.Jugador;
import edu.rico.tutorial.entity.enums.Posicion;

public record JugadorListadoDTO(
        Long id,
        String nombre,
        String mote,
        Posicion posicion,
        int partidosJugados,
        int goles,
        double valoracionMedia) {

    public static JugadorListadoDTO fromEntity(Jugador j) {
        int partidos = 0;
        int goles = 0;
        double valoracion = 0.0;

        if (j.getPerfil() != null) {
            partidos = j.getPerfil().getPartidos_jugados();
            goles = j.getPerfil().getGoles();
            valoracion = j.getPerfil().getValoracion_media();
        }

        return new JugadorListadoDTO(
                j.getId_jugador(),
                j.getNombre(),
                j.getMote(),
                j.getPosicion(),
                partidos,
                goles,
                valoracion);
    }
}
