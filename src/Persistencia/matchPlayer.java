/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;

/**
 *
 * @author Yuki
 */
public class matchPlayer {

    private int IDmp;

    //Tiros fallados se cuentan de uno en uno [t2f = 1 ---> 2 puntos fallados]
    private ArrayList<Integer> totmp, tlmp, tcmp, trmp, asmp, recmp, tapmp, rebdmp, rebomp, permp, tf2mp, tf3mp, flmp, tf1mp; // [1er, 2do, 3ro, 4to, tot]

    private ArrayList<ArrayList<Integer>> t2mp, t3mp, perAmp, t2fmp, t3fmp;

    private int val;

    private ArrayList<Integer> masmenos;

    private int tiemJugadomp;

    public matchPlayer() {
        totmp = new ArrayList<>();
        tlmp = new ArrayList<>();
        tcmp = new ArrayList<>();
        trmp = new ArrayList<>();
        asmp = new ArrayList<>();
        recmp = new ArrayList<>();
        tapmp = new ArrayList<>();
        rebdmp = new ArrayList<>();
        rebomp = new ArrayList<>();
        permp = new ArrayList<>();
        tf2mp = new ArrayList<>();
        tf3mp = new ArrayList<>();
        flmp = new ArrayList<>();
        tf1mp = new ArrayList<>();
        tiemJugadomp = 0;
        t2mp = new ArrayList<>();
        t3mp = new ArrayList<>();
        perAmp = new ArrayList<>();
        t2fmp = new ArrayList<>();
        t3fmp = new ArrayList<>();
        masmenos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            masmenos.add(0);
            totmp.add(0);
            tlmp.add(0);
            tcmp.add(0);
            trmp.add(0);
            asmp.add(0);
            recmp.add(0);
            tapmp.add(0);
            rebdmp.add(0);
            rebomp.add(0);
            permp.add(0);
            tf2mp.add(0);
            tf3mp.add(0);
            flmp.add(0);
            tf1mp.add(0);

            t2mp.add(new ArrayList<>());
            t3mp.add(new ArrayList<>());
            perAmp.add(new ArrayList<>());
            t2fmp.add(new ArrayList<>());
            t3fmp.add(new ArrayList<>());
        }
    }

    public matchPlayer(int id) {
        IDmp = id;
        totmp = new ArrayList<>();
        tlmp = new ArrayList<>();
        tcmp = new ArrayList<>();
        trmp = new ArrayList<>();
        asmp = new ArrayList<>();
        recmp = new ArrayList<>();
        tapmp = new ArrayList<>();
        rebdmp = new ArrayList<>();
        rebomp = new ArrayList<>();
        permp = new ArrayList<>();
        tf2mp = new ArrayList<>();
        tf3mp = new ArrayList<>();
        flmp = new ArrayList<>();
        tf1mp = new ArrayList<>();
        tiemJugadomp = 0;
        t2mp = new ArrayList<>();
        t3mp = new ArrayList<>();
        perAmp = new ArrayList<>();
        t2fmp = new ArrayList<>();
        t3fmp = new ArrayList<>();
        masmenos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            masmenos.add(0);
            totmp.add(0);
            tlmp.add(0);
            tcmp.add(0);
            trmp.add(0);
            asmp.add(0);
            recmp.add(0);
            tapmp.add(0);
            rebdmp.add(0);
            rebomp.add(0);
            permp.add(0);
            tf2mp.add(0);
            tf3mp.add(0);
            flmp.add(0);
            tf1mp.add(0);

            t2mp.add(new ArrayList<>());
            t3mp.add(new ArrayList<>());
            perAmp.add(new ArrayList<>());
            t2fmp.add(new ArrayList<>());
            t3fmp.add(new ArrayList<>());
        }
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setMasmenos(ArrayList<Integer> masmenos) {
        this.masmenos = masmenos;
    }

    public ArrayList<Integer> getMasmenos() {
        return masmenos;
    }

    public void setIDmp(int IDmp) {
        this.IDmp = IDmp;
    }

    public void setTiemJugadomp(int tiemJugadomp) {
        this.tiemJugadomp = tiemJugadomp;
    }

    public int getIDmp() {
        return IDmp;
    }

    public ArrayList<Integer> getTotmp() {
        return totmp;
    }

    public ArrayList<Integer> getTlmp() {
        return tlmp;
    }

    public ArrayList<Integer> getTcmp() {
        return tcmp;
    }

    public ArrayList<Integer> getTrmp() {
        return trmp;
    }

    public ArrayList<Integer> getAsmp() {
        return asmp;
    }

    public ArrayList<Integer> getRecmp() {
        return recmp;
    }

    public ArrayList<Integer> getTapmp() {
        return tapmp;
    }

    public void setTotmp(ArrayList<Integer> totmp) {
        this.totmp = totmp;
    }

    public void setTlmp(ArrayList<Integer> tlmp) {
        this.tlmp = tlmp;
    }

    public void setTcmp(ArrayList<Integer> tcmp) {
        this.tcmp = tcmp;
    }

    public void setTrmp(ArrayList<Integer> trmp) {
        this.trmp = trmp;
    }

    public void setAsmp(ArrayList<Integer> asmp) {
        this.asmp = asmp;
    }

    public void setRecmp(ArrayList<Integer> recmp) {
        this.recmp = recmp;
    }

    public void setTapmp(ArrayList<Integer> tapmp) {
        this.tapmp = tapmp;
    }

    public void setRebdmp(ArrayList<Integer> rebdmp) {
        this.rebdmp = rebdmp;
    }

    public void setRebomp(ArrayList<Integer> rebomp) {
        this.rebomp = rebomp;
    }

    public void setPermp(ArrayList<Integer> permp) {
        this.permp = permp;
    }

    public void setTf2mp(ArrayList<Integer> tf2mp) {
        this.tf2mp = tf2mp;
    }

    public void setTf3mp(ArrayList<Integer> tf3mp) {
        this.tf3mp = tf3mp;
    }

    public void setFlmp(ArrayList<Integer> flmp) {
        this.flmp = flmp;
    }

    public void setTf1mp(ArrayList<Integer> tf1mp) {
        this.tf1mp = tf1mp;
    }

    public ArrayList<Integer> getRebdmp() {
        return rebdmp;
    }

    public ArrayList<Integer> getRebomp() {
        return rebomp;
    }

    public ArrayList<Integer> getPermp() {
        return permp;
    }

    public ArrayList<Integer> getTf2mp() {
        return tf2mp;
    }

    public ArrayList<Integer> getTf3mp() {
        return tf3mp;
    }

    public ArrayList<Integer> getFlmp() {
        return flmp;
    }

    public ArrayList<Integer> getTf1mp() {
        return tf1mp;
    }

    public int getTiemJugadomp() {
        return tiemJugadomp;
    }

    public void setT2mp(ArrayList<ArrayList<Integer>> t2mp) {
        this.t2mp = t2mp;
    }

    public void setT3mp(ArrayList<ArrayList<Integer>> t3mp) {
        this.t3mp = t3mp;
    }

    public void setPerAmp(ArrayList<ArrayList<Integer>> perAmp) {
        this.perAmp = perAmp;
    }

    public void setT2fmp(ArrayList<ArrayList<Integer>> t2fmp) {
        this.t2fmp = t2fmp;
    }

    public void setT3fmp(ArrayList<ArrayList<Integer>> t3fmp) {
        this.t3fmp = t3fmp;
    }

    public ArrayList<ArrayList<Integer>> getT2mp() {
        return t2mp;
    }

    public ArrayList<ArrayList<Integer>> getT3mp() {
        return t3mp;
    }

    public ArrayList<ArrayList<Integer>> getPerAmp() {
        return perAmp;
    }

    public ArrayList<ArrayList<Integer>> getT2fmp() {
        return t2fmp;
    }

    public ArrayList<ArrayList<Integer>> getT3fmp() {
        return t3fmp;
    }

    public int getVal() {
        int aux = totmp.get(4) + asmp.get(4) - flmp.get(4) - permp.get(4) + rebdmp.get(4)
                + rebomp.get(4) + recmp.get(4) + tapmp.get(4) - tf1mp.get(4) - tf2mp.get(4) * 2
                - tf3mp.get(4) * 3;
        return aux;
    }

}
