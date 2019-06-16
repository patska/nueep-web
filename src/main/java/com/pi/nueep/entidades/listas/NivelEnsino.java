package com.pi.nueep.entidades.listas;

public enum NivelEnsino {
    EnsinoFundamental("Ensino Fundamental"),
    EnsinoMedio("Ensino Médio"),
    EnsinoSuperior("Ensino Superior");

    private String name;

    NivelEnsino(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}