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
public class SuperFantome extends Fantome {
    Pacman pac;
    public SuperFantome(int x, int y, Grille grille, Pacman pac) {
        super(x, y, grille);
        this.pac=pac;
    }
    
    public int[] distancePacman(){return new int[]{x-pac.getX(),y-pac.getY()};}
    
    
    @Override
    public void run(){
        if(abs(distancePacman()[0])>=abs(distancePacman()[1])){
            if(abs(distancePacman()[0])>=0 ){
                if(deplacement(Dir.g)){
                    deplacement(Dir.g);
                }
                else if(deplacement(Dir.b) && abs(distancePacman()[1])<0){
                    deplacement(Dir.b);
                }
                else if(deplacement(Dir.h) && abs(distancePacman()[1])>0){
                    deplacement(Dir.h);
                }
                 else if(deplacement(Dir.b)){
                    deplacement(Dir.b);
                }
                else if(deplacement(Dir.h)){
                    deplacement(Dir.h);
                }
                else{
                    deplacement(Dir.d);
                }
            }else{
                if(deplacement(Dir.d)){
                    deplacement(Dir.d);
                }
                else if(deplacement(Dir.b) && abs(distancePacman()[1])<0){
                    deplacement(Dir.b);
                }
                else if(deplacement(Dir.h) && abs(distancePacman()[1])>0){
                    deplacement(Dir.h);
                }
                 else if(deplacement(Dir.b)){
                    deplacement(Dir.b);
                }
                else if(deplacement(Dir.h)){
                    deplacement(Dir.h);
                }
                else{
                    deplacement(Dir.g);
                }
            }
        }else{
            if(abs(distancePacman()[1])>=0 ){
                if(deplacement(Dir.h)){
                    deplacement(Dir.h);
                }
                else if(deplacement(Dir.d) && abs(distancePacman()[0])<0){
                    deplacement(Dir.d);
                }
                else if(deplacement(Dir.g) && abs(distancePacman()[0])>0){
                    deplacement(Dir.g);
                }
                 else if(deplacement(Dir.d)){
                    deplacement(Dir.d);
                }
                else if(deplacement(Dir.g)){
                    deplacement(Dir.g);
                }
                else{
                    deplacement(Dir.b);
                }
            }else{
                if(deplacement(Dir.b)){
                    deplacement(Dir.b);
                }
                else if(deplacement(Dir.d) && abs(distancePacman()[1])<0){
                    deplacement(Dir.d);
                }
                else if(deplacement(Dir.g) && abs(distancePacman()[1])>0){
                    deplacement(Dir.g);
                }
                 else if(deplacement(Dir.d)){
                    deplacement(Dir.d);
                }
                else if(deplacement(Dir.g)){
                    deplacement(Dir.g);
                }
                else{
                    deplacement(Dir.h);
                }
            }
        }
        
        
    }
    
}
