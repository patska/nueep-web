package com.pi.nueep.dao;

import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.entidades.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
    @Query("SELECT e FROM Vaga e WHERE e.ativo = true")
    List<Vaga> encontrarTodosAtivos();

    @Query("SELECT e FROM Vaga e WHERE e.ativo = false")
    List<Vaga> encontrarTodosInativos();
}
