/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.penalite.entites;

/**
 *
 * @author yousra
 */
public class Penalite {
   private int idpenalite;
   private int idemprunt;
   private String description;

    public int getIdpenalite() {
        return idpenalite;
    }

    public void setIdpenalite(int idpenalite) {
        this.idpenalite = idpenalite;
    }

    public int getIdemprunt() {
        return idemprunt;
    }

    public void setIdemprunt(int idemprunt) {
        this.idemprunt = idemprunt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    public Penalite() {
    }
    
}
