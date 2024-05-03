package com.example.Libreria.Libreria.Entity;


import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "scaffale")
@Entity
public class Scaffale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descrizione;
	
	@OneToMany(mappedBy = "scaffale", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	 List<Libro> listaLibri;
	

	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
