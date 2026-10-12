package edu.rico.tutorial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.rico.tutorial.entity.Jugador;
import edu.rico.tutorial.entity.enums.Posicion;

public interface IJugadorRepository extends JpaRepository<Jugador, Long> {

    Optional<Jugador> findByMote(String mote);

    List<Jugador> findByPosicion(Posicion posicion);

    List<Jugador> findByPosicionAndNombre(Posicion posicion, String nombre);

    List<Jugador> findByPosicionOrMote(Posicion posicion, String mote);

    List<Jugador> findByNombreIgnoreCase(String nombre);

    List<Jugador> findByNombreStartingWithIgnoreCase(String nombre);

    List<Jugador> findByPosicionOrderByNombreAsc(Posicion posicion);

    // ?1 se vincula al 1.er argumento (posicionTexto)
    // ?2 se vincula al 2.º argumento (subcadenaNombre)
    @Query(value = "SELECT * FROM jugadores " +
            "WHERE posicion = ?1 AND nombre LIKE CONCAT('%', ?2, '%')", nativeQuery = true)
    List<Jugador> buscarPorPosicionYNombreContieneNativo(String posicionTexto, String subcadenaNombre);
}
