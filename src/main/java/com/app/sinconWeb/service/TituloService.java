/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.service;

import com.app.sinconWeb.models.StatusTitulo;
import com.app.sinconWeb.models.Titulo;
import com.app.sinconWeb.repository.TituloRepository;
import com.app.sinconWeb.repository.filter.TituloFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class TituloService {
    @Autowired
	private TituloRepository titulos;
    
    public void salvar(Titulo titulo) {
		try {

			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
    public void excluir(Long codigo) {
		titulos.delete(codigo);		
	}
    public String receber(Long codigo) {
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		return StatusTitulo.RECEBIDO.getDescricao();
	}
    public List<Titulo> filtrar(TituloFilter filtro){
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);
	}
    
}
