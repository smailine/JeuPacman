/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

/**
 *
 * @author cardo
 */
public class SuperFantome extends Fantome {
    Pacman pac;
    public SuperFantome(int x, int y, Grille grille, Pacman pac) {
        super(x, y, grille);
        this.pac=pac;
    }
    
    public int[] distancePacman(){return new int[]{x-pac.getX(),y-pac.getY()};}
    @Override
    
    
    public void run(){
        
        
    }
    
}
