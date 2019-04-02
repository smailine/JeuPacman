/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Librairie.Dir;
import Librairie.Grille;
import modele.Fantome;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cardo
 * 
 */
/**
 * 
 * classe representant un fantome heritant de fantome 
 */
public class FantomeNormal extends Fantome{
    /**
     * 
     * @param x position horizontale 
     * @param y position verticale 
     * @param grille  grille atribue au fantome
     * constructeur qui attribue une position et une grille au fantome. donne la derniére position du fantome: droite
     */
    public FantomeNormal(int x, int y, Grille grille) {
        super(x,y,grille);
        derniereDirection=Dir.h;
        
        
    }
    
  
    
    /**
     * fonction qui gère les déplacements du fantôme et le permet de choisir sa 
     * position soit aléatoirement soit dans les croisements en choisissant la case de plus grande valeur 
     */
    @Override
    public void run(){
        
        if(y>=11 && y<=16 && x>=13 && x<=15)
            this.revivre();
        for (int j=0; j<grille.getCroisement().length-1;j++){
            if(grille.getCroisement()[j][0]==x){
                for(int k=1; k<grille.getCroisement()[j].length-1;k++)
                {
                    if (grille.getCroisement()[j][k]==y){
                       if(grille.getTab()[j][k]>80){
                            if(grille.getTab()[x+1][y]>grille.getTab()[x-1][y] && grille.getTab()[x+1][y]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x+1][y]>grille.getTab()[y][y-1]){
                                    derniereDirection=Dir.d;
                                    this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x-1][y]>grille.getTab()[x+1][y] && grille.getTab()[x-1][y]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x-1][y]>grille.getTab()[x][y-1])
                            {
                                derniereDirection=Dir.g;
                                this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x][y+1]>grille.getTab()[x+1][y] && grille.getTab()[x][y+1]>grille.getTab()[x-1][y]
                                    && grille.getTab()[x][y+1]>grille.getTab()[x][y-1]){
                                    derniereDirection=Dir.b;
                                    this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x][y-1]>grille.getTab()[x+1][y] && grille.getTab()[x][y-1]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x][y-1]>grille.getTab()[x-1][y]){
                                    derniereDirection=Dir.h;
                                    this.deplacement(derniereDirection);}     
                            }
                        }
                    }
                }
             
                else{
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
    }
  
}