/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.transport;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.transportServices;
import services.utilisateurService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class GestionTransportController implements Initializable {

     @FXML
    private AnchorPane pane;
    private ImageView imageView;
    @FXML
    private ImageView image;
    @FXML
    private ImageView imageBus;
    @FXML
    private ImageView imageTaxi;
    @FXML
    private TableView<?> idTable;
    @FXML
    private TableColumn<?, ?> idType;
    @FXML
    private Button idAjouter;
    @FXML
    private Button idSupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             // TODO
             Affiche();
         } catch (SQLException ex) {
             Logger.getLogger(GestionTransportController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    

private void imageView(ActionEvent event) {       
    Image image = new Image("voiture.jpg");
        imageView = setImage(image);
        }
private void imageBus(ActionEvent event) {       
    Image imageBus = new Image("bus.jpg");
        imageView = setImage(imageBus);
        
}
private void imageTaxi(ActionEvent event) {       
    Image imageTaxi = new Image("taxiii.jpg");
        imageView = setImage(imageTaxi);
        
}
   
    

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("ModifierTransport.fxml"));
        pane.getChildren().setAll(page);
    }

    private void Affiche() throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         transportServices s = new transportServices(); 
        
           
         
            
        
       List utilisateur=s.findAll();
       ObservableList et=FXCollections.observableArrayList(utilisateur);
       idTable.setItems(et);
            
            
            idType.setCellValueFactory(new PropertyValueFactory<>("type"));
               }

    @FXML
    private void Supprimer(ActionEvent event) {
         transportServices s = new transportServices();
         transport c = (transport)idTable.getSelectionModel().getSelectedItem();
         // w= cc.getRef();
        //System.out.println(w);
       
        if(c == null){
            JOptionPane.showMessageDialog(null, "choisir un transport");
                   
        }else{
             try {
      
                 s.delete(c);
                 
                Affiche();
                 
                 JOptionPane.showMessageDialog(null, " transport supprimer");
               
                 c=null;
             } catch (SQLException ex) {
                 Logger.getLogger(utilisateurService.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    }

    
    }
