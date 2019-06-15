package com.pi.nueep.service;

import java.util.List;
import com.pi.nueep.entidades.Municipio;
import org.springframework.data.repository.query.Param;

public interface MunicipioService{
    public void salvar(Municipio municipio);
    public void deletarPorId(int id);
    public Municipio encontrarPorId(int oId);
    public Municipio encontrarPorNome(String nome);

}