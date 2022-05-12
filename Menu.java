/**
* @version 25/04/2022
* @author Felix Brineta
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
public class Menu{
    private JFrame fenetre;
    private JPanel newgam = new JPanel();
    private JPanel rpgame = new JPanel();
    private JPanel quit = new JPanel();
    private JButton newgame = new JButton("Nouvelle Partie");
    private JButton reprendregame = new JButton("Reprendre la partie");
    private JButton quitter = new JButton("Quitter la partie");
    private JFrame fenetre1 = new JFrame();
    public void setMenu(JFrame fenetre){
        this.fenetre=fenetre;
    }
    /*Un objet pour servir de fenetre1*/
    public void Menu1(){		
        /*On configure la fenetre1*/
        fenetre1.setSize(500,500);
        fenetre1.setMinimumSize(new Dimension(300,300));
        fenetre1.setLocation(200,200);
        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout r = new GridLayout(3,2);
        fenetre1.setLayout(r);

        newgam.add(newgame);
        rpgame.add(reprendregame);
        quit.add(quitter);
        fenetre1.add(newgam);
        fenetre1.add(rpgame);
        fenetre1.add(quit);
        fenetre1.setTitle("*** Menu ***");	
        ActionMenu amenu = new ActionMenu(fenetre,newgame,reprendregame,quitter,fenetre1);
        newgame.addActionListener(amenu);
        reprendregame.addActionListener(amenu);
        quitter.addActionListener(amenu);
        fenetre1.setVisible(true); /*Afficher la fenêtre*/
		}

}