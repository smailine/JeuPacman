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
 */
public class Grille {
     private int tab[][];
     private int croisement[][];
     private int horizontale;
     private int verticale;
     private int score;
     private int numFantomes;

     // pack executeur

     @SuppressWarnings("empty-statement")
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
        
        numFantomes=4;

    }
    
     /*public void getSommetsAretes(){
         ArrayList<ArrayList<Integer>> sommet;
         ArrayList<ArrayList<Integer>> aretes=new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> som = new ArrayList<Integer>();
          ArrayList<Integer> ar = new ArrayList<Integer>();
         int k=0;
         sommet = new ArrayList<ArrayList<Integer>>();
         for(int i=0; i<tab.length;i++){
             for(int j=0; i<tab[0].length-1; j++){
                 if(tab[i][j]>0){
                     som.add(i);
                     som.add(j);
                     if( i>0){
                         if(tab[i-1][j]>0){
                             
                             }
                     }
                     k++;
                     
                 }
                 
             }
         }
}*/
     
     
     
    public int[][] getCroisement(){
    return croisement;}


    public int[][] getTab() {
        return tab;
    }

    public int getHorizontale() {
        return horizontale;
    }

    public int getVerticale() {
        return verticale;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public void setHorizontale(int horizontale) {
        this.horizontale = horizontale;
    }

    public void setVerticale(int verticale) {
        this.verticale = verticale;
    }
    public void setScore(int valeur){
    score+=valeur;}



    public int getScore(){
    return score;}

    public int getNumFantomes(){
        return numFantomes;
    }

    public int getValeur(int x, int y){
        int valeur=0;
        if(tab[x][y]==1){valeur=10;}
        else if(tab[x][y]==3){valeur=100;}
        return valeur;
    }
    
    public int getElement(int x, int y){return tab[x][y];}
    public void setValeur(int x, int y, int valeur){tab[x][y]=valeur;}
    
    
    
   
    
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
