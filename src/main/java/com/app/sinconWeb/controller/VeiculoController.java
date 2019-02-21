/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.controller;

import com.app.sinconWeb.models.Veiculo;
import com.app.sinconWeb.service.VeiculoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marcelo Fernandes
 */
@Controller
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService service;

    @GetMapping
    public ModelAndView listaVeiculo() {
        ModelAndView modelAndView = new ModelAndView("dashboard/veiculo");
        modelAndView.addObject("listaDeVeiculo", service.listarVeiculo());
        return modelAndView;
    }

    @GetMapping("/veiculoAdd")
    public ModelAndView adicionarVeiculo(Veiculo veiculo) {
        ModelAndView modelAndView = new ModelAndView("dashboard/veiculoAdd");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvarVeiculo(@Valid Veiculo veiculo, BindingResult result) {
        if (result.hasErrors()) {
            return adicionarVeiculo(veiculo);
        }
        service.salvarVeiculo(veiculo);
        return listaVeiculo();
       
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarVeiculo(@PathVariable("id") Long id) {
        service.removerVeiculo(id);
        return listaVeiculo();
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarVeiculo(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("dashboard/veiculoAdd");
        mv.addObject("veiculo", service.findOne(id));
        return mv;
    }
}
