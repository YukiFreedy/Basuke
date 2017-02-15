/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yuki
 */
@XmlRootElement
public class wrapperID {
    private int IDCount;
    private int IDImagesCount;
    private int IDMatchCount;
    
    public wrapperID(){
        
    }

    public int getIDCount() {
        return IDCount;
    }

    public int getIDImagesCount() {
        return IDImagesCount;
    }

    public int getIDMatchCount() {
        return IDMatchCount;
    }

    public void setIDCount(int IDCount) {
        this.IDCount = IDCount;
    }

    public void setIDImagesCount(int IDImagesCount) {
        this.IDImagesCount = IDImagesCount;
    }

    public void setIDMatchCount(int IDMatchCount) {
        this.IDMatchCount = IDMatchCount;
    }
    
    
}
