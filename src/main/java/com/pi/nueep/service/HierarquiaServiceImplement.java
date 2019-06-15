package com.pi.nueep.service;

import com.pi.nueep.dao.HierarquiaRepository;
import com.pi.nueep.entidades.Hierarquia;
import org.springframework.stereotype.Service;

@Service
public class HierarquiaServiceImplement implements HierarquiaService {
    HierarquiaRepository hierarquiaRepository;

    public HierarquiaServiceImplement(HierarquiaRepository hierarquiaRepository1){
        hierarquiaRepository = hierarquiaRepository1;
    }


    @Override
    public void salvar(Hierarquia hierarquia) {
        hierarquiaRepository.save(hierarquia);
    }
}
