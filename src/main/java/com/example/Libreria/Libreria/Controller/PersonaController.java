package com.example.Libreria.Libreria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Libreria.Libreria.Entity.Persona;
import com.example.Libreria.Libreria.Repository.PersonaRepo;

@RestController
public class PersonaController {

	@Autowired
	PersonaRepo personaRepo;
	
	@PostMapping(value="/inserisciPersona")
	public String inserisciPersona(@RequestBody Persona p1) {
		personaRepo.save(p1);
		return "persona inserita a db";
	}
	
}
