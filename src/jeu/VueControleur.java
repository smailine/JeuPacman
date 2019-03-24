
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import Librairie.Dir;
import Librairie.FantomeNormal;
import Librairie.Grille;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import jeu.Jeu;

/**
 *
 * @author freder
 */
public class VueControleur extends Application {
    Dir deplacement = Dir.h;
    String score="0";
    @Override
    public void start(Stage primaryStage) {

        Jeu jeu = new Jeu();
        int longueur = jeu.getGrille().getHorizontale();
        int largeur = jeu.getGrille().getVerticale();

        BorderPane border = new BorderPane();

        GridPane gPane = new GridPane();

        VBox infoJeu = new VBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        TextFlow paneScore = new TextFlow();
        paneScore.setPrefSize(600, 300);
        paneScore.setTextAlignment(TextAlignment.CENTER);
        Label labelScore = new Label("Score : ");
        labelScore.setFont(new Font(30));
        Label labelVie = new Label("Vie : ");
        labelVie.setFont(new Font(30));
        Text scoreAffichage = new Text();
        scoreAffichage.setFont(new Font(30));
        Text vieAffichage = new Text();
        vieAffichage.setFont(new Font(30));

        /*Pane paneScore = new Pane();
        Label labelScore = new Label("Score");
        paneScore.getChildren().add(labelScore);
        Label scoreAffichage = new Label();
        paneScore.getChildren().add(scoreAffichage);*/



        int column = 0;
        int row = 0;
        int [][] grille = jeu.getGrille().getTab();
        Image image = new Image("File:images/mur.png");

        Image sansMur = new Image("File:images/sansMur.png");

        Image pacman_bas = new Image("File:images/pacman_bas.png");
        Image pacman_haut = new Image("File:images/pacman_haut.png");
        Image pacman_gauche = new Image("File:images/pacman_gauche.png");
        Image pacman_droite = new Image("File:images/pacman_droite.png");
        Image pacgum = new Image("File:images/pac_gomme.png");
        Image superpacgum = new Image("File:images/SuperPacgum.png");
        Image fantomeJaune = new Image("File:images/fantome_jaune.png");
        Image fantomeBleu = new Image("File:images/fantome_bleu.png");
        Image fantomeRose = new Image("File:images/fantome_rose.png");

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


                        if(jeu.getPacman().getX() == i && jeu.getPacman().getY() == j){
                                if(deplacement==Dir.b){
                                    imageViewTab[i][j].setImage(pacman_bas);
                                }else if(deplacement==Dir.h){
                                    imageViewTab[i][j].setImage(pacman_haut);
                                }else if(deplacement==Dir.g){
                                    imageViewTab[i][j].setImage(pacman_gauche);
                                }else{
                                    imageViewTab[i][j].setImage(pacman_droite);
                                }

                            }else if(jeu.getFantome().getX() == i && jeu.getFantome().getY() == j){
                                imageViewTab[i][j].setImage(fantomeJaune);
                            }
                            else if(jeu.getSuperFantome().getX() == i && jeu.getSuperFantome().getY() == j){
                                imageViewTab[i][j].setImage(fantomeBleu);
                            }
                    }

                }



                jeu.getPacman().deplacement(deplacement);
                jeu.getFantome().run();
                jeu.getSuperFantome().run();
                /**
                 * Affichage du score et des vies dans le TextFlow
                 */
                scoreAffichage.setText(String.valueOf(jeu.getGrille().getScore()));
                vieAffichage.setText(String.valueOf(jeu.getPacman().getNumVie()));

                if(jeu.getFantome().getX()==jeu.getPacman().getX() && jeu.getFantome().getY()==jeu.getPacman().getY() ){
                    jeu.getPacman().manger(jeu.getFantome());
                     jeu.getFantome().manger(jeu.getPacman());
                }
                if(jeu.getSuperFantome().getX()==jeu.getPacman().getX() && jeu.getSuperFantome().getY()==jeu.getPacman().getY() ){
                    jeu.getPacman().manger(jeu.getSuperFantome());
                    jeu.getSuperFantome().manger(jeu.getPacman());
                }
                /**
                * On convertit le score en String pour pouvoir le l'afficher via scoreAffichage
                */
                //scoreAffichage.setText(String.valueOf(score));


            }
            });

        gPane.setGridLinesVisible(false);

        hb1.getChildren().addAll(labelScore,scoreAffichage);
        hb1.setSpacing(10);
        hb2.getChildren().addAll(labelVie,vieAffichage);
        hb2.setSpacing(10);
        infoJeu.getChildren().addAll(hb1,hb2);
        paneScore.getChildren().addAll(infoJeu);
        gPane.setGridLinesVisible(false);

        border.setCenter(gPane);
        border.setRight(paneScore);
       // border.setRight(paneScore);

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
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Jeu Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(jeu).start();
        new Thread(jeu.getFantome()).start();
        new Thread(jeu.getSuperFantome()).start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
