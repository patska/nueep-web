package com.pi.nueep.service;

import java.util.List;

import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Empresa;

/**
 * EmpresaService
 */
public interface EmpresaService {

    public List<Empresa> pesquisar(String termoPesquisa);
    public Empresa encontrarPorId(int id);
    public List<Empresa> encontrarTodos();
    public void salvar(Empresa empresa);
    public void deletarPorId(int id);
    public Empresa pesquisarPeloNomeSocial(String NomeSocial);
    public Empresa pesquisarPeloCnpj(String cnpj);
    public List<Empresa> encontrarTodosAtivos();
    public List<Empresa> encontrarTodosInativos();
}