/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.service;

import com.app.sinconWeb.models.Usuario;
import com.app.sinconWeb.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Fernandes
 */
@Service //Define a classe como um bean do Spring
public class UsuarioService {
    
     @Autowired
    private UsuarioRepository ur;
     
      //Retorna uma lista com todos os usuarios  inseridos
    public List<Usuario> listarUsuarios() {
		return ur.findAll();
	}
	//Retorno um usuario a partir do ID
	public Usuario findOne(Long id) {
		return ur.findOne(id);
	}
	//Salva ou atualiza um usuario
	public Usuario salvarUsuario(Usuario usuario) {
		return ur.saveAndFlush(usuario);
	}
         
        //Exclui um usuario
	public void removerUsuario(Long id) {
		ur.delete(id);
	}
}
