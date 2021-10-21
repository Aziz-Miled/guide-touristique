/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.ResultSet;
import java.sql.Statement;


public class Offre_Hotel {
    
    
    private int id;
    Hotel H = new Hotel();
    OffreH offreH = new OffreH();
    private String etat_offre_hotel;

    
    public Offre_Hotel() {
    }

    public Offre_Hotel(Hotel H, OffreH offreH) {
        this.H = H;
        this.offreH = offreH;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setH(Hotel H) {
        this.H = H;
    }

    public void setOffreH(OffreH offreH) {
        this.offreH = offreH;
    }

    public void setEtat_offre_hotel(String etat_offre_hotel) {
        this.etat_offre_hotel = etat_offre_hotel;
    }

    
    public int getId() {
        return id;
    }

    public Hotel getH() {
        return H;
    }

    public OffreH getOffreH() {
        return offreH;
    }

    public String getEtat_offre_hotel() {
        return etat_offre_hotel;
    }

    @Override
    public String toString() {
        return "Offre_Hotel{" + "id=" + id + ", H=" + H + ", offreH=" + offreH + ", etat_offre_hotel=" + etat_offre_hotel + '}';
    }
    
    
}
