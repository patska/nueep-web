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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="cep")
	private String cep;
	@Column(name="bairro")
	private String bairro; 
	@Column(name="logradouro")
	private String logradouro;
	@Column(name="numero")
	private String numero;
	@Column(name="complemento")
	private String complemento;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="municipio_id")
	private Municipio municipio;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="candidato_endereco",
				joinColumns = @JoinColumn(name="endereco_id"),
				inverseJoinColumns = @JoinColumn(name="candidato_id"))
	private List<Candidato> candidato;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="empresa_endereco",
				joinColumns = @JoinColumn(name="endereco_id"),
				inverseJoinColumns = @JoinColumn(name="empresa_id"))
	private List<Empresa> empresa;

	public Endereco() {
		super();
	}

	

	public Endereco(String cep, String bairro, String logradouro, String numero, String complemento) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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



	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero="
				+ numero + ", complemento=" + complemento + ", municipio=" + municipio + ", candidato=" + candidato
				+ "]";
	}
	
	
}
