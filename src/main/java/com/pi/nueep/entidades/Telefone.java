package com.pi.nueep.entidades;

import java.util.List;

import javax.persistence.*;

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

	public Telefone(){}

	public Telefone(String fixo, String celular, boolean whatsapp, Telefone candidato, Telefone empresa) {
		this.fixo = fixo;
		this.celular = celular;
		this.whatsapp = whatsapp;

	}

	@Override
	public String toString() {
		return "Telefone{" +
				"id=" + id +
				", fixo='" + fixo + '\'' +
				", celular='" + celular + '\'' +
				", whatsapp=" + whatsapp +

				'}';
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

	public String getCelularWhatsap(){
		String whatsapp = celular.toString().replaceAll("[^0-9]", "");
		return "phone=55"+whatsapp;
	}




	
}
	

