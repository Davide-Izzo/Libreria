package com.example.Libreria.Libreria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Libreria.Libreria.Entity.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Integer>{

}
