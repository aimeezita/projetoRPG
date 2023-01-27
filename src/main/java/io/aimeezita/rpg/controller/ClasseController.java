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

import io.aimeezita.rpg.model.Classe;
import io.aimeezita.rpg.repository.ClasseRepository;

@RestController
@RequestMapping("/classe")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClasseController {

	
	@Autowired
	private ClasseRepository classeRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity <List<Classe>> getAll(){
		
		return ResponseEntity.ok(classeRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Classe> getById(@PathVariable Long id) {
		return classeRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Classe> postClasse(@Valid @RequestBody Classe classe) {
		return ResponseEntity.status(HttpStatus.CREATED).body(classeRepository.save(classe));
	}


	@PutMapping
	public ResponseEntity<Classe> putClasse(@Valid @RequestBody Classe classe) {
					
		return classeRepository.findById(classe.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(classeRepository.save(classe));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClasse(@PathVariable Long id) {
		
		return classeRepository.findById(id)
				.map(resposta -> {
					classeRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
