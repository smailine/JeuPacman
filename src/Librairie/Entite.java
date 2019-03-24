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
public class Entite {
    protected int x,y;
    protected Grille grille;
    protected boolean modeTueur=false;
    protected Dir derniereDirection;

    public Entite(Grille grille){
        this.x = 0;
        this.y = 0;
        this.grille = grille;
        derniereDirection=null;
    }

     public Entite(int x, int y, Grille grille){
        this.x = x;
        this.y = y;
        this.grille = grille;
    }

    public boolean deplacement(Dir deplacement){
        
        boolean rencontreMur = false;
        int tab[][] = this.grille.getTab();
        switch(deplacement){
            case h:
                if(this.getY()-1>=0){
                    if(tab[y-1][x]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y-1);
                        derniereDirection=Dir.h;
                        rencontreMur = false;
                    }
                }
            break;
            case b:
                if(this.getY()+1<this.grille.getVerticale()){
                    if(tab[y+1][x]==0){
                        rencontreMur = true;
                    }else{
                        this.setY(y+1);
                        rencontreMur = false;
                        derniereDirection=Dir.b;
                    }
                }
            break;

            case d:
                if(this.getX()+1<this.grille.getHorizontale()){
                    if(tab[y][x+1]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x+1);
                        rencontreMur = false;
                        derniereDirection=Dir.d;
                    }
                }
            break;

            case g:
                if(this.getX()-1>=0){
                   if(tab[y][x-1]==0){
                        rencontreMur = true;
                    }else{
                        this.setX(x-1);
                        rencontreMur = false;
                        derniereDirection=Dir.g;
                    }
                }
            break;

        }

        return rencontreMur;
    }

    public Dir getDerniereDirection(){return derniereDirection;}
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Grille getGrille(){
        return this.grille;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void changeMode(){
            modeTueur=!modeTueur;
            if(modeTueur==true){
                int i =0;
                while(i<2000)
                {
                    i++;
                }
                modeTueur=!modeTueur;
            }
    }

}
