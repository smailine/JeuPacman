/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import Librairie.newpackage.Pacman;
import java.util.Observable;
import java.util.Observer;
import Librairie.*;
/**
 *
 * @author p1506559
 */


public class Console implements Observer{
    private Jeu jeu;
    
    public Console(){
        this.jeu = new Jeu();
    }
    
    public Console(Jeu jeu){
        this.jeu = jeu;
    }
    
    /**
     * Avec l'interface graphique, nous allons mettre des cases à afficher
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        Grille grille = this.jeu.getGrille();
        int tab[][] = grille.getTab();
        for(int i = 0;i<grille.getHorizontale();i++){
            for(int j = 0;j<grille.getVerticale();j++){
                if(this.jeu.getPacman().getX() == i && this.jeu.getPacman().getY() == j){
                    System.out.print(" "+"O");
                }else{
                    System.out.print(" "+tab[i][j]);
                }
                
            }
            
            
            System.out.print(" \n");
        }
        System.out.println("   ");
        this.jeu.getPacman().deplacement(Dir.b);
        System.out.println( "\n\nvie pacman: " + new Pacman(new Grille()).getNumVie()+"\n\n");
    }
}
