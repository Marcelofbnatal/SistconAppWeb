/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.service;

import com.app.sinconWeb.models.Veiculo;
import com.app.sinconWeb.repository.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Fernandes
 */
@Service //Define a classe como um bean do Spring
public class VeiculoService {
  //injeta o repositório
	@Autowired
    private VeiculoRepository vr;
      
        //Retorna uma lista com todos veiculos inseridos
    public List<Veiculo> listarVeiculo() {
		return vr.findAll();
	}
	//Retorno um veiculo a partir do ID
	public Veiculo findOne(Long id) {
		return vr.findOne(id);
	}
	//Salva ou atualiza um veiculo
	public Veiculo salvarVeiculo(Veiculo veiculo) {
		return vr.saveAndFlush(veiculo);
	}
         
        //Exclui um veiculo
	public void removerVeiculo(Long id) {
		vr.delete(id);
	}
      
}
