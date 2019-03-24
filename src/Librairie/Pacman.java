
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import java.util.Scanner;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Scanner;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author cardo
 */
public class Pacman extends Entite{
    private int numVie;
    private boolean modeTueur;

    public Pacman(Grille grille) {
        super(2,5,grille);
        numVie=3;
        modeTueur=false;
    }



    public void choisirDirection(){
        char d='a';
        Scanner sc = new Scanner(System.in);
        while( d!='d'|| d!='b'||d!='h'||d!='g'|| d!='D'|| d!='B'||d!='H'||d!='G'){
            d=sc.next().charAt(0);
        }
    }


    public void manger(int pacgum){
        if(pacgum==1){
            grille.setScore(grille.getScore()+10);}
        else if(pacgum==3){
            grille.setScore(grille.getScore()+100);
           changeMode();
        }
    }


    public void manger(Fantome f){
        if(f.getNumVie()>0 && this.getModeTueur()==true)
            f.mort();
    }


    public void perdreVie(){
        if(numVie>0)
            numVie-=1;
    }
    public boolean getModeTueur(){return modeTueur;}
    public int getNumVie(){return numVie;}



  public boolean deplacement(Dir deplacement){
        for(int i = 0;i<grille.getVerticale();i++){
          for(int j = 0;j<grille.getHorizontale();j++){
              if(grille.getTab()[i][j]>3){

                  grille.setValeur(j,i,grille.getElement(j, i)-4);

              }
              else{
              grille.setValeur(y,x,2);}
          }
        }// mise à jour des feremones
        
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
                        grille.setScore(grille.getValeur(y, x));
                        grille.setValeur(y, x, 4002);
                        if(grille.getValeur(y, x)==100){this.changeMode();}
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
                        grille.setScore(grille.getValeur(y, x));
                        grille.setValeur(y, x, 4002);
                        if(grille.getValeur(y, x)==100){this.changeMode();}
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
                        grille.setScore(grille.getValeur(y, x));
                        grille.setValeur(y, x, 4002);
                        if(grille.getValeur(y, x)==100){this.changeMode();}
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
                        grille.setScore(grille.getValeur(y, x));
                        grille.setValeur(y, x, 4002);
                        if(grille.getValeur(y, x)==100){this.changeMode();}
                    }
                }else{
                    this.setX(grille.getHorizontale()-1);
                }
            break;

        }

        return rencontreMur;
    }
  /* public static void main(String[] args) {
       
   System.out.println( "\n\nvie pacman: " + new Pacman(new Grille()).getNumVie()+"\n\n");
   }*/
}
