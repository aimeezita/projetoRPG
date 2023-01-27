package io.aimeezita.rpg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aimeezita.rpg.model.ItemBag;
import io.aimeezita.rpg.repository.ItemBagRepository;

@RestController
@RequestMapping("/itembag")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemBagController {

	
	@Autowired
	private ItemBagRepository itemBagRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity <List<ItemBag>> getAll(){
		
		return ResponseEntity.ok(itemBagRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemBag> getById(@PathVariable Long id) {
		return itemBagRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<ItemBag> postItemBag(@Valid @RequestBody ItemBag itemBag) {
		return ResponseEntity.status(HttpStatus.CREATED).body(itemBagRepository.save(itemBag));
	}


	@PutMapping
	public ResponseEntity<ItemBag> putItemBag(@Valid @RequestBody ItemBag itemBag) {
					
		return itemBagRepository.findById(itemBag.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(itemBagRepository.save(itemBag));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteItemBag(@PathVariable Long id) {
		
		return itemBagRepository.findById(id)
				.map(resposta -> {
					itemBagRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
