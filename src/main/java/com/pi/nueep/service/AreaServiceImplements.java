package com.pi.nueep.service;

import com.pi.nueep.dao.AreaRepository;
import com.pi.nueep.entidades.Area;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImplements implements AreaService {

    private AreaRepository areaRepository;

    public AreaServiceImplements(AreaRepository oAreaRepository){
        areaRepository = oAreaRepository;
    }
    @Override
    public void salvar(Area area) {
        areaRepository.save(area);
    }
}
