/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeu.Jeu;

/**
 *
 * @author cardo
 */
public class FantomeInnocent extends Fantome {

    public FantomeInnocent(int x, int y, Grille grille) {
        super(x,y,grille);
    }



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
