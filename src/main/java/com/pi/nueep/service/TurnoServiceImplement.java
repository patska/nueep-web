package com.pi.nueep.service;

import com.pi.nueep.dao.TurnoRepository;
import com.pi.nueep.entidades.Turno;
import org.springframework.stereotype.Service;

@Service
public class TurnoServiceImplement implements TurnoService{
    private TurnoRepository turnoRepository;

    public TurnoServiceImplement(TurnoRepository turnoRepository1){
        turnoRepository = turnoRepository1;
    }

    @Override
    public void salvar(Turno turno) {
        turnoRepository.save(turno);
    }
}
