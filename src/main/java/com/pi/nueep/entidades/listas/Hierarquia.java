package com.pi.nueep.entidades.listas;

/**
 * Hierarquia
 */
public enum Hierarquia {

    MENOR_APRENDIZ("Menor Aprendiz"),
    ESTAGIARIO("Estagiário"),
    AUXILIAR("Auxiliar"),
    OPERACIONAL("Operacional"),
    ASSISTENTE("Assistente");

    private final String name;

    Hierarquia(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}