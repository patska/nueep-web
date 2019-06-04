package com.pi.nueep.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}