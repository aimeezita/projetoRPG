package io.aimeezita.rpg.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_bag")

public class ItemBag {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	/*Uma item bag recebe vário itens */
	@OneToMany(mappedBy = "itemBag", cascade = CascadeType.DETACH)
	@JsonIgnoreProperties("itembag")
	private List<Itens> itens;
	

	@OneToOne(mappedBy = "itemBag")
	@JsonIgnoreProperties("itembag")
	private Personagem personagem;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Itens> getItens() {
		return itens;
	}


	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}


	public Personagem getPersonagem() {
		return personagem;
	}


	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}



	
	
	
	
}
