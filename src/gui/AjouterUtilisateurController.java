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
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.EmailService;
import services.utilisateurService;
import utils.MailUtilisateur;

/**.
 * FXML Controller class
 *
 * @author houss
 */
public class AjouterUtilisateurController implements Initializable {

    @FXML
    private Button idSave;
    @FXML
    private TextField idPrenom;
    @FXML
    private TextField idNom;
    @FXML
    private TextField idEmail;
    @FXML
    private TextField idCinpassport;
    @FXML
    private TextField idMotdepasse;
    @FXML
    private ImageView imageView;
    
private utilisateurService su;
private EmailService sm;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button idRoteur;
    @FXML
    private Button Modifier;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        su = new utilisateurService() {
          //  @Override
            //public void login(utilisateur object) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
        };
        
        
        MailUtilisateur mailer;
        mailer = new MailUtilisateur(){};
        
    }    
     private void imageView(ActionEvent event) {       
    Image image = new Image("/icons/Tunisie.jpg");
        imageView = setImage(image);
        }
    @FXML
    private void save(ActionEvent event) throws Exception {
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        if (idNom.getText().isEmpty())
        {
          System.out.println("Nom vide !!!");
        } else if (idPrenom.getText().isEmpty()) {
           System.out.println("prenom vide !!!");   
        } else if (idEmail.getText().isEmpty()) {
           System.out.println("email vide !!!");   
        }else if (idCinpassport.getText().isEmpty()) {
           System.out.println("Cinpassport vide !!!");   
        }else if (idMotdepasse.getText().isEmpty()) {
           System.out.println("Mot de passe vide !!!");   
        }else{
        utilisateur u = new utilisateur();
        u.setNom(idNom.getText());
        u.setPrenom(idPrenom.getText());
        u.setEmail(idEmail.getText());
        u.setMotDePasse(idMotdepasse.getText());
        u.setCin_passport(idCinpassport.getText());
        su.insert(u);
        
         AnchorPane page=FXMLLoader.load(getClass().getResource("login.fxml"));
        pane.getChildren().setAll(page);          
            // Send an email for inscription confirmation
            MailUtilisateur mailer = new MailUtilisateur();
        mailer.SendMail(idEmail.getText());
        System.out.println("utilisateur ajouter");
        
        
        }
    }

    private ImageView setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void Retour(ActionEvent event)throws IOException {
         AnchorPane page=FXMLLoader.load(getClass().getResource("Login.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void Modifier(ActionEvent event)throws IOException {
         AnchorPane page=FXMLLoader.load(getClass().getResource("ModifierUtilisateur.fxml"));
        pane.getChildren().setAll(page);
    }
    
}
