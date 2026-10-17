package edu.rico.tutorial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rico.tutorial.entity.Jugador;
import edu.rico.tutorial.entity.dtos.JugadorDetalleDTO;
import edu.rico.tutorial.entity.dtos.JugadorListadoDTO;
import edu.rico.tutorial.repository.IJugadorRepository;

@Service
public class JugadorService {

    @Autowired
    private IJugadorRepository jugadorRepo;

    @Transactional(readOnly = true)
    public List<JugadorListadoDTO> listarTodos() {
        List<Jugador> entidades = jugadorRepo.findAll();
        List<JugadorListadoDTO> dtos = new ArrayList<>();

        for (Jugador j : entidades) {
            dtos.add(JugadorListadoDTO.fromEntity(j));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public Optional<JugadorDetalleDTO> obtenerPorId(Long id) {
        Optional<Jugador> jugadorOpt = jugadorRepo.findById(id);

        if (jugadorOpt.isPresent()) {
            JugadorDetalleDTO dto = JugadorDetalleDTO.fromEntity(jugadorOpt.get());
            return Optional.of(dto);
        }

        return Optional.empty();
    }
}
