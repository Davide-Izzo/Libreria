package com.example.Libreria.Libreria.Service;



import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.Libreria.Libreria.Entity.Libro;
import com.example.Libreria.Libreria.Entity.Noleggio;
import com.example.Libreria.Libreria.Entity.Persona;
import com.example.Libreria.Libreria.Repository.LibroRepo;
import com.example.Libreria.Libreria.Repository.NoleggioRepo;
import com.example.Libreria.Libreria.Repository.PersonaRepo;


@org.springframework.stereotype.Service
public class Service{

	@Autowired
	LibroRepo libroRepo;

	@Autowired
	PersonaRepo personaRepo;

	@Autowired
	NoleggioRepo noleggioRepo;

	//variabile per return lato controller
	int check;

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}



	public Noleggio noleggia(int LId, int PId) {

		Noleggio n1 = new Noleggio();
		Optional<Noleggio>noleggio;
		LocalDateTime dt = LocalDateTime.now();

		// vedo parametri passati dalla chiamata http
		try {
			System.out.println("id Libro: "+LId);
			System.out.println("id Persona: "+PId);

			// trovo libro e persona con id corrispondente
			Optional<Libro> l1 = libroRepo.findById(LId);
			Optional <Persona> p1 = personaRepo.findById(PId);

			// se gli id esistono vado a settare i campi del noleggio
			if(l1.isPresent()&& p1.isPresent()) {
				n1.setId_libro(LId);
				n1.setId_persona(PId);
				n1.setStato(true);
				n1.setData_in(dt);;
				//se la lista di noleggi contiene già il noleggio esco, se no salvo
				noleggio = noleggioRepo.findByIdLibroAndStato(LId, true);
				if(noleggio.isPresent()) {
					check=0;
				}
				else {
					noleggioRepo.save(n1);
					check=1;
				}
			}
		}
		catch (MethodArgumentTypeMismatchException e) {
			e.getMessage();
		}
		return n1;
	}	

	public int restituisci(int LId) {
		//recupero id noleggio
		try {
			Optional <Integer> num = noleggioRepo.findByIdLibroAndstato(LId,true);
			int id=0;
			LocalDateTime dt = LocalDateTime.now();
			if(num.isPresent()) {
				id=num.get();
				//controllo che esista un noleggio che abbia quell'id
				Optional <Noleggio> n1=noleggioRepo.findById(id);
				if(n1.isPresent()) {			
					Noleggio n=n1.get();
					//spengo stato del noleggio e salvo
					n.setStato(false);
					n.setData_fin(dt);
					noleggioRepo.save(n);
					check=1;
				}
				else {
					check = 0;
				}
			}
			else {
				check=0;
			}
		}
		catch(MethodArgumentTypeMismatchException e) {
			e.getMessage();
		}
		return check;
	}

}

