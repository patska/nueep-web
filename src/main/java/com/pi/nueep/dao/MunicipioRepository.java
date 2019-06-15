package com.pi.nueep.dao;

import com.pi.nueep.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.Municipio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
    @Query("SELECT e FROM Municipio e WHERE e.nome = :nome")
    Municipio encontrarPorNome(@Param("nome")String nome);
}
