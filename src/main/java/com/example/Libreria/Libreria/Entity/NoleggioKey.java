package com.example.Libreria.Libreria.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class NoleggioKey  implements Serializable{

	
	@Column(name= "id_persona")
	int id_persona;
	
	@Column(name = "id_libro")
	int id_libro;

	public NoleggioKey(int id_persona, int id_libro) {
		super();
		this.id_persona = id_persona;
		this.id_libro = id_libro;
	}


	public NoleggioKey() {
		super();
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	
	public int generaId(int lid, int pid) {
		int id = lid+pid;
		return id;
	}
	
	

}
