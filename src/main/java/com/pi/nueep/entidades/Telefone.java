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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.pi.nueep.entidades.listas.TipoDeTelefone;


@Entity
@Table(name="telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name="fixo")
	private String fixo;
	@Column(name="celular")
	private String celular;

	@Column(name="whatsapp")
	private boolean whatsapp; 
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="candidato_telefone",
				joinColumns = @JoinColumn(name="telefone_id"),
				inverseJoinColumns = @JoinColumn(name="candidato_id"))
	private List<Candidato> candidato;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="empresa_telefone",
				joinColumns = @JoinColumn(name="telefone_id"),
				inverseJoinColumns = @JoinColumn(name="empresa_id"))
	private List<Empresa> empresa;

	public Telefone(){}
	public Telefone(String fixo, String celular, boolean whatsapp, List<Candidato> candidato){
		this.fixo = fixo; 
		this.celular = celular; 
		this.whatsapp = whatsapp; 
		this.candidato = candidato;
	}

	public Telefone(List<Empresa> empresa, String fixo, String celular, boolean whatsapp){
		this.fixo = fixo; 
		this.celular = celular; 
		this.whatsapp = whatsapp; 
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(boolean whatsapp) {
		this.whatsapp = whatsapp;
	}

	public List<Candidato> getCandidato() {
		return candidato;
	}

	public void setCandidato(List<Candidato> candidato) {
		this.candidato = candidato;
	}

	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}


	
}
	

