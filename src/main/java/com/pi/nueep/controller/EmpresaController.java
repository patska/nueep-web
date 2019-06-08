package com.pi.nueep.controller;

import java.util.List;

import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.entidades.Endereco;
import com.pi.nueep.entidades.Estado;
import com.pi.nueep.entidades.Municipio;
import com.pi.nueep.entidades.Telefone;
import com.pi.nueep.service.EmpresaService;
import com.pi.nueep.service.EnderecoService;
import com.pi.nueep.service.EstadoService;
import com.pi.nueep.service.MunicipioService;
import com.pi.nueep.service.TelefoneService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * EmpresaController
 */
@Controller
@RequestMapping("empresa")
public class EmpresaController {

    private EmpresaService empresaService;
    private EnderecoService enderecoService;
    private MunicipioService municipioService;
    private EstadoService estadoService;
    private TelefoneService telefoneService;

    public EmpresaController(EmpresaService oEmpresaService,
        EnderecoService oEnderecoService,
        MunicipioService oMunicipioService,
        EstadoService oEstadoService,
        TelefoneService oTelefoneService
    ) {
        empresaService = oEmpresaService;
        enderecoService = oEnderecoService;
        municipioService = oMunicipioService;
        estadoService = oEstadoService;
        telefoneService = oTelefoneService;
    }

    @GetMapping("/novo")
    public String novaEmpresa(
        Model modelEmpresa,
		Model modeloTelefone, 
		Model modeloMunicipio,
		Model modeloEstado, 
		Model modeloEndereco
    ){
        Empresa empresa = new Empresa();
		Endereco endereco = new Endereco();
		Telefone telefone = new Telefone();
		Municipio municipio = new Municipio();
		Estado estado = new Estado(); 

        modeloEndereco.addAttribute("endereco", endereco);
		modelEmpresa.addAttribute("empresa", empresa);
		modeloEstado.addAttribute("estado", estado);
		modeloMunicipio.addAttribute("municipio", municipio);
        modeloTelefone.addAttribute("telefone", telefone);
        
        return "empresa/nova-empresa";
    }
    
    @PostMapping("/salvar")
    public String salvarEmpresa(
        @ModelAttribute("endereco") Endereco oEndereco, 
        @ModelAttribute("empresa") Empresa oEmpresa,
		@ModelAttribute("municipio") Municipio oMunicipio,
		@ModelAttribute("estado") Estado oEstado,
		@ModelAttribute("telefone") Telefone oTelefone    
    ){
        estadoService.salvar(oEstado);
		oMunicipio.setEstado(oEstado);
		municipioService.salvar(oMunicipio);

		oEndereco.setMunicipio(oMunicipio);
		enderecoService.salvar(oEndereco);
		oEmpresa.addEndereco(oEndereco);

		telefoneService.salvar(oTelefone);
		oEmpresa.addTelefone(oTelefone);

		oEmpresa.setAtivo(true);
        System.out.println("============");
        System.out.println("TELEFONE");
        System.out.println(oEmpresa.getTelefone());
        System.out.println("============");
        System.out.println("ENDERECO");
        System.out.println("============");
        System.out.println(oEmpresa.getEndereco());
        System.out.println("============");
		empresaService.salvar(oEmpresa);

		return "redirect:/empresa/listar";
    }

    @GetMapping("/listar")
    public String listarEmpresas(Model theModel){
        List<Empresa> empresas = empresaService.encontrarTodos();
        theModel.addAttribute("empresas", empresas);
        return "empresa/lista";
    }

    @GetMapping("/atualizar")
	public String mostrarFormulario(
		@RequestParam("empresaId") int oId, 
        Model empresaModel,
        Model telefoneModelo,
		Model enderecoModelo, 
		Model telefoeModelo, 
		Model municipioModelo, 
		Model estadoModelo
		){

		Empresa empresa = empresaService.encontrarPorId(oId);
        Telefone telefone = empresa.getTelefone().get(0);
        Endereco endereco = empresa.getEndereco().get(0);
		Municipio municipio = endereco.getMunicipio();
		Estado estado = municipio.getEstado();

    



		empresaModel.addAttribute("empresa", empresa);
		telefoneModelo.addAttribute("telefone", telefone);
		enderecoModelo.addAttribute("endereco", endereco);
		municipioModelo.addAttribute("municipio", municipio);
		estadoModelo.addAttribute("estado", estado);
		
		return "empresa/nova-empresa";

	}
    @GetMapping("/deletar")
	public String deletar(@RequestParam("empresaId") int oId){
		empresaService.deletarPorId(oId);
		
		return "redirect:/empresa/listar";
	}

}