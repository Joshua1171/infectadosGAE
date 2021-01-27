package com.indra.backgae.controllers;

import com.indra.backgae.entities.Hospitalizados;
import com.indra.backgae.services.IInfectadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfectadosController {
    @Autowired
    private IInfectadosService iInfectadosService;

    @GetMapping("/infectados")
    public List<Hospitalizados> verTodos(){
        return iInfectadosService.findAll();
    }
}
