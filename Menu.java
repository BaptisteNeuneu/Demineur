/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
public class Menu{



	public void Menu1(){
		/*Un objet pour servir de fenetre*/
        JFrame fenetre = new JFrame();
        /*On configure la fenetre*/
        fenetre.setSize(500,500);
        fenetre.setMinimumSize(new Dimension(300,300));
        fenetre.setLocation(200,200);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout r = new GridLayout(3,2);
		fenetre.setLayout(r);
		JPanel newgam = new JPanel();
		JPanel rpgame = new JPanel();
		JPanel quit = new JPanel();
		JButton newgame = new JButton("Nouvelle Partie");
		JButton reprendregame = new JButton("Reprendre la partie");
		JButton quitter = new JButton("Quitter la partie");
		newgam.add(newgame);
		rpgame.add(reprendregame);
		quit.add(quitter);
		fenetre.add(newgam);
		fenetre.add(rpgame);
		fenetre.add(quit);
				ActionMenu amenu = new ActionMenu(newgame,reprendregame,quitter);
		newgame.addActionListener(amenu);
		reprendregame.addActionListener(amenu);
		quitter.addActionListener(amenu);
			        fenetre.setVisible(true); /*Afficher la fenêtre*/
	}

}
