/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yuki
 */
public class Player {

    private int IDp;
    private int dorsalp;
    private String namep, surnamep, surname2p; //surname2 may be blank
    private int dd, mm, yyyy;
    private int pos;
    private matchPlayer mP;
    private ArrayList<Double> timep, mediumTimep, actTimep;
    private String img;
    private ArrayList<matchPlayer> mPListp;

    private final StringProperty nameP = new SimpleStringProperty();
    private final StringProperty surnameP = new SimpleStringProperty();
    private final StringProperty posP = new SimpleStringProperty();
    private final StringProperty birthP = new SimpleStringProperty();
    private final StringProperty imgP = new SimpleStringProperty();
    private final StringProperty timeP = new SimpleStringProperty();
    private final IntegerProperty dorsalP = new SimpleIntegerProperty();
    private final StringProperty minJuP = new SimpleStringProperty();

    private final IntegerProperty tot = new SimpleIntegerProperty();
    private final IntegerProperty tl = new SimpleIntegerProperty();
    private final IntegerProperty tc = new SimpleIntegerProperty();
    private final IntegerProperty tr = new SimpleIntegerProperty();
    private final IntegerProperty ass = new SimpleIntegerProperty();
    private final IntegerProperty rec = new SimpleIntegerProperty();
    private final IntegerProperty tap = new SimpleIntegerProperty();
    private final IntegerProperty rd = new SimpleIntegerProperty();
    private final IntegerProperty ro = new SimpleIntegerProperty();
    private final IntegerProperty val = new SimpleIntegerProperty();
    private final IntegerProperty per = new SimpleIntegerProperty();
    private final IntegerProperty pf = new SimpleIntegerProperty();
    private final IntegerProperty tlf = new SimpleIntegerProperty();
    private final IntegerProperty tcf = new SimpleIntegerProperty();
    private final IntegerProperty trf = new SimpleIntegerProperty();
    private final IntegerProperty fal = new SimpleIntegerProperty();
    private final IntegerProperty masmenos = new SimpleIntegerProperty();

    public IntegerProperty totProperty() {
        return tot;
    }

    public IntegerProperty tlProperty() {
        return tl;
    }

    public IntegerProperty tcProperty() {
        return tc;
    }

    public IntegerProperty trProperty() {
        return tr;
    }

    public IntegerProperty assProperty() {
        return ass;
    }

    public IntegerProperty recProperty() {
        return rec;
    }

    public IntegerProperty tapProperty() {
        return tap;
    }

    public IntegerProperty rdProperty() {
        return rd;
    }

    public IntegerProperty roProperty() {
        return ro;
    }

    public IntegerProperty valProperty() {
        return val;
    }

    public IntegerProperty perProperty() {
        return per;
    }

    public IntegerProperty pfProperty() {
        return pf;
    }

    public IntegerProperty tlfProperty() {
        return tlf;
    }

    public IntegerProperty tcfProperty() {
        return tcf;
    }

    public IntegerProperty trfProperty() {
        return trf;
    }

    public IntegerProperty falProperty() {
        return fal;
    }

    public IntegerProperty masmenosProperty() {
        return masmenos;
    }

    public void addmp(int id){
        this.mP = new matchPlayer(id);
    }
    
