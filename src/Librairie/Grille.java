/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cardo
 * 
 */
/**
 * 
 * classe permettant de déclarer  et de gerer une grille de jeu, en utilisant des entiers
 */
public class Grille {
     private int tab[][];
     private int croisement[][];
     private int horizontale;
     private int verticale;
     private int score;
    

     // pack executeur

     @SuppressWarnings("empty-statement")
     /**
      * Constructeur permettant de déclarer une grille de taille 28*27 et lister les croisements.
      */
    public Grille(){
        tab= new int [][]{
            {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
            {0,3,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,3,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {1,3,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,3,1},
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,3,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,2,2,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,2,2,2,2,2,2,2,2,1,0,0,1,0,0,0,0,0,0},
            {1,3,1,1,1,1,1,1,1,1,0,2,2,2,2,2,2,0,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,1,0,0,1,0,2,2,2,2,2,2,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,2,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,3,1,1,1,1,1,1,1,1,1,1,3,0,0,1,1,1,1,1,1,1,1,1,1,1,3,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1},
            {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
            {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0}
            
        };
         horizontale=tab[0].length;
         verticale=tab.length;
        // contient les croisement la ligne correspondant dans la grille croissement[i][0] et le reste pour les colones
        croisement=new int[][]{{1,1,6,12,15,21,26},
        {4,1,6,9,12,15,21,26},
        {7,1,6,9,12,15,21,26},
        {10,9,12,13,14,15,18},
        {13,6,9,18,21},
        {16,9,18},
        {19,1,6,9,12,15,18,21,26},
        {22,1,3,6,9,12,15,18,21,24,26},
        {25,1,3,6,9,12,15,18,21,24,26},};
        
       

    }
    

     
     /**
      * 
      * @return la liste de croisement, dont le premier element est la position verticale 
      * et les autres on se situe le croisement horizontalement 
      */
     
    public int[][] getCroisement(){
    return croisement;}


    /**
     * 
     * @return la grille 
     */
    public int[][] getTab() {
        return tab;
    }
    /**
     * 
     * @return renvoie le nombre de cases horizontale
     */
    public int getHorizontale() {
        return horizontale;
    }
/**
 * 
 * @return le nombre de cases verticales 
 */
    public int getVerticale() {
        return verticale;
    }
/**
 * 
 * @param tab 
 * permet de mettre une nouvelle table dans la grille
 */
    public void setTab(int[][] tab) {
        this.tab = tab;
    }
/**
 * 
 * @param horizontale 
 * permet de rentrer une nouvelle la taille horizontale
 */
    public void setHorizontale(int horizontale) {
        this.horizontale = horizontale;
    }
    /**
     * 
     * @param verticale 
     * permet de rentrer une nouvelle la taille verticale 
     */

    public void setVerticale(int verticale) {
        this.verticale = verticale;
    }
    
    /**
     * 
     * @param valeur 
     * permet de mettre a jour le score 
     */
    public void setScore(int valeur){
    score+=valeur;}


/**
 * 
 * @return le score actuel
 */
    public int getScore(){
    return score;}

   
/**
 * 
 * @param x position horizontale 
 * @param y position verticale 
 * @return la valeur a augmenter dans le ecore un fonction de la case x,y
 */
    public int getValeur(int x, int y){
        int valeur=0;
        if(tab[x][y]==1){valeur=10;}
        else if(tab[x][y]==3){valeur=100;}
        return valeur;
    }
    /**
     * 
     * @param x position horizontale 
     * @param y position verticale 
     * @return la valeur reel de la case x,y de la grille
     */
    public int getElement(int x, int y){return tab[x][y];}
    /**
     * 
     * @param x position horizontale 
     * @param y position verticale
     * @param valeur un entier
     * permet de mettre une certaine valeur dans la case x,y
     */
    public void setValeur(int x, int y, int valeur){tab[x][y]=valeur;}
    
    
    
   
    
     
     /**
      * renvoie la grille en forme de string
      */
    @Override
    public String toString(){
        String a="";
        for(int i=0; i<tab.length;i++){
            a+="    ";
            
        for(int j=0; j<tab[0].length;j++)
        {
            a+=tab[i][j]+"  ";
        }
        a+="   \n";
            }
        return a;
    }
    /**
     * 
     * @return boolean permettant de savoir si toute la grille a été visité 
     */
    public boolean ttGrilleVisite(){
        boolean a=true;
        for(int i=0; i<tab.length;i++){
            for(int j=0; j<tab[0].length;j++){
                if(tab[i][j]==1 ||tab[i][j]==3){
                    a=false;
                }
            }
        }
        return a;
    }
}
