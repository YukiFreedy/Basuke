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
import Persistencia.tonto;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class MatchDataController implements Initializable {

    @FXML
    private Label local;
    @FXML
    private Label visitante;
    @FXML
    private TextField dtot;
    @FXML
    private TextField drtot;
    @FXML
    private TextField dc1;
    @FXML
    private TextField dc2;
    @FXML
    private TextField dc3;
    @FXML
    private TextField dc4;
    @FXML
    private TextField dc1r;
    @FXML
    private TextField dc2r;
    @FXML
    private TextField dc3r;
    @FXML
    private TextField dc4r;
    @FXML
    private TextField dtc;
    @FXML
    private TextField dtl;
    @FXML
    private TextField dtr;
    @FXML
    private TextField dass;
    @FXML
    private TextField drec;
    @FXML
    private TextField dtap;
    @FXML
    private TextField drd;
    @FXML
    private TextField dro;
    @FXML
    private TextField dper;
    @FXML
    private TextField dtcf;
    @FXML
    private TextField dtlf;
    @FXML
    private TextField dtrf;
    @FXML
    private TextField dfal;
    @FXML
    private TextField dpp;
    @FXML
    private TextField dcfal;
    @FXML
    private TextField dtcr;
    @FXML
    private TextField dtlr;
    @FXML
    private TextField dtrr;
    @FXML
    private TextField t1;
    @FXML
    private TextField t1r;
    @FXML
    private TextField tc1;
    @FXML
    private TextField tl1;
    @FXML
    private TextField tr1;
    @FXML
    private TextField ass1;
    @FXML
    private TextField rec1;
    @FXML
    private TextField tap1;
    @FXML
    private TextField rd1;
    @FXML
    private TextField ro1;
    @FXML
    private TextField per1;
    @FXML
    private TextField tcf1;
    @FXML
    private TextField tlf1;
    @FXML
    private TextField trf1;
    @FXML
    private TextField fal1;
    @FXML
    private TextField pp1;
    @FXML
    private TextField fal1r;
    @FXML
    private TextField tc1r;
    @FXML
    private TextField tl1r;
    @FXML
    private TextField tr1r;
    @FXML
    private TextField t2;
    @FXML
    private TextField t2r;
    @FXML
    private TextField tc2;
    @FXML
    private TextField tl2;
    @FXML
    private TextField tr2;
    @FXML
    private TextField ass2;
    @FXML
    private TextField rec2;
    @FXML
    private TextField tap2;
    @FXML
    private TextField rd2;
    @FXML
    private TextField ro2;
    @FXML
    private TextField per2;
    @FXML
    private TextField tcf2;
    @FXML
    private TextField tlf2;
    @FXML
    private TextField trf2;
    @FXML
    private TextField fal2;
    @FXML
    private TextField pp2;
    @FXML
    private TextField fal2r;
    @FXML
    private TextField tc2r;
    @FXML
    private TextField tl2r;
    @FXML
    private TextField tr2r;
    @FXML
    private TextField t3;
    @FXML
    private TextField t3r;
    @FXML
    private TextField tc3;
    @FXML
    private TextField tl3;
    @FXML
    private TextField tr3;
    @FXML
    private TextField ass3;
    @FXML
    private TextField rec3;
    @FXML
    private TextField tap3;
    @FXML
    private TextField rd3;
    @FXML
    private TextField ro3;
    @FXML
    private TextField per3;
    @FXML
    private TextField tcf3;
    @FXML
    private TextField tlf3;
    @FXML
    private TextField trf3;
    @FXML
    private TextField fal3;
    @FXML
    private TextField pp3;
    @FXML
    private TextField fal3r;
    @FXML
    private TextField tc3r;
    @FXML
    private TextField tl3r;
    @FXML
    private TextField tr3r;
    @FXML
    private TextField t4;
    @FXML
    private TextField t4r;
    @FXML
    private TextField tc4;
    @FXML
    private TextField tl4;
    @FXML
    private TextField tr4;
    @FXML
    private TextField ass4;
    @FXML
    private TextField rec4;
    @FXML
    private TextField tap4;
    @FXML
    private TextField rd4;
    @FXML
    private TextField ro4;
    @FXML
    private TextField per4;
    @FXML
    private TextField tcf4;
    @FXML
    private TextField tlf4;
    @FXML
    private TextField trf4;
    @FXML
    private TextField fal4;
    @FXML
    private TextField pp4;
    @FXML
    private TextField fal4r;
    @FXML
    private TextField tc4r;
    @FXML
    private TextField tl4r;
    @FXML
    private TextField tr4r;

    private Match match;
    @FXML
    private TableView<Player> tableMatch;
    @FXML
    private TableColumn<Player, String> name1;
    @FXML
    private TableColumn<Player, Integer> tot;
    @FXML
    private TableColumn<Player, Integer> tl;
    @FXML
    private TableColumn<Player, Integer> tc;
    @FXML
    private TableColumn<Player, Integer> tr;
    @FXML
    private TableColumn<Player, Integer> ass;
    @FXML
    private TableColumn<Player, Integer> rec;
    @FXML
    private TableColumn<Player, Integer> tap;
    @FXML
    private TableColumn<Player, Integer> rd;
    @FXML
    private TableColumn<Player, Integer> ro;
    @FXML
    private TableColumn<Player, Integer> val;
    @FXML
    private TableView<Player> tableMatch1;
    @FXML
    private TableColumn<Player, String> name2;
    @FXML
    private TableColumn<Player, Integer> per;
    @FXML
    private TableColumn<Player, Integer> pf;
    @FXML
    private TableColumn<Player, Integer> tlf;
    @FXML
    private TableColumn<Player, Integer> tcf;
    @FXML
    private TableColumn<Player, Integer> trf;
    @FXML
    private TableColumn<Player, Integer> fal;
    @FXML
    private TableColumn<Player, String> tj;
    @FXML
    private TableColumn<Player, Integer> masmenos;

    private ObservableList<Player> ob1, ob2;
    private LineChart<String, Number> chart;
    @FXML
    private Button selectDatos;
    @FXML
    private RadioButton fiveMatches;
    @FXML
    private RadioButton mediumMatches;
    @FXML
    private RadioButton fullMatches;
    @FXML
    private RadioButton puntosTotales;
    @FXML
    private RadioButton tirosLibres;
    @FXML
    private RadioButton tirosCampo;
    @FXML
    private RadioButton triples;
    @FXML
    private RadioButton asistencias;
    @FXML
    private RadioButton recuperaciones;
    @FXML
    private RadioButton tapones;
    @FXML
    private RadioButton rebotesDefensivos;
    @FXML
    private RadioButton rebotesOfensivos;
    @FXML
    private RadioButton perdidas;
    @FXML
    private RadioButton puntosFallados;
    @FXML
    private RadioButton libresFallados;
    @FXML
    private RadioButton campoFallados;
    @FXML
    private RadioButton triplesFallados;
    @FXML
    private RadioButton faltas;

    private boolean gofre;
    @FXML
    private HBox hbox;
    @FXML
    private HBox boxChart;
    @FXML
    private TextField dtcr1;
    @FXML
    private TextField dtlr1;
    @FXML
    private TextField dtrr1;
    @FXML
    private TextField dc1r1;
    @FXML
    private TextField dc2r1;
    @FXML
    private TextField dc3r1;
    @FXML
    private TextField dc4r1;
    @FXML
    private TextField dc11;
    @FXML
    private TextField dc21;
    @FXML
    private TextField dc31;
    @FXML
    private TextField dc41;
    @FXML
    private TextField tc1r1;
    @FXML
    private TextField tl1r1;
    @FXML
    private TextField tr1r1;
    @FXML
    private TextField tc2r1;
    @FXML
    private TextField tl2r1;
    @FXML
    private TextField tr2r1;
    @FXML
    private TextField tc3r1;
    @FXML
    private TextField tl3r1;
    @FXML
    private TextField tr3r1;
    @FXML
    private TextField tc4r1;
    @FXML
    private TextField tl4r1;
    @FXML
    private TextField tr4r1;

    /**
     * Initializes the controller class.
     *
     * @param m
     */
    public void init(Match m, boolean inGame) {
        match = m;
        ass1.setText(Integer.toString(match.getAsm().get(0)));
        ass2.setText(Integer.toString(match.getAsm().get(1)));
        ass3.setText(Integer.toString(match.getAsm().get(2)));
        ass4.setText(Integer.toString(match.getAsm().get(3)));
        
        tc1r1.setText(Integer.toString(match.getTfcR().get(0)*2));
        tc2r1.setText(Integer.toString(match.getTfcR().get(1)*2));
        tc3r1.setText(Integer.toString(match.getTfcR().get(2)*2));
        tc4r1.setText(Integer.toString(match.getTfcR().get(3)*2));
        
        tl1r1.setText(Integer.toString(match.getTflR().get(0)));
        tl2r1.setText(Integer.toString(match.getTflR().get(1)));
        tl3r1.setText(Integer.toString(match.getTflR().get(2)));
        tl4r1.setText(Integer.toString(match.getTflR().get(3)));
        
        tr1r1.setText(Integer.toString(match.getTfrR().get(0)*3));
        tr2r1.setText(Integer.toString(match.getTfrR().get(1)*3));
        tr3r1.setText(Integer.toString(match.getTfrR().get(2)*3));
        tr4r1.setText(Integer.toString(match.getTfrR().get(3)*3));
        
        dc1r1.setText(Integer.toString(match.getFallidosRm().get(0)));
        dc2r1.setText(Integer.toString(match.getFallidosRm().get(1)));
        dc3r1.setText(Integer.toString(match.getFallidosRm().get(2)));
        dc4r1.setText(Integer.toString(match.getFallidosRm().get(3)));
        
        dtcr1.setText(Integer.toString(match.getTfcR().get(4)*2));
        dtlr1.setText(Integer.toString(match.getTflR().get(4)));
        dtrr1.setText(Integer.toString(match.getTfrR().get(4)*3));
        
        dc11.setText(Integer.toString(match.getFallm().get(0)));
        dc21.setText(Integer.toString(match.getFallm().get(1)));
        dc31.setText(Integer.toString(match.getFallm().get(2)));
        dc41.setText(Integer.toString(match.getFallm().get(3)));
        
        dtcf.setText(Integer.toString(match.getTf2m().get(4)));
        dtlf.setText(Integer.toString(match.getTf1m().get(4)));
        dtrf.setText(Integer.toString(match.getTf3m().get(4)));
        
        dass.setText(Integer.toString(match.getAsm().get(4)));
        dc1.setText(Integer.toString(match.getQ1()));
        dc1r.setText(Integer.toString(match.getQc1()));
        dc2.setText(Integer.toString(match.getQ2()));
        dc2r.setText(Integer.toString(match.getQc2()));
        dc3.setText(Integer.toString(match.getQ3()));
        dc3r.setText(Integer.toString(match.getQc3()));
        dc4.setText(Integer.toString(match.getQ4()));
        dc4r.setText(Integer.toString(match.getQc4()));
        dcfal.setText(Integer.toString(match.getFaltasRm().get(4)));
        dfal.setText(Integer.toString(match.getFlm().get(4)));
        dper.setText(Integer.toString(match.getPerm().get(4)));
        dpp.setText(Integer.toString(match.getFallm().get(4) + match.getQ1() + match.getQ2() + match.getQ3() + match.getQ4()));
        drd.setText(Integer.toString(match.getRebdm().get(4)));
        dro.setText(Integer.toString(match.getRebom().get(4)));
        drec.setText(Integer.toString(match.getRecm().get(4)));
        drtot.setText(Integer.toString(match.getResultC()));
        dtap.setText(Integer.toString(match.getTapm().get(4)));
        dtc.setText(Integer.toString(match.getTcm().get(4)*2));
        dtcf.setText(Integer.toString(match.getTf2m().get(4)*2));
        dtl.setText(Integer.toString(match.getTlm().get(4)));
        dtlf.setText(Integer.toString(match.getTf1m().get(4)));
        dtlr.setText(Integer.toString(match.getTlR().get(4)));
        dtot.setText(Integer.toString(match.getResultF()));
        dtcr.setText(Integer.toString(match.getTcR().get(4)));
        dtr.setText(Integer.toString(match.getTrm().get(4)*3));
        dtrf.setText(Integer.toString(match.getTf3m().get(4)*3));
        dtrr.setText(Integer.toString(match.getTrR().get(4)));
        fal1.setText(Integer.toString(match.getFlm().get(0)));
        fal1r.setText(Integer.toString(match.getFaltasRm().get(0)));
        fal2.setText(Integer.toString(match.getFlm().get(1)));
        fal2r.setText(Integer.toString(match.getFaltasRm().get(1)));
        fal3.setText(Integer.toString(match.getFlm().get(2)));
        fal3r.setText(Integer.toString(match.getFaltasRm().get(2)));
        fal4.setText(Integer.toString(match.getFlm().get(3)));
        fal4r.setText(Integer.toString(match.getFaltasRm().get(3)));
        if (match.isLocal()) {
            local.setText("Riba-Roja de Túria");
            visitante.setText(match.getRival());
        } else {
            local.setText(match.getRival());
            visitante.setText("Riba-Roja de Túria");
        }
        per1.setText(Integer.toString(match.getPerm().get(0)));
        per2.setText(Integer.toString(match.getPerm().get(1)));
        per3.setText(Integer.toString(match.getPerm().get(2)));
        per4.setText(Integer.toString(match.getPerm().get(3)));
        pp1.setText(Integer.toString(match.getFallm().get(0) + match.getQ1()));
        pp2.setText(Integer.toString(match.getFallm().get(1) + match.getQ2()));
        pp3.setText(Integer.toString(match.getFallm().get(2) + match.getQ3()));
        pp4.setText(Integer.toString(match.getFallm().get(0) + match.getQ4()));
        rd1.setText(Integer.toString(match.getRebdm().get(0)));
        rd2.setText(Integer.toString(match.getRebdm().get(1)));
        rd3.setText(Integer.toString(match.getRebdm().get(2)));
        rd4.setText(Integer.toString(match.getRebdm().get(3)));
        rec1.setText(Integer.toString(match.getRecm().get(0)));
        rec2.setText(Integer.toString(match.getRecm().get(1)));
        rec3.setText(Integer.toString(match.getRecm().get(2)));
        rec4.setText(Integer.toString(match.getRecm().get(3)));
        ro1.setText(Integer.toString(match.getRebom().get(0)));
        ro2.setText(Integer.toString(match.getRebom().get(1)));
        ro3.setText(Integer.toString(match.getRebom().get(2)));
        ro4.setText(Integer.toString(match.getRebom().get(3)));
        t1.setText(Integer.toString(match.getQ1()));
        t1r.setText(Integer.toString(match.getQc1()));
        t2.setText(Integer.toString(match.getQ2()));
        t2r.setText(Integer.toString(match.getQc2()));
        t3.setText(Integer.toString(match.getQ3()));
        t3r.setText(Integer.toString(match.getQc3()));
        t4.setText(Integer.toString(match.getQ4()));
        t4r.setText(Integer.toString(match.getQc4()));
        tap1.setText(Integer.toString(match.getTapm().get(0)));
        tap2.setText(Integer.toString(match.getTapm().get(1)));
        tap3.setText(Integer.toString(match.getTapm().get(2)));
        tap4.setText(Integer.toString(match.getTapm().get(3)));
        tc1.setText(Integer.toString(match.getTcm().get(0)*2));
        tc1r.setText(Integer.toString(match.getTcR().get(0)));
        tc2.setText(Integer.toString(match.getTcm().get(1)*2));
        tc2r.setText(Integer.toString(match.getTcR().get(1)));
        tc3.setText(Integer.toString(match.getTcm().get(2)*2));
        tc3r.setText(Integer.toString(match.getTcR().get(2)));
        tc4.setText(Integer.toString(match.getTcm().get(3)*2));
        tc4r.setText(Integer.toString(match.getTcR().get(3)));
        tcf1.setText(Integer.toString(match.getTf2m().get(0)*2));
        tcf2.setText(Integer.toString(match.getTf2m().get(1)*2));
        tcf3.setText(Integer.toString(match.getTf2m().get(2)*2));
        tcf4.setText(Integer.toString(match.getTf2m().get(3)*2));
        tl1.setText(Integer.toString(match.getTlm().get(0)));
        tl2.setText(Integer.toString(match.getTlm().get(1)));
        tl3.setText(Integer.toString(match.getTlm().get(2)));
        tl4.setText(Integer.toString(match.getTlm().get(3)));
        tl1r.setText(Integer.toString(match.getTlR().get(0)));
        tl2r.setText(Integer.toString(match.getTlR().get(1)));
        tl3r.setText(Integer.toString(match.getTlR().get(2)));
        tl4r.setText(Integer.toString(match.getTlR().get(3)));
        tr1.setText(Integer.toString(match.getTrm().get(0)*3));
        tr2.setText(Integer.toString(match.getTrm().get(1)*3));
        tr3.setText(Integer.toString(match.getTrm().get(2)*3));
        tr4.setText(Integer.toString(match.getTrm().get(3)*3));
        tr1r.setText(Integer.toString(match.getTrR().get(0)));
        tr2r.setText(Integer.toString(match.getTrR().get(1)));
        tr3r.setText(Integer.toString(match.getTrR().get(2)));
        tr4r.setText(Integer.toString(match.getTrR().get(3)));
        trf1.setText(Integer.toString(match.getTf3m().get(0)*3));
        trf2.setText(Integer.toString(match.getTf3m().get(1)*3));
        trf3.setText(Integer.toString(match.getTf3m().get(2)*3));
        trf4.setText(Integer.toString(match.getTf3m().get(3)*3));
        tlf1.setText(Integer.toString(match.getTf1m().get(0)));
        tlf2.setText(Integer.toString(match.getTf1m().get(1)));
        tlf3.setText(Integer.toString(match.getTf1m().get(2)));
        tlf4.setText(Integer.toString(match.getTf1m().get(3)));

        ArrayList<Player> pls = helper.getInstance().getPlayerList();

        for (int i = 0; i < pls.size(); i++) {
            /*if (!inGame) {
                pls.get(i).setmP(null);
            }*/
            pls.get(i).refreshActual(match.getIDm());
        }

        ArrayList<Player> pl = new ArrayList<>();
        for (int i = 0; i < pls.size(); i++) {
            for (int j = 0; j < pls.get(i).getmPListp().size(); j++) {
                if (pls.get(i).getmPListp().get(j).getIDmp() == match.getIDm() && !(pls.get(i).getmPListp().get(j).getTiemJugadomp() == 0)) {
                    pl.add(pls.get(i));
                }
            }
        }
        
        ob1 = FXCollections.observableArrayList(pl);
        ob2 = FXCollections.observableArrayList(pl);
        tableMatch.setItems(ob1);
        tableMatch1.setItems(ob2);
        name1.setCellValueFactory(new PropertyValueFactory<>("nameP"));
        name2.setCellValueFactory(new PropertyValueFactory<>("nameP"));
        tot.setCellValueFactory(new PropertyValueFactory<>("tot"));
        tl.setCellValueFactory(new PropertyValueFactory<>("tl"));
        tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
        tr.setCellValueFactory(new PropertyValueFactory<>("tr"));
        ass.setCellValueFactory(new PropertyValueFactory<>("ass"));
        rec.setCellValueFactory(new PropertyValueFactory<>("rec"));
        tap.setCellValueFactory(new PropertyValueFactory<>("tap"));
        rd.setCellValueFactory(new PropertyValueFactory<>("rd"));
        ro.setCellValueFactory(new PropertyValueFactory<>("ro"));
        val.setCellValueFactory(new PropertyValueFactory<>("val"));
        per.setCellValueFactory(new PropertyValueFactory<>("per"));
        pf.setCellValueFactory(new PropertyValueFactory<>("pf"));
        tlf.setCellValueFactory(new PropertyValueFactory<>("tlf"));
        tcf.setCellValueFactory(new PropertyValueFactory<>("tcf"));
        trf.setCellValueFactory(new PropertyValueFactory<>("trf"));
        fal.setCellValueFactory(new PropertyValueFactory<>("fal"));
        tj.setCellValueFactory(new PropertyValueFactory<>("minJuP"));
        masmenos.setCellValueFactory(new PropertyValueFactory<>("masmenos"));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gofre = false;
    }

    @FXML
    private void onSeeChart(ActionEvent event) {
        gofre = !gofre;

        if (gofre) {
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setGapStartAndEnd(true);
            xAxis.setLabel("Partido");
            NumberAxis yAxis = new NumberAxis();
            yAxis.setAutoRanging(true);
            chart = new LineChart<>(xAxis, yAxis);
            chart.setCreateSymbols(true);
            boxChart.getChildren().setAll(chart);
            chart.setPrefSize(1048, 328);
            hbox.setVisible(false);
            chart.setVisible(true);
            Task<tonto> task = new Task<tonto>() {
                @Override
                protected tonto call() throws Exception {
                    wrapper wrap = helper.getInstance();
                    tonto list = new tonto();
                    try {
                        ArrayList<XYChart.Series> ser = new ArrayList<>();
                        if (puntosTotales.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Puntos Totales");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (tirosLibres.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Tiros Libres");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (tirosCampo.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Tiros Campo");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (triples.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Triples");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (asistencias.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Asistencias");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (recuperaciones.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Recuperaciones");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (tapones.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Tapones");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (rebotesDefensivos.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Rebotes Defensivos");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (rebotesOfensivos.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Rebotes Ofensivos");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (perdidas.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Perdidas");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (puntosFallados.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Puntos Fallidos");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (libresFallados.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Libres Fallados");
                            list.getList().add(ser.get(ser.size() - 1));

                        }
                        if (campoFallados.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Campo Fallados");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (triplesFallados.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Triples Fallados");
                            list.getList().add(ser.get(ser.size() - 1));
                        }
                        if (faltas.isSelected()) {
                            ser.add(new XYChart.Series());
                            ser.get(ser.size() - 1).setName("Faltas");
                            list.getList().add(ser.get(ser.size() - 1));
                        }

                        int max = wrap.getMatchList().size();
                        if (max > 5) {
                            max = 5;
                        }
                        if (mediumMatches.isSelected()) {
                            max = (wrap.getMatchList().size() / 2 ) +1;
                        }
                        if (fullMatches.isSelected()) {
                            max = wrap.getMatchList().size();
                        }

                        int aux;
                        XYChart.Series<String, Integer> op;
                        for (int j = wrap.getMatchList().size() - max; j < wrap.getMatchList().size(); j++) {
                            aux = 0;
                            if (puntosTotales.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getResultF()));
                                aux++;
                            }
                            if (tirosLibres.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTlm().get(4)));
                                aux++;
                            }
                            if (tirosCampo.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTcm().get(4)*2));
                                aux++;
                            }
                            if (triples.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTrm().get(4)*3));
                                aux++;
                            }
                            if (asistencias.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getAsm().get(4)));
                                aux++;
                            }
                            if (recuperaciones.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getRecm().get(4)));
                                aux++;
                            }
                            if (tapones.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTapm().get(4)));
                                aux++;
                            }
                            if (rebotesDefensivos.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getRebdm().get(4)));
                                aux++;
                            }
                            if (rebotesOfensivos.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getRebom().get(4)));
                                aux++;
                            }
                            if (perdidas.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getPerm().get(4)));
                                aux++;
                            }
                            if (puntosFallados.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getFallm().get(4)));
                                aux++;
                            }
                            if (libresFallados.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTf1m().get(4)));
                                aux++;
                            }
                            if (campoFallados.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTf2m().get(4)));
                                aux++;
                            }
                            if (triplesFallados.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getTf3m().get(4)));
                                aux++;
                            }
                            if (faltas.isSelected()) {
                                op = (XYChart.Series) list.getList().get(aux);
                                op.getData().add(new XYChart.Data<>(wrap.getMatchList().get(j).getRival(), wrap.getMatchList().get(j).getFlm().get(4)));
                                aux++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return list;
                }
            };

            task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    try {
                        for (int i = 0; i < task.get().getList().size(); i++) {
                            chart.getData().add((XYChart.Series) task.get().getList().get(i));
                        }
                        selectDatos.setText("Seleccionar Datos");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread th = new Thread(task);
            th.setDaemon(true);
            th.run();
        } else {
            hbox.setVisible(true);
            chart.setVisible(false);
            selectDatos.setText("Mostrar Gráfico");
        }
    }

}
