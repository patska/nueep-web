package com.pi.nueep.controller;

import com.pi.nueep.config.SecurityService;
import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.entidades.Vaga;
import com.pi.nueep.entidades.sistema.User;
import com.pi.nueep.service.CandidatoService;
import com.pi.nueep.service.EmpresaService;
import com.pi.nueep.service.UserService;
import com.pi.nueep.service.VagaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {


	private CandidatoService candidatoService;
	private VagaService vagaService;
	private EmpresaService empresaService;
	private UserService userService;
	private SecurityService securityService;

	public MainController(CandidatoService candidatoService1,
						  VagaService vagaService1,
						  EmpresaService empresaService1,
						  UserService userService1,
						  SecurityService securityService1
	){

		candidatoService = candidatoService1;
		vagaService = vagaService1;
		empresaService = empresaService1;
		userService = userService1;
		securityService = securityService1;

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

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping("/registrar")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "novo-usuario";
	}

	@PostMapping("/registrar")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		/*userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}*/

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@GetMapping("/usuarios")
	public String mostrarUsuario(){
		return "editar-usuario";
	}
}
