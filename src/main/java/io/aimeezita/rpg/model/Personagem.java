package io.aimeezita.rpg.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Personagem {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	Sexo sexo;
	private Long vida;
	private Long mana;
	private Classe classe;
	private Atributos atributos;
	public int nivel;
	public Long experiencia;
	
	//foto
	
}
