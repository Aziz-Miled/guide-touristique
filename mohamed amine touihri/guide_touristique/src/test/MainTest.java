/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Hotel;
import entities.OffreH;
import entities.Offre_Hotel;
import services.HotelService;
import services.OffreH_Service;
import services.Offre_Hotel_Service;
import utils.MyDB;

/**
 *
 * @author user
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyDB.getInstance();

   Hotel h = new Hotel("eeee", "Hammamet", "23446085", "golf@gmail.com", "GOLF_page", 4);
   h.setId_hotel(7);
        HotelService hs = new HotelService();
//    hs.insert(h);
//        h.setId_hotel(6);
//        h.setNom("eeee");
//        h.setNombre_etoile(5);
//        hs.update(h);
//      hs.delete(6);
//        System.out.println(hs.findAll().toString());


        OffreH of1 = new OffreH("piscine_couvert", 40);
        of1.setId_offreH(5);
//        OffreH of2 = new OffreH("piscine_non_couvert", 30);
//        OffreH of3 = new OffreH("jacuzzi", 50);
//        OffreH of4 = new OffreH("massage", 55);
        OffreH_Service ofs = new OffreH_Service();
//        ofs.insert(of1);
//        ofs.insert(of2);
//        ofs.insert(of3);
//        ofs.insert(of4);

//        ofs.delete(8);
//        System.out.println(ofs.findAll().toString());


 Offre_Hotel oh1 = new Offre_Hotel(h,of1);
Offre_Hotel_Service ohs = new Offre_Hotel_Service();
//ohs.insert(oh1);
       System.out.println(ohs.findAll().toString());

    }

}
