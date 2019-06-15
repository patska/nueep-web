package com.pi.nueep.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

	// CIDADE
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="municipio_id")
	private Municipio municipio;
	// CANDIDATO
	@OneToMany(mappedBy = "endereco",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Candidato> candidatos;
	// EMPRESA
	@OneToMany(mappedBy = "endereco",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Empresa> empresas;

	public Endereco(){
	}

	public Endereco(String cep, String bairro, String logradouro, Municipio municipio, List<Candidato> candidato, List<Empresa> empresas) {
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.municipio = municipio;
		this.candidatos = candidato;
		this.empresas = empresas;
	}

	@Override
	public String toString() {
		return "Endereco{" +
				"id=" + id +
				", cep='" + cep + '\'' +
				", bairro='" + bairro + '\'' +
				", logradouro='" + logradouro + '\'' +
				", municipio=" + municipio +
				", candidato=" + candidatos +
				", empresas=" + empresas +
				'}';
	}

	public void addCandidato(Candidato candidato){
		if(candidatos == null) candidatos = new ArrayList<>();
		candidatos.add(candidato);
		candidato.setEndereco(this);
	}

	public void addEmpresa(Empresa empresa){
		if(empresas == null) empresas = new ArrayList<>();
		empresas.add(empresa);
		empresa.setEndereco(this);
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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidato) {
		this.candidatos = candidato;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
}
