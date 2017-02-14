/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

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
        /*
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent) myLoader.load();
        FXMLDocumentController dcCon = myLoader.<FXMLDocumentController>getController();
        Scene scene = new Scene(root);
        dcCon.init(dcCon);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    helper.saveWrapper();
            }
        });
        stage.setScene(scene);
        stage.show();
        */
        
        
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = (Parent) myLoader.load();
        FXMLDocumentController2 dcCon = myLoader.<FXMLDocumentController2>getController();
        Scene scene = new Scene(root);
        dcCon.init(dcCon);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    helper.saveWrapper();
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
