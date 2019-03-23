/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

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
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,3,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,3,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
            {0,3,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,3,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,3,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,2,2,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,2,2,2,2,2,2,0,1,0,0,1,0,0,0,0,0,0},
            {0,3,1,1,1,1,1,1,1,1,0,2,2,2,2,2,2,0,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,1,0,0,1,0,2,2,2,2,2,2,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,3,1,1,1,1,1,1,1,1,1,1,3,0,0,1,1,1,1,1,1,1,1,1,1,1,3,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
         horizontale=tab.length;
         verticale=tab[0].length;
        // contient les croisement la ligne correspondant dans la grille croissement[i][0] et le reste pour les colones
        croisement=new int[][]{{1,1,6,12,15,21,26},
        {5,1,6,9,12,15,21,26},
        {8,1,6,9,12,15,21,26},
        {11,9,12,15,18},
        {14,6,9,18,21},
        {17,9,18},
        {20,1,6,9,12,15,18,21,26},
        {23,1,3,6,9,12,15,18,21,24,26},
        {26,1,3,6,9,12,15,18,21,24,26},
        {29,1,12,15,16}};

    }

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


    public void setNumFantomes(int numFantomes){
        this.numFantomes=numFantomes;
    }



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
}
