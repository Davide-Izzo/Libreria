package com.example.Libreria.Libreria.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Libreria.Libreria.Entity.Libro;
import com.example.Libreria.Libreria.Repository.LibroRepo;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import jakarta.validation.Valid;

@RestController
public class LibroController {

	@Autowired
	private LibroRepo libroRepo;


	@GetMapping(value="/getLibri")
	public List<Libro> getLibri(){
		return libroRepo.findAll();
	}

	@GetMapping(value="/getLibro/{id}")
	public Libro getLibro(@PathVariable int id){
		Libro libro = null;
		Optional<Libro> l1 = libroRepo.findById(id);
		if(l1.isPresent()) {
			libro = l1.get();
		}
		return libro;
	}


	@PostMapping(value="/inserisci")
	public String inserisciLibro(@Valid @RequestBody Libro libro) {
		libroRepo.save(libro);
		return "libro salvato correttamente";
	}

	@DeleteMapping(value="/elimina/{id}")
	public String eliminaLibro(@PathVariable int id) {
		libroRepo.deleteById(id);
		return "eliminato il libro con l'id: "+id;
	}


	//stampa a video messaggio della validazione
	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
