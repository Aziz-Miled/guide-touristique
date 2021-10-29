/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * @author houss
 */
public class utilisateurService  implements service<utilisateur> {
    private Connection connection;
    private Statement st;
    private PreparedStatement pre;
     
    public utilisateurService(){
        connection= MyDB.getInstance().getConnection();
    }
    
    @Override
    public void insert(utilisateur object) {
        try {
            String req = "INSERT INTO user(nom,prenom,cin_passport,email,pwd,role) VALUES('"+object.getNom()+"','"+object.getPrenom()+"','"+object.getCin_passport()+"','"+object.getEmail()+"','"+object.getMotDePasse()+"','role')";
            Statement st = connection.createStatement();
            st.executeUpdate(req);

          
        } catch (SQLException ex) {
            Logger.getLogger(utilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(utilisateur object) {
        try {
            String req = " UPDATE utilisateur SET nom = '"+object.getNom()+"', prenom = '"+object.getPrenom()+"', cin_passport = '"+object.getCin_passport()+"', email = '"+object.getEmail()+"', motDePasse = '"+object.getMotDePasse()+"', prix = '"+"' WHERE id ='"+object.getId()+"' ";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(utilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public boolean delete(int id) throws SQLException {
        if(chercher(id)){
           System.out.println("exist");
        pre=connection.prepareStatement("delete from `user` where id = (?);");
        pre.setInt(1,id);
          pre.execute();
    return true;}
        else 
     {System.out.println("nexiste pas");
           return false;}

     }
     public boolean chercher(int ref) {
        String req="select * from user ";
         
        List<Integer> list = new ArrayList<>();
        
        try {
            st=connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
            
                list.add(rs.getInt(1));
             

                
            }
        } catch (SQLException ex) {
           Logger.getLogger(utilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(ref);  
    }
     public utilisateur login(String email, String Motdepasse) throws SQLException {
        try {
            PreparedStatement pre = connection.prepareStatement("select * from user where email = ? ");
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
 
            utilisateur u = new utilisateur();
            if (rs.next()) {
            //get the pwd of the entred user from the DB
            String password = rs.getString(5);
            //Check that the entred passwod (Motdepasse) is correct and matched to the pwd
            boolean matched = password.equals(Motdepasse);
            if (matched){
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setMotDePasse(rs.getString("pwd"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
             }
            else{System.out.println("Vérifier votre mot de passe");}
            
            }
        System.out.println(u);
        return u;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     *
    
     * @return
     */
   @Override
    public List<utilisateur> findAll() {
        List<utilisateur> listH = new ArrayList<>();
        String req = "SELECT * FROM user";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                utilisateur h = new utilisateur();
                h.setId(rs.getInt(1));
                h.setNom(rs.getString(2));
                 h.setPrenom(rs.getString(3));
                h.setEmail(rs.getString(4));
                h.setMotDePasse(rs.getString(5));
                h.setCin_passport(rs.getString(6));
               
                
                listH.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(utilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listH;
    }

    @Override
    public void delete(utilisateur object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void login(utilisateur object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}


    
    
    
