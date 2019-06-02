package com.pi.nueep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.nueep.dao.CandidatoRepository;
import com.pi.nueep.entidades.Candidato;

@Service
public class CandidatoServiceImplement implements CandidatoService {

	private CandidatoRepository candidatoRepository;
	
	@Autowired
	public CandidatoServiceImplement(CandidatoRepository oCandidatoRepository) {
		candidatoRepository = oCandidatoRepository;
	}
	
	@Override
	public List<Candidato> pesquisar() {
		return candidatoRepository.findAll();
	}

	@Override
	public Candidato encontrarPorMatricula(int matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvar(Candidato candidato) {
		candidatoRepository.save(candidato);

	}

	@Override
	public void deletarPorMatricular(int matricula) {
		// TODO Auto-generated method stub

	}

}
