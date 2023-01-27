package io.aimeezita.rpg.model;



import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_personagem")

public class Personagem {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int nivel;
	private BigDecimal experiencia;
	private String foto;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("personagem")
	Sexo sexo;
		
		
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("personagem")
	private Classe classe;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("personagem")
	private Atributos atributos;


	@OneToOne(cascade = CascadeType.ALL)
	private ItemBag itemBag;


	
	
	
	
	
	
	/**
	 * @param id
	 * @param nome
	 * @param nivel
	 * @param experiencia
	 * @param foto
	 * @param sexo
	 * @param classe
	 * @param atributos
	 * @param itemBag
	 */
	public Personagem(Long id, String nome, int nivel, BigDecimal experiencia, String foto, Sexo sexo, Classe classe,
			Atributos atributos, ItemBag itemBag) {
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.foto = foto;
		this.sexo = sexo;
		this.classe = classe;
		this.atributos = atributos;
		this.itemBag = itemBag;
	}








	public Long getId() {
		return id;
	}








	public void setId(Long id) {
		this.id = id;
	}








	public String getNome() {
		return nome;
	}








	public void setNome(String nome) {
		this.nome = nome;
	}








	public int getNivel() {
		return nivel;
	}








	public void setNivel(int nivel) {
		this.nivel = nivel;
	}








	public BigDecimal getExperiencia() {
		return experiencia;
	}








	public void setExperiencia(BigDecimal experiencia) {
		this.experiencia = experiencia;
	}








	public String getFoto() {
		return foto;
	}








	public void setFoto(String foto) {
		this.foto = foto;
	}








	public Sexo getSexo() {
		return sexo;
	}








	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}








	public Classe getClasse() {
		return classe;
	}








	public void setClasse(Classe classe) {
		this.classe = classe;
	}








	public Atributos getAtributos() {
		return atributos;
	}








	public void setAtributos(Atributos atributos) {
		this.atributos = atributos;
	}








	public ItemBag getItemBag() {
		return itemBag;
	}








	public void setItemBag(ItemBag itemBag) {
		this.itemBag = itemBag;
	}



	
	
	
	
	
	
	
}
