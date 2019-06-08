package com.pi.nueep.service;

import com.pi.nueep.entidades.Telefone;

public interface TelefoneService {
	

	public void salvar(Telefone telefone);
	public void deletarPorId(int id);
	public Telefone encontrarTelefonePorId(int id);
	

}
