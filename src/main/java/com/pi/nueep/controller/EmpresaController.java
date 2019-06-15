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
        @ModelAttribute("empresa") Empresa oEmpresa,
        @ModelAttribute("endereco") Endereco oEndereco,
		@ModelAttribute("municipio") Municipio oMunicipio,
		@ModelAttribute("estado") Estado oEstado,
		@ModelAttribute("telefone") Telefone oTelefone
    ){

        // VALIDAÇÃO DE ESTADO
        if(estadoService.encontrarPorUf(oEstado.getUf()) == null) estadoService.salvar(oEstado);
        else {
            oEstado = estadoService.encontrarPorUf(oEstado.getUf());
        }

        // VALIDAÇÃO DE MUNICIPIO
        if(municipioService.encontrarPorNome(oMunicipio.getNome()) == null){
            oMunicipio.setEstado(oEstado);
            municipioService.salvar(oMunicipio);
        }
        else {
            oMunicipio = municipioService.encontrarPorNome(oMunicipio.getNome());
        }

        // VALIDAÇÃO DE ENDEREÇO
        if(enderecoService.encontrarPorCep(oEndereco.getCep()) == null){
            oEndereco.setMunicipio(oMunicipio);
            enderecoService.salvar(oEndereco);
        } else oEndereco = enderecoService.encontrarPorCep(oEndereco.getCep());
        oEmpresa.setEndereco(oEndereco);

        // TELEFONE
        telefoneService.salvar(oTelefone);
        oEmpresa.setTelefone(oTelefone);

        oEmpresa.setAtivo(true);
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
		Model municipioModelo,
		Model estadoModelo
		){

        Empresa empresa = empresaService.encontrarPorId(oId);
        Endereco endereco = empresa.getEndereco();
        Telefone telefone = empresa.getTelefone();
        Municipio municipio = empresa.getEndereco().getMunicipio();
        Estado estado = empresa.getEndereco().getMunicipio().getEstado();

        empresaModel.addAttribute("empresa", empresa);
        enderecoModelo.addAttribute("endereco", endereco);
        telefoneModelo.addAttribute("telefone", telefone);
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