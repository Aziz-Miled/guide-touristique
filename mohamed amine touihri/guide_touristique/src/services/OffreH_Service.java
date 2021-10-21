/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.OffreH;
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
public class OffreH_Service implements Service<OffreH>{
    private Connection connection;

    public OffreH_Service() {
        connection = MyDB.getInstance().getConnection();
    }

   

    
    @Override
    public void insert(OffreH object) {
        try {
            String req = "INSERT INTO `offreh`(`nom_offre`,`prix_offre`) VALUES('"+object.getNom_offre()+"','"+object.getPrix_offre()+"')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(OffreH object) {
        try {
            String req = " UPDATE `offreh` SET nom_offre = '"+object.getNom_offre()+"', prix_offre = '"+object.getPrix_offre()+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
                try {
//            String req = " DELETE FROM `offreh` WHERE id ='"+id+"' ";
            String req = "UPDATE `offreh` SET etat_offre = 'supprime' WHERE id ='"+id+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public List<OffreH> findAll() {
        List<OffreH> listOffreH = new ArrayList<>();
        String req = "SELECT * FROM `OffreH` WHERE etat_offre = 'active'";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                OffreH o = new OffreH();
                o.setId_offreH(rs.getInt(1));
                o.setNom_offre(rs.getString("nom_offre"));
                o.setPrix_offre(rs.getInt("prix_offre"));
                o.setEtat_offre(rs.getString("etat_offre"));
                
                listOffreH.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOffreH;
    }
    
}
