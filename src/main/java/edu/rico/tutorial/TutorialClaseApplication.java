package edu.rico.tutorial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.rico.tutorial.entity.Jugador;
import edu.rico.tutorial.entity.enums.Posicion;
import edu.rico.tutorial.repository.IJugadorRepository;

@SpringBootApplication
public class TutorialClaseApplication implements CommandLineRunner {

	@Autowired
	private IJugadorRepository jugarepo;

	public static void main(String[] args) {
		SpringApplication.run(TutorialClaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. CREATE: Guardar un jugador
		Jugador j1 = new Jugador("Lionel Messi", "La Pulga", Posicion.DELANTERO);
		j1.setId_jugador(1L);
		jugarepo.save(j1);

		// 2. READ: Comprobar existencia y recuperar por ID
		if (jugarepo.existsById(1L)) {
			jugarepo.findById(1L).ifPresent(j -> System.out.println("Encontrado: " + j));
		}

		// 3. READ ALL: Listar todos
		List<Jugador> lista = jugarepo.findAll();
		System.out.println("Total jugadores: " + lista.size());

		// 4. UPDATE: Modificar y guardar
		j1.setNombre("Lionel Andrés Messi");
		jugarepo.save(j1); // Al tener ID 1L existente, actualiza en lugar de insertar

		// 5. DELETE: Borrar por ID
		// jugarepo.deleteById(1L);
	}

}
