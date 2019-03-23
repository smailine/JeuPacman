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
public class SuperFantome extends Fantome{
    
    public SuperFantome(int x, int y, Grille grille) {
        super(x,y,grille);
    }
    
    public static void main(String[] args ){
        Fantome a=new Fantome(14,16,new Grille());
        Pacman b=new Pacman(new Grille());
        b.manger(a);
        System.out.println(a.getNumVie());
    }
    
}
