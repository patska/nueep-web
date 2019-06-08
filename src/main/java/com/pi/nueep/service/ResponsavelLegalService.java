package com.pi.nueep.service;

import java.util.List;
import com.pi.nueep.entidades.ResponsavelLegal;;

public interface ResponsavelLegalService{
    public void salvar(ResponsavelLegal responsavelLegal);
    public void deletarPorId(int id);
    public ResponsavelLegal encontrarPorId(int id);
}