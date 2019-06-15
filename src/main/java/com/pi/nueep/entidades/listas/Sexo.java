package com.pi.nueep.entidades.listas;

public enum Sexo {
	Masculino("Masculino"),
	Feminino("Feminino"),
	Transexual("Transexual")
	;

	private String name;

	Sexo (String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
	