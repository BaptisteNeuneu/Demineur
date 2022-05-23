/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
/**inclusion des bibliothèques*/
import java.awt.*;
import javax.swing.*;
import java.io.*;
 
public class Fenetre {
    private JFrame fenetre = new JFrame();
    private int ligne = 30;
    private int colonne = 30;
    private int nbrMines = 899;
    private boolean[] presencemines = new boolean[ligne * colonne];
    private boolean[] clickable = new boolean[ligne * colonne];
    private int[] numbers = new int[ligne * colonne];
    private boolean[] clickdone = new boolean[ligne * colonne];
    private boolean lost;
    JMenuItem quitter2 = new JMenuItem("quitter");
    JButton[] buttons = new JButton[ligne * colonne];
    JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    JMenuItem reglage = new JMenuItem("option");
    JPanel p = new JPanel();
    boolean nouveau;
    private JButton sauvquit= new JButton("Sauvegarder Quitter");

    
   public void setFenetre(int ligne,int colonne,int nbrMines,boolean nouveau) {
       this.ligne=ligne;
       this.colonne=colonne;
       this.nbrMines=nbrMines;
       this.nouveau=nouveau;
   }
 
    public void fenetre1() {
        JLabel mineLabel = new JLabel("nombre de mines restante : " + nbrMines);
         GridLayout layout = new GridLayout(ligne, colonne);
        p.setLayout(layout);
        Grille grille = new Grille();
       if(!nouveau){
        grille.reprisepartie();
        else{
        grille.generationgrille(ligne,colonne,nbrMines);
        }

        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
        nbrMines, numbers,quitter2, newGameButton, layout, p, mineLabel, fenetre,reglage,lost);
        for (int i = 0; i < (ligne * colonne); i++) {
            p.add(buttons[i]);
        }
        JMenuBar menubar = new JMenuBar();
        JMenu menupara = new JMenu("Paramettre");
        
        reglage.addActionListener(newbut);
        newGameButton.addActionListener(newbut);
        quitter2.addActionListener(newbut);
        sauvquit.addActionListener(newbut);
        menupara.add(reglage);
        menupara.add(newGameButton);
        menupara.add(quitter2);
        menubar.add(menupara);
        ActionFenetre doFenetre = new ActionFenetre(buttons,numbers,presencemines,clickable,clickdone,ligne,colonne,nbrMines);
        fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  
        fenetre.addWindowsListener(doFenetre);
        fenetre.setJMenuBar(menubar);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        fenetre.add(sauvquit,BorderLayout.NORTH);
        fenetre.pack();
        fenetre.setVisible(true);
    }
    public static void main(String[] args) {
     Fenetre u = new Fenetre();
    u.fenetre1();
    }

}
