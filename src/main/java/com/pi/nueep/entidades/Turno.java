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
    @Column(name="turno")
    private TurnoEstudo turno;


    public Turno() {
    }


    public Turno(TurnoEstudo turno, Vaga vaga) {
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TurnoEstudo getTurno() {
        return turno;
    }

    public void setTurno(TurnoEstudo turno) {
        this.turno = turno;
    }



    @Override
    public String toString() {
        return "Turno [id=" + id + ", turno=" + turno + "]";
    }

    

    
}