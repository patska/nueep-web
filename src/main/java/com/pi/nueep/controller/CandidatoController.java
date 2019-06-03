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
import com.pi.nueep.service.CandidatoService;
import com.pi.nueep.service.EnderecoService;
import com.pi.nueep.service.EnderecoServiceImplement;

@Controller
@RequestMapping("candidato")
public class CandidatoController {
	
	private CandidatoService candidatoService;
	private EnderecoService enderecoService;
	
	public CandidatoController(CandidatoService oCandidatoService, EnderecoService oEnderecoService) {
		candidatoService = oCandidatoService;
		enderecoService = oEnderecoService;

	}
	

	
	@GetMapping("/novo")
	public String novoCandidato(Model modelo) {
		Candidato candidato = new Candidato();
		modelo.addAttribute("candidato", candidato);
		return "/candidato/novo-candidato";
	}
	
	@PostMapping("/salvar")
	public String salvarCandidato(@ModelAttribute("candidato") Candidato oCandidato,@ModelAttribute("endereco") Endereco oEndereco ) {
		System.out.println(oCandidato.getNomeCompleto());
		enderecoService.salvar(oEndereco);
		oCandidato.addEndereco(oEndereco);
		candidatoService.salvar(oCandidato);
		return "index";
	}
	
	
}
