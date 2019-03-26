/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import Librairie.newpackage.FantomeInnocent;
import Librairie.newpackage.Pacman;
import Librairie.newpackage.FantomeNormal;
import Librairie.newpackage.Fantome;
import Librairie.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import Librairie.newpackage.*;


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
    private FantomeNormal suFan;
    private int rapidite;

    public Jeu(){
       this.grille  = new Grille();
       this.pacman= new Pacman(grille);
       this.fan=new FantomeInnocent(14,12,grille);
       this.fanNorm=new FantomeNormal(15,14,grille);
       this.suFan=new FantomeNormal(14,13,grille);
       this.rapidite=300;
       
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
     public FantomeNormal getSuperFantome() {
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
                Thread.sleep(rapidite);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
public void setRapidite(int rap){rapidite=rap;}

    public static void main(String[] args) {
        Jeu j = new Jeu();
        //Entite e = new Entite(j.getGrille());
        
        Console c = new Console(j);
        j.addObserver(c);
        new Thread(j).start();
        
        
    }

}
