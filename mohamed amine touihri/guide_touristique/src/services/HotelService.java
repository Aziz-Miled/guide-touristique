/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Hotel;
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
public class HotelService implements Service<Hotel>{

    private Connection connection;
    
    public HotelService() {
        connection = MyDB.getInstance().getConnection();
    }
    
    @Override
    public void insert(Hotel object) {
        try {
            String req = "INSERT INTO `hotel`(`nom`,`adresse`,`tel`,`email`,`page_web`,`nombre_etoile`) VALUES('"+object.getNom()+"','"+object.getAdresse()+"','"+object.getTel()+"','"+object.getEmail()+"','"+object.getPage_web()+"','"+object.getNombre_etoile()+"')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Hotel object) {
        try {
            String req = " UPDATE `hotel` SET nom = '"+object.getNom()+"', adresse = '"+object.getAdresse()+"', tel = '"+object.getTel()+"', email = '"+object.getEmail()+"', page_web = '"+object.getPage_web()+"', nombre_etoile = '"+object.getNombre_etoile()+"' WHERE id_hotel ='"+object.getId_hotel()+"' ";
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
            String req = "UPDATE `hotel` SET etat = 'supprime' WHERE id_hotel ='"+id+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> listH = new ArrayList<>();
        String req = "SELECT * FROM `hotel` WHERE etat = 'active'";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                Hotel h = new Hotel();
                h.setId_hotel(rs.getInt(1));
                h.setNom(rs.getString("nom"));
                h.setAdresse(rs.getString(3));
                h.setTel(rs.getString("tel"));
                h.setEmail(rs.getString(5));
                h.setPage_web(rs.getString("page_web"));
                h.setNombre_etoile(rs.getInt("nombre_etoile"));
                h.setEtat(rs.getString("etat"));
                
                listH.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listH;
    }
    
}
