package com.pi.nueep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pi.nueep.dao.EnderecoRepository;
import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Endereco;
import com.pi.nueep.entidades.Estado;
import com.pi.nueep.entidades.Municipio;
import com.pi.nueep.entidades.Telefone;
import com.pi.nueep.service.CandidatoService;
import com.pi.nueep.service.EnderecoService;
import com.pi.nueep.service.EnderecoServiceImplement;
import com.pi.nueep.service.EstadoService;
import com.pi.nueep.service.MunicipioService;
import com.pi.nueep.service.TelefoneService;

@Controller
@RequestMapping("candidato")
public class CandidatoController {
	
	private CandidatoService candidatoService;
	private EnderecoService enderecoService;
	private MunicipioService municipioService;
	private EstadoService estadoService;
	private TelefoneService telefoneService;
	
	public CandidatoController(CandidatoService oCandidatoService, 
								EnderecoService oEnderecoService,
								MunicipioService oMunicipioService,
								EstadoService oEstadoService,
								TelefoneService oTelefoneService) {
		candidatoService = oCandidatoService;
		enderecoService = oEnderecoService;
		municipioService = oMunicipioService;
		estadoService = oEstadoService;
		telefoneService = oTelefoneService;
	}
	

	
	@GetMapping("/novo")
	public String novoCandidato(Model modelo) {
		Candidato candidato = new Candidato();
		modelo.addAttribute("candidato", candidato);
		return "/candidato/novo-candidato";
	}
	
	@PostMapping("/salvar")
	public String salvarCandidato(@ModelAttribute("candidato") Candidato oCandidato,
								@ModelAttribute("endereco") Endereco oEndereco,	
								@ModelAttribute("municipio") Municipio oMunicipio,
								@ModelAttribute("estado") Estado oEstado,
								@ModelAttribute("telefone") Telefone oTelefone) {
		

		estadoService.salvar(oEstado);

		oMunicipio.setEstado(oEstado);
		municipioService.salvar(oMunicipio);

		oEndereco.setMunicipio(oMunicipio);
		enderecoService.salvar(oEndereco);
		oCandidato.addEndereco(oEndereco);

		telefoneService.salvar(oTelefone);
		oCandidato.addTelefone(oTelefone);

		oCandidato.setAtivo(true);
		candidatoService.salvar(oCandidato);
		
		return "index";
	}
	
	
}
