package io.aimeezita.rpg.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_atributos")

public class Atributos {

	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	

	@OneToOne(mappedBy = "atributos")
	@JsonIgnoreProperties("atributos")
	private Personagem personagem;
	private int forca;
	private int estamina;
	private int destreza;
	private int inteligencia;
	private int sorte;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Personagem getPersonagem() {
		return personagem;
	}
	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	public int getForca() {
		return forca;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	public int getEstamina() {
		return estamina;
	}
	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}
	public int getDestreza() {
		return destreza;
	}
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	public int getSorte() {
		return sorte;
	}
	public void setSorte(int sorte) {
		this.sorte = sorte;
	}
	
	
	/**
	 * @param id
	 * @param personagem
	 * @param forca
	 * @param estamina
	 * @param destreza
	 * @param inteligencia
	 * @param sorte
	 */
	
	public Atributos(Long id, Personagem personagem, int forca, int estamina, int destreza, int inteligencia,
			int sorte) {
		this.id = id;
		this.personagem = personagem;
		this.forca = forca;
		this.estamina = estamina;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.sorte = sorte;
	}
	
	
	
	
	
	
	
}
