package com.pi.nueep.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vaga_area")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name="nome")
	private String nome; 
	@OneToOne(cascade = CascadeType.ALL)
	private Especializacao especializacao;
	
	
	public Area() {
		super();
	}
	
	public Area(String nome, List<Especializacao> especializacoes) {
		super();
		this.nome = nome;
	}
	public Area(int id, String nome, List<Especializacao> especializacoes) {
		super();
		this.id = id;
		this.nome = nome;
	}

	
	
	
	
	
	
}
