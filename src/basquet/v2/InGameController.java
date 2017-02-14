/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class InGameController implements Initializable {

    @FXML
    private Label name1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label namePr;
    @FXML
    private TextField nameRival;
    @FXML
    private TextField puntRival;
    @FXML
    private TextField puntPr;
    @FXML
    private Button ac1;
    @FXML
    private TextField axxx;
    @FXML
    private TextField xaxx;
    @FXML
    private TextField xxax;
    @FXML
    private TextField xxxa;
    @FXML
    private TextField cuarto;
    @FXML
    private Button cuartoNext;
    @FXML
    private TextField faltasPr;
    @FXML
    private TextField faltasRival;
    @FXML
    private Button stopTimer;
    @FXML
    private Label n1;
    @FXML
    private CheckBox f11;
    @FXML
    private CheckBox f12;
    @FXML
    private CheckBox f13;
    @FXML
    private CheckBox f14;
    @FXML
    private CheckBox f15;
    @FXML
    private Label n2;
    @FXML
    private CheckBox f21;
    @FXML
    private CheckBox f22;
    @FXML
    private CheckBox f23;
    @FXML
    private CheckBox f24;
    @FXML
    private CheckBox f25;
    @FXML
    private Label n3;
    @FXML
    private CheckBox f31;
    @FXML
    private CheckBox f32;
    @FXML
    private CheckBox f33;
    @FXML
    private CheckBox f34;
    @FXML
    private CheckBox f35;
    @FXML
    private Label n4;
    @FXML
    private CheckBox f41;
    @FXML
    private CheckBox f42;
    @FXML
    private CheckBox f43;
    @FXML
    private CheckBox f44;
    @FXML
    private CheckBox f45;
    @FXML
    private Label n5;
    @FXML
    private CheckBox f51;
    @FXML
    private CheckBox f52;
    @FXML
    private CheckBox f53;
    @FXML
    private CheckBox f54;
    @FXML
    private CheckBox f55;
    @FXML
    private Button butData;
    @FXML
    private Button ac2;
    @FXML
    private Button ac3;
    @FXML
    private CheckBox restarRival;
    @FXML
    private Button fl1;
    @FXML
    private Button fl2;
    @FXML
    private Button fl3;
    @FXML
    private TextField anotados;
    @FXML
    private TextField posibles;
    @FXML
    private Button masFaltas;
    @FXML
    private Button menosFaltas;

    private ArrayList<Player> ar;
    @FXML
    private Button T1;
    @FXML
    private Button T2;
    @FXML
    private Button T3;
    @FXML
    private Button rec;
    @FXML
    private Button ass;
    @FXML
    private Button rdef;
    @FXML
    private Button rofe;
    @FXML
    private Button rap;
    @FXML
    private Button x3;
    @FXML
    private Button x2;
    @FXML
    private Button x1;
    @FXML
    private Button falta;
    @FXML
    private Button perdida;
    @FXML
    private Button cambio;

    private Match match;

    private ArrayList<Player> equ;

    private helper help;
    @FXML
    private RadioButton radioRestar;
    @FXML
    private Pane i1;
    @FXML
    private Pane i2;
    @FXML
    private Pane i3;
    @FXML
    private Pane i4;
    @FXML
    private Pane i5;

    private int selected;

    private int cuartCount;

    private int[] R1, R2, R3, F1, F2, F3; //contador del Rival, sirbe para saber cuantas canastas de cada han metido.

    private InGameController controller;

    private boolean[][] faltas;

    private CheckBox[][] fal;

    private Task<Integer> th;

    private boolean running, timer;

    private int tiempo;
    @FXML
    private Text tc1;
    @FXML
    private Text tc2;
    @FXML
    private Text tc3;
    @FXML
    private Text trec;
    @FXML
    private Text tass;
    @FXML
    private Text trd;
    @FXML
    private Text tro;
    @FXML
    private Text tta;
    @FXML
    private Text tx1;
    @FXML
    private Text tx2;
    @FXML
    private Text tx3;
    @FXML
    private Text tfalta;
    @FXML
    private Text tper;
    @FXML
    private Text warningTime;
    @FXML
    private Button cuartoBack;

    private FXMLDocumentController dcC;

    private Player pl, pl2;

    private Thread t;
    @FXML
    private ProgressBar progressBar;

    /**
     * Initializes the controller class.
     *
     * @param are
     * @param rivalName
     * @param lv
     */
    public void init(ArrayList<Player> are, String rivalName, int lv, InGameController con, FXMLDocumentController dcC) {
        match = new Match();
        match.setIDm(helper.getInstance().getIDMatch());
        this.dcC = dcC;
        nameRival.setText(rivalName);
        tiempo = 600;
        running = true;
        timer = false;
        cuartoBack.setDisable(true);

        fal = new CheckBox[5][5];
        fal[0][0] = f11;
        fal[1][0] = f21;
        fal[2][0] = f31;
        fal[3][0] = f41;
        fal[4][0] = f51;
        fal[0][1] = f12;
        fal[1][1] = f22;
        fal[2][1] = f32;
        fal[3][1] = f42;
        fal[4][1] = f52;
        fal[0][2] = f13;
        fal[1][2] = f23;
        fal[2][2] = f33;
        fal[3][2] = f43;
        fal[4][2] = f53;
        fal[0][3] = f14;
        fal[1][3] = f24;
        fal[2][3] = f34;
        fal[3][3] = f44;
        fal[4][3] = f54;
        fal[0][4] = f15;
        fal[1][4] = f25;
        fal[2][4] = f35;
        fal[3][4] = f45;
        fal[4][4] = f55;

        controller = con;
        R1 = new int[5];
        R2 = new int[5];
        R3 = new int[5];
        F1 = new int[5];
        F2 = new int[5];
        F3 = new int[5];

        selected = 1;
        cuartCount = 1;

        equ = helper.getInstance().getPlayerList();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        if(match.getDate() == null) this.match.setDate(dateFormat.format(date));
        this.match.setRival(rivalName);
        boolean aux;
        if (lv == 0) {
            aux = true;
        } else {
            aux = false;
        }
        this.match.setLocal(aux);
        for (int i = 0; i < equ.size(); i++) {
            equ.get(i).addmp(match.getIDm());
        }
        helper.getInstance().setPlayerList(equ);
        this.ar = are;

        name1.setText(ar.get(0).getDorsalp() + ". " + ar.get(0).getNamep() + " " + ar.get(0).getSurnamep().substring(0, 1) + ".");
        name2.setText(ar.get(1).getDorsalp() + ". " + ar.get(1).getNamep() + " " + ar.get(1).getSurnamep().substring(0, 1) + ".");
        name3.setText(ar.get(2).getDorsalp() + ". " + ar.get(2).getNamep() + " " + ar.get(2).getSurnamep().substring(0, 1) + ".");
        name4.setText(ar.get(3).getDorsalp() + ". " + ar.get(3).getNamep() + " " + ar.get(3).getSurnamep().substring(0, 1) + ".");
        name5.setText(ar.get(4).getDorsalp() + ". " + ar.get(4).getNamep() + " " + ar.get(4).getSurnamep().substring(0, 1) + ".");

        n1.setText(ar.get(0).getDorsalp() + ". " + ar.get(0).getNamep() + " " + ar.get(0).getSurnamep().substring(0, 1) + ".");
        n2.setText(ar.get(1).getDorsalp() + ". " + ar.get(1).getNamep() + " " + ar.get(1).getSurnamep().substring(0, 1) + ".");
        n3.setText(ar.get(2).getDorsalp() + ". " + ar.get(2).getNamep() + " " + ar.get(2).getSurnamep().substring(0, 1) + ".");
        n4.setText(ar.get(3).getDorsalp() + ". " + ar.get(3).getNamep() + " " + ar.get(3).getSurnamep().substring(0, 1) + ".");
        n5.setText(ar.get(4).getDorsalp() + ". " + ar.get(4).getNamep() + " " + ar.get(4).getSurnamep().substring(0, 1) + ".");

        ImageView[] list = new ImageView[5];
        list[0] = img1;
        list[1] = img2;
        list[2] = img3;
        list[3] = img4;
        list[4] = img5;

        String img;
        InputStream is = null;
        for (int i = 0; i < list.length; i++) {
            img = are.get(i).getImg();
            try {
                if (img.equals("nop")) {
                    is = this.getClass().getResourceAsStream("/resources/NoUserImage_Big.png");
                } else {
                    is = new FileInputStream(img); // here I get FileNotFoundException
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Image aux2 = new Image(is);
            list[i].setImage(aux2);
        }
        setPlayerList();
        refresh();
        refresh2();
        refresh3(0);
        refresh4();
    }

    public void init(ArrayList<Player> are, String rivalName, int lv, InGameController con, FXMLDocumentController dcC, Match match) {
        this.match = match;
        this.dcC = dcC;
        nameRival.setText(rivalName);
        tiempo = 600;
        running = true;
        timer = false;
        cuartoBack.setDisable(true);

        fal = new CheckBox[5][5];
        fal[0][0] = f11;
        fal[1][0] = f21;
        fal[2][0] = f31;
        fal[3][0] = f41;
        fal[4][0] = f51;
        fal[0][1] = f12;
        fal[1][1] = f22;
        fal[2][1] = f32;
        fal[3][1] = f42;
        fal[4][1] = f52;
        fal[0][2] = f13;
        fal[1][2] = f23;
        fal[2][2] = f33;
        fal[3][2] = f43;
        fal[4][2] = f53;
        fal[0][3] = f14;
        fal[1][3] = f24;
        fal[2][3] = f34;
        fal[3][3] = f44;
        fal[4][3] = f54;
        fal[0][4] = f15;
        fal[1][4] = f25;
        fal[2][4] = f35;
        fal[3][4] = f45;
        fal[4][4] = f55;

        controller = con;
        R1 = new int[5];
        R2 = new int[5];
        R3 = new int[5];
        F1 = new int[5];
        F2 = new int[5];
        F3 = new int[5];

        for (int i = 0; i < 5; i++) {
            R1[i] = match.getTlR().get(i);
            System.out.println(R1[i]);
            R2[i] = match.getTcR().get(i);
            R3[i] = match.getTrR().get(i);
            F1[i] = match.getTflR().get(i);
            F2[i] = match.getTfcR().get(i);
            F3[i] = match.getTfrR().get(i);
        }

        selected = 1;
        cuartCount = 1;
        help = new helper();

        equ = helper.getInstance().getPlayerList();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.match.setDate(dateFormat.format(date));
        this.match.setRival(rivalName);
        boolean aux;
        if (lv == 0) {
            aux = true;
        } else {
            aux = false;
        }
        this.match.setLocal(aux);

        ArrayList<Player> ls = new ArrayList<>();

        for (int i = 0; i < are.size(); i++) {
            for (int j = 0; j < match.getPlayerListm().size(); j++) {
                if (are.get(i).getIDp() == equ.get(j).getIDp()) {
                    ls.add(equ.get(j));
                    break;
                }
            }
        }

        this.ar = ls;
        /*for (int i = 0; i < ar.size(); i++) {
            ar.get(i).getmP().setIDmp(match.getIDm());
        }*/

        name1.setText(ar.get(0).getDorsalp() + ". " + ar.get(0).getNamep() + " " + ar.get(0).getSurnamep().substring(0, 1) + ".");
        name2.setText(ar.get(1).getDorsalp() + ". " + ar.get(1).getNamep() + " " + ar.get(1).getSurnamep().substring(0, 1) + ".");
        name3.setText(ar.get(2).getDorsalp() + ". " + ar.get(2).getNamep() + " " + ar.get(2).getSurnamep().substring(0, 1) + ".");
        name4.setText(ar.get(3).getDorsalp() + ". " + ar.get(3).getNamep() + " " + ar.get(3).getSurnamep().substring(0, 1) + ".");
        name5.setText(ar.get(4).getDorsalp() + ". " + ar.get(4).getNamep() + " " + ar.get(4).getSurnamep().substring(0, 1) + ".");

        n1.setText(ar.get(0).getDorsalp() + ". " + ar.get(0).getNamep() + " " + ar.get(0).getSurnamep().substring(0, 1) + ".");
        n2.setText(ar.get(1).getDorsalp() + ". " + ar.get(1).getNamep() + " " + ar.get(1).getSurnamep().substring(0, 1) + ".");
        n3.setText(ar.get(2).getDorsalp() + ". " + ar.get(2).getNamep() + " " + ar.get(2).getSurnamep().substring(0, 1) + ".");
        n4.setText(ar.get(3).getDorsalp() + ". " + ar.get(3).getNamep() + " " + ar.get(3).getSurnamep().substring(0, 1) + ".");
        n5.setText(ar.get(4).getDorsalp() + ". " + ar.get(4).getNamep() + " " + ar.get(4).getSurnamep().substring(0, 1) + ".");

        ImageView[] list = new ImageView[5];
        list[0] = img1;
        list[1] = img2;
        list[2] = img3;
        list[3] = img4;
        list[4] = img5;

        String img;
        InputStream is = null;
        for (int i = 0; i < list.length; i++) {
            img = are.get(i).getImg();
            try {
                if (img.equals("nop")) {
                    is = this.getClass().getResourceAsStream("/resources/NoUserImage_Big.png");
                } else {
                    is = new FileInputStream(img); // here I get FileNotFoundException
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Image aux2 = new Image(is);
            list[i].setImage(aux2);
        }
        setPlayerList();
        refresh();
        refresh2();
        refresh3(0);
        refresh4();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stopTimer.setText("Empezar Cuarto");
        cuartoNext.setDisable(true);

    }

    @FXML
    private void onC1R(ActionEvent event) {
        if (restarRival.isSelected()) {

            match.getTlR().set(cuartCount - 1, match.getTlR().get(cuartCount - 1) - 1);
            match.getTlR().set(4, match.getTlR().get(4) - 1);
            if (cuartCount == 1) {
                match.setQc1(match.getQc1() - 1);
            }
            if (cuartCount == 2) {
                match.setQc2(match.getQc2() - 1);
            }
            if (cuartCount == 3) {
                match.setQc3(match.getQc3() - 1);
            }
            if (cuartCount == 4) {
                match.setQc4(match.getQc4() - 1);
            }
            match.setResultC(match.getResultC() - 1);
            R1[cuartCount - 1] += -1;
            R1[4]--;
            masmenos(1);

        } else {

            match.getTlR().set(cuartCount - 1, match.getTlR().get(cuartCount - 1) + 1);
            match.getTlR().set(4, match.getTlR().get(4) + 1);

            if (cuartCount == 1) {
                match.setQc1(match.getQc1() + 1);
            }
            if (cuartCount == 2) {
                match.setQc2(match.getQc2() + 1);
            }
            if (cuartCount == 3) {
                match.setQc3(match.getQc3() + 1);
            }
            if (cuartCount == 4) {
                match.setQc4(match.getQc4() + 1);
            }
            match.setResultC(match.getResultC() + 1);
            R1[cuartCount - 1]++;
            R1[4]++;
            masmenos(-1);
        }
        refresh2();
    }

    @FXML
    private void onCuarto(ActionEvent event) {
        cuartoBack.setDisable(false);

        if (cuartCount == 4) {
            saveMatch(true);
            dcC.refresh();
            Node a = (Node) T1.getParent();
            a.getScene().getWindow().hide();
            return;
        }

        cuartCount++;
        if (cuartCount == 1) {
            cuarto.setText("Primero");
        }
        if (cuartCount == 2) {
            cuarto.setText("Segundo");
        }
        if (cuartCount == 3) {
            cuarto.setText("Tercero");
        }
        if (cuartCount == 4) {
            cuarto.setText("Cuarto");
        }
        tiempo = 600;
        refresh3(0);
        refresh2();
    }

    public void saveMatch(boolean fin) {

        /*for (int i = 0; i < 5; i++) {
            match.getTcR().set(i, R2[i]);
            match.getTrR().set(i, R3[i]);
            match.getTlR().set(i, R1[i]);
            match.getTflR().set(i, F1[i]);
            match.getTfcR().set(i, F2[i]);
            match.getTfrR().set(i, F3[i]);
        }*/
        match.setRival(nameRival.getText());
        setPlayerList();

        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i < ar.size(); i++) {
            aux.add(ar.get(i).getIDp());
        }

        match.setActivos(aux);

        if (fin) {
            for (int i = 0; i < equ.size(); i++) {
                equ.get(i).getmPListp().add(equ.get(i).getmP());
                equ.get(i).setmP(null);
            }
        }

        aux = new ArrayList<>();

        for (int i = 0; i < equ.size(); i++) {
            aux.add(equ.get(i).getIDp());
        }

        match.setPlayerListm(aux);
        helper.getInstance().setPlayerList(equ);
        match.setPlayerListm(aux);
        progressBar.setVisible(true);
        Task task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                helper.getInstance().setMatch(match);
                return "aa";
            }
        };
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                progressBar.setVisible(false);
            }
        });
        Thread thread = new Thread(task);
        progressBar.progressProperty().bind(task.progressProperty());
        thread.start();
        if (fin) {
            running = false;
            dcC.refresh();
        }

    }

    @FXML
    private void onStopTimer(ActionEvent event) {
        if (cuartCount == 0) {
            cuartCount++;
        }
        if (!timer) {
            try {
                timer = true;
                running = true;
                th = new Task<Integer>() {
                    @Override
                    protected synchronized Integer call() throws Exception {
                        while (running) {
                            th.wait(1000);
                            refresh3(1);
                        }
                        return null;
                    }
                };
                t = new Thread(th);
                //t.setDaemon(true);
                t.start();
            } catch (Exception e) {
                try {
                    PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                    pr.write(e.toString());
                    pr.close();
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
            try {
                stopTimer.setText("Detener Tiempo");
                cuartoNext.setDisable(timer);
                cuartoBack.setDisable(timer);
                warningTime.setVisible(false);
            } catch (Exception e) {
                try {
                    PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                    pr.write(e.toString());
                    pr.close();
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }

        } else {
            try {
                timer = false;
                running = false;
                cuartoNext.setDisable(false);
                cuartoBack.setDisable(false);
                stopTimer.setText("Reanudar");
                warningTime.setVisible(false);
            } catch (Exception e) {
                try {
                    PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                    pr.write(e.toString());
                    pr.close();
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        }

    }

    @FXML
    private void onMatchData(ActionEvent event) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("matchData.fxml"));
            Parent root = (Parent) myLoader.load();
            MatchDataController dcCon = myLoader.<MatchDataController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Datos del Partido");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            //setPlayerList();
            saveMatch(false);
            dcCon.init(match, true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPlayerList() {
        for (int i = 0; i < ar.size(); i++) {
            for (int j = 0; j < equ.size(); j++) {
                if (equ.get(j).getIDp() == ar.get(i).getIDp()) {
                    equ.set(j, ar.get(i));
                    break;
                }
            }
        }

        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i < equ.size(); i++) {
            aux.add(equ.get(i).getIDp());
        }

        match.setPlayerListm(aux);
    }

    @FXML
    private void onC2R(ActionEvent event) {
        if (restarRival.isSelected()) {

            match.getTcR().set(cuartCount - 1, match.getTcR().get(cuartCount - 1) - 2);
            match.getTcR().set(4, match.getTcR().get(4) - 2);

            if (cuartCount == 1) {
                match.setQc1(match.getQc1() - 2);
            }
            if (cuartCount == 2) {
                match.setQc2(match.getQc2() - 2);
            }
            if (cuartCount == 3) {
                match.setQc3(match.getQc3() - 2);
            }
            if (cuartCount == 4) {
                match.setQc4(match.getQc4() - 2);
            }
            match.setResultC(match.getResultC() - 2);
            R2[cuartCount - 1] += -1;
            R2[4] += -1;
            masmenos(2);
        } else {

            match.getTcR().set(cuartCount - 1, match.getTcR().get(cuartCount - 1) + 2);
            match.getTcR().set(4, match.getTcR().get(4) + 2);

            if (cuartCount == 1) {
                System.out.println(match.getQc1());
                match.setQc1(match.getQc1() + 2);
            }
            if (cuartCount == 2) {
                match.setQc2(match.getQc2() + 2);
            }
            if (cuartCount == 3) {
                match.setQc3(match.getQc3() + 2);
            }
            if (cuartCount == 4) {
                match.setQc4(match.getQc4() + 2);
            }
            match.setResultC(match.getResultC() + 2);
            R2[cuartCount - 1]++;
            R2[4] += 1;
            masmenos(-2);
        }
        refresh2();
    }

    @FXML
    private void onC3R(ActionEvent event) {
        if (restarRival.isSelected()) {

            match.getTrR().set(cuartCount - 1, match.getTrR().get(cuartCount - 1) - 3);
            match.getTrR().set(4, match.getTrR().get(4) - 3);

            if (cuartCount == 1) {
                match.setQc1(match.getQc1() - 3);
            }
            if (cuartCount == 2) {
                match.setQc2(match.getQc2() - 3);
            }
            if (cuartCount == 3) {
                match.setQc3(match.getQc3() - 3);
            }
            if (cuartCount == 4) {
                match.setQc4(match.getQc4() - 3);
            }
            match.setResultC(match.getResultC() - 3);
            R3[cuartCount - 1] += -1;
            R3[4] += -1;
            masmenos(3);

        } else {

            match.getTrR().set(cuartCount - 1, match.getTrR().get(cuartCount - 1) + 3);
            match.getTrR().set(4, match.getTrR().get(4) + 3);

            if (cuartCount == 1) {
                match.setQc1(match.getQc1() + 3);
            }
            if (cuartCount == 2) {
                match.setQc2(match.getQc2() + 3);
            }
            if (cuartCount == 3) {
                match.setQc3(match.getQc3() + 3);
            }
            if (cuartCount == 4) {
                match.setQc4(match.getQc4() + 3);
            }
            match.setResultC(match.getResultC() + 3);
            R3[cuartCount - 1]++;
            R3[4] += 1;
            masmenos(-3);
        }
        refresh2();
    }

    @FXML
    private void onFC1R(ActionEvent event) {
        if (restarRival.isSelected()) {
            match.getFallidosRm().set(cuartCount - 1, match.getFallidosRm().get(cuartCount - 1) - 1);
            match.getFallidosRm().set(4, match.getFallidosRm().get(4) - 1);
            F1[cuartCount - 1]--;
            match.getTflR().set(cuartCount - 1, match.getTflR().get(cuartCount - 1) - 1);
            match.getTflR().set(4, match.getTflR().get(4) - 1);
            refresh2();
        } else {
            match.getFallidosRm().set(cuartCount - 1, match.getFallidosRm().get(cuartCount - 1) + 1);
            match.getFallidosRm().set(4, match.getFallidosRm().get(4) + 1);
            F1[cuartCount - 1]++;
            match.getTflR().set(cuartCount - 1, match.getTflR().get(cuartCount - 1) + 1);
            match.getTflR().set(4, match.getTflR().get(4) + 1);
            refresh2();
        }
    }

    @FXML
    private void onFC2R(ActionEvent event) {
        if (restarRival.isSelected()) {
            match.getFallidosRm().set(cuartCount - 1, match.getFallidosRm().get(cuartCount - 1) - 2);
            match.getFallidosRm().set(4, match.getFallidosRm().get(4) - 2);
            F2[cuartCount - 1]--;
            match.getTfcR().set(cuartCount - 1, match.getTfcR().get(cuartCount - 1) - 1);
            match.getTfcR().set(4, match.getTfcR().get(4) - 1);
            refresh2();

        } else {
            match.getFallidosRm().set(cuartCount - 1, match.getFallidosRm().get(cuartCount - 1) + 2);
            match.getFallidosRm().set(4, match.getFallidosRm().get(4) + 2);
            F2[cuartCount - 1]++;
            match.getTfcR().set(cuartCount - 1, match.getTfcR().get(cuartCount - 1) + 1);
            match.getTfcR().set(4, match.getTfcR().get(4) + 1);
            refresh2();
        }
    }

    @FXML
    private void onFC3R(ActionEvent event) {
        if (restarRival.isSelected()) {
            match.getFallidosRm().set(cuartCount - 1, match.getFallidosRm().get(cuartCount - 1) - 3);
            match.getFallidosRm().set(4, match.getFallidosRm().get(4) - 3);
            F3[cuartCount - 1]--;
            match.getTfrR().set(cuartCount - 1, match.getTfrR().get(cuartCount - 1) - 1);
            match.getTfrR().set(4, match.getTfrR().get(4) - 1);
            refresh2();

        } else {
            match.getFallidosRm().set(cuartCount - 1, match.getFallidosRm().get(cuartCount - 1) + 3);
            match.getFallidosRm().set(4, match.getFallidosRm().get(4) + 3);
            F3[cuartCount - 1]++;
            match.getTfrR().set(cuartCount - 1, match.getTfrR().get(cuartCount - 1) + 1);
            match.getTfrR().set(4, match.getTfrR().get(4) + 1);
            refresh2();
        }
    }

    @FXML
    private void onFaltaR(ActionEvent event) {
        match.getFaltasRm().set(cuartCount - 1, match.getFaltasRm().get(cuartCount - 1) + 1);
        match.getFaltasRm().set(4, match.getFaltasRm().get(4) + 1);
        refresh2();
    }

    @FXML
    private void onFaltaRM(ActionEvent event) {
        if (match.getFaltasRm().get(cuartCount - 1) == 0) {
            return;
        }
        match.getFaltasRm().set(cuartCount - 1, match.getFaltasRm().get(cuartCount - 1) - 1);
        match.getFaltasRm().set(4, match.getFaltasRm().get(4) - 1);
        refresh2();
    }

    @FXML
    private void onC1(ActionEvent event) {

        if (radioRestar.isSelected()) {

            Player pl = ar.get(selected - 1);

            pl.getmP().getTlmp().set(cuartCount - 1, pl.getmP().getTlmp().get(cuartCount - 1) - 1);
            pl.getmP().getTlmp().set(4, pl.getmP().getTlmp().get(4) - 1);
            pl.getmP().getTotmp().set(cuartCount - 1, pl.getmP().getTotmp().get(cuartCount - 1) - 1);
            pl.getmP().getTotmp().set(4, pl.getmP().getTotmp().get(4) - 1);
            minus(1);
            match.getTlm().set(cuartCount - 1, match.getTcm().get(cuartCount - 1) - 1);
            match.getTlm().set(4, match.getTcm().get(4) - 1);
            masmenos(-1);
        } else {
            Player pl = ar.get(selected - 1);
            Player pl2 = null;
            for (int i = 0; i < equ.size(); i++) {
                if (equ.get(i).getIDp() == pl.getIDp()) {
                    pl2 = equ.get(i);
                    break;
                }
            }
            pl.getmP().getTlmp().set(cuartCount - 1, pl.getmP().getTlmp().get(cuartCount - 1) + 1);
            pl.getmP().getTlmp().set(4, pl.getmP().getTlmp().get(4) + 1);
            pl.getmP().getTotmp().set(cuartCount - 1, pl.getmP().getTotmp().get(cuartCount - 1) + 1);
            pl.getmP().getTotmp().set(4, pl.getmP().getTotmp().get(4) + 1);
            plus(1);
            match.getTlm().set(cuartCount - 1, match.getTcm().get(cuartCount - 1) + 1);
            match.getTlm().set(4, match.getTcm().get(4) + 1);
            masmenos(1);
        }
        refresh2();
    }

    @FXML
    private void onC2(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {

            pl.getmP().getTcmp().set(cuartCount - 1, pl.getmP().getTcmp().get(cuartCount - 1) - 2);
            pl.getmP().getTcmp().set(4, pl.getmP().getTcmp().get(4) - 2);
            pl.getmP().getT2mp().get(cuartCount - 1).remove(pl.getmP().getT2mp().get(cuartCount - 1).size() - 1);
            pl.getmP().getTotmp().set(cuartCount - 1, pl.getmP().getTotmp().get(cuartCount - 1) - 2);
            pl.getmP().getTotmp().set(4, pl.getmP().getTotmp().get(4) - 2);
            minus(2);
            match.getTcm().set(cuartCount - 1, match.getTcm().get(cuartCount - 1) - 1);
            match.getTcm().set(4, match.getTcm().get(4) - 1);
            masmenos(-2);
        } else {
            try {
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Court.fxml"));
                Parent root = (Parent) myLoader.load();
                CourtController dcCon = myLoader.<CourtController>getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Media Cancha");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                dcCon.init(ar.get(selected - 1).getmP(), false, cuartCount);
                stage.setOnCloseRequest((WindowEvent event1) -> {
                    pl.getmP().getT2mp().get(cuartCount - 1).add(0);
                });
                stage.show();
            } catch (Exception e) {
                System.out.println("Holi, tengo un problema");
                e.printStackTrace();
            }

            pl.getmP().getTcmp().set(cuartCount - 1, pl.getmP().getTcmp().get(cuartCount - 1) + 2);
            pl.getmP().getTcmp().set(4, pl.getmP().getTcmp().get(4) + 2);
            pl.getmP().getTotmp().set(cuartCount - 1, pl.getmP().getTotmp().get(cuartCount - 1) + 2);
            pl.getmP().getTotmp().set(4, pl.getmP().getTotmp().get(4) + 2);
            plus(2);
            match.getTcm().set(cuartCount - 1, match.getTcm().get(cuartCount - 1) + 1);
            match.getTcm().set(4, match.getTcm().get(4) + 1);
            masmenos(2);
        }
        refresh2();
    }

    @FXML
    private void onC3(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {

            pl.getmP().getTrmp().set(cuartCount - 1, pl.getmP().getTrmp().get(cuartCount - 1) - 3);
            pl.getmP().getTrmp().set(4, pl.getmP().getTrmp().get(4) - 3);
            pl.getmP().getT3mp().get(cuartCount - 1).remove(pl.getmP().getT3mp().get(cuartCount - 1).size() - 1);
            pl.getmP().getTotmp().set(cuartCount - 1, pl.getmP().getTotmp().get(cuartCount - 1) - 3);
            pl.getmP().getTotmp().set(4, pl.getmP().getTotmp().get(4) - 3);
            minus(3);
            match.getTrm().set(cuartCount - 1, match.getTcm().get(cuartCount - 1) - 1);
            match.getTrm().set(4, match.getTcm().get(4) - 1);
            masmenos(-3);
        } else {
            try {
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("CourtTri.fxml"));
                Parent root = (Parent) myLoader.load();
                CourtTriController dcCon = myLoader.<CourtTriController>getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Media Cancha");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                dcCon.init(ar.get(selected - 1).getmP(), false, cuartCount);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        pl.getmP().getT3mp().get(cuartCount - 1).add(0);
                    }
                });
                stage.show();
            } catch (Exception e) {

            }

            pl.getmP().getTrmp().set(cuartCount - 1, pl.getmP().getTrmp().get(cuartCount - 1) + 3);
            pl.getmP().getTrmp().set(4, pl.getmP().getTrmp().get(4) + 3);
            pl.getmP().getTotmp().set(cuartCount - 1, pl.getmP().getTotmp().get(cuartCount - 1) + 3);
            pl.getmP().getTotmp().set(4, pl.getmP().getTotmp().get(4) + 3);
            plus(3);
            match.getTrm().set(cuartCount - 1, match.getTrm().get(cuartCount - 1) + 1);
            match.getTrm().set(4, match.getTrm().get(4) + 1);
            masmenos(3);
        }
        refresh2();

    }

    @FXML
    private void onRecu(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {

            pl.getmP().getRecmp().set(cuartCount - 1, pl.getmP().getRecmp().get(cuartCount - 1) - 1);
            pl.getmP().getRecmp().set(4, pl.getmP().getRecmp().get(4) - 1);
            match.getRecm().set(cuartCount - 1, match.getRecm().get(cuartCount - 1) - 1);
            match.getRecm().set(4, match.getRecm().get(4) - 1);
        } else {

            pl.getmP().getRecmp().set(cuartCount - 1, pl.getmP().getRecmp().get(cuartCount - 1) + 1);
            pl.getmP().getRecmp().set(4, pl.getmP().getRecmp().get(4) + 1);
            match.getRecm().set(cuartCount - 1, match.getRecm().get(cuartCount - 1) + 1);
            match.getRecm().set(4, match.getRecm().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onAss(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {

            pl.getmP().getAsmp().set(cuartCount - 1, pl.getmP().getAsmp().get(cuartCount - 1) - 1);
            pl.getmP().getAsmp().set(4, pl.getmP().getAsmp().get(4) - 1);
            match.getAsm().set(cuartCount - 1, match.getAsm().get(cuartCount - 1) - 1);
            match.getAsm().set(4, match.getAsm().get(4) - 1);
            refresh2();
        } else {

            pl.getmP().getAsmp().set(cuartCount - 1, pl.getmP().getAsmp().get(cuartCount - 1) + 1);
            pl.getmP().getAsmp().set(4, pl.getmP().getAsmp().get(4) + 1);
            match.getAsm().set(cuartCount - 1, match.getAsm().get(cuartCount - 1) + 1);
            match.getAsm().set(4, match.getAsm().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onRD(ActionEvent event) {
        if (radioRestar.isSelected()) {
            Player pl = ar.get(selected - 1);

            pl.getmP().getRebdmp().set(cuartCount - 1, pl.getmP().getRebdmp().get(cuartCount - 1) - 1);
            pl.getmP().getRebdmp().set(4, pl.getmP().getRebdmp().get(4) - 1);
            match.getRebdm().set(cuartCount - 1, match.getRebdm().get(cuartCount - 1) - 1);
            match.getRebdm().set(4, match.getRebdm().get(4) - 1);
        } else {
            Player pl = ar.get(selected - 1);

            pl.getmP().getRebdmp().set(cuartCount - 1, pl.getmP().getRebdmp().get(cuartCount - 1) + 1);
            pl.getmP().getRebdmp().set(4, pl.getmP().getRebdmp().get(4) + 1);
            match.getRebdm().set(cuartCount - 1, match.getRebdm().get(cuartCount - 1) + 1);
            match.getRebdm().set(4, match.getRebdm().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onRO(ActionEvent event) {
        if (radioRestar.isSelected()) {
            Player pl = ar.get(selected - 1);

            pl.getmP().getRebomp().set(cuartCount - 1, pl.getmP().getRebomp().get(cuartCount - 1) - 1);
            pl.getmP().getRebomp().set(4, pl.getmP().getRebomp().get(4) - 1);
            match.getRebom().set(cuartCount - 1, match.getRebom().get(cuartCount - 1) - 1);
            match.getRebom().set(4, match.getRebom().get(4) - 1);
            refresh2();
        } else {
            Player pl = ar.get(selected - 1);

            pl.getmP().getRebomp().set(cuartCount - 1, pl.getmP().getRebomp().get(cuartCount - 1) + 1);
            pl.getmP().getRebomp().set(4, pl.getmP().getRebomp().get(4) + 1);
            match.getRebom().set(cuartCount - 1, match.getRebom().get(cuartCount - 1) + 1);
            match.getRebom().set(4, match.getRebom().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onTap(ActionEvent event) {
        if (radioRestar.isSelected()) {
            Player pl = ar.get(selected - 1);

            pl.getmP().getTapmp().set(cuartCount - 1, pl.getmP().getTapmp().get(cuartCount - 1) - 1);
            pl.getmP().getTapmp().set(4, pl.getmP().getTapmp().get(4) - 1);
            match.getTapm().set(cuartCount - 1, match.getTapm().get(cuartCount - 1) - 1);
            match.getTapm().set(4, match.getTapm().get(4) - 1);
            refresh2();
        } else {
            Player pl = ar.get(selected - 1);

            pl.getmP().getTapmp().set(cuartCount - 1, pl.getmP().getTapmp().get(cuartCount - 1) + 1);
            pl.getmP().getTapmp().set(4, pl.getmP().getTapmp().get(4) + 1);
            match.getTapm().set(cuartCount - 1, match.getTapm().get(cuartCount - 1) + 1);
            match.getTapm().set(4, match.getTapm().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onFC1(ActionEvent event) {
        if (radioRestar.isSelected()) {
            Player pl = ar.get(selected - 1);

            pl.getmP().getTf1mp().set(cuartCount - 1, pl.getmP().getTf1mp().get(cuartCount - 1) - 1);
            pl.getmP().getTf1mp().set(4, pl.getmP().getTf1mp().get(4) - 1);
            match.getTf1m().set(cuartCount - 1, match.getTf1m().get(cuartCount - 1) - 1);
            match.getTf1m().set(4, match.getTf1m().get(4) - 1);
            match.getFallm().set(cuartCount - 1, match.getFallm().get(cuartCount - 1) - 1);
            match.getFallm().set(4, match.getFallm().get(4) - 1);
        } else {
            Player pl = ar.get(selected - 1);

            pl.getmP().getTf1mp().set(cuartCount - 1, pl.getmP().getTf1mp().get(cuartCount - 1) + 1);
            pl.getmP().getTf1mp().set(4, pl.getmP().getTf1mp().get(4) + 1);
            match.getTf1m().set(cuartCount - 1, match.getTf1m().get(cuartCount - 1) + 1);
            match.getTf1m().set(4, match.getTf1m().get(4) + 1);
            match.getFallm().set(cuartCount - 1, match.getFallm().get(cuartCount - 1) + 1);
            match.getFallm().set(4, match.getFallm().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onFC2(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {

            pl.getmP().getTf2mp().set(cuartCount - 1, pl.getmP().getTf2mp().get(cuartCount - 1) - 1);
            pl.getmP().getTf2mp().set(4, pl.getmP().getTf2mp().get(4) - 1);
            pl.getmP().getT2fmp().get(cuartCount - 1).remove(pl.getmP().getT2fmp().get(cuartCount - 1).size() - 1);
            match.getTf2m().set(cuartCount - 1, match.getTf2m().get(cuartCount - 1) - 1);
            match.getTf2m().set(4, match.getTf2m().get(4) - 1);
            match.getFallm().set(cuartCount - 1, match.getFallm().get(cuartCount - 1) - 2);
            match.getFallm().set(4, match.getFallm().get(4) - 2);
        } else {
            try {
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Court.fxml"));
                Parent root = (Parent) myLoader.load();
                CourtController dcCon = myLoader.<CourtController>getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Canasta Fallida");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                dcCon.init(ar.get(selected - 1).getmP(), true, cuartCount);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        pl.getmP().getT2fmp().get(cuartCount - 1).add(0);
                    }
                });
                stage.show();
            } catch (Exception e) {

            }

            pl.getmP().getTf2mp().set(cuartCount - 1, pl.getmP().getTf2mp().get(cuartCount - 1) + 1);
            pl.getmP().getTf2mp().set(4, pl.getmP().getTf2mp().get(4) + 1);
            match.getTf2m().set(cuartCount - 1, match.getTf2m().get(cuartCount - 1) + 1);
            match.getTf2m().set(4, match.getTf2m().get(4) + 1);
            match.getFallm().set(cuartCount - 1, match.getFallm().get(cuartCount - 1) + 2);
            match.getFallm().set(4, match.getFallm().get(4) + 2);
        }
        refresh2();
    }

    @FXML
    private void onFC3(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {

            pl.getmP().getTf3mp().set(cuartCount - 1, pl.getmP().getTf3mp().get(cuartCount - 1) - 1);
            pl.getmP().getTf3mp().set(4, pl.getmP().getTf3mp().get(4) - 1);
            pl.getmP().getT3fmp().get(cuartCount - 1).remove(pl.getmP().getT3fmp().get(cuartCount - 1).size() - 1);
            match.getTf3m().set(cuartCount - 1, match.getTf3m().get(cuartCount - 1) - 1);
            match.getTf3m().set(4, match.getTf3m().get(4) - 1);
            match.getFallm().set(cuartCount - 1, match.getFallm().get(cuartCount - 1) - 3);
            match.getFallm().set(4, match.getFallm().get(4) - 3);

        } else {
            try {
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("CourtTri.fxml"));
                Parent root = (Parent) myLoader.load();
                CourtTriController dcCon = myLoader.<CourtTriController>getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Triple Fallido");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                dcCon.init(ar.get(selected - 1).getmP(), true, cuartCount);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        pl.getmP().getT3fmp().get(cuartCount - 1).add(0);
                    }
                });
                stage.show();
            } catch (Exception e) {

            }

            pl.getmP().getTf3mp().set(cuartCount - 1, pl.getmP().getTf3mp().get(cuartCount - 1) + 1);
            pl.getmP().getTf3mp().set(4, pl.getmP().getTf3mp().get(4) + 1);
            match.getTf3m().set(cuartCount - 1, match.getTf3m().get(cuartCount - 1) + 1);
            match.getTf3m().set(4, match.getTf3m().get(4) + 1);
            match.getFallm().set(cuartCount - 1, match.getFallm().get(cuartCount - 1) + 3);
            match.getFallm().set(4, match.getFallm().get(4) + 3);
        }
        refresh2();
    }

    @FXML
    private void onRestar(ActionEvent event) {
        refresh2();
    }

    @FXML
    private void onFault(ActionEvent event) {
        if (radioRestar.isSelected()) {
            Player pl = ar.get(selected - 1);
            pl.getmP().getFlmp().set(cuartCount - 1, pl.getmP().getFlmp().get(cuartCount - 1) - 1);
            pl.getmP().getFlmp().set(4, pl.getmP().getFlmp().get(4) - 1);
            match.getFlm().set(cuartCount - 1, match.getFlm().get(cuartCount - 1) - 1);
            match.getFlm().set(4, match.getFlm().get(4) - 1);
            refresh2();
        } else {
            Player pl = ar.get(selected - 1);
            pl.getmP().getFlmp().set(cuartCount - 1, pl.getmP().getFlmp().get(cuartCount - 1) + 1);
            pl.getmP().getFlmp().set(4, pl.getmP().getFlmp().get(4) + 1);
            match.getFlm().set(cuartCount - 1, match.getFlm().get(cuartCount - 1) + 1);
            match.getFlm().set(4, match.getFlm().get(4) + 1);
        }
        refresh2();
        refresh4();
    }

    @FXML
    private void onPerdida(ActionEvent event) {
        pl = ar.get(selected - 1);

        if (radioRestar.isSelected()) {
            pl.getmP().getPermp().set(cuartCount - 1, pl.getmP().getPermp().get(cuartCount - 1) - 1);
            pl.getmP().getPermp().set(4, pl.getmP().getPermp().get(4) - 1);
            match.getPerm().set(cuartCount - 1, match.getPerm().get(cuartCount - 1) - 1);
            match.getPerm().set(4, match.getPerm().get(4) - 1);
        } else {
            try {
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("courtPer.fxml"));
                Parent root = (Parent) myLoader.load();
                CourtPerController dcCon = myLoader.<CourtPerController>getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Cambio");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                dcCon.init(ar.get(selected - 1).getmP(), cuartCount);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        pl.getmP().getPerAmp().get(cuartCount - 1).add(0);
                    }
                });
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Hola soy un problema de ventana");
            }

            pl.getmP().getPermp().set(cuartCount - 1, pl.getmP().getPermp().get(cuartCount - 1) + 1);
            pl.getmP().getPermp().set(4, pl.getmP().getPermp().get(4) + 1);
            match.getPerm().set(cuartCount - 1, match.getPerm().get(cuartCount - 1) + 1);
            match.getPerm().set(4, match.getPerm().get(4) + 1);
        }
        refresh2();
    }

    @FXML
    private void onSwitch(ActionEvent event) {
        setPlayerList();
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Switch.fxml"));
            Parent root = (Parent) myLoader.load();
            SwitchController dcCon = myLoader.<SwitchController>getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Cambio");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            dcCon.init(ar, controller);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void onImg1(MouseEvent event) {
        i1.setVisible(true);
        i2.setVisible(false);
        i3.setVisible(false);
        i4.setVisible(false);
        i5.setVisible(false);
        selected = 1;
        refresh2();
    }

    @FXML
    private void onImg2(MouseEvent event) {
        i1.setVisible(false);
        i2.setVisible(true);
        i3.setVisible(false);
        i4.setVisible(false);
        i5.setVisible(false);
        selected = 2;
        refresh2();
    }

    @FXML
    private void onImg3(MouseEvent event) {
        i1.setVisible(false);
        i2.setVisible(false);
        i3.setVisible(true);
        i4.setVisible(false);
        i5.setVisible(false);
        selected = 3;
        refresh2();
    }

    @FXML
    private void onImg4(MouseEvent event) {
        i1.setVisible(false);
        i2.setVisible(false);
        i3.setVisible(false);
        i4.setVisible(true);
        i5.setVisible(false);
        selected = 4;
        refresh2();
    }

    @FXML
    private void onImg5(MouseEvent event) {
        i1.setVisible(false);
        i2.setVisible(false);
        i3.setVisible(false);
        i4.setVisible(false);
        i5.setVisible(true);
        selected = 5;
        refresh2();
    }

    private void plus(int i) {
        if (cuartCount == 1) {
            match.setQ1(match.getQ1() + i);
        }
        if (cuartCount == 2) {
            match.setQ2(match.getQ2() + i);
        }
        if (cuartCount == 3) {
            match.setQ3(match.getQ3() + i);
        }
        if (cuartCount == 4) {
            match.setQ4(match.getQ4() + i);
        }
        match.setResultF(match.getResultF() + i);
        refresh2();
    }

    private void minus(int i) {
        if (cuartCount == 1) {
            match.setQ1(match.getQ1() - i);
        }
        if (cuartCount == 2) {
            match.setQ2(match.getQ2() - i);
        }
        if (cuartCount == 3) {
            match.setQ3(match.getQ3() - i);
        }
        if (cuartCount == 4) {
            match.setQ4(match.getQ4() - i);
        }
        match.setResultF(match.getResultF() - i);
        refresh2();
    }

    public void setSwitches(ObservableList<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            ar.set(i, list.get(i));
        }
        refresh();
        refresh2();
    }

    private void refresh() {

        try {
            name1.setText(ar.get(0).getDorsalp() + ". " + ar.get(0).getNamep() + " " + ar.get(0).getSurnamep().substring(0, 1) + ".");
            name2.setText(ar.get(1).getDorsalp() + ". " + ar.get(1).getNamep() + " " + ar.get(1).getSurnamep().substring(0, 1) + ".");
            name3.setText(ar.get(2).getDorsalp() + ". " + ar.get(2).getNamep() + " " + ar.get(2).getSurnamep().substring(0, 1) + ".");
            name4.setText(ar.get(3).getDorsalp() + ". " + ar.get(3).getNamep() + " " + ar.get(3).getSurnamep().substring(0, 1) + ".");
            name5.setText(ar.get(4).getDorsalp() + ". " + ar.get(4).getNamep() + " " + ar.get(4).getSurnamep().substring(0, 1) + ".");

            n1.setText(ar.get(0).getDorsalp() + ". " + ar.get(0).getNamep() + " " + ar.get(0).getSurnamep().substring(0, 1) + ".");
            n2.setText(ar.get(1).getDorsalp() + ". " + ar.get(1).getNamep() + " " + ar.get(1).getSurnamep().substring(0, 1) + ".");
            n3.setText(ar.get(2).getDorsalp() + ". " + ar.get(2).getNamep() + " " + ar.get(2).getSurnamep().substring(0, 1) + ".");
            n4.setText(ar.get(3).getDorsalp() + ". " + ar.get(3).getNamep() + " " + ar.get(3).getSurnamep().substring(0, 1) + ".");
            n5.setText(ar.get(4).getDorsalp() + ". " + ar.get(4).getNamep() + " " + ar.get(4).getSurnamep().substring(0, 1) + ".");

            ImageView[] list = new ImageView[5];
            list[0] = img1;
            list[1] = img2;
            list[2] = img3;
            list[3] = img4;
            list[4] = img5;

            String img;
            InputStream is = null;
            for (int i = 0; i < list.length; i++) {
                img = ar.get(i).getImg();
                try {
                    if (img.equals("nop")) {
                        is = this.getClass().getResourceAsStream("/resources/NoUserImage_Big.png");
                    } else {
                        is = new FileInputStream(img); // here I get FileNotFoundException
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Image aux2 = new Image(is);
                list[i].setImage(aux2);
            }
        } catch (Exception e) {
            try {
                PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                pr.write(e.toString());
                pr.close();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }

    }

    private void refresh2() {
        try {
            puntPr.setText(Integer.toString(match.getResultF()));
            puntRival.setText(Integer.toString(match.getResultC()));
            faltasPr.setText("Faltas: " + Integer.toString(match.getFlm().get(cuartCount - 1)));
            faltasRival.setText("Faltas: " + Integer.toString(match.getFaltasRm().get(cuartCount - 1)));
            anotados.setText(Integer.toString(match.getResultC()));
            posibles.setText(Integer.toString(match.getFallidosRm().get(4) + match.getResultC()));
            tc1.setText(Integer.toString(ar.get(selected - 1).getmP().getTlmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTlmp().get(4)));
            tc2.setText(Integer.toString(ar.get(selected - 1).getmP().getTcmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTcmp().get(4)));
            tc3.setText(Integer.toString(ar.get(selected - 1).getmP().getTrmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTrmp().get(4)));
            trec.setText(Integer.toString(ar.get(selected - 1).getmP().getRecmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getRecmp().get(4)));
            tass.setText(Integer.toString(ar.get(selected - 1).getmP().getAsmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getAsmp().get(4)));
            trd.setText(Integer.toString(ar.get(selected - 1).getmP().getRebdmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getRebdmp().get(4)));
            tro.setText(Integer.toString(ar.get(selected - 1).getmP().getRebomp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getRebomp().get(4)));
            tta.setText(Integer.toString(ar.get(selected - 1).getmP().getTapmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTapmp().get(4)));
            tx1.setText(Integer.toString(ar.get(selected - 1).getmP().getTf1mp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTf1mp().get(4)));
            tx2.setText(Integer.toString(ar.get(selected - 1).getmP().getTf2mp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTf2mp().get(4)));
            tx3.setText(Integer.toString(ar.get(selected - 1).getmP().getTf3mp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getTf3mp().get(4)));
            tfalta.setText(Integer.toString(ar.get(selected - 1).getmP().getFlmp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getFlmp().get(4)));
            tper.setText(Integer.toString(ar.get(selected - 1).getmP().getPermp().get(cuartCount - 1)) + " / " + Integer.toString(ar.get(selected - 1).getmP().getPermp().get(4)));

            if (radioRestar.isSelected()) {
                if (ar.get(selected - 1).getmP().getTlmp().get(cuartCount - 1) > 0) {
                    T1.setDisable(false);
                } else {
                    T1.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getTcmp().get(cuartCount - 1) > 0) {
                    T2.setDisable(false);
                } else {
                    T2.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getTrmp().get(cuartCount - 1) > 0) {
                    T3.setDisable(false);
                } else {
                    T3.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getRecmp().get(cuartCount - 1) > 0) {
                    rec.setDisable(false);
                } else {
                    rec.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getAsmp().get(cuartCount - 1) > 0) {
                    ass.setDisable(false);
                } else {
                    ass.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getRebdmp().get(cuartCount - 1) > 0) {
                    rdef.setDisable(false);
                } else {
                    rdef.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getRebomp().get(cuartCount - 1) > 0) {
                    rofe.setDisable(false);
                } else {
                    rofe.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getTapmp().get(cuartCount - 1) > 0) {
                    rap.setDisable(false);
                } else {
                    rap.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getTf1mp().get(cuartCount - 1) > 0) {
                    x1.setDisable(false);
                } else {
                    x1.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getTf2mp().get(cuartCount - 1) > 0) {
                    x2.setDisable(false);
                } else {
                    x2.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getTf3mp().get(cuartCount - 1) > 0) {
                    x3.setDisable(false);
                } else {
                    x3.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getFlmp().get(cuartCount - 1) > 0) {
                    falta.setDisable(false);
                } else {
                    falta.setDisable(true);
                }
                if (ar.get(selected - 1).getmP().getPermp().get(cuartCount - 1) > 0) {
                    perdida.setDisable(false);
                } else {
                    perdida.setDisable(true);
                }
            } else {
                T1.setDisable(false);
                T2.setDisable(false);
                T3.setDisable(false);
                rec.setDisable(false);
                ass.setDisable(false);
                rdef.setDisable(false);
                rofe.setDisable(false);
                rap.setDisable(false);
                x1.setDisable(false);
                x2.setDisable(false);
                x3.setDisable(false);
                falta.setDisable(false);
                perdida.setDisable(false);
            }

            if (restarRival.isSelected()) {
                if (R1[cuartCount - 1] > 0) {
                    ac1.setDisable(false);
                } else {
                    ac1.setDisable(true);
                }
                if (R2[cuartCount - 1] > 0) {
                    ac2.setDisable(false);
                } else {
                    ac2.setDisable(true);
                }
                if (R3[cuartCount - 1] > 0) {
                    ac3.setDisable(false);
                } else {
                    ac3.setDisable(true);
                }
                if (F1[cuartCount - 1] > 0) {
                    fl1.setDisable(false);
                } else {
                    fl1.setDisable(true);
                }
                if (F2[cuartCount - 1] > 0) {
                    fl2.setDisable(false);
                } else {
                    fl2.setDisable(true);
                }
                if (F3[cuartCount - 1] > 0) {
                    fl3.setDisable(false);
                } else {
                    fl3.setDisable(true);
                }
            } else {
                ac1.setDisable(false);
                ac2.setDisable(false);
                ac3.setDisable(false);
                fl1.setDisable(false);
                fl2.setDisable(false);
                fl3.setDisable(false);
            }
        } catch (Exception e) {
            try {
                PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                pr.write(e.toString());
                pr.close();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }

    //El del Tiempo
    private void refresh3(int i) {
        try {
            for (int x = 0; x < ar.size(); x++) {
                Player pl = ar.get(x);
                ar.get(x).getmP().setTiemJugadomp(ar.get(x).getmP().getTiemJugadomp() + i);
            }
            if (tiempo <= 0) {
                warningTime.setVisible(true);
                axxx.setText("0");
                xaxx.setText("0");
                xxax.setText("0");
                xxxa.setText("0");
                return;
            }
            tiempo += -i;
            match.getCuarterTimes().set(cuartCount - 1, match.getCuarterTimes().get(cuartCount - 1) - i);
            tiempo = match.getCuarterTimes().get(cuartCount - 1);
            /*
        if (tiempo == 600) {
            axxx.setText("1");
        } else {
            axxx.setText("0");
        }
        xaxx.setText(Integer.toString(tiempo / 60).substring(0, 1));
        if (tiempo % 60 < 10) {
            xxax.setText("0");
            xxxa.setText(Integer.toString(tiempo % 60));
        } else {
            xxax.setText(Integer.toString(tiempo % 60).substring(0, 1));
            xxxa.setText(Integer.toString(tiempo % 60).substring(1, 2));
        }
             */

            int aux = tiempo - i;
            String ax = Integer.toString(aux % 60);
            if (ax.length() == 1) {
                ax = "0" + ax;
            }
            String text = Integer.toString(aux / 60) + ax;
            while (text.length() != 4) {
                text = "0" + text;
            }
            axxx.setText(text.charAt(0) + "");
            xaxx.setText(text.charAt(1) + "");
            xxax.setText(text.charAt(2) + "");
            xxxa.setText(text.charAt(3) + "");
        } catch (Exception e) {
            try {
                PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                pr.write(e.toString());
                pr.close();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }

    //el de las faltas
    private void refresh4() {
        try {
            boolean aux;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (ar.get(i).getmP().getFlmp().get(4) > j) {
                        aux = true;
                    } else {
                        aux = false;
                    }
                    fal[i][j].setSelected(aux);
                }
            }
        } catch (Exception e) {
            try {
                PrintWriter pr = new PrintWriter(new File("crash_reports/crashed.txt"));
                pr.write(e.toString());
                pr.close();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }

    @FXML
    private void onRestarR(ActionEvent event) {
        refresh2();
    }

    public void end() {
        running = false;
    }

    @FXML
    private void onBackCuarter(ActionEvent event) {

        cuartCount--;

        if (cuartCount == 1) {
            cuartoBack.setDisable(true);
        }
        if (cuartCount == 1) {
            cuarto.setText("Primero");
        }
        if (cuartCount == 2) {
            cuarto.setText("Segundo");
        }
        if (cuartCount == 3) {
            cuarto.setText("Tercero");
        }
        refresh3(0);
        refresh2();
    }

    private void masmenos(int n) {
        for (int j = 0; j < 5; j++) {
            Player pl = ar.get(j);

            pl.getmP().getMasmenos().set(cuartCount - 1, pl.getmP().getMasmenos().get(cuartCount - 1) + n);
            pl.getmP().getMasmenos().set(4, pl.getmP().getMasmenos().get(4) + n);
        }
    }

    @FXML
    private void onMas10(ActionEvent event) {
        refresh3(-10);
    }

    @FXML
    private void onMas30(ActionEvent event) {
        refresh3(-30);
    }

    @FXML
    private void onMenos10(ActionEvent event) {
        refresh3(10);
    }

    @FXML
    private void onMenos30(ActionEvent event) {
        refresh3(30);
    }

    @FXML
    private void onSaveMatch(ActionEvent event) {
        saveMatch(false);
    }

    public void refreshito() {
        refresh2();

        setPlayerList();
        refresh4();
    }
}
