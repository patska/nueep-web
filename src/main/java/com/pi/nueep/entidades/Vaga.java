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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.pi.nueep.entidades.Turno;
@Entity
@Table(name="vaga")
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="titulo")
	private String titulo;
	@Column(name="descricao")
	private String descricao;
	@Column(name="salario")
	private double salario;
	@Column(name="vale_transporte")
	private double valeTransporte; 
	@Column(name="vale_refeicao")
	private double valeRefeicao;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="turno_id")
	private Turno turno;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="area_id")
	private List<Area> area;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="hierarquia_id")
	private List<Hierarquia> hierarquia;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="vaga_candidato",
				joinColumns = @JoinColumn(name="vaga_id"),
				inverseJoinColumns = @JoinColumn(name="candidato_id"))
	private List<Candidato> candidato;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="vaga_empresa",
				joinColumns = @JoinColumn(name="vaga_id"),
				inverseJoinColumns = @JoinColumn(name="empresa_id"))
	private List<Empresa> empresa;



	public Vaga() {
	}


	public Vaga(String titulo, String descricao, double salario, double valeTransporte, double valeRefeicao, Turno turno, List<Area> area, List<Hierarquia> hierarquia, List<Candidato> candidato, List<Empresa> empresa) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.salario = salario;
		this.valeTransporte = valeTransporte;
		this.valeRefeicao = valeRefeicao;
		this.turno = turno;
		this.area = area;
		this.hierarquia = hierarquia;
		this.candidato = candidato;
		this.empresa = empresa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public double getValeRefeicao() {
		return valeRefeicao;
	}

	public void setValeRefeicao(double valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Area> getArea() {
		return area;
	}

	public void setArea(List<Area> area) {
		this.area = area;
	}

	public List<Hierarquia> getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(List<Hierarquia> hierarquia) {
		this.hierarquia = hierarquia;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vaga [area=" + area + ", candidato=" + candidato + ", descricao=" + descricao + ", empresa=" + empresa
				+ ", hierarquia=" + hierarquia + ", id=" + id + ", salario=" + salario + ", titulo=" + titulo
				+ ", turno=" + turno + ", valeRefeicao=" + valeRefeicao + ", valeTransporte=" + valeTransporte + "]";
	}

	

}
