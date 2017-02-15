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
public class CourtTriController implements Initializable {

    private matchPlayer aux;
    @FXML
    private RadioButton n1;
    
    private boolean fallado;
    
    private int cuarto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void init(matchPlayer mP, boolean fallado, int cuarto) {
        this.aux = mP;
        this.fallado = fallado;
        this.cuarto = cuarto-1;
    }

    @FXML
    private void on1(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(1);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(1);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

    @FXML
    private void on2(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(2);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(2);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

    @FXML
    private void on3(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(3);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(3);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

    @FXML
    private void on4(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(4);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(4);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

    @FXML
    private void on5(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(5);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(5);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

    @FXML
    private void on6(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(6);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(6);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

    @FXML
    private void on7(ActionEvent event) {
        if (fallado) {
            aux.getT3fmp().get(cuarto).add(7);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        } else {
            aux.getT3mp().get(cuarto).add(7);
            Node a = (Node) n1.getParent();
            a.getScene().getWindow().hide();
        }
    }

}
