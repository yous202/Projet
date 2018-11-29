/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.livre.entites;

/**
 *
 * @author yousra
 */
public class Livre {
    private int numlivre;
    private String titre;
    private String auteur;
    private String genre;
    private int edition;
    private int idbib;
    private int nbrexemplaire;

    public int getNumlivre() {
        return numlivre;
    }

    public void setNumlivre(int numlivre) {
        this.numlivre = numlivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getIdbib() {
        return idbib;
    }

    public void setIdbib(int idbib) {
        this.idbib = idbib;
    }

    public int getNbrexemplaire() {
        return nbrexemplaire;
    }

    public void setNbrexemplaire(int nbrexemplaire) {
        this.nbrexemplaire = nbrexemplaire;
    }
    

    public Livre() {
    }
    
    
}
