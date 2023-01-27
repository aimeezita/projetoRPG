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

import io.aimeezita.rpg.model.Sexo;
import io.aimeezita.rpg.repository.SexoRepository;

@RestController
@RequestMapping("/sexo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SexoController {

	
	@Autowired
	private SexoRepository sexoRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity <List<Sexo>> getAll(){
		
		return ResponseEntity.ok(sexoRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sexo> getById(@PathVariable Long id) {
		return sexoRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Sexo> postSexo(@Valid @RequestBody Sexo sexo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(sexoRepository.save(sexo));
	}


	@PutMapping
	public ResponseEntity<Sexo> putSexo(@Valid @RequestBody Sexo sexo) {
					
		return sexoRepository.findById(sexo.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(sexoRepository.save(sexo));
				})
				.orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSexo(@PathVariable Long id) {
		
		return sexoRepository.findById(id)
				.map(resposta -> {
					sexoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
