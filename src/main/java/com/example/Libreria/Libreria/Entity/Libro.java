package com.example.Libreria.Libreria.Entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table(name = "libro")
@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message="titolo obbligatorio")
	@Size(min = 2, max = 20)
	@Column
	private String titolo;
	
	@NotBlank(message = "categoria obbligatoria")
	@Size(min = 2, max = 20)
	@Column
	private String categoria;
	
	@NotNull
	@Min(1)
	@Column
	private double prezzo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_scaffale")
	private Scaffale scaffale;
	
	
	@OneToMany(mappedBy = "libro")
	Set<Noleggio> noleggi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
