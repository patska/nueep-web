package com.pi.nueep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.service.CandidatoService;

@Controller
@RequestMapping("candidato")
public class CandidatoController {
	
	private CandidatoService candidatoService;
	
	public CandidatoController(CandidatoService oCandidatoService) {
		candidatoService = oCandidatoService;
	}
	
	@GetMapping("/novo")
	public String novoCandidato(Model modelo) {
		Candidato candidato = new Candidato();
		modelo.addAttribute("candidato", candidato);
		return "/candidato/novo-candidato";
	}
	
	@PostMapping("/salvar")
	public String salvarCandidato(@ModelAttribute("candidato") Candidato oCandidato) {
		System.out.println(oCandidato.getNomeCompleto());
		candidatoService.salvar(oCandidato);
		return "index";
	}
	
	
}
