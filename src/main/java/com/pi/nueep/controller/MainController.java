package com.pi.nueep.controller;

import com.pi.nueep.config.SecurityService;
import com.pi.nueep.config.UserValidator;
import com.pi.nueep.entidades.Candidato;
import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.entidades.Vaga;
import com.pi.nueep.entidades.sistema.User;
import com.pi.nueep.service.CandidatoService;
import com.pi.nueep.service.EmpresaService;
import com.pi.nueep.service.UserService;
import com.pi.nueep.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	private UserValidator userValidator;
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

			Model empresasAtivas,
			Model empresasInativas,
			Model vagasAtivas,
			Model vagasInativas,
			Model candidatosAtivos,
			Model candidatosInativos
	) {

		Candidato candidato = new Candidato();
		Vaga vaga = new Vaga();
		Empresa empresa=  new Empresa();

		List<Candidato> candidatos1 = candidatoService.encontrarTodosAtivos();
		candidatosAtivos.addAttribute("candidatosAtivos", candidatos1);
		List<Candidato> candidatos0 = candidatoService.encontrarTodosInativos();
		candidatosInativos.addAttribute("candidatosInativos", candidatos0);


		List<Vaga> vagas1 = vagaService.encontrarTodosAtivos();
		vagasAtivas.addAttribute("vagasAtivas", vagas1);
		List<Vaga> vagas0 = vagaService.encontrarTodosInativos();
		vagasInativas.addAttribute("vagasInativas", vagas0);

		List<Empresa> empresas1 = empresaService.encontrarTodosAtivos();
		empresasAtivas.addAttribute("empresasAtivas", empresas1);
		List<Empresa> empresas0 = empresaService.encontrarTodosInativos();
		empresasInativas.addAttribute("empresasInativas", empresas0);


		return "index";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("loginError", true);

		if (logout != null)
			model.addAttribute("message", "Logout realizado com sucesso.");

		return "login";
	}



	@GetMapping("/usuario")
	public String registration(Model model, Model modelEmpresa) {
		model.addAttribute("userForm", new User());
		List<User> usuarios = userService.encontrarTodos();
		modelEmpresa.addAttribute("usuarios", usuarios);
		return "editar-usuario";
	}

	@GetMapping("/usuario/deletar")
	public String deletar(@RequestParam("user") String username){
		User user = userService.findByUsername(username);
		userService.deletarPorId(user);
		return "redirect:/usuario";
	}


	@GetMapping("/usuario/alterar")
	public String alterar(@RequestParam("user") String username, Model model, Model empresa){
		model.addAttribute("userForm",userService.findByUsername(username));
		List<User> usuarios = userService.encontrarTodos();
		empresa.addAttribute("usuarios", usuarios);
		return "redirect:/usuario";
	}

	@PostMapping("/registrar")
	public String registration(@ModelAttribute("userForm") User userForm, Model model,  BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "redirect:/usuario";
		}

		userService.save(userForm);

		return "redirect:/usuario";
	}


}
