/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import modele.Jeu;
import modele.Pacman;
import java.util.Observable;
import java.util.Observer;
import Librairie.*;
/**
 *
 * @author p1506559
 *
 */

/**
 * 
 *  classe permettant d'afficher la grille d'un jeu
 */
public class Console implements Observer{
    private Jeu jeu;
    /**
     * constructeur sans parametre 
     */
    public Console(){
        this.jeu = new Jeu();
    }
    /**
     * 
     * @param jeu 
     * constructeur qui permet d'atribuer un jeu à la console 
     */
    public Console(Jeu jeu){
        this.jeu = jeu;
    }
    
    /**
     * Avec l'interface graphique, nous allons mettre des cases à afficher
     * @param o les classe qui la console observer
     * @param arg  un objet
     * a chaque notification du jeu on affiche la ,grille du jeu avec la position du pacman
     */
    @Override
    public void update(Observable o, Object arg) {
        Grille grille = this.jeu.getGrille();
        int tab[][] = grille.getTab();
        for(int i = 0;i<grille.getVerticale();i++){
            for(int j = 0;j<grille.getHorizontale();j++){
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
