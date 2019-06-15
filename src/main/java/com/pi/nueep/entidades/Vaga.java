package com.pi.nueep.entidades;

import java.text.NumberFormat;
import java.time.LocalDate;
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
import com.pi.nueep.entidades.listas.NivelEnsino;
import com.pi.nueep.entidades.listas.Sexo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Locale;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaga_id")
    private int id;

    @Column(name = "descricao", columnDefinition="TEXT")
    private String descricao;
    @Column(name = "salario")
    private double salario;
    @Column(name = "vale_transporte")
    private double valeTransporte;
    @Column(name = "vale_refeicao")
    private double valeRefeicao;
    @Column(name = "sexo_exigencia")
    private Sexo sexo_exigencia;
    @Column (name = "idade_minima")
    private int idade_minima;
    @Column (name="nivel_ensino_exigencia")
    private NivelEnsino nivel_ensino_exigencia;
    @Column(name = "data_cadastro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "turno_id")
    private Turno turno;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "hierarquia_id")
    private Hierarquia hierarquia;

    @ManyToMany(
            cascade = CascadeType.ALL)
    @JoinTable(
            name="vagas_candidatos",
            joinColumns = @JoinColumn(name="vaga_id"), 
            inverseJoinColumns = @JoinColumn(name="candidato_id")
    )
    private List<Candidato> candidatos;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Vaga() {
    }

    public Vaga(int id, String descricao, double salario, double valeTransporte, double valeRefeicao, Sexo sexo_exigencia, int idade_minima, NivelEnsino nivel_ensino_exigencia, Area area, Turno turno, Hierarquia hierarquia, Empresa empresa, LocalDate dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.salario = salario;
        this.valeTransporte = valeTransporte;
        this.valeRefeicao = valeRefeicao;
        this.sexo_exigencia = sexo_exigencia;
        this.idade_minima = idade_minima;
        this.nivel_ensino_exigencia = nivel_ensino_exigencia;
        this.area = area;
        this.turno = turno;
        this.hierarquia = hierarquia;
        this.empresa = empresa;
        this.dataCadastro = dataCadastro;
    }

    

    public Vaga(List<Candidato> candidatos) {
        this.candidatos = candidatos;
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

    public String getSalarioReais(){
        Locale ptBr = new Locale("pt", "BR");
        String salarioEmReais =  NumberFormat.getCurrencyInstance().format(salario);
        return salarioEmReais;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Hierarquia getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(Hierarquia hierarquia) {
        this.hierarquia = hierarquia;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sexo getSexo_exigencia() {
        return sexo_exigencia;
    }

    public void setSexo_exigencia(Sexo sexo_exigencia) {
        this.sexo_exigencia = sexo_exigencia;
    }

    public int getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(int idade_minima) {
        this.idade_minima = idade_minima;
    }

    public NivelEnsino getNivel_ensino_exigencia() {
        return nivel_ensino_exigencia;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setNivel_ensino_exigencia(NivelEnsino nivel_ensino_exigencia) {
        this.nivel_ensino_exigencia = nivel_ensino_exigencia;
    }

    public void addCandidato(Candidato tempCandidato) {
        if (candidatos == null) {
            candidatos = new ArrayList<>();
        }
        candidatos.add(tempCandidato);
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", salario=" + salario +
                ", valeTransporte=" + valeTransporte +
                ", valeRefeicao=" + valeRefeicao +
                ", sexo_exigencia=" + sexo_exigencia +
                ", idade_minima=" + idade_minima +
                ", nivel_ensino_exigencia=" + nivel_ensino_exigencia +
                ", dataCadastro=" + dataCadastro +
                ", area=" + area +
                ", turno=" + turno +
                ", hierarquia=" + hierarquia +
                ", candidatos=" + candidatos +
                ", empresa=" + empresa +
                '}';
    }
}
