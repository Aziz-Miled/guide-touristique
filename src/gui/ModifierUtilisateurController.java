/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.utilisateur;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import services.utilisateurService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class ModifierUtilisateurController implements Initializable {

    @FXML
    private Button Roteur;
    @FXML
    private Button Supprimer;
    @FXML
    private AnchorPane pane;
    @FXML
    private TableColumn<?, ?> idNom;
    @FXML
    private TableColumn<?, ?> idPrenom;
    @FXML
    private TableColumn<?, ?> idEmail;
    @FXML
    private TableColumn<?, ?> idCinpassport;
    @FXML
    private TableView<?> idtable;
    @FXML
    private ImageView imageSupp;

    /**
     * Initializes the controller class.
     */
      

    @FXML
    private void Retour(ActionEvent event)throws IOException {
         AnchorPane page=FXMLLoader.load(getClass().getResource("Utilisateur.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        utilisateurService su = new utilisateurService();
         utilisateur cc = (utilisateur)idtable.getSelectionModel().getSelectedItem();
         // w= cc.getRef();
        //System.out.println(w);
       
        if(cc == null){
            JOptionPane.showMessageDialog(null, "choisir utilisateur");
                   
        }else{
             try {
      
                 su.delete(cc.getId());
                 
                Affiche();
                 
                 JOptionPane.showMessageDialog(null, " utilisateur supprimer");
               
                 cc=null;
             } catch (SQLException ex) {
                 Logger.getLogger(utilisateurService.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Affiche();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void imageSupp(ActionEvent event) {         
    Image imageSupp = new Image("/icons/delete.jpg");
       imageSupp = setImage();
        }
        // TODO

    private void Affiche() throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        utilisateurService sr = new utilisateurService(); 
        
           
         
            
        
       List utilisateur=sr.findAll();
       ObservableList et=FXCollections.observableArrayList(utilisateur);
       idtable.setItems(et);
            
            
            idNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            idPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            idEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            idCinpassport.setCellValueFactory(new PropertyValueFactory<>("cin_passport"));
    }

    private Image setImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void PDF(ActionEvent event)throws DocumentException  {
        //Document doc = new Document() ;
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\houss\\Desktop\\test.pdf"));
            doc.open();
            Paragraph p = new Paragraph("A discription de le restauration est : ");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

            //  Font a = new Font(Font.FontFamily.TIMES_ROMAN,20f );
            Paragraph contenu = new Paragraph(preparerMsg());
            doc.add(contenu);
            doc.close();

            Desktop.getDesktop().open(new File("C:\\Users\\houss\\Desktop\\test.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModifierUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(ModifierUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModifierUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String preparerMsg() {
        //    Hotel hotel = tvhHotel_bad.getSelectionModel().getSelectedItem();
        utilisateur c = (utilisateur) idtable.getSelectionModel().getSelectedItem();

        String ch = " \n \n"
                + "Nom: " + c.getNom() + "\n \n"
                + "Prenom: " + c.getPrenom()+ "\n \n"
                + "Email: " + c.getEmail() + "\n \n "
                + "Cin passport: " + c.getCin_passport()+ "\n \n";
                

        return ch;
    }

    
}

    
    

    
    
