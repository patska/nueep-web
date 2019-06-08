package com.pi.nueep.service;

import com.pi.nueep.entidades.Estado;

public interface EstadoService {

	public void salvar(Estado estado);
	public void deletarPorId(int id);
	public Estado encontrarPorId(int oId);
	
}
