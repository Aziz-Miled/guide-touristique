/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class OffreH {
    private int id_offreH;
    private String nom_offre;
    private float prix_offre;
    private String etat_offre;
    List<Hotel> listH = new ArrayList<>();

    public OffreH() {
    }

    public OffreH(String nom_offre, float prix_offre) {
        this.nom_offre = nom_offre;
        this.prix_offre = prix_offre;
    }

    public void setId_offreH(int id_offreH) {
        this.id_offreH = id_offreH;
    }

    public void setNom_offre(String nom_offre) {
        this.nom_offre = nom_offre;
    }

    public void setPrix_offre(float prix_offre) {
        this.prix_offre = prix_offre;
    }

    public void setListH(List<Hotel> listH) {
        this.listH = listH;
    }

    public void setEtat_offre(String etat_offre) {
        this.etat_offre = etat_offre;
    }

    public int getId_offreH() {
        return id_offreH;
    }

    public String getNom_offre() {
        return nom_offre;
    }

    public float getPrix_offre() {
        return prix_offre;
    }

    public String getEtat_offre() {
        return etat_offre;
    }

    public List<Hotel> getListH() {
        return listH;
    }

    @Override
    public String toString() {
        return "OffreH{" + "id_offreH=" + id_offreH + ", nom_offre=" + nom_offre + ", prix_offre=" + prix_offre + ", etat_offre=" + etat_offre + ", listH=" + listH + '}';
    }
    
    
    
}
