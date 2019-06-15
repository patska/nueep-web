package com.pi.nueep.entidades.listas;

public enum TurnoEstudo {
    Diurno("Diurno"), Vespertino("Vespertino"), Integral("Integral"), Noturno("Noturno");

    private final String name;

    TurnoEstudo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
