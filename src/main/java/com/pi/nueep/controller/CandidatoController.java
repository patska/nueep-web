package com.pi.nueep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Endereco;
import com.pi.nueep.entidades.Estado;
import com.pi.nueep.entidades.Municipio;
import com.pi.nueep.entidades.ResponsavelLegal;
import com.pi.nueep.entidades.Telefone;
import com.pi.nueep.service.CandidatoService;
import com.pi.nueep.service.EnderecoService;
import com.pi.nueep.service.EstadoService;
import com.pi.nueep.service.MunicipioService;
import com.pi.nueep.service.ResponsavelLegalService;
import com.pi.nueep.service.TelefoneService;

@Controller
@RequestMapping("candidato")
public class CandidatoController {

	private CandidatoService candidatoService;
	private EnderecoService enderecoService;
	private MunicipioService municipioService;
	private EstadoService estadoService;
	private TelefoneService telefoneService;
	private ResponsavelLegalService responsavelLegalService;

	public CandidatoController(CandidatoService oCandidatoService,
		EnderecoService oEnderecoService,
		MunicipioService oMunicipioService,
		EstadoService oEstadoService,
		TelefoneService oTelefoneService,
		ResponsavelLegalService oResponsavelLegalService) {

		candidatoService = oCandidatoService;
		enderecoService = oEnderecoService;
		municipioService = oMunicipioService;
		estadoService = oEstadoService;
		telefoneService = oTelefoneService;
		responsavelLegalService = oResponsavelLegalService;
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

		return "/candidato/novo-candidato";
	}

	@PostMapping("/salvar")
	public String salvarCandidato(@ModelAttribute("endereco") Endereco oEndereco, @ModelAttribute("candidato") Candidato oCandidato,
		@ModelAttribute("municipio") Municipio oMunicipio,
		@ModelAttribute("estado") Estado oEstado,
		@ModelAttribute("telefone") Telefone oTelefone,
		@ModelAttribute("responsavel-legal") ResponsavelLegal oResponsavelLegal) {


		estadoService.salvar(oEstado);
		oMunicipio.setEstado(oEstado);
		municipioService.salvar(oMunicipio);

		oEndereco.setMunicipio(oMunicipio);
		enderecoService.salvar(oEndereco);
		oCandidato.addEndereco(oEndereco);

		telefoneService.salvar(oTelefone);
		oCandidato.addTelefone(oTelefone);

		oCandidato.setAtivo(true);
		responsavelLegalService.salvar(oResponsavelLegal);
		oCandidato.setResponsavelLegal(oResponsavelLegal);

		responsavelLegalService.salvar(oResponsavelLegal);
		candidatoService.salvar(oCandidato);

		return "index";
	}


}