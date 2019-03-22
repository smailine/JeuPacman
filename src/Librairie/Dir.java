/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

/**
 *
 * @author p1506559
 */
public enum Dir {
    
    h("h",1),
    b("b",-1),
    g("g",-1),
    d("d",1);
    
    private String deplacement = "";
    private int coord = 0;
    
    Dir(String deplacement,int coord){
        this.deplacement = deplacement;
        this.coord = coord;
    }
    
    public int getCoordonnee(){
        return this.coord;
    }
    
    public String toString(){
        return this.deplacement;
    }
    
    

}
