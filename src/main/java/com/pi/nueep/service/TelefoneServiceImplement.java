package com.pi.nueep.service;

import java.util.Optional;

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

    @Override
    public Telefone encontrarTelefonePorId(int id) {
         
		Optional<Telefone> resultado = telefoneRepository.findById(id);
		Telefone candidato = null;
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
		telefoneRepository.deleteById(id);
	}

}