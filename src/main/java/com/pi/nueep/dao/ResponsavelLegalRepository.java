package com.pi.nueep.dao;

import com.pi.nueep.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.ResponsavelLegal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;;

public interface ResponsavelLegalRepository extends JpaRepository<ResponsavelLegal, Integer> {
    @Query("SELECT e FROM ResponsavelLegal e WHERE e.rgResponsavel = :rgResponsavel")
    ResponsavelLegal encontrarPorRg(@Param("rgResponsavel")String rgResponsavel);
}
