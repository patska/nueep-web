package com.pi.nueep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
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

	@Override
	public Endereco encontrarPorId(int oId) {
		
		Optional<Endereco> resultado = enderecoRepository.findById(oId);
		Endereco candidato = null;
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
		enderecoRepository.deleteById(id);
	}


}
