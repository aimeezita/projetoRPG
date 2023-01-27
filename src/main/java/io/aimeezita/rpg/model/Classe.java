package io.aimeezita.rpg.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_classe")

public class Classe {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nomeDaClasse;
	private String habilidadesDaClasse;
	private String equipamentosDaClasse;



	@OneToOne(mappedBy = "classe")
	@JsonIgnoreProperties("classe")
	private Personagem personagem;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNomeDaClasse() {
		return nomeDaClasse;
	}



	public void setNomeDaClasse(String nomeDaClasse) {
		this.nomeDaClasse = nomeDaClasse;
	}



	public String getHabilidadesDaClasse() {
		return habilidadesDaClasse;
	}



	public void setHabilidadesDaClasse(String habilidadesDaClasse) {
		this.habilidadesDaClasse = habilidadesDaClasse;
	}



	public String getEquipamentosDaClasse() {
		return equipamentosDaClasse;
	}



	public void setEquipamentosDaClasse(String equipamentosDaClasse) {
		this.equipamentosDaClasse = equipamentosDaClasse;
	}



	public Personagem getPersonagem() {
		return personagem;
	}



	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	
	
	
	
}
