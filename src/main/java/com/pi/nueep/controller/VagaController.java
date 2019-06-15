package com.pi.nueep.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pi.nueep.entidades.*;
import com.pi.nueep.entidades.listas.AreaProfissional;
import com.pi.nueep.entidades.listas.NivelEnsino;
import com.pi.nueep.entidades.listas.Sexo;
import com.pi.nueep.entidades.listas.TurnoEstudo;
import com.pi.nueep.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * VagaController
 */
@Controller
@RequestMapping("vaga")
public class VagaController {

    private EmpresaService empresaService;
    private VagaService vagaService;
    private AreaService areaService;
    private HierarquiaService hierarquiaService;
    private TurnoService turnoService;
    private CandidatoService candidatoService;

    public VagaController(EmpresaService aEmpresaService, VagaService aVagaService,
                          AreaService oAreaService, HierarquiaService hierarquiaService1,
                          TurnoService turnoService1, CandidatoService candidatoService1) {

        empresaService = aEmpresaService;
        vagaService = aVagaService;
        areaService = oAreaService;
        hierarquiaService = hierarquiaService1;
        turnoService = turnoService1;
        candidatoService = candidatoService1;
    }

    @GetMapping("/novo")
    public String novaVaga(
            Model modelEmpresa,
            Model modelVaga,
            Model modelAreaTipo,
            Model modelArea,
            Model modelHierarquia,
            Model modelHierarquiaTipo,
            Model modelTurno,
            Model modelTurnoTipo,
            Model modelTipoEnsino,
            Model modelTipoSexo
    ) {
        Empresa empresa = new Empresa();
        Vaga vaga = new Vaga();
        Area area = new Area();
        Hierarquia hierarquia = new Hierarquia();
        Turno turno = new Turno();
        modelEmpresa.addAttribute("empresa", empresa);
        modelVaga.addAttribute("vaga", vaga);
        modelArea.addAttribute("area", area);
        modelHierarquia.addAttribute("hierarquias", hierarquia);
        modelTurno.addAttribute("turnos", turno);
        modelAreaTipo.addAttribute("tiposDeArea", AreaProfissional.values());
        modelHierarquiaTipo.addAttribute("tipoHierarquia", com.pi.nueep.entidades.listas.Hierarquia.values());
        modelTurnoTipo.addAttribute("tipoTurno", TurnoEstudo.values());
        modelTipoEnsino.addAttribute("tipoEnsino", NivelEnsino.values());
        modelTipoSexo.addAttribute("tipoSexo", Sexo.values());

        return "vaga/nova-vaga";
    }

    @PostMapping("/salvar")
    public String salvarEmpresa(@RequestParam("EmpresaRazaoSocial") String razaoSocial,
                                @RequestParam("salarioString") String salarioString,
                                @RequestParam("vtString") String vtString,
                                @RequestParam("vrString") String vrString,
                                @ModelAttribute("vaga") Vaga aVaga,
                                @ModelAttribute("area") Area oArea,
                                @ModelAttribute("hierarquia") Hierarquia aHierarquia,
                                @ModelAttribute("turno") Turno oTurno) {

        Empresa empresa = empresaService.pesquisarPeloNomeSocial(razaoSocial);
        aVaga.setHierarquia(aHierarquia);
        aVaga.setArea(oArea);
        aVaga.setTurno(oTurno);
        aVaga.setEmpresa(empresa);
        // SALÁRIO, VT E VR STRING TO DOUBLE
        salarioString = salarioString.replaceAll("[^0-9]", "");
        vtString = vtString.replaceAll("[^0-9]", "");
        vrString = vrString.replaceAll("[^0-9]", "");
        double salarioDouble = Double.parseDouble(salarioString) / 100;
        double vtDouble = Double.parseDouble(vtString) / 100;
        double vrDouble = Double.parseDouble(vrString) / 100;
        System.out.println("Salário em double é: " + salarioDouble);
        System.out.println("VT em double é: " + vtDouble);
        System.out.println("VR em double é: " + vrDouble);
        aVaga.setSalario(salarioDouble);
        aVaga.setValeRefeicao(vrDouble);
        aVaga.setValeTransporte(vtDouble);
        System.out.println(aVaga.toString());
        aVaga.setDataCadastro(LocalDate.now());
        vagaService.salvar(aVaga);


        return "redirect:/vaga/listar";
    }


    @GetMapping("/listar")
    public String listarVagas(Model theModel) {
        List<Vaga> vagas = vagaService.encontrarTodos();
        theModel.addAttribute("vagas", vagas);
        return "vaga/lista";
    }

    @GetMapping("/incluirCandidato")
    public String incluirCandidato(@RequestParam("candidato") int candidatoId, @RequestParam("vaga") int vagaId) {
        Vaga vaga = vagaService.encontrarPorId(vagaId);
        Candidato candidato = candidatoService.encontrarPorId(candidatoId);
        if (!vaga.getCandidatos().contains(candidato)) {
            vaga.addCandidato(candidato);
            vagaService.salvar(vaga);
        }
        String retorno = "redirect:/vaga/ficha?vagaId=" + vagaId;
        return retorno;
    }

    @GetMapping("/excluirCandidato")
    public String excluirCandidato(@RequestParam("candidato") int candidatoId, @RequestParam("vaga") int vagaId) {
        Vaga vaga = vagaService.encontrarPorId(vagaId);
        Candidato candidato = candidatoService.encontrarPorId(candidatoId);
        vaga.getCandidatos().remove(candidato);
        vagaService.salvar(vaga);
        String retorno = "redirect:/vaga/ficha?vagaId=" + vagaId;
        return retorno;
    }

    @GetMapping("/ficha")
    public String fichaVaga(@RequestParam("vagaId") int id, Model modelVaga, Model modelVagas, Model modelCandidato) {
        Vaga vaga = vagaService.encontrarPorId(id);
        modelVaga.addAttribute("vaga", vaga);
        List<Candidato> candidatosVaga = vaga.getCandidatos();
        modelVagas.addAttribute("candidatosVaga", candidatosVaga);
        List<Candidato> candidatos = candidatoService.encontrarTodos();
        modelCandidato.addAttribute("candidatos", candidatos);
        System.out.println(vaga.toString());
        return "vaga/ficha";
    }


    @RequestMapping("/empresaAutocomplete")
    @ResponseBody
    public List<String> empresaAutoCompletar() {
        List<Empresa> listaEmpresa = empresaService.encontrarTodos();
        List<String> sugg = new ArrayList<String>();
        for (Empresa empresa : listaEmpresa) {
            sugg.add(empresa.getNomeSocial());
        }

        return sugg;
    }
}