/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
public class Menu{
		private int i;


	public void Menu(){
		/*Un objet pour servir de fenetre*/
        JFrame fenetre = new JFrame();
        /*On configure la fenetre*/
        fenetre.setSize(500,500);
        fenetre.setMinimumSize(new Dimension(300,300));
        fenetre.setLocation(200,200);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gestionnaire = new GridLayout(10, 1);
		       for (i = 0; i < 4; i++) {
            fenetre.add(new JPanel());
        }
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
		fenetre.add(quit);
		fenetre.add(rpgame);
				ActionMenu amenu = new ActionMenu(fenetre,newgame);
		newgame.addActionListener(amenu);
		//reprendregame.addActionListener(this);
		quitter.addActionListener(amenu);
			        fenetre.setVisible(true); /*Afficher la fenêtre*/
	}
	public static void main(String[] args){
	new Menu();
}
}