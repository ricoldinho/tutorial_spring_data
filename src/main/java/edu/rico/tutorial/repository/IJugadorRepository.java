package edu.rico.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.tutorial.entity.Jugador;

public interface IJugadorRepository extends JpaRepository<Jugador, Long> {

}
