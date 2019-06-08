package com.pi.nueep.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pi.nueep.entidades.listas.EstadoCivil;
import com.pi.nueep.entidades.listas.GrauInstrucao;
import com.pi.nueep.entidades.listas.ModalidadeEnsino;
import com.pi.nueep.entidades.listas.NivelEnsino;
import com.pi.nueep.entidades.listas.Sexo;
import com.pi.nueep.entidades.listas.TurnoEstudo;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "candidato")
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "nome_social")
	private String nomeSocial;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@Column(name="matricula")
	private String matricula;
	

	@Column(name = "data_nascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Enumerated(EnumType.STRING)
	@Column(name = "nivel_ensino")
	private NivelEnsino nivelEnsino; 

	@Enumerated(EnumType.STRING)
	@Column(name="grau_instrucao")
	private GrauInstrucao grauInstrucao;

	@Enumerated(EnumType.STRING)
	@Column(name = "modalidade_ensino")
	private ModalidadeEnsino modalidadeEnsino;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "turno_estudo")
	private TurnoEstudo turnoEstudo;


	@Column(name = "email")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo")
	private Sexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	private EstadoCivil estadoCivil;

	@Column(name = "condicao_especial")
	boolean condicaoEspecial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "responsavel_legal_id")
	private ResponsavelLegal responsavelLegal;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "candidato_endereco", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> endereco;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "candidato_telefone", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "telefone_id"))
	private List<Telefone> telefone;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "vaga_candidato", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "vaga_id"))
	private List<Vaga> vaga;
	
	public Candidato() {
		super();
	}


	public Candidato(String nomeCompleto, String nomeSocial, boolean ativo, String matricula, LocalDate dataNascimento, String cpf, String rg, NivelEnsino nivelEnsino, GrauInstrucao grauInstrucao, ModalidadeEnsino modalidadeEnsino, TurnoEstudo turnoEstudo, String email, Sexo sexo, EstadoCivil estadoCivil, boolean condicaoEspecial, ResponsavelLegal responsavelLegal, List<Endereco> endereco, List<Telefone> telefone, List<Vaga> vaga) {
		this.nomeCompleto = nomeCompleto;
		this.nomeSocial = nomeSocial;
		this.ativo = ativo;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.nivelEnsino = nivelEnsino;
		this.grauInstrucao = grauInstrucao;
		this.modalidadeEnsino = modalidadeEnsino;
		this.turnoEstudo = turnoEstudo;
		this.email = email;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.condicaoEspecial = condicaoEspecial;
		this.responsavelLegal = responsavelLegal;
		this.endereco = endereco;
		this.telefone = telefone;
		this.vaga = vaga;
	}

	




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public boolean isCondicaoEspecial() {
		return condicaoEspecial;
	}

	public void setCondicaoEspecial(boolean condicaoEspecial) {
		this.condicaoEspecial = condicaoEspecial;
	}

	public ResponsavelLegal getResponsavelLegal() {
		return responsavelLegal;
	}

	public void setResponsavelLegal(ResponsavelLegal responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public void addTelefone(Telefone tlf) {

		if (telefone == null) {
			telefone = new ArrayList();
		}

		telefone.add(tlf);
	}
	
	

	public List<Vaga> getVaga() {
		return vaga;
	}

	public void setVaga(List<Vaga> vaga) {
		this.vaga = vaga;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void addEndereco(Endereco end) {

		if (endereco == null) {
			endereco = new ArrayList();
		}

		endereco.add(end);
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setResponsavelLegal(String matricula) {
		this.matricula = matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public NivelEnsino getNivelEnsino() {
		return nivelEnsino;
	}

	public void setNivelEnsino(NivelEnsino nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public GrauInstrucao getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public ModalidadeEnsino getModalidadeEnsino() {
		return modalidadeEnsino;
	}

	public void setModalidadeEnsino(ModalidadeEnsino modalidadeEnsino) {
		this.modalidadeEnsino = modalidadeEnsino;
	}

	public TurnoEstudo getTurnoEstudo() {
		return turnoEstudo;
	}

	public void setTurnoEstudo(TurnoEstudo turnoEstudo) {
		this.turnoEstudo = turnoEstudo;
	}

		
	
	
}
