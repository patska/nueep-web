package com.pi.nueep.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pi.nueep.entidades.listas.TurnoEstudo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 * Turno
 */
@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "periodo")
    private TurnoEstudo periodo;
    @OneToMany(mappedBy = "turno",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    private List<Vaga> vagas;

    public Turno() {
    }

    public Turno(TurnoEstudo periodo, List<Vaga> vagas) {
        this.periodo = periodo;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TurnoEstudo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(TurnoEstudo periodo) {
        this.periodo = periodo;
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
        tempVaga.setTurno(this);
    }

}
