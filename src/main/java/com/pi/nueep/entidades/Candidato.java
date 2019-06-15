package com.pi.nueep.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import java.util.ArrayList;
import javax.persistence.*;

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
    @Column(name = "candidato_id")
    private int id;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Column(name = "nome_social")
    private String nomeSocial;
    @Column(name = "ativo")
    private boolean ativo;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "data_nascimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "email")
    private String email;
    @Column(name="numero")
    private String numero;
    @Column(name="complemento")
    private String complemento;
    @Column(name = "condicao_especial")
    boolean condicaoEspecial;


    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_ensino")
    private NivelEnsino nivelEnsino;
    @Enumerated(EnumType.STRING)
    @Column(name = "grau_instrucao")
    private GrauInstrucao grauInstrucao;
    @Enumerated(EnumType.STRING)
    @Column(name = "modalidade_ensino")
    private ModalidadeEnsino modalidadeEnsino;
    @Enumerated(EnumType.STRING)
    @Column(name = "turno_estudo")
    private TurnoEstudo turnoEstudo;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "responsavel_legal_id")
    private ResponsavelLegal responsavelLegal;

    // ENDERECO
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="endereco_id")
    private Endereco endereco;
    // TELEFONE
    @OneToOne
    @JoinColumn(name="telefone_id")
    private Telefone telefone;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="vagas_candidatos",
            joinColumns = @JoinColumn(name="candidato_id"),
            inverseJoinColumns = @JoinColumn(name="vaga_id")
    )
    private List<Vaga> vaga;

    public Candidato(){}

    public Candidato(String nomeCompleto, String nomeSocial, boolean ativo, String matricula, LocalDate dataNascimento, String cpf, String rg, String email, String numero, String complemento, boolean condicaoEspecial, NivelEnsino nivelEnsino, GrauInstrucao grauInstrucao, ModalidadeEnsino modalidadeEnsino, TurnoEstudo turnoEstudo, Sexo sexo, EstadoCivil estadoCivil, ResponsavelLegal responsavelLegal, Endereco endereco, Telefone telefone, List<Vaga> vaga) {
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.ativo = ativo;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.numero = numero;
        this.complemento = complemento;
        this.condicaoEspecial = condicaoEspecial;
        this.nivelEnsino = nivelEnsino;
        this.grauInstrucao = grauInstrucao;
        this.modalidadeEnsino = modalidadeEnsino;
        this.turnoEstudo = turnoEstudo;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.responsavelLegal = responsavelLegal;
        this.endereco = endereco;
        this.telefone = telefone;
        this.vaga = vaga;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", ativo=" + ativo +
                ", matricula='" + matricula + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", email='" + email + '\'' +
                ", condicaoEspecial=" + condicaoEspecial +
                ", nivelEnsino=" + nivelEnsino +
                ", grauInstrucao=" + grauInstrucao +
                ", modalidadeEnsino=" + modalidadeEnsino +
                ", turnoEstudo=" + turnoEstudo +
                ", sexo=" + sexo +
                ", estadoCivil=" + estadoCivil +
                ", responsavelLegal=" + responsavelLegal +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                ", vaga=" + vaga +
                '}';
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public boolean isCondicaoEspecial() {
        return condicaoEspecial;
    }

    public void setCondicaoEspecial(boolean condicaoEspecial) {
        this.condicaoEspecial = condicaoEspecial;
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

    public ResponsavelLegal getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(ResponsavelLegal responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Vaga> getVaga() {
        return vaga;
    }

    public void setVaga(List<Vaga> vaga) {
        this.vaga = vaga;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
