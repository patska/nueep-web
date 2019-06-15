package com.pi.nueep.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area_profissional_espec")
public class Especializacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name="especializacao")
	private String especializacao;
	public Especializacao() {
		super();
	}
	public Especializacao(String especializacao) {
		super();
		this.especializacao = especializacao;
	}
	@Override
	public String toString() {
		return "Especializacao [id=" + id + ", especializacao=" + especializacao + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	} 
	
	
}
