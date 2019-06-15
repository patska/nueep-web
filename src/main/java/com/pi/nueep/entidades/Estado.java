package com.pi.nueep.entidades;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; 
	@Column(name = "nome")
	private String nome;
	@Column(name = "uf")
	private String uf;

	@OneToMany(mappedBy = "estado",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Municipio> municipios;
	
	public Estado(){
	}

	public Estado(String nome, String uf, List<Municipio> municipios) {
		this.nome = nome;
		this.uf = uf;
		this.municipios = municipios;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public void add(Municipio municipio){
		if(municipios == null){
			municipios = new ArrayList<>();
		}
		municipios.add(municipio);
		municipio.setEstado(this);
	}
}
