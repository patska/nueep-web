package com.pi.nueep.controller;

import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.entidades.Vaga;
import com.pi.nueep.service.CandidatoService;
import com.pi.nueep.service.EmpresaService;
import com.pi.nueep.service.VagaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {


	private CandidatoService candidatoService;
	private VagaService vagaService;
	private EmpresaService empresaService;

	public MainController(CandidatoService candidatoService1,
						  VagaService vagaService1,
						  EmpresaService empresaService1){

		candidatoService = candidatoService1;
		vagaService = vagaService1;
		empresaService = empresaService1;

	}


	@GetMapping("/")
	public String mostrarHome(
			Model candidatoMod,
			Model vagaMod,
			Model empresaMod
	) {

		Candidato candidato = new Candidato();
		Vaga vaga = new Vaga();
		Empresa empresa=  new Empresa();
		List<Candidato> candidatos = candidatoService.encontrarTodos();
		List<Vaga> vagas = vagaService.encontrarTodos();
		List<Empresa> empresas = empresaService.encontrarTodos();

		System.out.println("Tamanho Candidatos: " + candidatos.size());
		System.out.println("Listas Candidatos: " + candidatos);

		candidatoMod.addAttribute("candidatos", candidatos);
		vagaMod.addAttribute("vagas", vagas);
		empresaMod.addAttribute("empresas", empresas);

		return "index";
	}
	
}
