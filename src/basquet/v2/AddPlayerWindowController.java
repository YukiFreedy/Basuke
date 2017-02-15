/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import Persistencia.*;
import Persistencia.wrapper;
import Persistencia.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class AddPlayerWindowController implements Initializable {

    @FXML
    private ImageView photo;
    @FXML
    private ChoiceBox<Integer> dd;
    @FXML
    private ChoiceBox<Integer> mm;
    @FXML
    private ChoiceBox<Integer> yyyy;
    @FXML
    private ChoiceBox<String> pos;
    @FXML
    private Button cancel;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private Text error;
    @FXML
    private TextField surname2;

    private FXMLDocumentController dcCon;

    private boolean mode;

    private Player pl;
    @FXML
    private TextField dorsal;

    private File file;

    private String img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img = "nop";
        mode = false;
        ObservableList data = FXCollections.observableArrayList();
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            aux.add(i);
        }
        data.setAll(aux);
        mm.setItems(data);
        dd.setItems(data);

        data = FXCollections.observableArrayList();
        aux = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        //get current date time with Date()
        Date date = new Date();
        int year = Integer.parseInt(dateFormat.format(date));
        for (int i = year; i != 1900; i--) {
            aux.add(i);
        }
        data.setAll(aux);
        yyyy.setItems(data);

        mm.getSelectionModel().select(0);
        yyyy.getSelectionModel().select(0);
        dd.getSelectionModel().select(0);

        data = FXCollections.observableArrayList();
        ArrayList<String> aux2 = new ArrayList<>();

        aux2.add("1. Base");
        aux2.add("2. Escolta");
        aux2.add("3. Alero");
        aux2.add("4. Ala-Pívot");
        aux2.add("5. Pívot");

        data.setAll(aux2);
        pos.setItems(data);
        pos.getSelectionModel().select(0);
    }

    @FXML
    private void onPhoto(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(cancel.getScene().getWindow());
        if (file == null) {
            return;
        }
        wrapper wrap = helper.getInstance();
        img = "resources/" + wrap.getIDImage() + ".jpg";
        File toCopy = new File(img);
        try {
            Files.copy(file.toPath(), toCopy.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        InputStream is = null;
        try {
            is = new FileInputStream(img); // here I get FileNotFoundException
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image aux2 = new Image(is);
        photo.setImage(aux2);

    }

    @FXML
    private void onDD(MouseEvent event) {
        ObservableList data = FXCollections.observableArrayList();
        ArrayList<Integer> aux = new ArrayList<>();
        int max = 30;
        int x = mm.getSelectionModel().getSelectedItem();
        if (x == 1 || x == 3 || x == 5 || x == 7 || x == 8 || x == 10 || x == 12) {
            max = 31;
        }
        if (x == 2) {
            double a = yyyy.getSelectionModel().getSelectedItem() % 4;
            if (a == 0) {
                max = 29;
            } else {
                max = 28;
            }
        }
        for (int i = 1; i <= max; i++) {
            aux.add(i);
        }

        data.setAll(aux);
        dd.setItems(data);

    }

    @FXML
    private void onAccept(ActionEvent event) {
        if (name.getText().isEmpty()) {
            error.setText("El Campo de Nombre Está Vacío");
            error.setVisible(true);
            return;
        }
        if (surname.getText().isEmpty()) {
            error.setText("El Campo de Apellido Está Vacío");
            error.setVisible(true);
            return;
        }
        if (dorsal.getText().isEmpty()) {
            error.setText("El Campo Dorsal Está Vacío");
            error.setVisible(true);
            return;
        }
        if (!mode) {
            Player player = Factory.createPlayer();
            player.setNamep(name.getText());
            player.setSurnamep(surname.getText());
            player.setSurname2p(surname2.getText());
            player.setBirthday(dd.getSelectionModel().getSelectedItem(), mm.getSelectionModel().getSelectedItem(), yyyy.getSelectionModel().getSelectedItem());
            player.setPos(pos.getSelectionModel().getSelectedIndex() + 1);
            player.setImg(img);
            player.setDorsal(Integer.parseInt(dorsal.getText()));
            player.setIDp(helper.getInstance().getID());

            helper.getInstance().addPlayer(player);
        } else {
            pl.setNamep(name.getText());
            pl.setSurnamep(surname.getText());
            pl.setSurname2p(surname2.getText());
            pl.setBirthday(dd.getSelectionModel().getSelectedItem(), mm.getSelectionModel().getSelectedItem(), yyyy.getSelectionModel().getSelectedItem());
            pl.setPos(pos.getSelectionModel().getSelectedIndex() + 1);
            pl.setImg(img);
            pl.setDorsal(Integer.parseInt(dorsal.getText()));

            helper.getInstance().modPlayer(pl);

        }
        dcCon.refresh();

        Node a = (Node) cancel.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void onCancel(ActionEvent event) {
        Node a = (Node) cancel.getParent();
        a.getScene().getWindow().hide();
    }

    public void init(FXMLDocumentController dcCon) {
        this.dcCon = dcCon;
    }

    public void loadPlayer(Player p) {
        this.name.setText(p.getNamep());
        this.surname.setText(p.getSurnamep());
        this.surname2.setText(p.getSurname2p());
        this.pos.getSelectionModel().select(Integer.parseInt(Integer.toString(p.getPos()).substring(0, 1)) - 1);
        this.dorsal.setText(Integer.toString(p.getDorsal()));
        
        String[] aux = p.birthPProperty().get().split("/");

        this.dd.getSelectionModel().select(Integer.parseInt(aux[0]));
        this.mm.getSelectionModel().select(Integer.parseInt(aux[1]));
        this.yyyy.getSelectionModel().select(Integer.parseInt(aux[2]));
        this.pl = p;
        mode = true;
        //img left
        this.img = p.getImg();
        InputStream is = null;
        try {
            if(img.equals("nop"))is = this.getClass().getResourceAsStream("/resources/NoUserImage_Big.png");
            else is = new FileInputStream(img); // here I get FileNotFoundException
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image aux2 = new Image(is);
        photo.setImage(aux2);
    }

    @FXML
    private void onDorsal(KeyEvent event) {
        if (!"0123456789".contains(event.getCharacter())) {
            event.consume();
        }
    }

}
