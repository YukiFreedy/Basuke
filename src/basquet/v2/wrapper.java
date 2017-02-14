/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet.v2;

import java.util.ArrayList;

/**
 *
 * @author Yuki
 */
public class wrapper {
    
    private int IDCount;
    private int IDImagesCount;
    private int IDMatchCount;
    private ArrayList<Match> matchList;
    private ArrayList<Player> playerList;

    public void setIDMatchCount(int IDMatchCount) {
        this.IDMatchCount = IDMatchCount;
    }

    public int getIDMatchCount() {
        return IDMatchCount;
    }
    
    
    public wrapper(){
        matchList = new ArrayList<>();
        playerList = new ArrayList<>();
        IDCount = 0;
        IDImagesCount = 0;
    }
    
    public wrapper(ArrayList<Match> matchList, ArrayList<Player> playerList){
        this.matchList = matchList;
        this.playerList = playerList;
        IDCount = 0;
        IDImagesCount = 0;
    }
    
    public wrapper(ArrayList<Match> matchList, ArrayList<Player> playerList, Match started){
        this.matchList = matchList;
        this.playerList = playerList;
        IDCount = 0;
        IDImagesCount = 0;
    }

    public void setMatchList(ArrayList<Match> matchList) {
        this.matchList = matchList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }


    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }
    
    public void addMatch(Match match){
        matchList.add(match);
    }

    public int getIDCount() {
        return IDCount;
    }

    public void setIDCount(int IDCount) {
        this.IDCount = IDCount;
    }

    public int getIDImagesCount() {
        return IDImagesCount;
    }

    public void setIDImagesCount(int IDImagesCount) {
        this.IDImagesCount = IDImagesCount;
    }
    
    public int getIDImage(){
        IDImagesCount++;
        return IDImagesCount-1;
    }
    
    public int getID(){
        IDCount++;
        return IDCount-1;
    }
    
    public int getIDMatch(){
        IDMatchCount++;
        return IDMatchCount-1;
    }
    
    public void modPlayer(Player pl){
        for(int i = 0; i < playerList.size(); i++){
            if(pl.getIDp() == playerList.get(i).getIDp()){
                playerList.set(i, pl);
                return;
            }
        }
        System.out.println("Check out modPlayer");
        playerList.add(pl);
    }
    
    public void setMatch(Match match){
        for(int i = 0; i < matchList.size(); i++){
            if(match.getIDm() == matchList.get(i).getIDm()){
                matchList.set(i, match);
                return;
            }
        }
        matchList.add(match);
    }
    
}
