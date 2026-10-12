package edu.rico.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	}

}
