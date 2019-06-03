package com.pi.nueep.service;

import java.util.List;

import com.pi.nueep.dao.EstadoRepository;
import com.pi.nueep.entidades.Estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadoServiceImplement implements EstadoService {

	private EstadoRepository estadoRepository;
	
	@Autowired
	public EstadoServiceImplement(EstadoRepository oEstadoRepository) {
		estadoRepository = oEstadoRepository;
	}
    
	@Override
	public void salvar(Estado estado) {
		estadoRepository.save(estado);

	}



}
