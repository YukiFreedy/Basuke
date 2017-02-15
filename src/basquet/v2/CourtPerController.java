/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import Persistencia.matchPlayer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class CourtPerController implements Initializable {

    @FXML
    private RadioButton n1;

    private matchPlayer aux;
    
    private int cuarto;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void init(matchPlayer mP, int cuarto){
        aux = mP;
        this.cuarto = cuarto-1;
    }

    @FXML
    private void on1(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(1);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on2(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(2);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on4(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(4);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on5(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(5);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on3(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(3);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on6(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(6);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on8(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(8);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on7(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(7);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on9(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(9);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on10(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(10);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on12(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(12);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on13(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(13);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void on11(ActionEvent event) {
        aux.getPerAmp().get(cuarto).add(11);
        Node a = (Node) n1.getParent();
        a.getScene().getWindow().hide();
    }
    
}
