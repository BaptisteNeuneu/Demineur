/**
* @version 22/05/2022
* @author Felix Brinet
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.lang.*;

public class Fond extends JComponent{
    /**
    * Image a mettre en fond
    */

	private Image fond;


    /**
    * Constructeur destine a recuperer le chemin
    * vers l'image a afficher en fond
    * @param s : la chaine de caractere
    */

    /**
    * Constrcuteur destine a afficher l image 
    */
	public Fond(String s) {
		super();
		this.fond = getToolkit().getImage(this.getClass().getResource(s));
	}

	public void paintComponent(Graphics g) {
		if (this.isOpaque()) {

      		g.setColor(this.getBackground());
      		g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	}
    	g.drawImage(this.fond, 0, 0, this);
    		
	}
}