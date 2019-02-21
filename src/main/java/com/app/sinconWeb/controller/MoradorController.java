/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.controller;

import com.app.sinconWeb.models.Morador;
import com.app.sinconWeb.service.MoradorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marcelo Fernandes
 */
@Controller //Define a classe como um bean do Spring
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorService service;//	Injeta a classe de serviços

    //Vai para tela do CRUD aonde são listados todos os moradores
    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("dashboard/morador");
        mv.addObject("moradores", service.findAll());
        return mv;
    }

    //Vai para tela de adição de um morador
    @GetMapping("/add")
    public ModelAndView add(Morador morador) {

        ModelAndView mv = new ModelAndView("dashboard/moradorAdd");
        mv.addObject("morador", morador);
        return mv;
    }
    //Vai para tela de edição dos moradores (mesma tela de adição, contudo é enviado para a view um objeto que já existe)

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("dashboard/moradorAdd");
        mv.addObject("morador", service.findOne(id));
        return mv;
    }
    //Exclui um morador por seu ID e redireciona para a tela principal

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        service.delete(id);

        return findAll();
    }
    //Recebe um objeto preenchido do Thymeleaf e valida 
    //Se tudo estiver ok, salva e volta para tela principal

    @PostMapping("/save")
    public ModelAndView save(@Valid Morador morador, BindingResult result) {

        if (result.hasErrors()) {
            return add(morador);
        }

        service.save(morador);

        return findAll();
    }
}
