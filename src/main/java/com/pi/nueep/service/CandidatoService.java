package com.pi.nueep.service;

import java.util.List;

import com.pi.nueep.entidades.Candidato;

public interface CandidatoService {

	public List<Candidato> pesquisar();
	public Candidato encontrarPorMatricula(int matricula);
	public void salvar(Candidato candidato);
	public void deletarPorMatricular(int matricula);
	
}
