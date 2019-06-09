package com.pi.nueep.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pi.nueep.entidades.listas.AreaProfissional;

@Entity
@Table(name="vaga_area")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Enumerated(EnumType.STRING)
	@Column(name="nome")
	private AreaProfissional nome; 
	@OneToOne(cascade = CascadeType.ALL)
	private Especializacao especializacao;
	
	
	public Area() {
		super();
	}
	

	public Area(AreaProfissional nome, Especializacao especializacao) {
		this.nome = nome;
		this.especializacao = especializacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AreaProfissional getNome() {
		return nome;
	}

	public void setNome(AreaProfissional nome) {
		this.nome = nome;
	}

	public Especializacao getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(Especializacao especializacao) {
		this.especializacao = especializacao;
	}
	
	
	
	
	
	
	
}
