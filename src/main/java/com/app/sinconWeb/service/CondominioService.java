/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.service;

import com.app.sinconWeb.models.Condominio;
import com.app.sinconWeb.repository.CondominioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Fernandes
 */
@Service //Define a classe como um bean do Spring
public class CondominioService {
    
    @Autowired
    private CondominioRepository cr;
    
     //Retorna uma lista com todos os condominios inseridos
    public List<Condominio> listarCondominio() {
		return cr.findAll();
	}
	//Retorno um condominio a partir do ID
	public Condominio findOne(Long id) {
		return cr.findOne(id);
	}
	//Salva ou atualiza um condominio
	public Condominio salvarCondominio(Condominio condominio) {
		return cr.saveAndFlush(condominio);
	}
         
        //Exclui um condominio
	public void removerCondominio(Long id) {
		cr.delete(id);
	}
}
