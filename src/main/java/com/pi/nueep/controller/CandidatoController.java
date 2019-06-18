package com.pi.nueep.controller;

import com.pi.nueep.entidades.*;
import com.pi.nueep.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {

    private CandidatoService candidatoService;
    private EnderecoService enderecoService;
    private MunicipioService municipioService;
    private EstadoService estadoService;
    private TelefoneService telefoneService;
    private ResponsavelLegalService responsavelLegalService;
    private VagaService vagaService;

    public CandidatoController(CandidatoService oCandidatoService,
                               EnderecoService oEnderecoService,
                               MunicipioService oMunicipioService,
                               EstadoService oEstadoService,
                               TelefoneService oTelefoneService,
                               ResponsavelLegalService oResponsavelLegalService,
                               VagaService vagaService1) {

        candidatoService = oCandidatoService;
        enderecoService = oEnderecoService;
        municipioService = oMunicipioService;
        estadoService = oEstadoService;
        telefoneService = oTelefoneService;
        responsavelLegalService = oResponsavelLegalService;
        vagaService = vagaService1;
    }


    @GetMapping("/novo")
    public String novoCandidato(
            Model modeloCandidato,
            Model modeloTelefone,
            Model modeloMunicipio,
            Model modeloEstado,
            Model modelResponsavelLegal,
            Model modeloEndereco) {

        Candidato candidato = new Candidato();
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();
        Municipio municipio = new Municipio();
        Estado estado = new Estado();
        ResponsavelLegal responsavelLegal = new ResponsavelLegal();

        modeloEndereco.addAttribute("endereco", endereco);
        modeloCandidato.addAttribute("candidato", candidato);
        modeloEstado.addAttribute("estado", estado);
        modeloMunicipio.addAttribute("municipio", municipio);
        modeloTelefone.addAttribute("telefone", telefone);
        modelResponsavelLegal.addAttribute("responsavelLegal", responsavelLegal);

        return "candidato/novo-candidato";
    }

    @PostMapping("/salvar")
    public String salvarCandidato(@ModelAttribute("endereco") Endereco oEndereco, @ModelAttribute("candidato") Candidato oCandidato,
                                  @ModelAttribute("municipio") Municipio oMunicipio,
                                  @ModelAttribute("estado") Estado oEstado,
                                  @ModelAttribute("telefone") Telefone oTelefone,
                                  @ModelAttribute("responsavelLegal") ResponsavelLegal oResponsavelLegal) {


        //VALIDAÇÃO DE RESPONSÁVEL LEGAL

        if (responsavelLegalService.encontrarPorRg(oResponsavelLegal.getRgResponsavel()) == null) {
            if (oResponsavelLegal.getRgResponsavel() != null) responsavelLegalService.salvar(oResponsavelLegal);
        } else {
            oResponsavelLegal = responsavelLegalService.encontrarPorRg(oResponsavelLegal.getRgResponsavel());
        }
        oCandidato.setResponsavelLegal(oResponsavelLegal);
        // VALIDAÇÃO DE ESTADO
        if (estadoService.encontrarPorUf(oEstado.getUf()) == null) estadoService.salvar(oEstado);
        else {
            oEstado = estadoService.encontrarPorUf(oEstado.getUf());
        }

        // VALIDAÇÃO DE MUNICIPIO
        if (municipioService.encontrarPorNome(oMunicipio.getNome()) == null) {
            oMunicipio.setEstado(oEstado);
            municipioService.salvar(oMunicipio);
        } else {
            oMunicipio = municipioService.encontrarPorNome(oMunicipio.getNome());
        }

        // VALIDAÇÃO DE ENDEREÇO
        if (enderecoService.encontrarPorCep(oEndereco.getCep()) == null) {
            oEndereco.setMunicipio(oMunicipio);
            enderecoService.salvar(oEndereco);
        } else oEndereco = enderecoService.encontrarPorCep(oEndereco.getCep());
        oCandidato.setEndereco(oEndereco);

        // TELEFONE
        telefoneService.salvar(oTelefone);
        oCandidato.setTelefone(oTelefone);


        oCandidato.setAtivo(true);

        candidatoService.salvar(oCandidato);


        return "redirect:/candidato/listar";
    }

    @GetMapping("/listar")
    public String listarCandidatos(Model theModel) {
        List<Candidato> candidatos = candidatoService.encontrarTodosAtivos();

        theModel.addAttribute("candidatos", candidatos);

        return "candidato/lista";
    }

    @GetMapping("/inativos")
    public String listarCandidatosDesativados(Model theModel) {
        List<Candidato> candidatos = candidatoService.encontrarTodosInativos();
        theModel.addAttribute("candidatos", candidatos);

        return "candidato/desativados";
    }

    @GetMapping("/ativar")
    public String reativarCandidato(@RequestParam("candidatoId") int id){
        Candidato candidato = candidatoService.encontrarPorId(id);
        candidato.setAtivo(true);
        candidatoService.salvar(candidato);
        return "redirect:/candidato/inativos";
    }

    @GetMapping("/atualizar")
    public String mostrarFormulario(
            @RequestParam("candidatoId") int oId,
            Model candidatoModelo,
            Model telefoneModelo,
            Model enderecoModelo,
            Model municipioModelo,
            Model estadoModelo,
            Model responsavelLegalModelo
    ) {

        Candidato candidato = candidatoService.encontrarPorId(oId);
        Endereco endereco = candidato.getEndereco();
        Telefone telefone = candidato.getTelefone();
        Municipio municipio = candidato.getEndereco().getMunicipio();
        Estado estado = candidato.getEndereco().getMunicipio().getEstado();
        ResponsavelLegal responsavelLegal = candidato.getResponsavelLegal();

        candidatoModelo.addAttribute("candidato", candidato);
        enderecoModelo.addAttribute("endereco", endereco);
        telefoneModelo.addAttribute("telefone", telefone);
        municipioModelo.addAttribute("municipio", municipio);
        estadoModelo.addAttribute("estado", estado);
        responsavelLegalModelo.addAttribute("responsavelLegal", responsavelLegal);


        return "candidato/novo-candidato";

    }


    @GetMapping("/ficha")
    public String fichaCandidato(@RequestParam("candidatoId") int id, Model modelCandidatoVagas, Model modelVagas, Model modelCandidato) {

        Candidato candidato = candidatoService.encontrarPorId(id);
        modelCandidato.addAttribute("candidato", candidato);
        List<Vaga> vagas = candidato.getVaga();
        modelVagas.addAttribute("vagas", vagas);

        return "/candidato/ficha";
    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("candidatoId") int oId) {

        Candidato candidato = candidatoService.encontrarPorId(oId);
        List<Vaga> vagas = vagaService.encontrarTodos();
        if (!vagas.contains(candidato)) {
            candidato.setAtivo(false);
            candidatoService.salvar(candidato);
        } else {

        }

        return "redirect:/candidato/listar";
    }


}