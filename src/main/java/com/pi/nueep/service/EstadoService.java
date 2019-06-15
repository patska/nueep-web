package com.pi.nueep.service;

import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.entidades.Estado;
import org.springframework.data.repository.query.Param;

public interface EstadoService {

	public void salvar(Estado estado);
	public void deletarPorId(int id);
	public Estado encontrarPorId(int oId);
	public Estado encontrarPorUf(String uf);
	
}
