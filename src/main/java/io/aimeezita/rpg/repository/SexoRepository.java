package io.aimeezita.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.aimeezita.rpg.model.Sexo;

@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long>{

	public List<Sexo> findAllById(@Param("id") Long id);
}
