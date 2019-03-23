
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
        if(pacgum==0){
            grille.setScore(grille.getScore()+10);}
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

}
