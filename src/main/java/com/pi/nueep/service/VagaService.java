package com.pi.nueep.service;

import com.pi.nueep.entidades.Vaga;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VagaService {

    public void salvar(Vaga vaga);
    public List<Vaga> encontrarTodos();
    public Vaga encontrarPorId(int id);
    public List<Vaga> encontrarTodosAtivos();
    public List<Vaga> encontrarTodosInativos();
}
