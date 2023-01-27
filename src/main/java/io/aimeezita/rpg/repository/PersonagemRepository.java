package io.aimeezita.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.aimeezita.rpg.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long>{
	
	public List<Personagem> findAllById(@Param("id") Long id);
	public List<Personagem> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
