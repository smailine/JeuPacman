/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Smaïline
 */

public class Modele extends Observable{

    private Jeu jeu;
    
    public Modele(){
        this.jeu = new Jeu();
    }
    
    public Modele(Jeu jeu){
        this.jeu = jeu;
    }

    public Jeu getJeu() {
        return jeu;
    }
    
    
    
}
