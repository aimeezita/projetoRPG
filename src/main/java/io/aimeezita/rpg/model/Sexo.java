package io.aimeezita.rpg.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Sexo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	public String tipo;
}
