/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reserv.entities;

/**
 *
 * @author yousra
 */
public class Reservation {
    private int idreserv;
    private int numlivre;
    private String cin;

    public int getIdreserv() {
        return idreserv;
    }

    public void setIdreserv(int idreserv) {
        this.idreserv = idreserv;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getNumlivre() {
        return numlivre;
    }

    public void setNumlivre(int numlivre) {
        this.numlivre = numlivre;
    }
    
    
    public Reservation() {
    }
    
    
}
