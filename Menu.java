/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;
public class Menu{
 private JButton[] buttons;
    private boolean[] presencemines;
    private boolean[] clickdone;
    private boolean[] clickable;
    private GridLayout layout;
    private JPanel p;
    private int ligne;
    private int colonne;
    private int nbrMines;
    private int[] numbers;
    private JLabel mineLabel;
    private JMenuItem reglage;
    private JFrame fenetre;
    private JMenuItem newGameButton;
    private JMenuItem quitter2;

    public void setMenu(JButton[] buttons,boolean[] presencemines,boolean[] clickdone,boolean[] clickable,GridLayout layout,JPanel p,
    int ligne,int colonne,int nbrMines,int[] numbers,boolean lost,JLabel mineLabel,JMenuItem newGameButton,JFrame fenetre,JMenuItem reglage){
        this.buttons=buttons;
        this.presencemines=presencemines;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.layout=layout;
        this.p=p;
        this.ligne=ligne;
        this.colonne=colonne;
        this.nbrMines=nbrMines;
        this.numbers=numbers;
        this.mineLabel=mineLabel;
        this.fenetre=fenetre;
        this.reglage=reglage;
    }
    /*Un objet pour servir de fenetre1*/
    public void Menu1(){
        JFrame fenetre1 = new JFrame();		
        /*On configure la fenetre1*/
        fenetre1.setSize(500,500);
        fenetre1.setMinimumSize(new Dimension(300,300));
        fenetre1.setLocation(200,200);
        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout r = new GridLayout(3,2);
        fenetre1.setLayout(r);
        JPanel newgam = new JPanel();
        JPanel rpgame = new JPanel();
        JPanel quit = new JPanel();
        JButton newgame = new JButton("Nouvelle Partie");
        JButton reprendregame = new JButton("Reprendre la partie");
        JButton quitter = new JButton("Quitter la partie");
        newgam.add(newgame);
        rpgame.add(reprendregame);
        quit.add(quitter);
        fenetre1.add(newgam);
        fenetre1.add(rpgame);
        fenetre1.add(quit);
        fenetre1.setTitle("*** Menu ***");	
        ActionMenu amenu = new ActionMenu(newgame,reprendregame,quitter,fenetre1,ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers,layout, newGameButton, p, mineLabel, fenetre,reglage,quitter2);
        newgame.addActionListener(amenu);
        reprendregame.addActionListener(amenu);
        quitter.addActionListener(amenu);
        fenetre1.setVisible(true); /*Afficher la fenêtre*/
		}

}