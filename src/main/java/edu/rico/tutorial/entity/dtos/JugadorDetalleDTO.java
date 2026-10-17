package edu.rico.tutorial.entity.dtos;

import java.util.ArrayList;
import java.util.List;

import edu.rico.tutorial.entity.Fichaje;
import edu.rico.tutorial.entity.Jugador;
import edu.rico.tutorial.entity.enums.Posicion;

public record JugadorDetalleDTO(
        Long id,
        String nombre,
        String mote,
        Posicion posicion,
        PerfilEstadisticoDTO perfil,
        List<FichajeDetalleDTO> fichajes) {

    public static JugadorDetalleDTO fromEntity(Jugador j) {
        if (j == null) {
            return null;
        }

        List<FichajeDetalleDTO> listaFichajes = new ArrayList<>();
        if (j.getHistorialFichajes() != null) {
            for (Fichaje f : j.getHistorialFichajes()) {
                listaFichajes.add(FichajeDetalleDTO.fromEntity(f));
            }
        }

        return new JugadorDetalleDTO(
                j.getId_jugador(),
                j.getNombre(),
                j.getMote(),
                j.getPosicion(),
                PerfilEstadisticoDTO.fromEntity(j.getPerfil()),
                listaFichajes);
    }
}
