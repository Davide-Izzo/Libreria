package com.example.Libreria.Libreria.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.Libreria.Libreria.Entity.Noleggio;

import java.util.Optional;


@Repository
public interface NoleggioRepo extends JpaRepository <Noleggio, Integer>{


//	public List<Noleggio> findByIdLibro(int idLibro);
//	
//	
//	public Optional<Noleggio> findByIdLibroAndStato(int idLibro, boolean stato);
	
	
	@Query("select id from Noleggio where id_libro = :id_libro and stato = :stato")
	public Optional<Noleggio> findByIdLibroAndStato(@Param("id_libro")int idLibro, @Param("stato")boolean stato);
	
	@Query("select id from Noleggio where id_libro = :id_libro and stato = :stato")
	public Optional<Integer> findByIdLibroAndstato(@Param("id_libro")int idLibro, @Param("stato")boolean stato);
}
