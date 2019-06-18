package com.pi.nueep.dao;

import com.pi.nueep.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.Candidato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
    @Query("SELECT e FROM Candidato e WHERE e.ativo = true")
    List<Candidato> encontrarTodosAtivos();

    @Query("SELECT e FROM Candidato e WHERE e.ativo = false")
    List<Candidato> encontrarTodosInativos();

    @Query(value = "DELETE FROM vagas_candidatos vu WHERE vu.candidato_id = ?1", nativeQuery = true)
    void deletarCandidatoDeVagas(Integer candidatoId);
}
