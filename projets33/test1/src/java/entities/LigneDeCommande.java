/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yousra
 */
@Entity
@Table(name = "LIGNE_DE_COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LigneDeCommande.findAll", query = "SELECT l FROM LigneDeCommande l")
    , @NamedQuery(name = "LigneDeCommande.findByIdligne", query = "SELECT l FROM LigneDeCommande l WHERE l.idligne = :idligne")
    , @NamedQuery(name = "LigneDeCommande.findByQtecomm", query = "SELECT l FROM LigneDeCommande l WHERE l.qtecomm = :qtecomm")})
public class LigneDeCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLIGNE")
    private Integer idligne;
    @Column(name = "QTECOMM")
    private BigInteger qtecomm;
    @JoinColumn(name = "IDCOMMANDE", referencedColumnName = "IDCOMMANDE")
    @ManyToOne(optional = false)
    private Commande idcommande;
    @JoinColumn(name = "IDPRODUIT")
    @ManyToOne(optional = false)
    private Produit idproduit;

    public LigneDeCommande() {
    }

    public LigneDeCommande(Integer idligne) {
        this.idligne = idligne;
    }

    public Integer getIdligne() {
        return idligne;
    }

    public void setIdligne(Integer idligne) {
        this.idligne = idligne;
    }

    public BigInteger getQtecomm() {
        return qtecomm;
    }

    public void setQtecomm(BigInteger qtecomm) {
        this.qtecomm = qtecomm;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idligne != null ? idligne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneDeCommande)) {
            return false;
        }
        LigneDeCommande other = (LigneDeCommande) object;
        if ((this.idligne == null && other.idligne != null) || (this.idligne != null && !this.idligne.equals(other.idligne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.com.LigneDeCommande[ idligne=" + idligne + " ]";
    }
    
}
