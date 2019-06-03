package com.pi.nueep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.nueep.dao.EnderecoRepository;
import com.pi.nueep.entidades.Endereco;

@Service
public class EnderecoServiceImplement implements EnderecoService {

	private EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoServiceImplement(EnderecoRepository oEnderecoRepository) {
		enderecoRepository = oEnderecoRepository;
	}
	
	@Override
	public void salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

}
