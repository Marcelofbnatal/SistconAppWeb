/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Marcelo Fernandes
 */
@Entity
public class Espaco implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "espaco_seq", sequenceName = "espaco_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "espaco_seq")
    private int id;
    private String nome;
    private String detalhesEspaco;
    @ManyToOne
    private Condominio condominio;
    @OneToMany(mappedBy = "espaco")
    private List<Reserva> reservas;
    
    

    public Espaco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhesEspaco() {
        return detalhesEspaco;
    }

    public void setDetalhesEspaco(String detalhesEspaco) {
        this.detalhesEspaco = detalhesEspaco;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}
