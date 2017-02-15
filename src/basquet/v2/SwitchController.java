/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import Persistencia.helper;
import Persistencia.wrapper;
import Persistencia.Player;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class SwitchController implements Initializable {

    @FXML
    private TableView<Player> tableAct;
    @FXML
    private Button right;
    @FXML
    private Button left;
    @FXML
    private Button accept;
    @FXML
    private TableView<Player> tableCam;
    
    @FXML
    private TableColumn<Player, Integer> plDorsal1;
    @FXML
    private TableColumn<Player, String> name1;
    @FXML
    private TableColumn<Player, Integer> plDorsal2;
    @FXML
    private TableColumn<Player, String> name2;

    
    private ObservableList<Player> obPl, obAct;
    
    private InGameController con;
    @FXML
    private TableColumn<Player, String> apellido1;
    @FXML
    private TableColumn<Player, String> pos1;
    @FXML
    private TableColumn<Player, String> apellido2;
    @FXML
    private TableColumn<Player, String> pos2;

    /**
     * Initializes the controller class.
     * 
     */
    
    public void init(ArrayList<Player> oba, InGameController con){
        for(int i = 0; i < oba.size(); i++) oba.get(i).refresh();
        this.obAct = FXCollections.observableArrayList(oba);
        wrapper wrap = helper.refresh();
        obPl = FXCollections.observableArrayList(wrap.getPlayerList());
        tableCam.setItems(obPl);
        tableAct.setItems(obAct);
        
        for(int i = 0; i < obAct.size(); i++){
            for (int j = 0; j < obPl.size(); j++){
                if(obAct.get(i).getIDp() == obPl.get(j).getIDp()){
                    obPl.remove(j);
                    break;
                }
            }
        }
        System.out.println(obAct.get(0).getNamep());
        this.con = con;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accept.setDisable(true);
        right.disableProperty().bind(Bindings.equal(-1, tableAct.getSelectionModel().selectedIndexProperty()));
        left.disableProperty().bind(Bindings.equal(-1, tableCam.getSelectionModel().selectedIndexProperty()));

        name1.setCellValueFactory(new PropertyValueFactory<>("nameP"));
        plDorsal1.setCellValueFactory(new PropertyValueFactory<>("dorsalP"));
        apellido1.setCellValueFactory(new PropertyValueFactory<>("surnameP"));
        pos1.setCellValueFactory(new PropertyValueFactory<>("posP"));
        
        
        name2.setCellValueFactory(new PropertyValueFactory<>("nameP"));
        plDorsal2.setCellValueFactory(new PropertyValueFactory<>("dorsalP"));
        apellido2.setCellValueFactory(new PropertyValueFactory<>("surnameP"));
        pos2.setCellValueFactory(new PropertyValueFactory<>("posP"));
    }    

    @FXML
    private void onRight(ActionEvent event) {
        obPl.add(tableAct.getSelectionModel().getSelectedItem());
        obAct.remove(tableAct.getSelectionModel().getSelectedItem());
        accept.setDisable(true);
    }

    @FXML
    private void onLeft(ActionEvent event) {
        if(obAct.size() == 5){
            event.consume();
            return;
        }
        obAct.add(tableCam.getSelectionModel().getSelectedItem());
        obPl.remove(tableCam.getSelectionModel().getSelectedItem());
        if (obAct.size() == 5) {
            accept.setDisable(false);
        }
    }

    @FXML
    private void onAccept(ActionEvent event) {
        
        con.setSwitches(obAct);
        con.refreshito();
        Node a = (Node) accept.getParent();
        a.getScene().getWindow().hide();
    }
    
}
