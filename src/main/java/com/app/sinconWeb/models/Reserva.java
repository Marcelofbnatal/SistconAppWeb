/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sinconWeb.models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcelo Fernandes
 */
@Entity
public class Reserva implements Serializable{
    
    @Id
    @SequenceGenerator(name = "reserva_seq", sequenceName = "reserva_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_seq")
    private int id;
    @ManyToOne
    private Lote lote;
    @ManyToOne
    private Espaco espaco;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataReserva;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Calendar getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Calendar dataReserva) {
        this.dataReserva = dataReserva;
    }  
}
