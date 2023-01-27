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

import io.aimeezita.rpg.model.Atributos;
import io.aimeezita.rpg.repository.AtributosRepository;

@RestController
@RequestMapping("/atributos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AtributosController {

	
	@Autowired
	private AtributosRepository atributosRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity <List<Atributos>> getAll(){
		
		return ResponseEntity.ok(atributosRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Atributos> getById(@PathVariable Long id) {
		return atributosRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Atributos> postAtributos(@Valid @RequestBody Atributos atributos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(atributosRepository.save(atributos));
	}


	@PutMapping
	public ResponseEntity<Atributos> putAtributos(@Valid @RequestBody Atributos atributos) {
					
		return atributosRepository.findById(atributos.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(atributosRepository.save(atributos));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAtributos(@PathVariable Long id) {
		
		return atributosRepository.findById(id)
				.map(resposta -> {
					atributosRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
