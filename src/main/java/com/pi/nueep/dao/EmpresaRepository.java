package com.pi.nueep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

import com.pi.nueep.entidades.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

   @Query("SELECT e FROM Empresa e WHERE e.nomeSocial = :nomeSocial")
    Empresa encontrarPorNomeSocial(@Param("nomeSocial")String nomeSocial);

    @Query("SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")
    Empresa encontrarPorCnpj(@Param("cnpj")String cnpj);


    @Query("SELECT e FROM Empresa e ")
    Empresa carregarPrimeiro();
}
