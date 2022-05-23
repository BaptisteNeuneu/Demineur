/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Menu{
    private JPanel newgam = new JPanel();
    private JPanel rpgame = new JPanel();
    private JPanel quit = new JPanel();
    private JButton newgame = new JButton("Nouvelle Partie");
    private JButton reprendregame = new JButton("Reprendre la partie");
    private JButton quitter = new JButton("Quitter la partie");
    private JFrame fenetre1 = new JFrame();
    
    /*Un objet pour servir de fenetre1*/
    public void Menu1(){		
        /*On configure la fenetre1*/
        /*On récupère la taille de la fenêtre1*/
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = 750;
		int hauteur = 520;
        fenetre1.setSize(+longueur,+hauteur);
        /**
         * On empèche de réduire  et agrandir la fenêtre1
         */
        fenetre1.setMinimumSize(new Dimension(+longueur,+hauteur));
        fenetre1.setResizable(false);
        fenetre1.setLocation(100,100);
        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout r = new GridLayout(3,2);
        JPanel pan = new JPanel();
        Fond image = new Fond("/Images/demineur_fond.jpg");
		image.setLayout(null);
        pan.setLayout(r);
        newgam.add(newgame);
        rpgame.add(reprendregame);
        quit.add(quitter);
        pan.add(newgam);
        pan.add(rpgame);
        pan.add(quit);
        pan.add(image);
        fenetre1.add(pan);
        fenetre1.setTitle("*** Menu ***");
        File fichier = new File("save.dat");
        if(!fichier.exists()){
            reprendregame.setEnabled(false);
        }	
        ActionMenu amenu = new ActionMenu(newgame,reprendregame,quitter,fenetre1);
        newgame.addActionListener(amenu);
        reprendregame.addActionListener(amenu);
        quitter.addActionListener(amenu);
        fenetre1.setVisible(true); /*Afficher la fenêtre*/
		}

}
