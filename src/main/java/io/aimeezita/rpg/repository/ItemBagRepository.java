package io.aimeezita.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.aimeezita.rpg.model.ItemBag;

@Repository
public interface ItemBagRepository extends JpaRepository<ItemBag, Long>{
	
	public List<ItemBag> findAllById(@Param("id") Long id);

}
