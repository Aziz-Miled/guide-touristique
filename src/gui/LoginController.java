/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.utilisateurService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button idConnecter;
    @FXML
    private Button idSave;
    @FXML
    private TextField idEmail;
    @FXML
    private PasswordField idMotdepasse;
    @FXML
    private ImageView imageview;
    
   utilisateurService su = new utilisateurService();
    @FXML
    private ImageView imagePwd;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    } 
    private void imageView(ActionEvent event) {       
    Image imageview = new Image("/icons/utilisateur.jpg");
        imageview = setImage();
    }
        
    private void imagePwd(ActionEvent event) {         
    Image imagePwd = new Image("/icons/password.jpg");
       imagePwd = setImage();
        }
    


    
    @FXML
    private void connecter(ActionEvent event) throws IOException, Exception {
        utilisateur u = new utilisateur();
        u.setEmail(idEmail.getText());
        u.setMotDePasse(idMotdepasse.getText());
        u =  su.login(idEmail.getText(), idMotdepasse.getText());
        if(u.getId()== 0){
            
            Alert alert = new Alert(Alert.AlertType.ERROR, "Verifier vos donnés", ButtonType.CLOSE);
            alert.show();
           
             
        } else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Je vous souhaite la bienvenue Mr/Mme "+ u.getNom()+" "+ u.getPrenom(), ButtonType.OK);
                alert.show();
                
        
    }
         AnchorPane page=FXMLLoader.load(getClass().getResource("GestionTransport.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void save(ActionEvent event) throws IOException {
         AnchorPane page=FXMLLoader.load(getClass().getResource("Utilisateur.fxml"));
        pane.getChildren().setAll(page);
    }

    private Image setImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
}
