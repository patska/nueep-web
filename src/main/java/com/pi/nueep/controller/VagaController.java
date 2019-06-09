package com.pi.nueep.controller;

import java.util.ArrayList;
import java.util.List;

import com.pi.nueep.dao.EmpresaRepository;
import com.pi.nueep.entidades.Empresa;
import com.pi.nueep.service.EmpresaService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * VagaController
 */
@Controller
@RequestMapping("vaga")
public class VagaController {

    private EmpresaService empresaService;

    public VagaController(EmpresaService aEmpresaService){
        empresaService = aEmpresaService;
    }

    @GetMapping("/novo")
    public String novaVaga(Model modelEmpresa){
        Empresa empresa = new Empresa();
        modelEmpresa.addAttribute("empresa", empresa);
        return "vaga/nova-vaga";
    }

    @PostMapping("/salvar")
    public String salvarEmpresa(@RequestParam("EmpresaRazaoSocial") String razaoSocial)
    {
        System.out.println(razaoSocial);
        Empresa empresa = empresaService.pesquisarPeloNomeSocial(razaoSocial);
        System.out.println(empresa.toString());
		return "redirect:/empresa/listar";
    }


    @RequestMapping("/empresaAutocomplete")
    @ResponseBody
    public List<String> empresaAutoCompletar(){
        List<Empresa> listaEmpresa = empresaService.encontrarTodos();
        List<String> sugg = new ArrayList<String>();
        for (Empresa empresa : listaEmpresa) {
            sugg.add(empresa.getNomeSocial());
        }
        
        return sugg;
    }
}