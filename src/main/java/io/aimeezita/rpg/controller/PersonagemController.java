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

import io.aimeezita.rpg.model.Personagem;
import io.aimeezita.rpg.repository.PersonagemRepository;

@RestController
@RequestMapping("/personagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonagemController {
	
	@Autowired
	private PersonagemRepository personagemRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity <List<Personagem>> getAll(){
		
		return ResponseEntity.ok(personagemRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Personagem> getById(@PathVariable Long id) {
		return personagemRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Personagem>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(personagemRepository.findAllByNomeContainingIgnoreCase(nome));
			
	}
	
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Personagem> postPersonagem(@Valid @RequestBody Personagem personagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personagemRepository.save(personagem));
	}
	
	
	



	@PutMapping("/atualizar")
	public ResponseEntity<Personagem> putPersonagem (@Valid @RequestBody Personagem personagem){
		
		return personagemRepository.findById(personagem.getId())
			.map(resposta -> ResponseEntity.ok().body(personagemRepository.save(personagem)))
			.orElse(ResponseEntity.notFound().build());
	}
	

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePersonagem(@PathVariable Long id) {
		
			return personagemRepository.findById(id)
			.map(resposta -> { 
				personagemRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			})
			.orElse(ResponseEntity.notFound().build());
	}

}
