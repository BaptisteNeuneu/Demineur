/**
* @version 25/04/2022
* @author Felix Brinet
*/
/**
 * inclusion des bibliothèques
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Menu{
    /**
     * Définition des boutons "Nouvelle Partie", 
     * "Reprendre la partie" et
     * "Quitter la partie"
     */
    private JButton newgame = new JButton("Nouvelle Partie");
    private JButton reprendregame = new JButton("Reprendre la partie");
    private JButton quitter = new JButton("Quitter la    partie");
    /**
     * Un objet pour servir de fenetre1
     */
    private JFrame fenetre1 = new JFrame();
    

    public void Menu1(){		
        /**
         * On configure la fenetre1
         */
        /**
         * On définit la taille et la position de la fenêtre1
         */
		int longueur = 750;
		int hauteur = 520;
        fenetre1.setSize(+longueur,+hauteur);
        fenetre1.setLocation(100,100);
        /**
         * On empèche la réduction et agrandissement fenêtre1
         */
        fenetre1.setMinimumSize(new Dimension(+longueur,+hauteur));
        fenetre1.setResizable(false);
        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre1.setLayout(new BorderLayout());
        /**
         * Ajout du fond de la fenêtre1
         */
	    fenetre1.setContentPane(new JLabel(new ImageIcon("./Images/demineur_fond.jpg")));
	    fenetre1.setLayout(new FlowLayout());
        /**
         * Ajout des boutons à la fenêtre1
         */
        fenetre1.add(newgame);
        fenetre1.add(reprendregame);
        fenetre1.add(quitter);
        fenetre1.setTitle("*** Menu ***");
        /**
         * Appel du fichier sauvegarde
         * si il existe alors le bouton et reprendre partie 
         * est clickable sinon le bouton est est désactiver
         */
        File fichier = new File("save.dat");
        if(!fichier.exists()){
            reprendregame.setEnabled(false);
        }	
        /**
         * Appel des actions de la classe ActionMenu 
         * effectuer par les différents boutons : 
         * "Jouer" "Reprendre partie" et "Quitter"
         */
        ActionMenu amenu = new ActionMenu(newgame,reprendregame,quitter,fenetre1);
        newgame.addActionListener(amenu);
        reprendregame.addActionListener(amenu);
        quitter.addActionListener(amenu);
        /**
         * Afficher la fenêtre
         */
        fenetre1.setVisible(true); 
		}

}
