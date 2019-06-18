package com.pi.nueep.service;

import com.pi.nueep.dao.VagaRepository;
import com.pi.nueep.entidades.Vaga;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaServiceImplements implements VagaService {
    private VagaRepository vagaRepository;

    public VagaServiceImplements(VagaRepository aVagaRepository){
        vagaRepository = aVagaRepository;
    }

    @Override
    public void salvar(Vaga vaga) {
        vagaRepository.save(vaga);
    }

    @Override
    public List<Vaga> encontrarTodos() {
        return vagaRepository.findAll();
    }

    @Override
    public Vaga encontrarPorId(int id) {
        return vagaRepository.findById(id).get();
    }

    @Override
    public List<Vaga> encontrarTodosAtivos() {
        return vagaRepository.encontrarTodosAtivos();
    }

    @Override
    public List<Vaga> encontrarTodosInativos() {
        return vagaRepository.encontrarTodosInativos();
    }
}
