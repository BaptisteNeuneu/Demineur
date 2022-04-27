/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques
import java.awt.*;
import javax.swing.*;
 
public class Fenetre  {
 
    private int ligne = 10;
    private int colonne = 10;
    private int nbrMines = 5;
    JFrame fenetre = new JFrame();
    GridLayout layout = new GridLayout(ligne, colonne);
    /*type[][] name = new type[ligne][colonne];
     * type[x][y];
     * is 1d
     * type[] name = new type[ligne*colonne];
     * type[(ligne*y)+x];*/
    private boolean[] presencemines = new boolean[ligne * colonne];
    private boolean[] clickable = new boolean[ligne * colonne];
    private int[] numbers = new int[ligne * colonne];
    private boolean[] clickdone = new boolean[ligne * colonne];
    JButton[] buttons = new JButton[ligne * colonne];
    JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    JMenuItem reglage = new JMenuItem("options");
    JLabel mineLabel = new JLabel("mines: " + nbrMines + " marqué: 0" + " suposition: 0");
    JPanel p = new JPanel();
 
    public Fenetre() {
        p.setLayout(layout);
        Setup grille1 = new Setup();
        grille1.setSetup(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers);
        grille1.setupI();
        for (int i = 0; i < (ligne * colonne); i++) {
            p.add(buttons[i]);
        }
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Menu");

        //newGameButton.addActionListener(this);
        m.add(newGameButton);
        //reglage.addActionListener(this);
        m.add(reglage);
        mb.add(m);
        fenetre.setJMenuBar(mb);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        fenetre.pack();
        //reglage.addActionListener(this);
        fenetre.setVisible(true);
    }
    public static void main(String[] args){
    new Fenetre();
    }

}
