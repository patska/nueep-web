package com.pi.nueep.service;

import java.util.List;
import com.pi.nueep.entidades.ResponsavelLegal;
import org.springframework.data.repository.query.Param;;

public interface ResponsavelLegalService{
    public void salvar(ResponsavelLegal responsavelLegal);
    public void deletarPorId(int id);
    public ResponsavelLegal encontrarPorId(int id);
    public ResponsavelLegal encontrarPorRg(String rgResponsavel);
}