    public Player() {
        timep = new ArrayList<>();
        mediumTimep = new ArrayList<>();
        actTimep = new ArrayList<>();
        mPListp = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            timep.add(0.0);
            mediumTimep.add(0.0);
            actTimep.add(0.0);
        }
    }

    public void refresh(int id) {
        matchPlayer aux = null;
        for (int i = 0; i < this.getmPListp().size(); i++) {
            if (id == getmPListp().get(i).getIDmp()) {
                aux = getmPListp().get(i);
            }
        }
        nameP.set(getNamep() + " " + getSurnamep().charAt(0) + ".");
        tot.set(aux.getTotmp().get(4));
        tl.set(aux.getTlmp().get(4));
        tc.set(aux.getTcmp().get(4));
        tr.set(aux.getTrmp().get(4));
        ass.set(aux.getAsmp().get(4));
        rec.set(aux.getRecmp().get(4));
        tap.set(aux.getTapmp().get(4));
        rd.set(aux.getRebdmp().get(4));
        ro.set(aux.getRebomp().get(4));
        per.set(aux.getPermp().get(4));
        tlf.set(aux.getTf1mp().get(4));
        tcf.set(aux.getTf2mp().get(4));
        trf.set(aux.getTf3mp().get(4));
        fal.set(aux.getFlmp().get(4));
        int pfa = aux.getTf1mp().get(4) + aux.getTf2mp().get(4) * 2 + aux.getTf3mp().get(4) * 3;
        pf.set(pfa);
        val.set(aux.getVal());

    }

    public void refreshActual(int id) {
        matchPlayer aux = null;
        System.out.println("getmP() == null =" + (getmP() == null));
        if(getmP() == null)
            for(int i = 0; i < getmPListp().size(); i++){
                if(getmPListp().get(i).getIDmp() == id){
                    aux = getmPListp().get(i);
                    System.out.println("loaded");
                    break;
                }
            }
        else aux = getmP();
        mP = aux;
        nameP.set(getNamep() + " " + getSurnamep().charAt(0) + ".");
        tot.set(aux.getTotmp().get(4));
        tl.set(aux.getTlmp().get(4));
        tc.set(aux.getTcmp().get(4));
        tr.set(aux.getTrmp().get(4));
        ass.set(aux.getAsmp().get(4));
        rec.set(aux.getRecmp().get(4));
        tap.set(aux.getTapmp().get(4));
        rd.set(aux.getRebdmp().get(4));
        ro.set(aux.getRebomp().get(4));
        per.set(aux.getPermp().get(4));
        tlf.set(aux.getTf1mp().get(4));
        tcf.set(aux.getTf2mp().get(4));
        trf.set(aux.getTf3mp().get(4));
        fal.set(aux.getFlmp().get(4));
        masmenos.set(aux.getMasmenos().get(4));
        int pfa = aux.getTf1mp().get(4) + aux.getTf2mp().get(4) * 2 + aux.getTf3mp().get(4) * 3;
        pf.set(pfa);
        val.set(aux.getVal());
        int sec = mP.getTiemJugadomp() % 60;
        System.out.println(mP.getTiemJugadomp());
        int min = mP.getTiemJugadomp() / 60;
        String b = min + " m " + sec + "s";
        minJuP.set(b);

    }

    public void refreshActual() {
        matchPlayer aux = getmP();
        mP = aux;
        nameP.set(getNamep() + " " + getSurnamep().charAt(0) + ".");
        tot.set(aux.getTotmp().get(4));
        tl.set(aux.getTlmp().get(4));
        tc.set(aux.getTcmp().get(4));
        tr.set(aux.getTrmp().get(4));
        ass.set(aux.getAsmp().get(4));
        rec.set(aux.getRecmp().get(4));
        tap.set(aux.getTapmp().get(4));
        rd.set(aux.getRebdmp().get(4));
        ro.set(aux.getRebomp().get(4));
        per.set(aux.getPermp().get(4));
        tlf.set(aux.getTf1mp().get(4));
        tcf.set(aux.getTf2mp().get(4));
        trf.set(aux.getTf3mp().get(4));
        fal.set(aux.getFlmp().get(4));
        masmenos.set(aux.getMasmenos().get(4));
        int pfa = aux.getTf1mp().get(4) + aux.getTf2mp().get(4) * 2 + aux.getTf3mp().get(4) * 3;
        pf.set(pfa);
        val.set(aux.getVal());
        int sec = mP.getTiemJugadomp() % 60;
        System.out.println(mP.getTiemJugadomp());
        int min = mP.getTiemJugadomp() / 60;
        String b = min + " m " + sec + "s";
        minJuP.set(b);

    }
    
    public void refresh() {
        nameP.set(namep);
        surnameP.set(surnamep + " " + surname2p);
        birthP.set(dd + "/" + mm + "/" + yyyy);
        imgP.set(img);
        String aux = "1. Base";
        if (pos == 2) {
            aux = "2. Escolta";
        }
        if (pos == 3) {
            aux = "3. Alero";
        }
        if (pos == 4) {
            aux = "4. Ala-Pívot";
        }
        if (pos == 5) {
            aux = "5. Pívot";
        }
        posP.set(aux);
        dorsalP.set(dorsalp);
        int m = (int) Double.parseDouble(actTimep.get(4).toString()) / 60;
        int s = (int) Double.parseDouble(actTimep.get(4).toString()) % 60;
        timeP.set(m + " min " + s + " sec");

        if (mP != null) {
            int sec = mP.getTiemJugadomp() % 60;
            int min = mP.getTiemJugadomp() / 60;
            String b = min + " m " + sec + "s";
            minJuP.set(b);
        }
    }

    public int getDorsal() {
        return dorsalp;
    }

    public void setDorsal(int dorsal) {
        this.dorsalp = dorsal;
    }

    public StringProperty timePProperty() {
        return timeP;
    }

    public IntegerProperty dorsalPProperty() {
        return dorsalP;
    }

    public StringProperty namePProperty() {
        return nameP;
    }

    public StringProperty surnamePProperty() {
        return surnameP;
    }

    public StringProperty minJuPProperty() {
        int sec = mP.getTiemJugadomp() % 60;
        int min = mP.getTiemJugadomp() / 60;
        String b = min + " m " + sec + "s";
        minJuP.set(b);
        System.out.println(b);
        return minJuP;
    }

    public void setTimep(ArrayList<Double> timep) {
        this.timep = timep;
    }

    public void setMediumTimep(ArrayList<Double> mediumTimep) {
        this.mediumTimep = mediumTimep;
    }

    public void setActTimep(ArrayList<Double> actTimep) {
        this.actTimep = actTimep;
    }

    public ArrayList<Double> getTimep() {
        return timep;
    }

    public ArrayList<Double> getMediumTimep() {
        return mediumTimep;
    }

    public ArrayList<Double> getActTimep() {
        return actTimep;
    }

    public StringProperty posPProperty() {
        return posP;
    }

    public StringProperty birthPProperty() {
        return birthP;
    }

    public StringProperty imgPProperty() {
        return imgP;
    }

    public void setBirthday(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
    }

    public void setIDp(int IDp) {
        this.IDp = IDp;
    }

    public void setDorsalp(int dorsalp) {
        this.dorsalp = dorsalp;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public void setSurnamep(String surnamep) {
        this.surnamep = surnamep;
    }

    public void setSurname2p(String surname2p) {
        this.surname2p = surname2p;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setmP(matchPlayer mP) {
        this.mP = mP;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setmPListp(ArrayList<matchPlayer> mPListp) {
        this.mPListp = mPListp;
    }

    public int getIDp() {
        return IDp;
    }

    public int getDorsalp() {
        return dorsalp;
    }

    public String getNamep() {
        return namep;
    }

    public String getSurnamep() {
        return surnamep;
    }

    public String getSurname2p() {
        return surname2p;
    }

    public int getDd() {
        return dd;
    }

    public int getMm() {
        return mm;
    }

    public int getYyyy() {
        return yyyy;
    }

    public int getPos() {
        return pos;
    }

    public matchPlayer getmP() {
        return mP;
    }

    public String getImg() {
        return img;
    }

    public ArrayList<matchPlayer> getmPListp() {
        return mPListp;
    }

}
