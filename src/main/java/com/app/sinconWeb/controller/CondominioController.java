/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.controller;

import com.app.sinconWeb.models.Condominio;
import com.app.sinconWeb.service.CondominioService;
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
@Controller //Define a classe como um bean do Spring
@RequestMapping("/condominios")
public class CondominioController {
    
    @Autowired
    private CondominioService service; //Injeta a classe de serviços
    
    @GetMapping
    public ModelAndView listaCondominio() {
        ModelAndView modelAndView = new ModelAndView("dashboard/condominio");
        modelAndView.addObject("listaDeCondominio", service.listarCondominio());
        return modelAndView;
    }
    @GetMapping("/condominioAdd")
    public ModelAndView adicionarCondominio(Condominio condominio) {
        ModelAndView modelAndView = new ModelAndView("dashboard/condominioAdd");
        modelAndView.addObject("condominio", condominio);
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvarCondominio(@Valid Condominio condominio, BindingResult result) {
        if (result.hasErrors()) {
            return adicionarCondominio(condominio);
        }
        service.salvarCondominio(condominio);
        return listaCondominio();
       
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarCondominio(@PathVariable("id") Long id) {
        service.removerCondominio(id);
        return listaCondominio();
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarCondominio(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("dashboard/condominioAdd");
        mv.addObject("condominio", service.findOne(id));
        return mv;
    }
}
