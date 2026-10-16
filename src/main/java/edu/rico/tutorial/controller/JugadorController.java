package edu.rico.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.rico.tutorial.entity.Jugador;
import edu.rico.tutorial.repository.IJugadorRepository;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorRepository jugadorRepository;

    @GetMapping("/all")
    public List<Jugador> encontrarJugadores() {
        return jugadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jugador encontrarJugadorPorId(@PathVariable Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

}
