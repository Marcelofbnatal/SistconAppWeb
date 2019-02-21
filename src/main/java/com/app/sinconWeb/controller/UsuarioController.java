/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.controller;

import com.app.sinconWeb.controller.*;
import com.app.sinconWeb.models.Usuario;
import com.app.sinconWeb.repository.UsuarioRepository;
import com.app.sinconWeb.service.UsuarioService;
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
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;//	Injeta a classe de serviços

    @GetMapping
    public ModelAndView listaUsuario() {
        ModelAndView modelAndView = new ModelAndView("dashboard/usuario");
        modelAndView.addObject("listaDeUsuario", service.listarUsuarios());
        return modelAndView;
    }

    @GetMapping("/usuarioAdd")
    public ModelAndView adicionarUsuario(Usuario usuario) {
        ModelAndView modelAndView = new ModelAndView("dashboard/usuarioAdd");
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return adicionarUsuario(usuario);
        }
        service.salvarUsuario(usuario);
        return listaUsuario();
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarUsuario(@PathVariable("id") Long id) {
        service.removerUsuario(id);
        return listaUsuario();
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarUsuario(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("dashboard/usuarioAdd");
        mv.addObject("usuario", service.findOne(id));
        return mv;
    }

}
