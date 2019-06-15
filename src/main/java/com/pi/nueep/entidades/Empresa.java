package com.pi.nueep.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.pi.nueep.entidades.listas.Porte;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private int id;
    @Column(name = "ativo")
    private boolean ativo;
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
    @Column(name="numero")
    private String numero;
    @Column(name="complemento")
    private String complemento;
    // ENDERECO
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="endereco_id")
    private Endereco endereco;
    // TELEFONE
    @OneToOne
    @JoinColumn(name="telefone_id")
    private Telefone telefone;
    // VAGAS
    @OneToMany(mappedBy = "empresa",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Vaga> vagas;


    public Empresa() {
    }

    public Empresa(boolean ativo, String nomeFantasia, String nomeSocial, String cnpj, String responsavel, Porte porte, String website, String email, String numero, String complemento, Endereco endereco, Telefone telefone, List<Vaga> vagas) {
        this.ativo = ativo;
        this.nomeFantasia = nomeFantasia;
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.porte = porte;
        this.website = website;
        this.email = email;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
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

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", porte=" + porte +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                ", vagas=" + vagas +
                '}';
    }
}
