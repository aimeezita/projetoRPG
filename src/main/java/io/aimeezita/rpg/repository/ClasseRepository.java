package io.aimeezita.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.aimeezita.rpg.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	
	public List<Classe> findAllById(@Param("id") Long id);

}
