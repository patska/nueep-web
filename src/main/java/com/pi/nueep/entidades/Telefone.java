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
	@Column(name="numero")
	private String numero;
	@Column(name="ddd")
	private String ddd;
	@Column(name="tipo")
	private TipoDeTelefone tipo;
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

	public Telefone() {
		super();
	}

	public Telefone(String numero, String ddd, TipoDeTelefone tipo, boolean whatsapp) {
		super();
		this.numero = numero;
		this.ddd = ddd;
		this.tipo = tipo;
		this.whatsapp = whatsapp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public TipoDeTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTelefone tipo) {
		this.tipo = tipo;
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

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", ddd=" + ddd + ", tipo=" + tipo + ", whatsapp="
				+ whatsapp + ", candidato=" + candidato + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

