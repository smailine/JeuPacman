/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie.newpackage;

import Librairie.Dir;
import Librairie.Entite;
import Librairie.Grille;

/**
 *
 * @author cardo
 */
public class Fantome extends Entite implements Runnable{
    protected int numVie;
    protected boolean modeTueur;
    public Fantome(int x, int y, Grille grille) {
        super(x, y, grille);
        numVie=2;
        modeTueur=true;
    }

    public int getNumVie() {
        return numVie;
    }

    

    public boolean isModeTueur() {
        return modeTueur;
    }

    
    
    
    
    public void revivre(){
        if(numVie>0)
            numVie=2;
    }
    
   public void mort(){
       if(numVie>0){
           numVie-=1;
           grille.setScore(grille.getScore()+200);
       }
       else
           numVie=0;
   }
    
   public void manger(Pacman pac){
       if(pac.getModeTueur()==false && x==pac.getX() && y==pac.getY() && this.numVie>1){
            pac.perdreVie();
            if(pac.getNumVie()>0){pac.setPosition(2,4);}
            for(int i=0; i<grille.getHorizontale(); i++){
                for (int j=0; j<grille.getVerticale();j++){
                    if (grille.getElement(j, i)>3){
                        grille.setValeur(j,i,2);
                    }
                }
            }
       }
            
   }

    @Override
    public void run() {
        if(y>=11 && y<=16 && x>=13 && x<=15)
            this.revivre();
        this.deplacement(Dir.d);
    }
    
    
}
