/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yuki
 */
public class tonto {
    
    private ObservableList list;
    
    public tonto(){
        list = FXCollections.observableArrayList();
    }
    
    public ObservableList getList(){
        return list;
    }
    
}
