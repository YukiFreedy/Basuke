/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Yuki
 */
public class helper {

    private static wrapper wrap;

    public static wrapper getInstance() {
        if (wrap == null) {
            wrap = loadWrapper();
            return wrap;
        } else {
            return wrap;
        }
    }

    private static wrapper loadWrapper() {
        wrapper aux = new wrapper();
        try {

            JAXBContext jaxbContext;
            Marshaller jaxbMarshaller;
            Unmarshaller jaxbUnmarshaller;

            File file = new File("playerList.xml");
            wrapperPlayer wP;
            if (!file.exists()) {
                jaxbContext = JAXBContext.newInstance(wrapperPlayer.class);
                jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                wP = new wrapperPlayer();
                wP.setPlayerList(new ArrayList<>());
                jaxbMarshaller.marshal(wP, file);
            } else {
                jaxbContext = JAXBContext.newInstance(wrapperPlayer.class);
                jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                wP = (wrapperPlayer) jaxbUnmarshaller.unmarshal(file);
            }
            aux.setPlayerList(wP.getPlayerList());

            
            
            
            file = new File("matchesList.xml");
            wrapperMatches wM;

            if (!file.exists()) {
                jaxbContext = JAXBContext.newInstance(wrapperMatches.class);
                jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                wM = new wrapperMatches();
                jaxbMarshaller.marshal(wM, file);
            } else {
                jaxbContext = JAXBContext.newInstance(wrapperMatches.class);
                jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                wM = (wrapperMatches) jaxbUnmarshaller.unmarshal(file);
            }
            aux.setMatchList(wM.getMatchList());

            
            
            
            file = new File("IDList.xml");
            wrapperID wID;
            if (!file.exists()) {
                jaxbContext = JAXBContext.newInstance(wrapperID.class);
                jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                wID = new wrapperID();
            } else {

                jaxbContext = JAXBContext.newInstance(wrapperID.class);
                jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                wID = (wrapperID) jaxbUnmarshaller.unmarshal(file);
            }
            aux.setIDCount(wID.getIDCount());
            aux.setIDImagesCount(wID.getIDImagesCount());
            aux.setIDMatchCount(wID.getIDMatchCount());

            wrap = aux;
        } catch (Exception e) {
            System.out.println("Failed you bitch");
            e.printStackTrace();
        }
        return wrap;
    }

    public static void saveWrapper() {
        try {
            File file = new File("playerList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapperPlayer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            wrapperPlayer wP = new wrapperPlayer();
            wP.setPlayerList(getInstance().getPlayerList());
            jaxbMarshaller.marshal(wP, file);

            file = new File("matchesList.xml");
            jaxbContext = JAXBContext.newInstance(wrapperMatches.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            wrapperMatches wM = new wrapperMatches();
            wM.setMatchList(getInstance().getMatchList());
            jaxbMarshaller.marshal(wM, file);

            file = new File("IDList.xml");
            jaxbContext = JAXBContext.newInstance(wrapperID.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            wrapperID wID = new wrapperID();
            wID.setIDCount(getInstance().getIDCount());
            wID.setIDImagesCount(getInstance().getIDImagesCount());
            wID.setIDMatchCount(getInstance().getIDMatchCount());
            jaxbMarshaller.marshal(wID, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    private void addPlayer(Player player) {
        loadWrapper();
        wrap.addPlayer(player);
        saveWrapper(wrap);
    }

    private void addMatch(Match match) {
        loadWrapper();
        wrap.addMatch(match);
        saveWrapper(wrap);

    }

    private void modPlayer(Player pl) {
        int id = pl.getIDp();
        loadWrapper();
        ArrayList<Player> a = wrap.getPlayerList();
        for (int i = 0; i <= a.size(); i++) {
            if (a.get(i).getIDp() == id) {
                a.set(i, pl);
                saveWrapper(wrap);
                return;
            }
        }
    }

    private ArrayList<Player> getEquipo() {
        loadWrapper();
        return wrap.getPlayerList();
    }

    private void setEquipo(ArrayList<Player> equ) {
        loadWrapper();
        wrap.setPlayerList(equ);
        saveWrapper(wrap);
    }
     */
    public static wrapper refresh() {
        ArrayList<Player> a = wrap.getPlayerList();
        //revisar tamaño
        Player player;
        for (int i = 0; i < a.size(); i++) {
            player = a.get(i);
            player.refresh();
        }
        return wrap;
    }

    private int getID() {
        int i = 0;
        try {
            File file = new File("IDList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapperID.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            wrapperID wID = (wrapperID) jaxbUnmarshaller.unmarshal(file);
            i = wID.getIDCount();
            wID.setIDCount(i + 1);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(wID, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    private int getIDImage() {
        int i = 0;
        try {
            File file = new File("IDList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapperID.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            wrapperID wID = (wrapperID) jaxbUnmarshaller.unmarshal(file);
            i = wID.getIDImagesCount();
            wID.setIDImagesCount(i + 1);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(wID, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    private int getIDMatch() {
        int i = 0;
        try {
            File file = new File("IDList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapperID.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            wrapperID wID = (wrapperID) jaxbUnmarshaller.unmarshal(file);
            i = wID.getIDMatchCount();
            wID.setIDMatchCount(i + 1);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(wID, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    /*
    private void setMatch(Match match){
        ArrayList<Match> aux = wrap.getMatchList();
        for(int i = 0; i < aux.size(); i++){
            if(match.getIDm() == aux.get(i).getIDm()){
                aux.set(i, match);
                wrap.setMatchList(aux);
                saveWrapper(wrap);
                System.out.println("Setted Match");
                return;
            }
        }
        this.addMatch(match);
        System.out.println("Added Match");
    }*/
}
