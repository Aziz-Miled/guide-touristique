/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.transport;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.transportService;
import services.transportServices;
import utils.MyDB;

/**
 *
 * @author houss
 */
public class mainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          MyDB.getInstance();
       MyDB db1= MyDB.getInstance();
       // MyDB db2= MyDB.getInstance();
       // MyDB db3= MyDB.getInstance();
       // MyDB db4= MyDB.getInstance();
        //MyDB db5= MyDB.getInstance();
        //transport t=new transport("jlkj");
        transportServices s= new transportServices();
        //s.insert(t);
       //System.out.println("DB0 : " + db0.toString());
       // System.out.println("DB1 : " + db1.toString());
      //  System.out.println("DB2 : " + db2.toString());
       // System.out.println("DB3 : " + db3.toString());
       // System.out.println("DB4 : " + db4.toString());
       // System.out.println("DB5 : " + db5.toString());
       
    }
}
            

