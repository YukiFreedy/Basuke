/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import Persistencia.Factory;
import Persistencia.helper;
import Persistencia.Match;
import Persistencia.wrapper;
import Persistencia.Player;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Yuki
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Match> tableMatch;

    private ObservableList<Match> obMatch;

    @FXML
    private Button butExamineMatch;
    @FXML
    private Button butEraseMatch;
    @FXML
    private Label labelNumMatches;
    @FXML
    private TableView<Player> tablePlayers;

    private ObservableList<Player> obPlayers;

    @FXML
    private Button butExaminePlayer;
    @FXML
    private Button butErasePlayer;
    @FXML
    private Button butAddPlayer;
    @FXML
    private Label labelNumPlayers;
    @FXML
    private Button butNewMatch;
    @FXML
    private Button butRestartMatch;

    private wrapper marshed;
    @FXML
    private Button butModPlayer;

    private helper help;
    @FXML
    private TableColumn<Player, String> photo;
    @FXML
    private TableColumn<Player, String> name;
    @FXML
    private TableColumn<Player, String> surnames;
    @FXML
    private TableColumn<Player, String> pos;
    @FXML
    private TableColumn<Player, Integer> birth;
    @FXML
    private Label labelNotEnoughPl;
    @FXML
    private TableColumn<Match, String> columnRival;
    @FXML
    private TableColumn<Match, String> columnDía;
    @FXML
    private TableColumn<Match, String> columnResultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        marshed = helper.getInstance();

        refresh();

        tableMatch.setItems(obMatch);
        tablePlayers.setItems(obPlayers);

        columnRival.setCellValueFactory(c -> c.getValue().rivalPProperty());
        columnDía.setCellValueFactory(c -> c.getValue().datePProperty());
        columnResultado.setCellValueFactory(c -> c.getValue().resultPProperty());

        name.setCellValueFactory(new PropertyValueFactory<>("nameP"));
        surnames.setCellValueFactory(new PropertyValueFactory<>("surnameP"));
        birth.setCellValueFactory(new PropertyValueFactory<>("dorsalP"));
        pos.setCellValueFactory(new PropertyValueFactory<>("posP"));
        photo.setCellValueFactory(c -> c.getValue().imgPProperty());
        photo.setCellFactory(c -> new TableCell<Player, String>() {
            private ImageView view = new ImageView();

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    InputStream is = null;
                    if (item.equals("nop")) {
                        item = "/resources/NoUserImage_Big.png";
                        is = this.getClass().getResourceAsStream("/resources/NoUserImage_Big.png");
                    }

                    try {
                        is = new FileInputStream(item); // here I get FileNotFoundException

                    } catch (Exception e) {

                    }
                    Image image = new Image(is, 500, 100, true, true);
                    view.setImage(image);
                    setGraphic(view);
                }
            }
        });

        butEraseMatch.disableProperty().bind(Bindings.equal(-1, tableMatch.getSelectionModel().selectedIndexProperty()));
        butRestartMatch.disableProperty().bind(Bindings.equal(-1, tableMatch.getSelectionModel().selectedIndexProperty()));
        butErasePlayer.disableProperty().bind(Bindings.equal(-1, tablePlayers.getSelectionModel().selectedIndexProperty()));
        butExaminePlayer.disableProperty().bind(Bindings.equal(-1, tablePlayers.getSelectionModel().selectedIndexProperty()));
        butModPlayer.disableProperty().bind(Bindings.equal(-1, tablePlayers.getSelectionModel().selectedIndexProperty()));
        butExamineMatch.disableProperty().bind(Bindings.equal(-1, tableMatch.getSelectionModel().selectedIndexProperty()));

    }

    @FXML
    private void onEraseMatch(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Dialogo de Confirmación");
        alert.setHeaderText("Está a Punto de Borrarse el Partido para siempre");
        alert.setContentText("¿Estás seguro de que quieres eliminarlo?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            marshed = helper.getInstance();
            int id = tableMatch.getSelectionModel().getSelectedItem().getIDm();
            ArrayList<Player> li = marshed.getPlayerList();
            for (int i = 0; i < li.size(); i++) {
                for (int j = 0; j < li.get(i).getmPListp().size(); j++) {
                    if (id == li.get(i).getmPListp().get(j).getIDmp()) {
                        System.out.println("removed mp");
                        li.get(i).getmPListp().remove(j);
                    }
                }
            }
            ArrayList<Match> list = marshed.getMatchList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getIDm() == id) {
                    list.remove(i);
                }
            }
            refresh();
        }
    }

    @FXML
    private void onErasePlayer(ActionEvent event
    ) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Dialogo de Confirmación");
        alert.setHeaderText("Está a Punto de Borrarse el Jugador para siempre");
        alert.setContentText("¿Estás seguro de que quieres eliminarlo?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ArrayList<Player> list = helper.getInstance().getPlayerList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getIDp() == tablePlayers.getSelectionModel().getSelectedItem().getIDp()) {
                    list.remove(i);
                }
            }
            refresh();
        }

    }

    @FXML
    private void onAddPlayer(ActionEvent event
    ) {
        labelNotEnoughPl.setVisible(false);

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("addPlayerWindow.fxml"));
        Factory.showAddPlayerWindowController(myLoader);

    }

    @FXML
    private void onModPlayer(ActionEvent event) {

        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("addPlayerWindow.fxml"));
        AddPlayerWindowController con = Factory.showAddPlayerWindowController(myLoader);
        con.init(this);
        Player pl = tablePlayers.getSelectionModel().getSelectedItem();
        con.loadPlayer(pl);

    }

    public void refresh() {
        ArrayList<Player> a = helper.getInstance().getPlayerList();
        //revisar tamaño
        Player player;
        for (int i = 0; i < a.size(); i++) {
            player = a.get(i);
            player.refresh();
        }
        obMatch = FXCollections.observableArrayList(marshed.getMatchList());
        obPlayers = FXCollections.observableArrayList(marshed.getPlayerList());
        tablePlayers.setItems(obPlayers);
        tableMatch.setItems(obMatch);
        labelNumPlayers.setText("Número de Jugadores: " + Integer.toString(obPlayers.size()));
        labelNumMatches.setText("Número de Partidos " + Integer.toString(obMatch.size()));
    }

    @FXML
    private void onNewMatch(ActionEvent event) {
        if (obPlayers.size() < 5) {
            labelNotEnoughPl.setVisible(true);
            return;
        }
        newMatch();
    }

    public void newMatch() {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("prestart.fxml"));
        Factory.showPrestartController(myLoader).init(this);
    }

    @FXML
    private void onResumeMatch(ActionEvent event) {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("prestart.fxml"));
        Factory.showPrestartController(myLoader).init(this,tableMatch.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void onLookMatch(ActionEvent event) {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("matchData.fxml"));
        Match match = tableMatch.getSelectionModel().getSelectedItem();
        Factory.showMatchDataController(myLoader).init(match, false);
    }

    @FXML
    private void onLookPlayer(ActionEvent event) {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("PlayerData.fxml"));
        Player pl = tablePlayers.getSelectionModel().getSelectedItem();
        Factory.showPlayerDataController(myLoader).init(pl);
    }

}
