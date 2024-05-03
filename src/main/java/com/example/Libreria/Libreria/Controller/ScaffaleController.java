package com.example.Libreria.Libreria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.Libreria.Libreria.Entity.Scaffale;
import com.example.Libreria.Libreria.Repository.ScaffaleRepo;

@RestController
public class ScaffaleController {
	@Autowired
	private ScaffaleRepo scaffaleRepo;
	
	@PostMapping(value="/inserisciScaffale")
	public String inserisciScaffale(@RequestBody Scaffale scaffale) {
		scaffaleRepo.save(scaffale);
		return "inserito scaffale";
	}
}
