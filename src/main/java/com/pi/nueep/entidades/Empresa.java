package com.pi.nueep.entidades;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import com.pi.nueep.entidades.listas.Porte;

import javax.persistence.OneToMany;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private int id;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "nome_social")
    private String nomeSocial;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "responsavel")
    private String responsavel;
    @Enumerated(EnumType.STRING)
    @Column(name = "porte")
    private Porte porte;
    @Column(name = "website")
    private String website;
    @Column(name = "email")
    private String email;
    @Column(name = "ativo")
    private boolean ativo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "empresa_endereco", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> endereco;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "empresa_telefone", joinColumns = @JoinColumn(name = "empresa_id"), inverseJoinColumns = @JoinColumn(name = "telefone_id"))
    private List<Telefone> telefone;

    @OneToMany(mappedBy = "area",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Vaga> vagas;


    public Empresa() {
        super();
    }


    public Empresa(String nomeFantasia, String nomeSocial, String cnpj, String responsavel, Porte porte, String website, String email, boolean ativo, List<Endereco> endereco, List<Telefone> telefone, List<Vaga> vaga) {
        this.nomeFantasia = nomeFantasia;
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.porte = porte;
        this.website = website;
        this.email = email;
        this.ativo = ativo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.vagas = vagas;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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

    public List<Vaga> getVaga() {
        return vagas;
    }

    public void setVaga(List<Vaga> vaga) {
        this.vagas = vaga;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public void addVaga(Vaga tempVaga) {
        if (vagas == null) {
            vagas = new ArrayList<>();
        }
        vagas.add(tempVaga);
        tempVaga.setEmpresa(this);
    }


}
