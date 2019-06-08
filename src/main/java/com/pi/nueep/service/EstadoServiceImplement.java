package com.pi.nueep.service;

import java.util.List;
import java.util.Optional;

import com.pi.nueep.dao.EstadoRepository;
import com.pi.nueep.entidades.Estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadoServiceImplement implements EstadoService {

	private EstadoRepository estadoRepository;
	
	@Autowired
	public EstadoServiceImplement(EstadoRepository oEstadoRepository) {
		estadoRepository = oEstadoRepository;
	}
    
	@Override
	public void salvar(Estado estado) {
		estadoRepository.save(estado);

	}

	@Override
	public Estado encontrarPorId(int oId) {
		Optional<Estado> resultado = estadoRepository.findById(oId);
		Estado candidato = null;
		if(resultado.isPresent()){
			candidato = resultado.get();
		}
		else{
			throw new RuntimeException("Não encontrado. Candidato - ID: " + oId);
		}

		return candidato;
	}

	@Override
	public void deletarPorId(int id) {
		estadoRepository.deleteById(id);
	}



}
