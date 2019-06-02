package com.pi.nueep.entidades;

import java.util.ArrayList;
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

@Entity
@Table(name="empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	@Column(name="nome_social")
	private String nomeSocial; 
	@Column(name="cnpj")
	private String cnpj;
	@Column(name="responsavel")
	private String responsavel; 
	@Column(name="porte")
	private String porte; 
	@Column(name="website")
	private String website;
	@Column(name="email")
	private String email; 

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "empresa_endereco", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> endereco;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "empresa_telefone", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "telefone_id"))
	private List<Telefone> telefone;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "vaga_empresa", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "vaga_id"))
	private List<Vaga> vaga;

	public Empresa() {
		super();
	}

	public Empresa(String nomeFantasia, String nomeSocial, String cnpj, String responsavel, String porte,
			String website, String email) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.nomeSocial = nomeSocial;
		this.cnpj = cnpj;
		this.responsavel = responsavel;
		this.porte = porte;
		this.website = website;
		this.email = email;
	}
	
	
	public void addTelefone(Telefone tlf) {

		if (telefone == null) {
			telefone = new ArrayList();
		}

		telefone.add(tlf);
	}

	public void addEndereco(Endereco end) {

		if (endereco == null) {
			endereco = new ArrayList();
		}

		endereco.add(end);
	}
}
