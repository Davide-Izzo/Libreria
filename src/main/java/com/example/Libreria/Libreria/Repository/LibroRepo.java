package com.example.Libreria.Libreria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Libreria.Libreria.Entity.Libro;

public interface LibroRepo extends JpaRepository<Libro,Integer>{

}
