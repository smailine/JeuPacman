
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VueControleur;

import Librairie.Dir;
import modele.FantomeInnocent;
import Librairie.Grille;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
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
import modele.Jeu;

/**
 *
 * @author 11506559
 *
 */
/**
 * 
 *  classe permettant d'afficher l'etat actuel du jeu et d'avoir les informations saisies
 *par l'utilisateur
 */
public class VueControleur extends Application {
    Dir deplacement = Dir.h;
    String score="0";
    Jeu jeu = null;
    Boolean actif = false;
    Text issuJeu = new Text();
    
    
    /**
     * gere l'affichage en fonction de l'etat du jeu et de recupere les informations saisies par l'utilisateur 
     * il permet egalement d'initaliser un nouveau jeu
     */
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
                /// mise à jours des images 
                for(int i = 0;i< grilleJeu.getVerticale() ;i++){
                    for(int j = 0;j<grilleJeu.getHorizontale();j++){
                        if(jeu.mur(i,j)){
                            imageViewTab[i][j].setImage(image);
                        }else if(jeu.superPacgum(i,j)){
                            imageViewTab[i][j].setImage(superpacgum);
                        }else if(jeu.pacgum(i,j)){
                            imageViewTab[i][j].setImage(pacgum);
                        }else{
                            imageViewTab[i][j].setImage(sansMur);
                        }

                         if(jeu.getFantomeNormal1().getX() == j && jeu.getFantomeNormal1().getY() == i){
                            if(jeu.totalVieFantome(jeu.getFantomeNormal1())) {
                                if(jeu.getPacman().getModeTueur()){imageViewTab[i][j].setImage(fantomeRoseMangeable);}
                                else{imageViewTab[i][j].setImage(fantomeRose);}
                            }
                             else{
                                imageViewTab[i][j].setImage(fantomeMort);
                            }

                        }else if (jeu.getFantomeNormal().getX() == j && jeu.getFantomeNormal().getY() == i){
                            if(jeu.totalVieFantome(jeu.getFantomeNormal())) {
                                if(jeu.getPacman().getModeTueur()){imageViewTab[i][j].setImage(fantomeBleuMangeable);}
                                else{imageViewTab[i][j].setImage(fantomeBleu);}
                            }
                             else{
                                imageViewTab[i][j].setImage(fantomeMort);
                            }

                        }
                        else if(jeu.getFantomeInnocent().getX() == j && jeu.getFantomeInnocent().getY() == i ){
                            if(jeu.totalVieFantome(jeu.getFantomeInnocent())) {
                                if(jeu.getPacman().getModeTueur()){imageViewTab[i][j].setImage(fantomeJauneMangeable);}
                                else{imageViewTab[i][j].setImage(fantomeJaune);}
                            }
                            else{
                                imageViewTab[i][j].setImage(fantomeMort);
                            }

                        }
                        else if(jeu.getPacman().getX() == j && jeu.getPacman().getY() == i && !jeu.getPacman().mort()){

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
                jeu.getFantomeInnocent().run();
                jeu.getFantomeNormal().run();
                jeu.getFantomeNormal1().run();
                /**
                 * Affichage du score et des vies dans le TextFlow
                 */
                scoreAffichage.setText(String.valueOf(jeu.getGrille().getScore()));
                vieAffichage.setText(String.valueOf(jeu.getPacman().getNumVie()));

                if(jeu.getPacman().mort()){
                    issuJeu.setText("Game Over, plus de vie");
                    
                }else if(jeu.getGrille().ttGrilleVisite()){
                    issuJeu.setText("Vous avez gagné, trop fort");
                }
               
              jeu.interationFantomePacman();
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
                issuJeu.setText("");
                issuJeu.setFont(new Font(30));
                
            }
        });



        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Jeu Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(jeu).start();
        new Thread(jeu.getFantomeInnocent()).start();
        new Thread(jeu.getFantomeNormal()).start();
        new Thread(jeu.getFantomeNormal1()).start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
