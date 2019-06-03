package com.pi.nueep.service;

import com.pi.nueep.dao.TelefoneRepository;
import com.pi.nueep.entidades.Telefone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneServiceImplement implements TelefoneService{
   
    private TelefoneRepository telefoneRepository;

    @Autowired
    public TelefoneServiceImplement(TelefoneRepository oTelefoneRepository){
        telefoneRepository = oTelefoneRepository;
    }

    @Override
	public void salvar(Telefone telefone) {
		telefoneRepository.save(telefone);
	}

}