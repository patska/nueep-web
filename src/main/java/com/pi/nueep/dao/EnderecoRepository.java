package com.pi.nueep.dao;

import com.pi.nueep.entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.Endereco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    @Query("SELECT e FROM Endereco e WHERE e.cep = :cep")
    Endereco encontrarPorCep(@Param("cep")String cep);
}
