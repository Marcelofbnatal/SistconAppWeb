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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Marcelo Fernandes
 */
@Entity
public class Condominio implements Serializable {

    @Id
    @SequenceGenerator(name = "condominio_seq", sequenceName = "condominio_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominio_seq")
    private Long id;
    private String nome;
    private String endereco;
    @OneToMany(mappedBy = "condominio")
    private List<Espaco> espacos;
    @OneToMany(mappedBy = "condominio")
    private List<Lote> lotes;

    public Condominio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Espaco> getEspacos() {
        return espacos;
    }

    public void setEspacos(List<Espaco> espacos) {
        this.espacos = espacos;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

}
