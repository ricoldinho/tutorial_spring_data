package edu.rico.tutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.rico.tutorial.entity.dtos.JugadorDetalleDTO;
import edu.rico.tutorial.entity.dtos.JugadorListadoDTO;
import edu.rico.tutorial.service.JugadorService;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // Endpoint 1: Listado general
    // GET http://localhost:8080/api/jugadores
    @GetMapping
    public ResponseEntity<List<JugadorListadoDTO>> listarTodos() {
        List<JugadorListadoDTO> jugadores = jugadorService.listarTodos();
        return ResponseEntity.ok(jugadores);
    }

    // Endpoint 2: Detalle por ID
    // GET http://localhost:8080/api/jugadores/{id}
    @GetMapping("/{id}")
    public ResponseEntity<JugadorDetalleDTO> obtenerPorId(@PathVariable Long id) {
        Optional<JugadorDetalleDTO> jugadorOpt = jugadorService.obtenerPorId(id);

        if (jugadorOpt.isPresent()) {
            return ResponseEntity.ok(jugadorOpt.get());
        }

        return ResponseEntity.notFound().build();
    }
}
