package com.pi.nueep.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="municipio")
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name="nome")
	private String nome; 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="estado_id")
	private Estado estado;
	public Municipio() {
		super();
	}
	
	
	
	public Municipio(String nome) {
		super();
		this.nome = nome;
	}



	@Override
	public String toString() {
		return "Municipio [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
