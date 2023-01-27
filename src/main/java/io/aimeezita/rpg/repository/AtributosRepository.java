package io.aimeezita.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.aimeezita.rpg.model.Atributos;

@Repository
public interface AtributosRepository extends JpaRepository<Atributos, Long>{
	
	public List<Atributos> findAllById(@Param("id") Long id);

}
