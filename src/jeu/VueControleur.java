
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import Librairie.Dir;
import Librairie.Grille;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import jeu.Jeu;

/**
 *
 * @author freder
 */
public class VueControleur extends Application {
    Dir deplacement = Dir.d;
   
    @Override
    public void start(Stage primaryStage) {
        Jeu jeu = new Jeu();
        
       
        int longueur = jeu.getGrille().getHorizontale();
        int largeur = jeu.getGrille().getVerticale();
      
        
        BorderPane border = new BorderPane();
        
        GridPane gPane = new GridPane();
        
        int column = 0;
        int row = 0;
        int [][] grille = jeu.getGrille().getTab();
        Image image = new Image("File:images/mur.png");
        
        Image sansMur = new Image("File:images/sansMur.png");
        
        Image pacman = new Image("File:images/pacman.png");
        Image pacgum = new Image("File:images/Pacgum.png");
        Image superpacgum = new Image("File:images/SuperPacgum.png");

        ImageView [][] imageViewTab = new ImageView[longueur][largeur];
        for (int i = 0;i<longueur;i++) {
            for(int j = 0;j<largeur;j++){
               
                ImageView imageView = new ImageView();
                
                imageViewTab[i][j] = imageView;
                gPane.add(imageView,j, i);
            
            }
        
        }
        
           
            jeu.addObserver(new Observer(){
            @Override
            public void update(Observable o, Object arg) {
                
                Grille grilleJeu = jeu.getGrille();
                int tab[][] = grilleJeu.getTab();
                
                for(int i = 0;i<grilleJeu.getHorizontale();i++){
                    for(int j = 0;j<grilleJeu.getVerticale();j++){
                        if(tab[i][j]==0){
                            imageViewTab[i][j].setImage(image);
                        }else if(tab[i][j]==3){
                            imageViewTab[i][j].setImage(superpacgum);
                        }else if(tab[i][j]==1){
                            imageViewTab[i][j].setImage(pacgum);
                        }else{
                            imageViewTab[i][j].setImage(sansMur);
                        }
                       
                        if(jeu.getEntite().getX() == i && jeu.getEntite().getY() == j){
                            imageViewTab[i][j].setImage(pacman);
                        }

                    }

                }
                
                jeu.getEntite().deplacement(deplacement);
            }
            });
            

        gPane.setGridLinesVisible(true);
        
        border.setCenter(gPane);
        
        Scene scene = new Scene(border, Color.LIGHTBLUE);
        /**
         * Ici nous avons les event permettant de gérer les déplacements à l'aide du clavier
         */
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                case UP: 
                    deplacement = Dir.h;
                    break;
                case DOWN:
                    deplacement = Dir.b;
                    break;
                case LEFT:
                    deplacement = Dir.g;
                    break;
                case RIGHT:
                    deplacement = Dir.d;
                    break;
            }
        }
    });
        primaryStage.setTitle("Jeu Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread(jeu).start();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
