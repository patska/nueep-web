package com.pi.nueep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.nueep.entidades.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
