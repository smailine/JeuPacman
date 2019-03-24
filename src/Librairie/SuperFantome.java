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
public class SuperFantome extends Fantome{
    private Pacman pac;
    public SuperFantome(int x, int y, Grille grille, Pacman pac) {
        super(x,y,grille);
        derniereDirection=Dir.h;
        this.pac=pac;
        
    }
    
    public static void main(String[] args ){
        Fantome a=new Fantome(14,16,new Grille());
        Pacman b=new Pacman(new Grille());
        b.manger(a);
        System.out.println(a.getNumVie());
    }
    /*@Override
    public void run(){
        for (int j=0; j<grille.getCroisement().length-1;j++){
            if(grille.getCroisement()[j][0]==x){
                for(int k=1; k<grille.getCroisement()[j].length-1;k++)
                {
                    if (grille.getCroisement()[j][k]==y){
                       
                            if(grille.getTab()[x+1][y]>grille.getTab()[x-1][y] && grille.getTab()[x+1][y]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x+1][y]>=grille.getTab()[y][y-1]){
                                    derniereDirection=Dir.b;
                                    this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x-1][y]>grille.getTab()[x+1][y] && grille.getTab()[x-1][y]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x-1][y]>grille.getTab()[x][y-1])
                            {
                                derniereDirection=Dir.h;
                                this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x][y+1]>grille.getTab()[x+1][y] && grille.getTab()[x][y+1]>grille.getTab()[x-1][y]
                                    && grille.getTab()[x][y+1]>=grille.getTab()[x][y-1]){
                                    derniereDirection=Dir.h;
                                    this.deplacement(derniereDirection);}
                            else if(grille.getTab()[x][y-1]>grille.getTab()[x+1][y] && grille.getTab()[x][y-1]>grille.getTab()[x][y+1]
                                    && grille.getTab()[x][y-1]>=grille.getTab()[x-1][y]){
                                    derniereDirection=Dir.h;
                                    this.deplacement(derniereDirection);
                                }
                            else{
                                if(abs(distancePacman()[0])>=abs(distancePacman()[0])){
                                    if(distancePacman()[0]<0){//pacman en bas (vers le haut pour le code )
                                        if(this.deplacement(Dir.h)){
                                            this.deplacement(Dir.h);
                                             derniereDirection=Dir.h;
                                        }
                                        else if(distancePacman()[1]<0 && this.deplacement(Dir.d)){
                                            this.deplacement(Dir.d);
                                             derniereDirection=Dir.d;
                                        }
                                        else if(distancePacman()[1]>=0 && this.deplacement(Dir.g)){
                                            this.deplacement(Dir.g);
                                             derniereDirection=Dir.g;
                                        }
                                        else{
                                            this.deplacement(Dir.b);
                                             derniereDirection=Dir.b;
                                        }
                                    }else{//pacman en haut (vers le haut dans le code )
                                           if(this.deplacement(Dir.b)){
                                            this.deplacement(Dir.b);
                                             derniereDirection=Dir.b;
                                        }
                                        else if(distancePacman()[1]<=0 && this.deplacement(Dir.d)){
                                            this.deplacement(Dir.d);
                                             derniereDirection=Dir.d;
                                        }
                                        else if(distancePacman()[1]>=0 && this.deplacement(Dir.g)){
                                            this.deplacement(Dir.g);
                                             derniereDirection=Dir.g;
                                        }
                                        else{
                                            this.deplacement(Dir.h);
                                             derniereDirection=Dir.h;
                                        }    
                                    }

                                }else{
                                    if(distancePacman()[1]<0){//pacman en droite (vers la droite pour le code )
                                    if(this.deplacement(Dir.d)){
                                        this.deplacement(Dir.d);
                                         derniereDirection=Dir.d;
                                    }
                                    else if(distancePacman()[0]<=0 && this.deplacement(Dir.h)){
                                        this.deplacement(Dir.h);
                                         derniereDirection=Dir.h;
                                    }
                                    else if(distancePacman()[0]>=0 && this.deplacement(Dir.b)){
                                        this.deplacement(Dir.b);
                                         derniereDirection=Dir.b;
                                    }
                                    else{
                                        this.deplacement(Dir.g);
                                         derniereDirection=Dir.g;
                                    }
                                }else{//pacman en haut (vers le haut dans le code )
                                       if(this.deplacement(Dir.g)){
                                        this.deplacement(Dir.g);
                                         derniereDirection=Dir.g;
                                    }
                                    else if(distancePacman()[0]<=0 && this.deplacement(Dir.h)){
                                        this.deplacement(Dir.h);
                                         derniereDirection=Dir.h;
                                    }
                                    else if(distancePacman()[0]>=0 && this.deplacement(Dir.b)){
                                        this.deplacement(Dir.b);
                                         derniereDirection=Dir.h;
                                    }
                                    else{
                                        this.deplacement(Dir.d);
                                         derniereDirection=Dir.h;
                                    }    
                                }
                                
                            }
                            
                            }
                    }
                }
            }
             
            else{
                if(10<x && x<18 && 10<y && y<18){
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
                           derniereDirection=Dir.h;
                    }
                }else{
                      if(abs(distancePacman()[0])>=abs(distancePacman()[0])){
            if(distancePacman()[0]<0){//pacman en bas (vers le haut pour le code )
                if(this.deplacement(Dir.h)){
                    this.deplacement(Dir.h);
                     derniereDirection=Dir.h;
                }
                else if(distancePacman()[1]<0 && this.deplacement(Dir.d)){
                    this.deplacement(Dir.d);
                     derniereDirection=Dir.d;
                }
                else if(distancePacman()[1]>=0 && this.deplacement(Dir.g)){
                    this.deplacement(Dir.g);
                     derniereDirection=Dir.g;
                }
                else{
                    this.deplacement(Dir.b);
                     derniereDirection=Dir.b;
                }
            }else{//pacman en haut (vers le haut dans le code )
                   if(this.deplacement(Dir.b)){
                    this.deplacement(Dir.b);
                     derniereDirection=Dir.b;
                }
                else if(distancePacman()[1]<=0 && this.deplacement(Dir.d)){
                    this.deplacement(Dir.d);
                     derniereDirection=Dir.d;
                }
                else if(distancePacman()[1]>=0 && this.deplacement(Dir.g)){
                    this.deplacement(Dir.g);
                     derniereDirection=Dir.g;
                }
                else{
                    this.deplacement(Dir.h);
                     derniereDirection=Dir.h;
                }    
            }

        }else{
            if(distancePacman()[1]<0){//pacman en droite (vers la droite pour le code )
            if(this.deplacement(Dir.d)){
                this.deplacement(Dir.d);
                 derniereDirection=Dir.d;
            }
            else if(distancePacman()[0]<=0 && this.deplacement(Dir.h)){
                this.deplacement(Dir.h);
                 derniereDirection=Dir.h;
            }
            else if(distancePacman()[0]>=0 && this.deplacement(Dir.b)){
                this.deplacement(Dir.b);
                 derniereDirection=Dir.b;
            }
            else{
                this.deplacement(Dir.g);
                 derniereDirection=Dir.g;
            }
        }else{//pacman en haut (vers le haut dans le code )
               if(this.deplacement(Dir.g)){
                this.deplacement(Dir.g);
                 derniereDirection=Dir.g;
            }
            else if(distancePacman()[0]<=0 && this.deplacement(Dir.h)){
                this.deplacement(Dir.h);
                 derniereDirection=Dir.h;
            }
            else if(distancePacman()[0]>=0 && this.deplacement(Dir.b)){
                this.deplacement(Dir.b);
                 derniereDirection=Dir.h;
            }
            else{
                this.deplacement(Dir.d);
                 derniereDirection=Dir.h;
            }    
         }
                    
                
            }
        }
            
    }}}/*
    
    public int[] distancePacman(){
        return new int[]{x-pac.getX(), y-pac.getY()};
    }

    
    /*public void run(){
             derniereDirection=Dir.b;
        deplacement(Dir.h);
        if((x<16 && x>11)&& (y>8 && y<16)){
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
        else if(abs(distancePacman()[0])>=abs(distancePacman()[0])){
            if(distancePacman()[0]<0){//pacman en bas (vers le haut pour le code )
                if(this.deplacement(Dir.h)){
                    this.deplacement(Dir.h);
                     derniereDirection=Dir.h;
                }
                else if(distancePacman()[1]<0 && this.deplacement(Dir.d)){
                    this.deplacement(Dir.d);
                     derniereDirection=Dir.d;
                }
                else if(distancePacman()[1]>=0 && this.deplacement(Dir.g)){
                    this.deplacement(Dir.g);
                     derniereDirection=Dir.g;
                }
                else{
                    this.deplacement(Dir.b);
                     derniereDirection=Dir.b;
                }
            }else{//pacman en haut (vers le haut dans le code )
                   if(this.deplacement(Dir.b)){
                    this.deplacement(Dir.b);
                     derniereDirection=Dir.b;
                }
                else if(distancePacman()[1]<=0 && this.deplacement(Dir.d)){
                    this.deplacement(Dir.d);
                     derniereDirection=Dir.d;
                }
                else if(distancePacman()[1]>=0 && this.deplacement(Dir.g)){
                    this.deplacement(Dir.g);
                     derniereDirection=Dir.g;
                }
                else{
                    this.deplacement(Dir.h);
                     derniereDirection=Dir.h;
                }    
            }

        }else{
            if(distancePacman()[1]<0){//pacman en droite (vers la droite pour le code )
            if(this.deplacement(Dir.d)){
                this.deplacement(Dir.d);
                 derniereDirection=Dir.d;
            }
            else if(distancePacman()[0]<=0 && this.deplacement(Dir.h)){
                this.deplacement(Dir.h);
                 derniereDirection=Dir.h;
            }
            else if(distancePacman()[0]>=0 && this.deplacement(Dir.b)){
                this.deplacement(Dir.b);
                 derniereDirection=Dir.b;
            }
            else{
                this.deplacement(Dir.g);
                 derniereDirection=Dir.g;
            }
        }else{//pacman en haut (vers le haut dans le code )
               if(this.deplacement(Dir.g)){
                this.deplacement(Dir.g);
                 derniereDirection=Dir.g;
            }
            else if(distancePacman()[0]<=0 && this.deplacement(Dir.h)){
                this.deplacement(Dir.h);
                 derniereDirection=Dir.h;
            }
            else if(distancePacman()[0]>=0 && this.deplacement(Dir.b)){
                this.deplacement(Dir.b);
                 derniereDirection=Dir.h;
            }
            else{
                this.deplacement(Dir.d);
                 derniereDirection=Dir.h;
            }    
        }
    }
      
    }*/
}