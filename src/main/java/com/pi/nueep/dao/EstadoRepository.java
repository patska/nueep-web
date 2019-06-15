package com.pi.nueep.dao;

import com.pi.nueep.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    @Query("SELECT e FROM Estado e WHERE e.uf = :uf")
    Estado encontrarPorUf(@Param("uf")String uf);
}
