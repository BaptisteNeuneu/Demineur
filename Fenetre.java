/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques
import java.awt.*;
import javax.swing.*;
 
public class Fenetre   {
    private JFrame fenetre = new JFrame();
    private int ligne;
    private int colonne;
    private int nbrMines;
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
    private boolean lost;
    JButton[] buttons = new JButton[ligne * colonne];
    JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    JLabel mineLabel = new JLabel("mines: " + nbrMines + " marqué: 0" + " suposition: 0");
    JPanel p = new JPanel();
   public void setFenetre(int ligne,int colonne,int nbrMines){
       this.ligne=ligne;
       this.colonne=colonne;
       this.nbrMines=nbrMines;
   }
 
    public void fenetre1() {
        p.setLayout(layout);
        Setup newsetup = new Setup();
        newsetup.setSetup(buttons,presencemines,clickdone,clickable,layout,p,ligne,colonne,nbrMines,numbers,lost,mineLabel,newGameButton,fenetre);
        newsetup.setupI();
        for (int i = 0; i < (ligne * colonne); i++) {
            p.add(buttons[i]);
        }
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Menu");
        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers, newGameButton, layout, p, mineLabel);
        newGameButton.addActionListener(newbut);
        m.add(newGameButton);
        mb.add(m);
        fenetre.setJMenuBar(mb);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        fenetre.pack();
        fenetre.setVisible(true);
    }
    public static void main(String[] args){
     Fenetre u = new Fenetre();
     u.fenetre1();
    }

}
