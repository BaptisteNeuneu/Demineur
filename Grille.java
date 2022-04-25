/**
* @version 03/02/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;

public class Grille {
    private static int ligne = 15;
    private static int colonne = 15;
    private static int taille = ligne * colonne;
    // Un objet pour servir de fenetre
    private static JFrame fenetre = new JFrame();

    public static void main(String[] args) {

        // On configure la fenetre
        fenetre.setSize(500,500);
        fenetre.setMinimumSize(new Dimension(500, 500));
        fenetre.setLocation(500, 0);
        Case macase = new Case();
        GridLayout grille = new GridLayout(ligne, colonne);
        fenetre.setLayout(grille);
        for(int i = 0; i < ligne; i++){
            for(int j = 0; j < colonne; j++){
                JButton bouton = new JButton("");
                fenetre.add(bouton);
        }
    }
    fenetre.setVisible(true); //Afficher la fenêtre
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






    }
}