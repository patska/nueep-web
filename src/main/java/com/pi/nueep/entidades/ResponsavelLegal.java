package com.pi.nueep.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responsavel_legal")
public class ResponsavelLegal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nome_completo")
	private String nomeCompletoResponsavel;
	@Column(name = "rgResponsavel")
	private String rgResponsavel;
	@Column(name = "cpf")
	private String cpf;

	

	public ResponsavelLegal(String nomeCompletoResponsavel, String rgResponsavel, String cpf) {
		super();
		this.nomeCompletoResponsavel = nomeCompletoResponsavel;
		this.rgResponsavel = rgResponsavel;
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "ResponsavelLegal [id=" + id + ", nomeCompletoResponsavel=" + nomeCompletoResponsavel + ", rgResponsavel = " + rgResponsavel +
			", cpf=" + cpf + "]";
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
	public String getNomeCompletoResponsavel() {
		return nomeCompletoResponsavel;
	}
	public void setNomeCompletoResponsavel(String nomeCompletoResponsavel) {
		this.nomeCompletoResponsavel = nomeCompletoResponsavel;
	}
	public String getRgResponsavel() {
		return rgResponsavel;
	}
	public void setRgResponsavel(String rgResponsavel) {
		this.rgResponsavel = rgResponsavel;;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}