/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import modele.FantomeInnocent;
import modele.Pacman;
import modele.FantomeNormal;
import modele.Fantome;
import Librairie.*;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
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
    private FantomeNormal suFan;
    private int rapidite;
    private boolean actif;

    public Jeu(){
       this.grille  = new Grille();
       this.pacman= new Pacman(grille);
       this.fan=new FantomeInnocent(14,12,grille);
       this.fanNorm=new FantomeNormal(15,14,grille);
       this.suFan=new FantomeNormal(14,13,grille);
       this.rapidite=300;
       this.actif=false;
       
       
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
    
    public boolean totalVieFantome(Fantome fant){return fant.getNumVie()==2;}
    public boolean demiVieFantome(Fantome fant ){return fant.getNumVie()==1;}
    public boolean mur(int x, int y){return grille.getElement(x,y)==0;}
    public boolean pacgum(int x, int y){return grille.getElement(x,y)==1;}
    public boolean superPacgum(int x, int y){return grille.getElement(x,y)==1;}

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


     public void interationFantomePacman(){
             if(this.getPacman().getModeTueur() && !actif){
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask(){
                        public void run(){
                            getPacman().changeMode();
                            actif=false;
                            setRapidite(200);
                        }
                        }, 10000);
                        actif=true;
                    }
            if(this.getSuperFantome().getX()==this.getPacman().getX() && this.getSuperFantome().getY()==this.getPacman().getY() ){
                        this.getPacman().manger(this.getSuperFantome());
                        this.getSuperFantome().manger(this.getPacman());
                    }
            else if(this.getFantomeNormal().getX()==this.getPacman().getX() && this.getFantomeNormal().getY()==this.getPacman().getY() ){
                        this.getPacman().manger(this.getFantomeNormal());
                        this.getFantomeNormal().manger(this.getPacman());
                    }
             else if(this.getFantome().getX()==this.getPacman().getX() && this.getFantome().getY()==this.getPacman().getY() ){
                this.getPacman().manger(this.getFantome());
                this.getFantome().manger(this.getPacman());
             }
    }
    public static void main(String[] args) {
        Jeu j = new Jeu();
        //Entite e = new Entite(j.getGrille());
        
        Console c = new Console(j);
        j.addObserver(c);
        new Thread(j).start();
        System.out.println(j.getGrille().toString());
        
        
    }

}
