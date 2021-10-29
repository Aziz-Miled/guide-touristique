/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.transport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
import utils.transportDB;

/**
 *
 * @author houss
 */
public class transportServices implements service<transport> {
    Connection connection;
     
    public transportServices(){
        connection= MyDB.getInstance().getConnection();
    }
    @Override
    public void insert(transport object) {
        try {
            String req = "INSERT INTO transport(id,type) VALUES('"+object.getId()+"','"+object.getType()+"')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(transportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(transport object) {
        try {
            String req = " UPDATE transport SET type = '"+object.getType()+",' WHERE id ='"+object.getId()+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(transportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(transport object) {
        try {
            String req = " DELETE FROM transport WHERE id ='"+object.getId()+"'";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(transportService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    /**
     *
    
     * @return
     */
    @Override
    public List<transport> findAll() {
        List<transport> listT = new ArrayList<>();
        String req = "SELECT * FROM transport";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                transport t = new transport();
                t.setId(rs.getInt(1));
                t.setType(rs.getString("type"));
        
                listT.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(transportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listT;
    }  

   // @Override
   // public void login(transport object) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    @Override
    public void login(transport object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}