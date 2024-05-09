package com.example.Libreria.Libreria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Libreria.Libreria.Entity.Noleggio;
import com.example.Libreria.Libreria.Repository.NoleggioRepo;
import com.example.Libreria.Libreria.Service.Service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@RestControllerAdvice
public class OperazioniController {

	@Autowired
	private Service s1;
	@Autowired
	private NoleggioRepo noleggioRepo;
	
	

	//inserire id libro e id persona
	@PostMapping(value = "/noleggiaLibro/{LId}/{PId}")
	public List<Noleggio> noleggiaLibro( @PathVariable int LId, @PathVariable int PId) {
		s1.noleggia(LId,PId);
		if(s1.getCheck()==0) {
			System.out.println("non possibile");
			return noleggioRepo.findAll();
		}
		else {
			return noleggioRepo.findAll();}
	}

	//inserire id libro da restituire
	@PostMapping(value="/restituisciLibro/{LId}")
	public List<Noleggio> restituisciLibro(@PathVariable int LId) {
		s1.restituisci(LId);
		if(s1.getCheck()==0) {
			return noleggioRepo.findAll();
		}
		else {
			return noleggioRepo.findAll();
		}
	}

}