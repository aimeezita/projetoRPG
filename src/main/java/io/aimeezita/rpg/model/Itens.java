package io.aimeezita.rpg.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_itens")

public class Itens {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nomeDoItem;
	
	
	@ManyToOne
	@JsonIgnoreProperties("itens")
	private ItemBag itemBag;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeDoItem() {
		return nomeDoItem;
	}


	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}


	public ItemBag getItemBag() {
		return itemBag;
	}


	public void setItemBag(ItemBag itemBag) {
		this.itemBag = itemBag;
	}
	
	
}
