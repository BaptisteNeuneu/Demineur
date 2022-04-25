/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
public class Menu{
	  private int lx;
  	  private int ly;
  	  private int mx;
	  private int my;
  	  private int px;
  	  private int py;

	public Menu(int lx,int ly,int mx,int my,int px,int py){
		this.lx=lx;
    	this.ly=ly;
    	this.mx=mx;
		this.my=my;
    	this.px=px;
    	this.py=py;
	}
	public void Menu(){
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