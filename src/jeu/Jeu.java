/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import Librairie.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author p1506559
 */
public class Jeu extends Observable implements Runnable{

    /**
     * @param args the command line arguments
     */
    private Grille grille;
    private Console console;
    private Pacman pacman;
    private FantomeInnocent fan;
    private FantomeNormal fanNorm;
    private SuperFantome suFan;

    public Jeu(){
       this.grille  = new Grille();
       this.pacman= new Pacman(grille);
       this.fan=new FantomeInnocent(14,12,grille);
       this.fanNorm=new FantomeNormal(15,14,grille);
       this.suFan=new SuperFantome(14,13,grille,pacman);
    }

    public Grille getGrille() {
        return this.grille;
    }

    public Fantome getFantome() {
        return fan;
    }
    public FantomeNormal getFantomeNormal() {
        return fanNorm;
    }
     public SuperFantome getSuperFantome() {
        return suFan;
    }
    public Pacman getPacman() {
        return pacman;
    }
    



    public void run(){
        /*try{
           Thread.sleep(1000);
           this.console.notify();
           run();
        } catch (InterruptedException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        while(true){
            setChanged();
            notifyObservers();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


    public static void main(String[] args) {
        Jeu j = new Jeu();
        //Entite e = new Entite(j.getGrille());
        
        Console c = new Console(j);
        j.addObserver(c);
        new Thread(j).start();
        
        
    }

}
