/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.transport;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.transportServices;
import services.utilisateurService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class ModifierTransportController implements Initializable {

    @FXML
    private TextField idTypeT;
    @FXML
    private Button idAjout;
    @FXML
    private Button idRetour;
    private transportServices s;
    @FXML
    private AnchorPane Pane;
    @FXML
    private TextField idTransport;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         s=new transportServices();
    }    

    @FXML
    private void AjouterTransport(ActionEvent event)throws Exception {
        if (idTypeT.getText().isEmpty())
        {
          System.out.println(" champ vide !!!");
        }else if (idTransport.getText().isEmpty()) {
           System.out.println("Type vide !!!");
        }else {
        transport u = new transport();
        u.setType(idTypeT.getText());
        u.setId(Integer.parseInt(idTypeT.getText()));
        u.setType(idTransport.getText());
        
        s.insert(u);
    
    }
    }
    @FXML
    private void Retour(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("GestionTransport.fxml"));
        Pane.getChildren().setAll(page);
    }
    
}
