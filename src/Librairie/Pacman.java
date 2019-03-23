
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
        super(5,2,grille);
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
            grille.setScore(grille.getScore()+10);
            
        }
        else if(pacgum==3){
            grille.setScore(grille.getScore()+100);
           changeMode();
        }
    }


    public void manger(Fantome f){
        if(f.getNumVie()>0 && this.getModeTueur()==true)
            f.setNumVie(f.getNumVie()-1);
    }


    public void perdreVie(){
        if(numVie>0)
            numVie-=1;
    }
    public boolean getModeTueur(){return modeTueur;}
    public int getNumVie()
    {return numVie;}



  public boolean deplacement(Dir deplacement){
        for(int i = 0;i<grille.getHorizontale();i++){
          for(int j = 0;j<grille.getVerticale();j++){
              if(grille.getTab()[i][j]>3){
                  grille.setValeur(x,y,grille.getValeur(x, y)-4);
              }
          }
        }// mise à jour des feremones
        System.out.println(deplacement);
        boolean rencontreMur = false;
        int tab[][] = this.grille.getTab();
        switch(deplacement){
            case h:
                if(this.getX()-1>=0){
                    if(tab[x-1][y]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x-1);
                        derniereDirection=Dir.h;
                        rencontreMur = false;
                        grille.setScore(grille.getValeur(x, y));
                        grille.setValeur(x, y, 104);
                    }
                }
            break;
            case b:
                if(this.getX()+1<this.grille.getVerticale()){
                   if(tab[x+1][y]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x+1);
                        rencontreMur = false;
                        derniereDirection=Dir.b;
                        grille.setScore(grille.getValeur(x, y));
                        grille.setValeur(x, y, 104);
                    }
                }
            break;

            case d:
                if(this.getY()+1<this.grille.getHorizontale()){
                    if(tab[x][y+1]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y+1);
                        rencontreMur = false;
                        derniereDirection=Dir.d;
                        grille.setScore(grille.getValeur(x, y));
                        grille.setValeur(x, y, 104);
                    }
                }
            break;

            case g:
                if(this.getY()-1>=0){
                   if(tab[x][y-1]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y-1);
                        rencontreMur = false;
                        derniereDirection=Dir.g;
                        grille.setScore(grille.getValeur(x, y));
                        grille.setValeur(x, y, 4002);
                    }
                }
            break;

        }

        return rencontreMur;
    }
}

