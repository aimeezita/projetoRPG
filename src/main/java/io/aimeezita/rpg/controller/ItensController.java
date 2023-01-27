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

import io.aimeezita.rpg.model.Itens;
import io.aimeezita.rpg.repository.ItensRepository;

@RestController
@RequestMapping("/itens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItensController {

	
	@Autowired
	private ItensRepository itensRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity <List<Itens>> getAll(){
		
		return ResponseEntity.ok(itensRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Itens> getById(@PathVariable Long id) {
		return itensRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Itens> postItens(@Valid @RequestBody Itens itens) {
		return ResponseEntity.status(HttpStatus.CREATED).body(itensRepository.save(itens));
	}


	@PutMapping
	public ResponseEntity<Itens> putItens(@Valid @RequestBody Itens itens) {
					
		return itensRepository.findById(itens.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(itensRepository.save(itens));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteItens(@PathVariable Long id) {
		
		return itensRepository.findById(id)
				.map(resposta -> {
					itensRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
