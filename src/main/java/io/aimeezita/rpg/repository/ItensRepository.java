package io.aimeezita.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.aimeezita.rpg.model.Itens;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Long>{
	
	public List<Itens> findAllById(@Param("id") Long id);

}
