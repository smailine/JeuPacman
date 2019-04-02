
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Librairie.Dir;
import Librairie.Entite;
import Librairie.Grille;
import modele.Fantome;
import java.util.Scanner;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Scanner;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author cardo
 *
 */
/**
 * 
 *  classe pacman avec tous ces caractéristiques
 */
public class Pacman extends Entite{
    
    private int numVie=3;
   /**
    * 
    * @param grille grille atribue au pacman
    * Constructeur qui attribue une grille au pacman et le donne 3 vie et le met en mode proie
    */

    public Pacman(Grille grille) {
        super(2,4,grille);
        numVie=3;
        modeTueur=false;
    }


/**
 * fonction qui permet à l'utilisateur de chosir une direction: d,g,h,b
 */
    public void choisirDirection(){
        char d='a';
        Scanner sc = new Scanner(System.in);
        while( d!='d'|| d!='b'||d!='h'||d!='g'|| d!='D'|| d!='B'||d!='H'||d!='G'){
            d=sc.next().charAt(0);
        }
    }
    /**
     * 
     * @param f le fantome qui interagit avec le pacman
     * fonction qui permettra au pacman de manger des fantomes
     */
    public void manger(Fantome f){
        if(f.getNumVie()>0 && this.getModeTueur())
            f.mort();
    }
    
    /**
     * 
     * @param x position horizontale 
     * @param y position verticale
     * donne une position (x,y) au pacman
     */

    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * diminue le mumbre de vie du pacman
     */
    public void perdreVie(){
        if(numVie>0)
            numVie-=1;
    }
    
    /**
     * 
     * @return si le pacman est en predateur ou pas 
     */
    public boolean getModeTueur(){return modeTueur;}
    /**
     * 
     * @return le nombre de vie du pacman
     */
    public int getNumVie(){return numVie;}
    /**
     * 
     * @return dir si le pacman a perdu des vies ou pas 
     */
    public boolean totalVie(){return numVie==3;}
    /**
     * 
     * @return si le pacman est mort ou pas 
     */
    public boolean mort(){return numVie==0;}


/**
 * 
 * @param deplacement la prochain deplacement du pacman
 * gere le deplacement du pacman et mets a jour le score de la grille et augmente 
 * la valeur de la case ou pacman viens passer toute en diminuant ce qu'on une valeur superieur à 3 de 4 
 * @return si le pacman a retrouvé un mur ou pas 
 */
  public boolean deplacement(Dir deplacement){

        boolean rencontreMur = false;
        int tab[][] = this.grille.getTab();
        if(numVie>0){
        switch(deplacement){
            case h:
                if(this.getY()-1>=0){
                    if(tab[y-1][x]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y-1);
                        derniereDirection=Dir.h;
                        rencontreMur = false;
                        miseAjourScoreGrille();
                    }
                }else{
                    this.setY(grille.getVerticale()-1);
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
                        miseAjourScoreGrille();
                    }
                }else{
                    this.setY(0);
                }
            break;

            case d:
                if(this.getX()<this.grille.getHorizontale()-1){
                    if(tab[y][x+1]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x+1);
                        rencontreMur = false;
                        derniereDirection=Dir.d;
                        miseAjourScoreGrille();
                    }
                }else{
                    this.setX(0);
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
                        miseAjourScoreGrille();
                    }
                }else{
                    this.setX(grille.getHorizontale()-1);
                }
            break;

        }
        }
          for(int i = 0;i<grille.getVerticale();i++){
          for(int j = 0;j<grille.getHorizontale();j++){
              if(grille.getTab()[i][j]>3){

                  grille.setValeur(j,i,grille.getElement(j, i)-4);

              }
              else{
              grille.setValeur(y,x,2);}
          }
        }

        return rencontreMur;
    }

  /**
   * mise a jour du score et la valeur de case de la grille où le pacman se trouve
   * et changer le mode vers le mode predateur si le pacman a mange un super pacgum
   */
  public void miseAjourScoreGrille(){
      grille.setScore(grille.getValeur(y, x));
      if(grille.getValeur(y, x)==100 && !this.modeTueur){this.changeMode();}
      grille.setValeur(y, x, 4002);               
  }


}
