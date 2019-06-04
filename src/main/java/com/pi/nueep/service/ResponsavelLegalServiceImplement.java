package com.pi.nueep.service;

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


}