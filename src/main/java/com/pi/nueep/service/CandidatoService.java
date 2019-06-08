package com.pi.nueep.service;

import java.util.List;

import com.pi.nueep.entidades.Candidato;

public interface CandidatoService {

	public List<Candidato> pesquisar();
	public Candidato encontrarPorId(int oId);
	public List<Candidato> encontrarTodos();
	public void salvar(Candidato candidato);
	public void deletarPorId (int id);
}
