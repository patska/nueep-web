package com.pi.nueep.entidades.listas;

public enum GrauInstrucao {
    Completo("Completo"),
    Incompleto("Incompleto");

    private String name;

    GrauInstrucao(String name){
        this.name=name;
    }
    public String getName( ){
        return name;
    }
}