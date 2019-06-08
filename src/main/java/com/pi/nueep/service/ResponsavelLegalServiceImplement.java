package com.pi.nueep.service;

import java.util.Optional;

import com.pi.nueep.dao.ResponsavelLegalRepository;
import com.pi.nueep.entidades.ResponsavelLegal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelLegalServiceImplement implements ResponsavelLegalService{

    private ResponsavelLegalRepository responsavelLegalRepository;

    @Autowired
    public ResponsavelLegalServiceImplement(ResponsavelLegalRepository oResponsavelLegal){
        responsavelLegalRepository = oResponsavelLegal;
    }

    @Override
    public void salvar(ResponsavelLegal responsavelLegal){
        responsavelLegalRepository.save(responsavelLegal);
    }

    @Override
    public ResponsavelLegal encontrarPorId(int id) {
        	
		Optional<ResponsavelLegal> resultado = responsavelLegalRepository.findById(id);
		ResponsavelLegal candidato = null;
		if(resultado.isPresent()){
			candidato = resultado.get();
		}
		else{
			throw new RuntimeException("Não encontrado. Candidato - ID: " + id);
		}

		return candidato;
    }

    @Override
    public void deletarPorId(int id) {
        responsavelLegalRepository.deleteById(id);
    }


}