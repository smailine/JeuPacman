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
        numVie=2;
    }
    
   public void mort(){
       if(numVie>0){
           numVie-=1;
       }
       else
           numVie=0;
   }
    
   public void manger(Pacman pac){
       if(pac.getModeTueur()==false && x==pac.getX() && y==pac.getY()){
            pac.perdreVie();
            if(pac.getNumVie()>0){pac.setPosition(5,2);}
            for(int i=0; i<grille.getVerticale(); i++){
                for (int j=0; j<grille.getHorizontale();j++){
                    if (grille.getElement(j, i)>3){
                        grille.setValeur(j,i,2);
                    }
                }
            }
       }
            
   }

    @Override
    public void run() {
        this.deplacement(Dir.d);
    }
    
    
}
