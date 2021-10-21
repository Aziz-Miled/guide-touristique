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
public class Hotel {

    private int id_hotel;
    private String nom;
    private String adresse;
    private String tel;
    private String email;
    private String page_web;
    private int nombre_etoile;
    private String etat;
    List<OffreH> listOffreH = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String nom, String adresse, String tel, String email, String page_web, int nombre_etoile) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.page_web = page_web;
        this.nombre_etoile = nombre_etoile;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPage_web(String page_web) {
        this.page_web = page_web;
    }

    public void setNombre_etoile(int nombre_etoile) {
        this.nombre_etoile = nombre_etoile;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setListOffreH(List<OffreH> listOffreH) {
        this.listOffreH = listOffreH;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getPage_web() {
        return page_web;
    }

    public int getNombre_etoile() {
        return nombre_etoile;
    }

    public String getEtat() {
        return etat;
    }

    public List<OffreH> getListOffreH() {
        return listOffreH;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + ", email=" + email + ", page_web=" + page_web + ", nombre_etoile=" + nombre_etoile + ", etat=" + etat + ", listOffreH=" + listOffreH + '}';
    }

    
    

    public void setId_hotel(int aInt) {
        this.id_hotel = aInt;
    }

}
