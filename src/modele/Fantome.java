/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Librairie.Dir;
import Librairie.Entite;
import Librairie.Grille;

/**
 *
 * @author cardo
 *
 */
/**
 * 
 *  Classe Fantome avec toute les caractéristique d'un fantome heritant d'entite
 */
public class Fantome extends Entite implements Runnable{
    protected int numVie;
    protected boolean modeTueur;
    /**
     * 
     * @param x position horizontale 
     * @param y position verticale 
     * @param grille grille attribué au fantome 
     * constructeur permettant de donner une position et une grille au fantome, ainsi qui 2 vies et un mode Tueur à true.
     */
    public Fantome(int x, int y, Grille grille) {
        super(x, y, grille);
        numVie=2;
        modeTueur=true;
    }
/**
 * 
 * @return un entier entre 0 et 2
 * le numbre de vie qui reste au fantome 
 */
    public int getNumVie() {
        return numVie;
    }

    
/**
 * 
 * @return mode du fantomes
 * le mode actuel du fantome 
 */
    public boolean isModeTueur() {
        return modeTueur;
    }

    
    
    /**
     * permet au fantome de gagner vie s'il est mort ou demi-mort
     */
    
    public void revivre(){
        if(numVie>0)
            numVie=2;
    }
    
    /**
     * fait perdre une vie au fantome s'il est vivant
     */
   public void mort(){
       if(numVie>0){
           numVie-=1;
           grille.setScore(grille.getScore()+200);
       }
       else
           numVie=0;
   }
    
   /**
    * 
    * @param pac le pacman qui interagit avec lui
    * permet au fantome de manger le pacman s'il le peut. Si son mode predateur est activé 
    */
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
/**
 * fonction sui gere de deplacement du fantome dans ce cas toujours a droite
 */
    @Override
    public void run() {
        if(y>=11 && y<=16 && x>=13 && x<=15)
            this.revivre();
        this.deplacement(Dir.d);
    }
    
    
}
