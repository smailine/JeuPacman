 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cardo
 * 
 */
/**
 * 
 * Une classe permettant de declarer une entité capable de se deplacer et 
 * changer de mode, s'il peut être en deux etats differents 
 */
public class Entite {
    protected int x,y;
    protected Grille grille;
    protected boolean modeTueur=false;
    protected Dir derniereDirection;

    /**
     * 
     * @param grille la grille qui sera attribue a l'entité
     * Constructeur qui prend un paramètre une grille et initialise la position de l'entité à (0,0)
     */
    public Entite(Grille grille){
        this.x = 0;
        this.y = 0;
        this.grille = grille;
        derniereDirection=null;
    }
   
    /**
     * 
     * @param x la position horizontale
     * @param y la position verticale
     * @param grille grille qui sera atribué a l'entité
     * Constructeur qui prend un paramètre une grille et la position (x,y) qui seront attribués à l'entité 
     */
     public Entite(int x, int y, Grille grille){
        this.x = x;
        this.y = y;
        this.grille = grille;
    }
     
     /**
      * 
      * @param deplacement instance de l'enumerable Dir
      * @return un Boolean 
      * la fonction qui permet de deplacer l'entite et nous permet de déterminer
      * grâce au retour sil'entité se déplace dans un couloir ou bien s'il s'est 
      * cogné contre un mur en fonction de la direction choisit
      * 
      */
    public boolean deplacement(Dir deplacement){
        
        boolean rencontreMur = false;
        int tab[][] = this.grille.getTab();
        switch(deplacement){
            case h:
                if(this.getY()-1>=0){
                    if(tab[y-1][x]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y-1);
                        derniereDirection=Dir.h;
                        rencontreMur = false;
                    }
                }
            break;
            case b:
                if(this.getY()+1<this.grille.getVerticale()){
                    if(tab[y+1][x]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y+1);
                        rencontreMur = false;
                        derniereDirection=Dir.b;
                    }
                }
            break;

            case d:
                if(this.getX()+1<this.grille.getHorizontale()){
                    if(tab[y][x+1]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x+1);
                        rencontreMur = false;
                        derniereDirection=Dir.d;
                    }
                }
            break;

            case g:
                if(this.getX()-1>=0){
                   if(tab[y][x-1]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x-1);
                        rencontreMur = false;
                        derniereDirection=Dir.g;
                    }
                }
            break;

        }

        return rencontreMur;
    }
/**
 * 
 * @return La dernière direction choisit par l’entité 
 */
    public Dir getDerniereDirection(){return derniereDirection;}
    
    /**
     * 
     * @return la position horizontal de l'entité 
     */
    public int getX(){
        return this.x;
    }
    /**
     * 
     * @return la position verticale de l'entité
     */
    public int getY(){
        return this.y;
    }
    /**
     * 
     * @return la grille dans laquel l'entité se trouve 
     */
    public Grille getGrille(){
        return this.grille;
    }
    /**
     * 
     * @param x position horizontale 
     * permet de changer la position horizontal de l'entité 
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * 
     * @param y position verticale 
     *  permet de changer la position vertical de l'entité 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 
     * @param grille la nouvelle grille de l'entite
     *  
     */
    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    /**
     * permet de changer le mode de l'entité s'il a deux modes differents 
     */
    public void changeMode(){ modeTueur=!modeTueur;}
    }


