package com.pi.nueep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.Endereco;

public interface ResponsavelLegalRepository extends JpaRepository<Endereco, Integer> {

}
