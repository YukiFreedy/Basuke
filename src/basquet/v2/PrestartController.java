/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import Persistencia.helper;
import Persistencia.Match;
import Persistencia.wrapper;
import Persistencia.Player;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class PrestartController implements Initializable {

    @FXML
    private Button butStart;
    @FXML
    private Label labelTitle;
    @FXML
    private TableView<Player> tablePl;
    @FXML
    private Button butDer;
    @FXML
    private Button butIzq;
    @FXML
    private TableView<Player> tableAct;
    @FXML
    private TableColumn<Player, String> plName;
    @FXML
    private TableColumn<Player, String> plSurnames;
    @FXML
    private TableColumn<Player, String> plPos;

    @FXML
    private TableColumn<Player, String> actName;
    @FXML
    private TableColumn<Player, String> actSurname;
    @FXML
    private TableColumn<Player, String> actPos;

    private helper help = new helper();

    private ObservableList<Player> obPl, obAct;
    @FXML
    private Label error;
    @FXML
    private TextField equipo;
    @FXML
    private ChoiceBox<String> local;
    @FXML
    private Label errorRival;

    private FXMLDocumentController dcC;

    private Match match;

    public void init(FXMLDocumentController dcC) {
        this.dcC = dcC;
    }

    public void init(FXMLDocumentController dcC, Match match) {
        this.dcC = dcC;

        ArrayList<Player> aux = helper.getInstance().getPlayerList();
        
        equipo.setText(match.getRival());
        for (int i = 0; i < match.getPlayerListm().size(); i++) {
            System.out.println("Number of mp: " + aux.get(i).getmPListp().size());
            for (int j = 0; j < aux.get(i).getmPListp().size(); j++) {
                if (aux.get(i).getmPListp().get(j).getIDmp() == match.getIDm()) {
                    aux.get(i).setmP(aux.get(i).getmPListp().get(j));
                    System.out.println(i+ " -----> "+ j+", timePlayed is: " + aux.get(i).getmP().getTiemJugadomp());
                    aux.get(i).getmPListp().remove(j);
                    break;
                }
            }
        }

        this.match = match;
        setPlayerList();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> aux = new ArrayList<>();
        ObservableList<String> ob = FXCollections.observableArrayList();
        aux.add("Partido Local");
        aux.add("Partido Visitante");

        ob.setAll(aux);
        local.setItems(ob);

        local.getSelectionModel().select(0);

        wrapper wrap = helper.refresh();
        obPl = FXCollections.observableArrayList(wrap.getPlayerList());
        tablePl.setItems(obPl);
        obAct = FXCollections.observableArrayList();
        tableAct.setItems(obAct);

        butDer.disableProperty().bind(Bindings.equal(-1, tablePl.getSelectionModel().selectedIndexProperty()));
        butIzq.disableProperty().bind(Bindings.equal(-1, tableAct.getSelectionModel().selectedIndexProperty()));

        butStart.setDisable(true);

        plName.setCellValueFactory(new PropertyValueFactory<Player, String>("nameP"));
        plSurnames.setCellValueFactory(new PropertyValueFactory<Player, String>("surnameP"));
        plPos.setCellValueFactory(new PropertyValueFactory<Player, String>("posP"));

        actName.setCellValueFactory(new PropertyValueFactory<Player, String>("nameP"));
        actSurname.setCellValueFactory(new PropertyValueFactory<Player, String>("surnameP"));
        actPos.setCellValueFactory(new PropertyValueFactory<Player, String>("posP"));

    }

    @FXML
    private void onButDer(ActionEvent event) {
        if (obAct.size() == 5) {
            error.setVisible(true);
            return;
        }
        obAct.add(tablePl.getSelectionModel().getSelectedItem());
        obPl.remove(tablePl.getSelectionModel().getSelectedItem());
        if (obAct.size() == 5) {
            butStart.setDisable(false);
        }
    }

    @FXML
    private void onButIzq(ActionEvent event) {
        error.setVisible(false);
        obPl.add(tableAct.getSelectionModel().getSelectedItem());
        obAct.remove(tableAct.getSelectionModel().getSelectedItem());
        butStart.setDisable(true);
    }

    @FXML
    private void onStart(ActionEvent event) {
        ArrayList<Player> data = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (obAct.get(j).getPos() == i) {
                    data.add(obAct.get(j));
                }
            }
        }
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("inGame.fxml"));
            Parent root = (Parent) myLoader.load();
            InGameController dcCon = myLoader.<InGameController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Partido");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(true);
            if (match != null) dcCon.init(data, equipo.getText(), local.getSelectionModel().getSelectedIndex(), dcCon, dcC, match);
            else dcCon.init(data, equipo.getText(), local.getSelectionModel().getSelectedIndex(), dcCon, dcC);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    dcCon.saveMatch(true);
                    dcCon.end();
                }
            });
            stage.show();
            Node a = (Node) butDer.getParent();
            a.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onRival(KeyEvent event) {
        errorRival.setVisible(false);
    }

    private void setPlayerList(){
        ArrayList<Integer> aux = match.getActivos();
        
        if(aux == null) return;
        if(aux.size() != 5) return;
        
        for(int i = 0; i < aux.size(); i++){
            for(int j = 0; j < obPl.size(); j++){
                if(obPl.get(j).getIDp() == aux.get(i)){
                    obAct.add(obPl.get(j));
                    obPl.remove(j);
                }
            }
        }
        
        butStart.setDisable(false);
    }
    
}
