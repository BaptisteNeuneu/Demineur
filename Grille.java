/**
* @version 26/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;

public class Grille {
    private int ligne = 15;
    private int colonne = 15;
    private int nbrMines = 15;
    private boolean[] presencemines = new boolean[ligne * colonne] ;
    private int[] numbers;
   // private static int taille = ligne * colonne;
    // Un objet pour servir de fenetre
    private  JFrame fenetre = new JFrame();

    public void main(String[] args) {

        // On configure la fenetre
        fenetre.setSize(500,500);
        fenetre.setMinimumSize(new Dimension(500, 500));
        fenetre.setLocation(500, 0);
        Case macase = new Case();
        GridLayout grille = new GridLayout(ligne, colonne);
        fenetre.setLayout(grille);
        for(int i = 0; i < ligne; i++){
            for(int j = 0; j < colonne; j++){
                macase.Case1();
        }
    }
    fenetre.setVisible(true); //Afficher la fenêtre
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Mine newrandMine = new Mine();
    newrandMine.setMine( nbrMines,ligne,colonne,presencemines);
    newrandMine.Mine1();
    FillNumber newsetnumber = new FillNumber();
    newsetnumber.setFillNumber(ligne, colonne, presencemines, numbers);
    newsetnumber.fillnumbers();



    }
}
