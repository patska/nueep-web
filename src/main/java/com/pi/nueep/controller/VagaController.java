package com.pi.nueep.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pi.nueep.entidades.*;
import com.pi.nueep.entidades.Hierarquia;
import com.pi.nueep.entidades.listas.*;
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
            Model modelTipoSexo,
            Model modelGrauInstrucao
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
        modelGrauInstrucao.addAttribute("tipoGrau", GrauInstrucao.values());

        return "vaga/nova-vaga";
    }
    @GetMapping("/atualizar")
    public String atualizarVag(@RequestParam("vagaId") int oId,
                               Model modelEmpresa,
                               Model modelVaga,
                               Model modelAreaTipo,
                               Model modelArea,
                               Model modelHierarquia,
                               Model modelHierarquiaTipo,
                               Model modelTurno,
                               Model modelTurnoTipo,
                               Model modelTipoEnsino,
                               Model modelTipoSexo,
                               Model modelGrauInstrucao){
        Vaga vaga = vagaService.encontrarPorId(oId);
        Empresa empresa = vaga.getEmpresa();
        Area area = vaga.getArea();
        Hierarquia hierarquia = vaga.getHierarquia();
        Turno turno = vaga.getTurno();
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
        modelGrauInstrucao.addAttribute("tipoGrau", GrauInstrucao.values());
        return "vaga/nova-vaga";


    }

    @GetMapping("finalizar")
    public String finalizarVaga(
            @RequestParam("vagaId") int vagaId,
            @RequestParam("candidatoId") int candidatoId
    ){

        Vaga vaga = vagaService.encontrarPorId(vagaId);
        Candidato candidato = candidatoService.encontrarPorId(candidatoId);
        candidato.setAtivo(false);
        vaga.setAtivo(false);
        vaga.setDataEncerramento(LocalDate.now());
        candidatoService.salvar(candidato);
        vagaService.salvar(vaga);


        return "redirect:/vaga/listar";
    }

    @PostMapping("/salvar")
    public String salvarEmpresa(@RequestParam("EmpresaRazaoSocial") String razaoSocial,
                                @RequestParam("salarioString") String salarioString,
                                @RequestParam("vrString") String vrString,
                                @ModelAttribute("vaga") Vaga aVaga,
                                @ModelAttribute("area") Area oArea,
                                @ModelAttribute("hierarquia") Hierarquia aHierarquia,
                                @ModelAttribute("turno") Turno oTurno) {

        System.out.println("TERMO DE PESQUISA: " + razaoSocial);
        Empresa empresa = empresaService.pesquisarPeloNomeSocial(razaoSocial);
        System.out.println("EMPRESA ENCONTRAR POR RAZÃO SOCIAL: " + empresa);
        aVaga.setHierarquia(aHierarquia);
        aVaga.setArea(oArea);
        aVaga.setTurno(oTurno);
        aVaga.setEmpresa(empresa);
        // SALÁRIO, VT E VR STRING TO DOUBLE
        salarioString = salarioString.replaceAll("[^0-9]", "");
        vrString = vrString.replaceAll("[^0-9]", "");
        double salarioDouble = Double.parseDouble(salarioString) / 100;
        double vrDouble = Double.parseDouble(vrString) / 100;
        System.out.println("Salário em double é: " + salarioDouble);
        System.out.println("VR em double é: " + vrDouble);
        aVaga.setSalario(salarioDouble);
        aVaga.setValeRefeicao(vrDouble);
        System.out.println(aVaga.toString());
        aVaga.setDataCadastro(LocalDate.now());
        aVaga.setAtivo(true);
        vagaService.salvar(aVaga);


        return "redirect:/vaga/listar";
    }


    @GetMapping("/listar")
    public String listarVagas(Model theModel) {
        List<Vaga> vagas = vagaService.encontrarTodosAtivos();
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

    @GetMapping("/vagasEncerradas")
    public String listarVagasEncerradas(Model theModel) {
        List<Vaga> vagas = vagaService.encontrarTodosInativos();
        theModel.addAttribute("vagas", vagas);
        return "vaga/encerradas";
    }


    @GetMapping("/ficha")
    public String fichaVaga(@RequestParam("vagaId") int id, Model modelVaga, Model modelVagas, Model modelCandidato) {
        Vaga vaga = vagaService.encontrarPorId(id);
        modelVaga.addAttribute("vaga", vaga);
        List<Candidato> candidatosVaga = vaga.getCandidatos();
        System.out.println("LISTA DE CANDIDATOS: " + candidatosVaga);
        List<Candidato> candidatosVagaAux = candidatosVaga;
        for(int i = 0; i < candidatosVagaAux.size(); i++){
            if(!candidatosVagaAux.get(i).isAtivo()){
                candidatosVaga.remove(i);
            }
        }
        System.out.println("LISTA DE CANDIDATOS DEPOIS: " + candidatosVaga);

        modelVagas.addAttribute("candidatosVaga", candidatosVaga);
        List<Candidato> candidatos = candidatoService.encontrarTodosAtivos();
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