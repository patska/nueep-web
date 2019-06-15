package com.pi.nueep.service;

import java.util.List;

import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Endereco;
import org.springframework.data.repository.query.Param;

public interface EnderecoService {
	

	public void salvar(Endereco endereco);
	public void deletarPorId(int id);
	public Endereco encontrarPorId(int oId);
	public Endereco encontrarPorCep(String cep);


}
