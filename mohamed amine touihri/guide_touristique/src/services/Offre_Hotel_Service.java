/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Hotel;
import entities.OffreH;
import entities.Offre_Hotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author user
 */
public class Offre_Hotel_Service implements Service<Offre_Hotel>{
    private Connection connection;

    public Offre_Hotel_Service() {
        connection = MyDB.getInstance().getConnection();
    }
    
    
    @Override
    public void insert(Offre_Hotel object) {
try {
            String req = "INSERT INTO `offre_hotel`(`id_H`,`id_O`) VALUES('"+object.getH().getId_hotel()+"','"+object.getOffreH().getId_offreH()+"')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Offre_Hotel object) {
try {
            String req = " UPDATE `offre_hotel` SET id_hotel = '"+object.getH().getId_hotel()+"', id_offreH = '"+object.getOffreH().getId_offreH()+"' WHERE id ='"+object.getId()+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
try {
//            String req = " DELETE FROM `hotel` WHERE id ='"+id+"' ";
            String req = "UPDATE `offre_hotel` SET etat_offre_hotel  = 'supprime' WHERE id ='"+id+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public List<Offre_Hotel> findAll() {
List<Offre_Hotel> listOH = new ArrayList<>();
//        String req = "SELECT (hotel.nom, hotel.adresse, hotel.tel, hotel.email, hotel.page_web, hotel.nombre_etoile, offreh.nom_offre, offreh.prix_offre, hotel.id, offreh.id) FROM `offre_hotel` of WHERE offre_hotel.etat_offre_hotel = 'active' AND offre_hotel.id_hotel=hotel.id AND offre_hotel.id_offreH=offreh.id ";
            String req = "SELECT ( nom, adresse, tel, email, page_web, nombre_etoile, nom_offre, prix_offre, id_hotel, id_offreH) FROM `offre_hotel` WHERE etat_offre_hotel = 'active' AND id_H =id_hotel AND id_O =id_offreH ";
//            String req2="SELECT * FROM hotel h NATURAL JOIN offre_hotel oh WHERE h.id_hotel=oh.id_H";
            try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
//                Hotel H = new Hotel(setNom(rs.getString("nom")),setAdresse(rs.getString("adresse")),setTel(rs.getString("tel")),setEmail(rs.getString("email")),setPage_web(rs.getString("page_web")),setNombre_etoile(rs.getInt("nombre_etoile")));
                Hotel H = new Hotel(rs.getString("nom"),rs.getString("adresse"),rs.getString("tel"),rs.getString("email"),rs.getString("page_web"),rs.getInt("nombre_etoile"));
                OffreH offreH = new OffreH(rs.getString("nom_offre"),rs.getInt("prix_offre"));
                
                Offre_Hotel OH = new Offre_Hotel(H,offreH);
                listOH.add(OH);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOH;    }
    
}
