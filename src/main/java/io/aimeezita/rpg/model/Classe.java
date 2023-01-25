package io.aimeezita.rpg.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Classe {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDaClasse;
	
	private String habilidadesDaClasse;
	
	private String equipamentosDaClasse;
}
