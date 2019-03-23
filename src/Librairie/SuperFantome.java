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
    @Override
    public void run(){
        Dir d=this.getDerniereDirection();
        
        for (int j=0; j<grille.getCroisement().length-1;j++){
            if(grille.getCroisement()[j][0]==x){
                for(int k=1; k<grille.getCroisement()[j].length-1;k++)
                {
                    if (grille.getCroisement()[j][k]==y){
                        if(grille.getTab()[j][k]<80){
                            if(grille.getTab()[j+1][k]>grille.getTab()[j-1][k] && grille.getTab()[j+1][k]>grille.getTab()[j][k+1]
                                    && grille.getTab()[j+1][k]>grille.getTab()[j][k-1])
                                    d=Dir.b;
                            else if(grille.getTab()[j-1][k]>grille.getTab()[j+1][k] && grille.getTab()[j-1][k]>grille.getTab()[j][k+1]
                                    && grille.getTab()[j-1][k]>grille.getTab()[j][k-1])
                                    d=Dir.h;
                            else if(grille.getTab()[j][k+1]>grille.getTab()[j+1][k] && grille.getTab()[j][k+1]>grille.getTab()[j-1][k]
                                    && grille.getTab()[j][k+1]>grille.getTab()[j][k-1])
                                    d=Dir.h;
                            else if(grille.getTab()[j][k-1]>grille.getTab()[j+1][k] && grille.getTab()[j][k-1]>grille.getTab()[j][k+1]
                                    && grille.getTab()[j][k-1]>grille.getTab()[j-1][k])
                                    d=Dir.h;
                            this.deplacement(d);
                             }else {
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
            }
        }
    
    
}
