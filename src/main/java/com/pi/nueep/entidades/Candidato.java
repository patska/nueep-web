package com.pi.nueep.entidades;

import java.sql.Date;
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
import com.pi.nueep.entidades.listas.Sexo;

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
	private boolean matricula;
	

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;


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


	public Candidato(String nomeCompleto, String nomeSocial, boolean ativo, boolean matricula, Date dataNascimento,
			String cpf, String rg, String email, Sexo sexo, EstadoCivil estadoCivil, boolean condicaoEspecial,
			ResponsavelLegal responsavelLegal, List<Endereco> endereco, List<Telefone> telefone, List<Vaga> vaga) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.nomeSocial = nomeSocial;
		this.ativo = ativo;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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

	public boolean isMatricula() {
		return matricula;
	}

	public void setMatricula(boolean matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nomeCompleto=" + nomeCompleto + ", nomeSocial=" + nomeSocial + ", ativo="
				+ ativo + ", matricula=" + matricula + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", rg="
				+ rg + ", email=" + email + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", condicaoEspecial="
				+ condicaoEspecial + ", responsavelLegal=" + responsavelLegal + ", endereco=" + endereco + ", telefone="
				+ telefone + ", vaga=" + vaga + "]";
	}

	
}