/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

/**
 *
 * @author p1506559
 * 
 */
/**
 * classe permettant d'énumérer les directions droite(d), gauche(g), haut(h) et bas(b)
 *
 */
public enum Dir {
    
    h("h",1),
    b("b",-1),
    g("g",-1),
    d("d",1);
    
    private String deplacement = "";
    private int coord = 0;
    /**
    Constructeur permettant de donner une direction droite(d), gauche(g), haut(h) et bas(b), et une coordonnée soit 1 soit -1
    */
    Dir(String deplacement,int coord){
        this.deplacement = deplacement;
        this.coord = coord;
    }
    /**
     * 
     * @return un entier 1 ou -1 en fonction de la direction
     */
    public int getCoordonnee(){
        return this.coord;
    }
    
    /**
     * 
     * @return un string soit d,g,b ou h
     */
    public String toString(){
        return this.deplacement;
    }
    
    

}
