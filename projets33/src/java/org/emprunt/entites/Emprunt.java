/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emprunt.entites;

import java.sql.Date;

/**
 *
 * @author yousra
 */
public class Emprunt {
     private int idemprunt;
    private int idreserv;
    private Date datedebut;
    private Date datefin;
    private String retour;

    public String getRetour() {
        return retour;
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }
    

    public int getIdemprunt() {
        return idemprunt;
    }

    public void setIdemprunt(int idemprunt) {
        this.idemprunt = idemprunt;
    }

    public int getIdreserv() {
        return idreserv;
    }

    public void setIdreserv(int idreserv) {
        this.idreserv = idreserv;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Emprunt() {
    }
   
    
    
}
