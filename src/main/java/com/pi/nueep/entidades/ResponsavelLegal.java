package com.pi.nueep.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="responsavel_legal")
public class ResponsavelLegal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name = "nome_completo")
	private String nomeCompleto; 
	@Column(name = "rg")
	private String rg; 
	@Column(name = "cpf")
	private String cpf;
	
	
	
	public ResponsavelLegal(String nomeCompleto, String rg, String cpf) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.rg = rg;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "ResponsavelLegal [id=" + id + ", nomeCompleto=" + nomeCompleto + ", rg=" + rg + ", cpf=" + cpf + "]";
	}

	public ResponsavelLegal() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	} 
	
	
}
