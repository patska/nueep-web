package com.pi.nueep.service;

import java.util.List;
import java.util.Optional;

import com.pi.nueep.dao.EmpresaRepository;
import com.pi.nueep.entidades.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmpresaServiceImplement
 */
@Service
public class EmpresaServiceImplement implements EmpresaService {

    private EmpresaRepository empresaRepository; 

    @Autowired
    public EmpresaServiceImplement (EmpresaRepository aEmpresaRepository){
        empresaRepository = aEmpresaRepository;
    }

  
    @Override
    public Empresa encontrarPorId(int id) {
        Optional<Empresa> resultado = empresaRepository.findById(id);
        Empresa empresa = null; 
        if(resultado.isPresent()){
            empresa = resultado.get();
        }
        else {
            throw new RuntimeException("Não encontrada a empresa com o ID: " + id);
        }
        return empresa;
    }

    @Override
    public List<Empresa> encontrarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    public void salvar(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void deletarPorId(int id) {
        empresaRepository.deleteById(id);
    }



    @Override
    public List<Empresa> pesquisar(String termoPesquisa) {
        return null;
        }

    @Override
    public Empresa pesquisarPeloNomeSocial(String NomeSocial) {
        return empresaRepository.encontrarPorNomeSocial(NomeSocial);
    }

    @Override
    public Empresa pesquisarPeloCnpj(String cnpj) {
        return empresaRepository.encontrarPorCnpj(cnpj);
    }

    @Override
    public List<Empresa> encontrarTodosAtivos() {
        return empresaRepository.encontrarTodosAtivos();
    }

    @Override
    public List<Empresa> encontrarTodosInativos() {
        return empresaRepository.encontrarTodosInativos();
    }


}