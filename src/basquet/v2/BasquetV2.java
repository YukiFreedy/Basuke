/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import Persistencia.Factory;
import Persistencia.helper;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Yuki
 */
public class BasquetV2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Factory.showFXMLDocumentController(myLoader);
        
        
        /*
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Factory.showFXMLDocumentController2(myLoader);
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
