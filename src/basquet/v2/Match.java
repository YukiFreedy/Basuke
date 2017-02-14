/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yuki
 */
public class Match {

    private int IDm;
    private ArrayList<Integer>/* playerListm,*/ activos;
    private ArrayList<Integer> playerListm;
    private int resultF, resultC, q1, q2, q3, q4, qc1, qc2, qc3, qc4;
    private ArrayList<Integer> totm, tlm, tcm, trm, asm, recm, tapm, rebdm, rebom, perm, tf1m, tf2m, tf3m, flm, fallm;
    private ArrayList<Integer> cuarterTimes;
    
    private int posiblesRm;
    private ArrayList<Integer> faltasRm, fallidosRm, tcR, tlR, trR, tflR, tfcR, tfrR;
    
    private boolean local;
    private String rival, date;
    
    private final StringProperty rivalP = new SimpleStringProperty();
    private final StringProperty dateP = new SimpleStringProperty();
    private final StringProperty resultP = new SimpleStringProperty();

    public Match() {
        tflR = new ArrayList<>();
        tfcR = new ArrayList<>();
        tfrR = new ArrayList<>();
        faltasRm = new ArrayList<>();
        fallidosRm = new ArrayList<>();
        totm = new ArrayList<>();
        tcm = new ArrayList<>();
        trm = new ArrayList<>();
        asm = new ArrayList<>();
        recm = new ArrayList<>();
        tapm = new ArrayList<>();
        rebdm = new ArrayList<>();
        rebom = new ArrayList<>();
        perm = new ArrayList<>();
        tf2m = new ArrayList<>();
        tf3m = new ArrayList<>();
        flm = new ArrayList<>();
        fallm = new ArrayList<>();
        tcR = new ArrayList<>();
        tlR = new ArrayList<>();
        trR = new ArrayList<>();
        tlm = new ArrayList<>();
        tf1m = new ArrayList<>();
        cuarterTimes = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            faltasRm.add(0);
            cuarterTimes.add(600);
            fallidosRm.add(0);
            totm.add(0);
            tcm.add(0);
            trm.add(0);
            asm.add(0);
            recm.add(0);
            tapm.add(0);
            rebdm.add(0);
            rebom.add(0);
            perm.add(0);
            tf2m.add(0);
            tf3m.add(0);
            flm.add(0);
            fallm.add(0);
            tcR.add(0);
            tlR.add(0);
            trR.add(0);
            tlm.add(0);
            tf1m.add(0);
            tflR.add(0);
            tfcR.add(0);
            tfrR.add(0);
        }
    }
    
    public void setActivos(ArrayList<Integer> activos) {
        this.activos = activos;
    }

    public ArrayList<Integer> getActivos() {
        return activos;
    }

    public StringProperty rivalPProperty() {
        rivalP.set(rival);
        return rivalP;
    }
    
    public StringProperty datePProperty() {
        dateP.set(date);
        return dateP;
    }

    public ArrayList<Integer> getCuarterTimes() {
        return cuarterTimes;
    }

    public void setCuarterTimes(ArrayList<Integer> cuarterTimes) {
        this.cuarterTimes = cuarterTimes;
    }
    
    public StringProperty resultPProperty() {
        resultP.set(Integer.toString(resultF) + " / "+ Integer.toString(resultC));
        return resultP;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public boolean isLocal() {
        return local;
    }

    public String getRival() {
        return rival;
    }

    public void setTflR(ArrayList<Integer> tflR) {
        this.tflR = tflR;
    }

    public void setTfcR(ArrayList<Integer> tfcR) {
        this.tfcR = tfcR;
    }

    public void setTfrR(ArrayList<Integer> tfrR) {
        this.tfrR = tfrR;
    }

    public ArrayList<Integer> getTflR() {
        return tflR;
    }

    public ArrayList<Integer> getTfcR() {
        return tfcR;
    }

    public ArrayList<Integer> getTfrR() {
        return tfrR;
    }

    public void setTlm(ArrayList<Integer> tlm) {
        this.tlm = tlm;
    }

    public void setTf1m(ArrayList<Integer> tf1m) {
        this.tf1m = tf1m;
    }

    public ArrayList<Integer> getTlm() {
        return tlm;
    }

    public ArrayList<Integer> getTf1m() {
        return tf1m;
    }

    public void setTcR(ArrayList<Integer> tcR) {
        this.tcR = tcR;
    }

    public void setTlR(ArrayList<Integer> tlR) {
        this.tlR = tlR;
    }

    public void setTrR(ArrayList<Integer> trR) {
        this.trR = trR;
    }

    public ArrayList<Integer> getTcR() {
        return tcR;
    }

    public ArrayList<Integer> getTlR() {
        return tlR;
    }

    public ArrayList<Integer> getTrR() {
        return trR;
    }

    public void setIDm(int IDm) {
        this.IDm = IDm;
    }

    public void setPlayerListm(ArrayList<Integer> playerListm) {
        this.playerListm = playerListm;
    }

    public void setResultF(int resultF) {
        this.resultF = resultF;
    }

    public void setResultC(int resultC) {
        this.resultC = resultC;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public void setQc1(int qc1) {
        this.qc1 = qc1;
    }

    public void setQc2(int qc2) {
        this.qc2 = qc2;
    }

    public void setQc3(int qc3) {
        this.qc3 = qc3;
    }

    public void setQc4(int qc4) {
        this.qc4 = qc4;
    }

    public void setPosiblesRm(int posiblesRm) {
        this.posiblesRm = posiblesRm;
    }

    public int getIDm() {
        return IDm;
    }

    public int getResultF() {
        return resultF;
    }

    public int getResultC() {
        return resultC;
    }

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }

    public int getQ3() {
        return q3;
    }

    public int getQ4() {
        return q4;
    }

    public int getQc1() {
        return qc1;
    }

    public int getQc2() {
        return qc2;
    }

    public int getQc3() {
        return qc3;
    }

    public int getQc4() {
        return qc4;
    }

    public ArrayList<Integer> getPlayerListm() {
        return playerListm;
    }

    public ArrayList<Integer> getTotm() {
        return totm;
    }

    public ArrayList<Integer> getTcm() {
        return tcm;
    }

    public ArrayList<Integer> getTrm() {
        return trm;
    }

    public ArrayList<Integer> getAsm() {
        return asm;
    }

    public void setTotm(ArrayList<Integer> totm) {
        this.totm = totm;
    }

    public void setTcm(ArrayList<Integer> tcm) {
        this.tcm = tcm;
    }

    public void setTrm(ArrayList<Integer> trm) {
        this.trm = trm;
    }

    public void setAsm(ArrayList<Integer> asm) {
        this.asm = asm;
    }

    public void setRecm(ArrayList<Integer> recm) {
        this.recm = recm;
    }

    public void setTapm(ArrayList<Integer> tapm) {
        this.tapm = tapm;
    }

    public void setRebdm(ArrayList<Integer> rebdm) {
        this.rebdm = rebdm;
    }

    public void setRebom(ArrayList<Integer> rebom) {
        this.rebom = rebom;
    }

    public void setPerm(ArrayList<Integer> perm) {
        this.perm = perm;
    }

    public void setTf2m(ArrayList<Integer> tf2m) {
        this.tf2m = tf2m;
    }

    public void setTf3m(ArrayList<Integer> tf3m) {
        this.tf3m = tf3m;
    }

    public void setFlm(ArrayList<Integer> flm) {
        this.flm = flm;
    }

    public void setFallm(ArrayList<Integer> fallm) {
        this.fallm = fallm;
    }

    public ArrayList<Integer> getRecm() {
        return recm;
    }

    public ArrayList<Integer> getTapm() {
        return tapm;
    }

    public ArrayList<Integer> getRebdm() {
        return rebdm;
    }

    public ArrayList<Integer> getRebom() {
        return rebom;
    }

    public ArrayList<Integer> getPerm() {
        return perm;
    }

    public ArrayList<Integer> getTf2m() {
        return tf2m;
    }

    public ArrayList<Integer> getTf3m() {
        return tf3m;
    }

    public ArrayList<Integer> getFlm() {
        return flm;
    }

    public ArrayList<Integer> getFallm() {
        return fallm;
    }

    public ArrayList<Integer> getFaltasRm() {
        return faltasRm;
    }

    public ArrayList<Integer> getFallidosRm() {
        return fallidosRm;
    }

    public void setFaltasRm(ArrayList<Integer> faltasRm) {
        this.faltasRm = faltasRm;
    }

    public void setFallidosRm(ArrayList<Integer> fallidosRm) {
        this.fallidosRm = fallidosRm;
    }

    public int getPosiblesRm() {
        return posiblesRm;
    }

}
