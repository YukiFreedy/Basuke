/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yuki
 */
@XmlRootElement
public class wrapperMatches {
    
    private ArrayList<Match> matchList;

    public wrapperMatches() {
        matchList = new ArrayList<>();
    }

    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(ArrayList<Match> matchList) {
        this.matchList = matchList;
    }
    
    
}
