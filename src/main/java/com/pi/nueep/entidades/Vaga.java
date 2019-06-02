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
import javax.persistence.Table;

import com.pi.nueep.entidades.listas.Turno;

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
	@Column(name="turno")
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
}
