/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import basquet.v2.AddPlayerWindowController;
import basquet.v2.CourtController;
import basquet.v2.FXMLDocumentController;
import basquet.v2.FXMLDocumentController2;
import basquet.v2.InGameController;
import basquet.v2.MatchDataController;
import basquet.v2.PlayerDataController;
import basquet.v2.PrestartController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Yuki
 */
public class Factory {
    
    public static Match createMatch(){
        return new Match();
    }
    
    public static Player createPlayer(){
        return new Player();
    }
    
    public static matchPlayer createMatchPlayer(){
        return new matchPlayer();
    }
    
    public static matchPlayer createMatchPlayer(int id){
        return new matchPlayer(id);
    }
    
    public static FXMLDocumentController showFXMLDocumentController(FXMLLoader myLoader){
        try{
        Parent root = (Parent) myLoader.load();
        FXMLDocumentController dcCon = myLoader.<FXMLDocumentController>getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    helper.saveWrapper();
            }
        });
        stage.setScene(scene);
        stage.show();
        return dcCon;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static FXMLDocumentController2 showFXMLDocumentController2(FXMLLoader myLoader){
        try{
        Parent root = (Parent) myLoader.load();
        FXMLDocumentController2 dcCon = myLoader.<FXMLDocumentController2>getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                    helper.saveWrapper();
            }
        });
        stage.setScene(scene);
        stage.show();
        return dcCon;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static PrestartController showPrestartController(FXMLLoader myLoader){
        try {
            Parent root = (Parent) myLoader.load();
            PrestartController dcCon = myLoader.<PrestartController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Quinteto Inicial");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(true);
            stage.show();
            return dcCon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static MatchDataController showMatchDataController(FXMLLoader myLoader){
        try {
            Parent root = (Parent) myLoader.load();
            MatchDataController dcCon = myLoader.<MatchDataController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Datos del Partido");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
            return dcCon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static PlayerDataController showPlayerDataController(FXMLLoader myLoader){
        try {
            Parent root = (Parent) myLoader.load();
            PlayerDataController dcCon = myLoader.<PlayerDataController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Datos de Jugador");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
            return dcCon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static AddPlayerWindowController showAddPlayerWindowController(FXMLLoader myLoader){
        try {
            Parent root = (Parent) myLoader.load();
            AddPlayerWindowController dcCon = myLoader.<AddPlayerWindowController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Datos del Jugador");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
            return dcCon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Stage showCourtController(FXMLLoader myLoader, InGameController inGame){
        try {
            Parent root = (Parent) myLoader.load();
                CourtController dcCon = myLoader.<CourtController>getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Media Cancha");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                /*dcCon
                stage.setOnCloseRequest((WindowEvent event1) -> {
                    pl.getmP().getT2mp().get(cuartCount - 1).add(0);
                });
                stage.show();*/
                return stage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
}
