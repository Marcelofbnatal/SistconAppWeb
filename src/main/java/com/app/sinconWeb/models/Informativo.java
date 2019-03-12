/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcelo Fernandes
 */
public class Informativo implements Serializable {
    @Id
    @SequenceGenerator(name = "informativo_seq", sequenceName = "informativo_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "informativo_seq")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAviso;
    private String assunto;
    private String conteudo;

    public Informativo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataAviso() {
        return dataAviso;
    }

    public void setDataAviso(Calendar dataAviso) {
        this.dataAviso = dataAviso;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
    
    