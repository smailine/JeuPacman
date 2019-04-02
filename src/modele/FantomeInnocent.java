package modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Librairie.Grille;
import Librairie.Dir;
import modele.Fantome;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cardo
 * 
 */
/**
 * 
 * classe representant un fantome heritant de fantome avec une deplacement aleatoire
 */
public class FantomeInnocent extends Fantome {
/**
 * 
 * @param x position horizontale.
 * @param y position verticale. 
 * @param grille la grille atribue au fantome.
 * constructeur qui attribue une position et une grille au fantome.
 */
    public FantomeInnocent(int x, int y, Grille grille) {
        super(x,y,grille);
    }



    
    /**
     * permet de gerer les deplacements du fantome 
     */
    @Override
    public void run() {
        
        if(y>=11 && y<=16 && x>=13 && x<=15)
            this.revivre();
        int nombreChoisi = 1 + (int) (Math.random()*((4 - 1)+1));
        if(nombreChoisi == 1){
            this.deplacement(Dir.d);
        }else if(nombreChoisi == 2){
            this.deplacement(Dir.g);
        }else if(nombreChoisi == 3){
            this.deplacement(Dir.h);
        }else{
            this.deplacement(Dir.b);
        }

    }

}
