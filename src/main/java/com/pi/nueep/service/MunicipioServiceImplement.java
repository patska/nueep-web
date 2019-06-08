package com.pi.nueep.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.pi.nueep.dao.MunicipioRepository;
import com.pi.nueep.entidades.Municipio;

@Service
public class MunicipioServiceImplement implements MunicipioService{

    private MunicipioRepository municipioRepository;

    @Autowired
    public MunicipioServiceImplement(MunicipioRepository oMunicipioRepository){
        municipioRepository = oMunicipioRepository;
    }

    @Override
	public void salvar(Municipio municipio) {
		municipioRepository.save(municipio);

	}

    @Override
    public Municipio encontrarPorId(int oId) {
        
		Optional<Municipio> resultado = municipioRepository.findById(oId);
		Municipio candidato = null;
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
		municipioRepository.deleteById(id);
	}
}