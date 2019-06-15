package com.pi.nueep.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hierarquia")
public class Hierarquia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nivel")
    private com.pi.nueep.entidades.listas.Hierarquia nivel;
    @OneToMany(mappedBy = "hierarquia",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    private List<Vaga> vagas;

    public Hierarquia() {
    }

    public Hierarquia(com.pi.nueep.entidades.listas.Hierarquia nivel, List<Vaga> vagas) {
        this.nivel = nivel;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.pi.nueep.entidades.listas.Hierarquia getNivel() {
        return nivel;
    }

    public void setNivel(com.pi.nueep.entidades.listas.Hierarquia nivel) {
        this.nivel = nivel;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public void addVaga(Vaga tempVaga) {
        if (vagas == null) {
            vagas = new ArrayList<>();
        }
        vagas.add(tempVaga);
        tempVaga.setHierarquia(this);
    }

}
