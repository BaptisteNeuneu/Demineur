/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques
import java.awt.*;
import javax.swing.*;
 
public class Fenetre   {
 
    private int ligne = 10;
    private int colonne = 10;
    private int nbrMines = 5;
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
   
 
    public void Fenetre() {
         JFrame fenetre = new JFrame();
        p.setLayout(layout);
        Setup newsetup = new Setup();
        newsetup.setupI();
        for (int i = 0; i < (ligne * colonne); i++) {
            p.add(buttons[i]);
        }
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Menu");
        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers, reglage, newGameButton, layout, p, mineLabel);
        newGameButton.addActionListener(newbut);
        m.add(newGameButton);
        reglage.addActionListener(newbut);
        m.add(reglage);
        mb.add(m);
        fenetre.setJMenuBar(mb);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        fenetre.pack();
        reglage.addActionListener(newbut);
        fenetre.setVisible(true);
    }
    public static void main(String[] args){
    new Fenetre();
    }

}
