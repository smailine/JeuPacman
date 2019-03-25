
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import Librairie.Dir;
import Librairie.FantomeInnocent;
import Librairie.Grille;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
import javafx.stage.WindowEvent;
import jeu.Jeu;

/**
 *
 * @author freder
 */
public class VueControleur extends Application {
    Dir deplacement = Dir.h;
    String score="0";
    Jeu jeu = null;
    @Override
    public void start(Stage primaryStage) {

        jeu = new Jeu();
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
        Button boutonReinitialisation = new Button("Réinitialisation");
        Text issuJeu = new Text();
        issuJeu.setFont(new Font(30));
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
        Image fantomeJauneMangeable = new Image("File:images/fantome_jaune_bis.png");
        Image fantomeBleuMangeable = new Image("File:images/fantome_bleu_bis.png");
        Image fantomeRoseMangeable = new Image("File:images/fantome_rose_bis.png");
        Image fantomeMort = new Image("File:images/mort.png");
        ImageView [][] imageViewTab = new ImageView[largeur][longueur];
        
        
            

        for (int i = 0;i<largeur;i++) {
            for(int j = 0;j< longueur;j++){
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


                // i pour parcourir les X
                // j pour parcourir les Y
                for(int i = 0;i< grilleJeu.getVerticale() ;i++){
                    for(int j = 0;j<grilleJeu.getHorizontale();j++){
                        if(tab[i][j]==0){
                            imageViewTab[i][j].setImage(image);
                        }else if(tab[i][j]==3){
                            imageViewTab[i][j].setImage(superpacgum);
                        }else if(tab[i][j]==1){
                            imageViewTab[i][j].setImage(pacgum);
                        }else{
                            imageViewTab[i][j].setImage(sansMur);
                        }

                        if(jeu.getSuperFantome().getX() == j && jeu.getSuperFantome().getY() == i){
                            if(jeu.getFantome().getNumVie()==2) {
                                if(jeu.getPacman().getModeTueur()==true){imageViewTab[i][j].setImage(fantomeBleuMangeable);}
                                else{imageViewTab[i][j].setImage(fantomeBleu);}
                            }
                             else{
                                imageViewTab[i][j].setImage(fantomeMort);
                            }

                        }
                        else if(jeu.getFantome().getX() == j && jeu.getFantome().getY() == i ){
                            if(jeu.getFantome().getNumVie()==2) {
                                if(jeu.getPacman().getModeTueur()==true){imageViewTab[i][j].setImage(fantomeJauneMangeable);}
                                else{imageViewTab[i][j].setImage(fantomeJaune);}
                            }
                            else{
                                imageViewTab[i][j].setImage(fantomeMort);
                            }

                        }
                        else if(jeu.getPacman().getX() == j && jeu.getPacman().getY() == i && jeu.getPacman().getNumVie()>0){

                                if(deplacement==Dir.b){
                                    imageViewTab[i][j].setImage(pacman_bas);
                                }else if(deplacement==Dir.h){
                                    imageViewTab[i][j].setImage(pacman_haut);
                                }else if(deplacement==Dir.g){
                                    imageViewTab[i][j].setImage(pacman_gauche);
                                }else{
                                    imageViewTab[i][j].setImage(pacman_droite);
                                }
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
                
                if(jeu.getPacman().getNumVie()==0){
                    issuJeu.setText("Game Over, vous n'avez plus de vie");
                }else if(jeu.getGrille().ttGrilleVisite()){
                    issuJeu.setText("Vous avez gagné, décidemment vous êtes très fort");
                }
                
                

                if(jeu.getFantome().getX()==jeu.getPacman().getX() && jeu.getFantome().getY()==jeu.getPacman().getY() ){
                    jeu.getPacman().manger(jeu.getFantome());
                    jeu.getFantome().manger(jeu.getPacman());
                }
                if(jeu.getSuperFantome().getX()==jeu.getPacman().getX() && jeu.getSuperFantome().getY()==jeu.getPacman().getY() ){
                    jeu.getPacman().manger(jeu.getSuperFantome());
                    jeu.getSuperFantome().manger(jeu.getPacman());
                }
                
            }
            });
       



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
        gPane.setGridLinesVisible(false);

        hb1.getChildren().addAll(labelScore,scoreAffichage);
        hb1.setSpacing(10);
        hb2.getChildren().addAll(labelVie,vieAffichage);
        hb2.setSpacing(10);
        infoJeu.getChildren().addAll(hb1,hb2,issuJeu,boutonReinitialisation);
        paneScore.getChildren().addAll(infoJeu);
        gPane.setGridLinesVisible(false);

        border.setCenter(gPane);
        border.setRight(paneScore);
        
        /**
         * Code ci-dessous nous permet de fermer la fenêtre avec la croix-rouge
         */
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        /**
         * Le bouton boutonReinitialisation permet de réinitialiser le jeu (on recommence du début)
         */
         boutonReinitialisation.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println( "Restarting app!" );
                jeu = new Jeu();
                deplacement = Dir.h;
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
