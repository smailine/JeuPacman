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
 * 
 */
/**
 * 
 * classe ou sont initalisées les composantes du jeu
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
/**
 * construteur du jeu qui lui attribue 1 FantomeInnocent, 2 FantomeNormal, une console,
 * un pacman, et une rapidité de réfléchissement un actif.
 */
    public Jeu(){
       this.grille  = new Grille();
       this.pacman= new Pacman(grille);
       this.fan=new FantomeInnocent(14,12,grille);
       this.fanNorm=new FantomeNormal(15,14,grille);
       this.suFan=new FantomeNormal(14,13,grille);
       this.rapidite=300;
       this.actif=false;
       
       
    }
    /**
     * 
     * @return la grille du jeu
     */
    public Grille getGrille() {
        return this.grille;
    }
    /**
     * 
     * @return le fantome Innocent
     */
    public Fantome getFantomeInnocent() {
        return fan;
    }
    /**
     * 
     * @return le premier fantome normal
     */
    public FantomeNormal getFantomeNormal() {
        return fanNorm;
    }
    /**
     * 
     * @return le deuxiéme fantome Normal
     */
     public FantomeNormal getFantomeNormal1() {
        return suFan;
    }
     /**
      * 
      * @return le pacman 
      */
    public Pacman getPacman() {
        return pacman;
    }
    
    /**
     * 
     * @param fant le fantome qui l'on veut savoir s'il a tout ses vies 
     * @return si le fantome à tout ces vies
     */
    public boolean totalVieFantome(Fantome fant){return fant.getNumVie()==2;}
    /**
     * 
     * @param fant le fantome qui l'on veut savoir s'il a la moitie ses vies 
     * @return si le fantome a la moitié de sa vie 
     */
    public boolean demiVieFantome(Fantome fant ){return fant.getNumVie()==1;}
    /**
     * 
     * @param x  position horizontale 
     * @param y position verticale
     * @return si la position x,y de la grille est un mur ou pas 
     */
    public boolean mur(int x, int y){return grille.getElement(x,y)==0;}
    /**
     * 
     * @param x position horizontale
     * @param y position verticale
     * @return si la position x,y de la grille est un pacgum ou pas 
     */
    public boolean pacgum(int x, int y){return grille.getElement(x,y)==1;}
    /**
     * 
     * @param x position horizontale
     * @param y position verticale
     * @return si la position x,y de la grille est un super pacgum ou pas 
     */
    public boolean superPacgum(int x, int y){return grille.getElement(x,y)==3;}

    /**
     * fonction permettant de réfléchir le jeu
     */
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
    /**
     * 
     * @param rap 
     * permet de changer la rapidité du Réfléchissement
     */
    public void setRapidite(int rap){rapidite=rap;}

    /**
     * permet de gerer l'interationentre le pacman et les differents fantomes
     * si le pacman est a la même position qu'unfantome et qu'il a manger un super pacgum 
     * il y a  moins de 10secondes il peut manger le fantome sinon il est manger
     */
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
            if(this.getFantomeNormal1().getX()==this.getPacman().getX() && this.getFantomeNormal1().getY()==this.getPacman().getY() ){
                        this.getPacman().manger(this.getFantomeNormal1());
                        this.getFantomeNormal1().manger(this.getPacman());
                    }
            else if(this.getFantomeNormal().getX()==this.getPacman().getX() && this.getFantomeNormal().getY()==this.getPacman().getY() ){
                        this.getPacman().manger(this.getFantomeNormal());
                        this.getFantomeNormal().manger(this.getPacman());
                    }
             else if(this.getFantomeInnocent().getX()==this.getPacman().getX() && this.getFantomeInnocent().getY()==this.getPacman().getY() ){
                this.getPacman().manger(this.getFantomeInnocent());
                this.getFantomeInnocent().manger(this.getPacman());
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
