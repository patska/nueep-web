package com.pi.nueep.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;

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
	public Candidato pesquisar(String termoPesquisapesquisa) {
		List<Candidato> todosCandidatos = candidatoRepository.findAll();
		Optional<Candidato> resultado = null;
		Candidato candidatoFinal = null;
		for (Candidato candidato : todosCandidatos) {
			if(candidato.getCpf() == termoPesquisapesquisa){
				candidato = resultado.get();
			}
		}
		if(resultado.isPresent()){
			candidatoFinal = resultado.get();
		}
		else{
			throw new RuntimeException("Não encontrado.");
		}
		return candidatoFinal;
	}

	@Override
	public Candidato encontrarPorId(int oId) {
		
		Optional<Candidato> resultado = candidatoRepository.findById(oId);
		Candidato candidato = null;
		if(resultado.isPresent()){
			candidato = resultado.get();
		}
		else{
			throw new RuntimeException("Não encontrado. Candidato - ID: " + oId);
		}

		return candidato;
	}

	@Override
	public List<Candidato> encontrarTodosAtivos() {
		return candidatoRepository.encontrarTodosAtivos();
	}

	@Override
	public List<Candidato> encontrarTodosInativos() {
		return candidatoRepository.encontrarTodosInativos();
	}

	@Override
	public void salvar(Candidato candidato) {
		candidatoRepository.save(candidato);

	}



	@Override
	public List<Candidato> encontrarTodos() {
		return candidatoRepository.findAll();
	}

	@Override
	public void deletarPorId(int id) {
		candidatoRepository.deleteById(id);
	}

	@Override
	public void deletarCandidatoDeVagas(Integer candidatoId) {
		candidatoRepository.deletarCandidatoDeVagas(candidatoId);
	}




}
