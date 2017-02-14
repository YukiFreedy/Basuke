/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yuki
 */
public class PlayerDataController implements Initializable {

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
    private TextField dfp;
    @FXML
    private Label nombre;
    @FXML
    private TextField valoracion;
    @FXML
    private TextField tiempoJugado;
    @FXML
    private TextField dmasmen;

    /**
     * Initializes the controller class.
     */
    
    public void init(Player player){
        nombre.setText(player.getNamep());
        
        int tc,tl, tr,ass,rec,tap,rd,ro,per,tcf,tlf,trf,fal,pp,fp, val, tj, masmenos; 
        tc = tl = tr = ass = rec = tap = rd = ro = per = tcf = tlf = trf = fal = pp = fp = val = tj= masmenos=0;
        for(int i = 0; i < player.getmPListp().size();i++){
            tc += player.getmPListp().get(i).getTcmp().get(4);
            tl += player.getmPListp().get(i).getTlmp().get(4);
            tr += player.getmPListp().get(i).getTrmp().get(4);
            ass += player.getmPListp().get(i).getAsmp().get(4);
            rec += player.getmPListp().get(i).getRecmp().get(4);
            tap += player.getmPListp().get(i).getTapmp().get(4);
            rd += player.getmPListp().get(i).getRebdmp().get(4);
            ro += player.getmPListp().get(i).getRebomp().get(4);
            per += player.getmPListp().get(i).getPermp().get(4);
            tcf += player.getmPListp().get(i).getTf2mp().get(4)*2;
            tlf += player.getmPListp().get(i).getTf1mp().get(4);
            trf += player.getmPListp().get(i).getTf3mp().get(4)*3;
            fal += player.getmPListp().get(i).getFlmp().get(4);
            pp += tc+tl+tr;
            fp += tlf+tcf+trf;
            val += player.getmPListp().get(i).getVal();
            tj += player.getmPListp().get(i).getTiemJugadomp();
            masmenos += player.getmPListp().get(i).getMasmenos().get(4);
        }
        
        
        double size = (double) player.getmPListp().size();
        dtc.setText(Double.toString(tc/size));
        dtl.setText(Double.toString(tl/size));
        dtr.setText(Double.toString(tr/size));
        dass.setText(Double.toString(ass/size));
        drec.setText(Double.toString(rec/size));
        dtap.setText(Double.toString(tap/size));
        drd.setText(Double.toString(rd/size));
        dro.setText(Double.toString(ro/size));
        dper.setText(Double.toString(per/size));
        dtcf.setText(Double.toString(tcf/size));
        dtlf.setText(Double.toString(tlf/size));
        dtrf.setText(Double.toString(trf/size));
        dfal.setText(Double.toString(fal/size));
        dpp.setText(Double.toString(pp/size));
        dfp.setText(Double.toString(fp/size));
        dmasmen.setText(Double.toString(masmenos/size));
        
        valoracion.setText(Double.toString(val/size));
        double time = tj/size;
        int m = (int) (time/60);
        int s = (int) (time%60);
        String t = String.format("%3d m %2d s", m, s);
        tiempoJugado.setText(t);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
