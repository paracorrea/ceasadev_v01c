package com.ceasa.dev.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceasa.dev.dominio.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
	
	
	@Query("SELECT t FROM Grupo t WHERE t.nome = ?1")
	Grupo findByNome(String nome);



}
