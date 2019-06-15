package com.pi.nueep.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="municipio")
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name="nome")
	private String nome;


	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="estado_id")
	private Estado estado;

	@OneToMany(mappedBy = "municipio",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Endereco> enderecos;


	public Municipio(){}

	public Municipio(String nome, Estado estado, List<Endereco> enderecos) {
		this.nome = nome;
		this.estado = estado;
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Municipio{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", estado=" + estado +
				", enderecos=" + enderecos +
				'}';
	}

	public void addEnderecos(Endereco endereco){
		if (enderecos == null) enderecos = new ArrayList<>();
		enderecos.add(endereco);
		endereco.setMunicipio(this);
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
