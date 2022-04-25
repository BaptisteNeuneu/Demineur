/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
public class TestMenu{
	public static void main(String[] args) {
		int lx = 1000;
		int ly = 800;
		int px = 0;
		int py = 0;
		int mx = lx;
		int my = ly;
		/*Un objet pour servir de fenetre*/
        JFrame fenetre = new JFrame();
        /*On configure la fenetre*/
        fenetre.setSize(lx,ly);
        fenetre.setMinimumSize(new Dimension(mx,my));
        fenetre.setLocation(px,py);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true); /*Afficher la fenêtre*/
	}
}
