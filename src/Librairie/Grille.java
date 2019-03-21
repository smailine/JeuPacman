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
public class Grille {
     private int tab[][];
     private int horizontale;
     private int verticale;
     
     
    public Grille(){
       this.setHorizontale(10); 
       this.setVerticale(10);
       this.tab = new int [][]
               {
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0},
                    {1,1,1,0,1,0,1,0,0,0}
                };
     
        /*for(int i = 0;i<this.horizontale;i++){
            for(int j = 0;j<this.verticale;j++){
                if(j%2==0){
                  this.tab[i][j] = 0;
                }else{
                  this.tab[i][j] = 1;
                }  
            }
            
        }*/
        
        
    }
    
    public Grille(int x, int y){
        this.tab = new int [x][y];
        
        for(int i = 0;i<this.horizontale;i++){
            for(int j = 0;j<this.verticale;j++){
                if(j%2==0){
                  this.tab[i][j] = 0;
                }else{
                  this.tab[i][j] = 1;
                }  
            }
            
        }
    }

     
     
    
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
    
   
   
}
