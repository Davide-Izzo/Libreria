package com.example.Libreria.Libreria.Entity;


import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table(name= "noleggio")
@Entity
public class Noleggio {
//	@EmbeddedId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	NoleggioKey id;
	private int id;
	
	@ManyToOne
	@MapsId("id_persona")
	@JoinColumn(name = "id_persona")
	Persona persona;
	
	@ManyToOne
	@MapsId("id_libro")
	@JoinColumn(name = "id_libro")
	Libro libro;
	
	@Column
	private int id_libro;
	
	@Column
	private int id_persona;

	@Column
	private boolean stato;
	
	@Column
	private LocalDateTime data_in;
	@Column
	private LocalDateTime data_fin;
	
	public int getId() {
		return id;
	}
	
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public LocalDateTime getData_in() {
		return data_in;
	}

	public void setData_in(LocalDateTime data_in) {
		this.data_in = data_in;
	}

	public LocalDateTime getData_fin() {
		return data_fin;
	}

	public void setData_fin(LocalDateTime data_fin) {
		this.data_fin = data_fin;
	}


}
