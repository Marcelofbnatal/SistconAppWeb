/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.service;

import com.app.sinconWeb.models.Morador;
import com.app.sinconWeb.repository.MoradorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Fernandes
 */
@Service //Define a classe como um bean do Spring
public class MoradorService {

    @Autowired
    private MoradorRepository mr;

    //Retorna uma lista com todos moradores inseridos
    public List<Morador> findAll() {
        return mr.findAll();
    }
    
    //Retorno um morador a partir do ID
    public Morador findOne(Long id) {
        return mr.findOne(id);
    }

    //Salva ou atualiza um morador
    public Morador save(Morador morador) {
        System.out.println(morador);
        return mr.save(morador);
    }

    //Exclui um morador
    public void delete(Long id) {
        mr.delete(id);
    }
}
