/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import java.util.Scanner;

/**
 *
 * @author cardo
 */
public class FantomeNormal extends Fantome {

    public FantomeNormal(int x, int y, Grille grille) {
        super(x,y,grille);
    }

    /*public Dir choisirDirection(){
        Dir direction = null;

        
        switch(i){
            case 0:
                direction=Dir.b;
                break;
            case 1:
                direction=Dir.g;
                break;
            case 2:
                direction=Dir.h;
                break;
            case 3:
                direction=Dir.d;
                break;
        }
        return direction;
    }    a finir */

    @Override
    public void run() {
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
