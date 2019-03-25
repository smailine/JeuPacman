/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librairie;

import static java.lang.Math.abs;

/**
 *
 * @author cardo
 */
public class FantomeNormal extends Fantome{
    public FantomeNormal(int x, int y, Grille grille) {
        super(x,y,grille);
        derniereDirection=Dir.h;
        
        
    }
    
    public static void main(String[] args ){
        Fantome a=new Fantome(14,16,new Grille());
        Pacman b=new Pacman(new Grille());
        b.manger(a);
        System.out.println(a.getNumVie());
    }
    @Override
    public void run(){
        for (int j=0; j<grille.getCroisement().length-1;j++){
            if(grille.getCroisement()[j][0]==x){
                for(int k=1; k<grille.getCroisement()[j].length-1;k++)
                {
                    if (grille.getCroisement()[j][k]==y){
                       if(grille.getTab()[j][k]>80){
                            if(grille.getTab()[x+1][y]>grille.getTab()[x-1][y] && grille.getTab()[x+1][y]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x+1][y]>grille.getTab()[y][y-1]){
                                    derniereDirection=Dir.b;
                                    this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x-1][y]>grille.getTab()[x+1][y] && grille.getTab()[x-1][y]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x-1][y]>grille.getTab()[x][y-1])
                            {
                                derniereDirection=Dir.h;
                                this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x][y+1]>grille.getTab()[x+1][y] && grille.getTab()[x][y+1]>grille.getTab()[x-1][y]
                                    && grille.getTab()[x][y+1]>grille.getTab()[x][y-1]){
                                    derniereDirection=Dir.h;
                                    this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x][y-1]>grille.getTab()[x+1][y] && grille.getTab()[x][y-1]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x][y-1]>grille.getTab()[x-1][y]){
                                    derniereDirection=Dir.h;
                                    this.deplacement(derniereDirection);}
                            /*else {
                                int nombreChoisi = 1 + (int) (Math.random()*((4 - 1)+1));
                                if(nombreChoisi == 1){
                                    this.deplacement(Dir.d);
                                    derniereDirection=Dir.d;
                                }else if(nombreChoisi == 2){
                                    this.deplacement(Dir.g);
                                    derniereDirection=Dir.g;
                                }else if(nombreChoisi == 3){
                                    this.deplacement(Dir.h);
                                    derniereDirection=Dir.h;
                                }else{
                                     this.deplacement(Dir.b);
                                    derniereDirection=Dir.b;
                                    }
                                }*/
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