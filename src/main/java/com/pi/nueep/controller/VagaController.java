package com.pi.nueep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * VagaController
 */
@Controller
@RequestMapping("vaga")
public class VagaController {

    @GetMapping("/novo")
    public String novaVaga(){
        return "vaga/nova-vaga";
    }
}