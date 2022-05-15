/**
* @version 26/04/2022
* @author Baptiste Nevejansa
*/
//inclusion des bibliothèques
import java.awt.*;
import javax.swing.*;
 
public class Fenetre   {
    private JFrame fenetre = new JFrame();
    private int ligne = 30;
    private int colonne =30;
    private int nbrMines =899;

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
    JMenuItem quitter2 = new JMenuItem("quitter");
    JButton[] buttons = new JButton[ligne * colonne];
    JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    JMenuItem reglage = new JMenuItem("option");
    JPanel p = new JPanel();
    private JButton sauvquit= new JButton("Sauvegarder Quitter");
   public void setFenetre(int ligne,int colonne,int nbrMines){
       this.ligne=ligne;
       this.colonne=colonne;
       this.nbrMines=nbrMines;
   }

   public void setupI() {
    GridLayout layout = new GridLayout(ligne, colonne);
    JLabel mineLabel = new JLabel("mines: " + nbrMines + " marqué: 0" + " suposition: 0");
    for (int x = 0; x < ligne; x++) {
        for (int y = 0; y < colonne; y++) {
            presencemines[(ligne * y) + x] = false;
            clickdone[(ligne * y) + x] = false;
            clickable[(ligne * y) + x] = true;
            buttons[(ligne * y) + x] = new JButton( );
            buttons[(ligne*y)+x].setBackground(Color.DARK_GRAY);
            buttons[(ligne * y) + x].setPreferredSize(new Dimension(
                    30, 30));
                    ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers,quitter2, newGameButton, layout, p, mineLabel, fenetre,reglage,lost);
            buttons[(ligne * y) + x].addActionListener(newbut);
            buttons[(ligne * y) + x].addMouseListener(newbut);
        }
    } 
Case b = new Case();
b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
b.Mine();
b.fillnumbers();
}
 
    public void fenetre1() {
        JLabel mineLabel = new JLabel("mines: " + nbrMines + " marqué: 0" + " suposition: 0");
         GridLayout layout = new GridLayout(ligne, colonne);
        p.setLayout(layout);
       /* Setup newsetup = new Setup();
       newsetup.setSetup(buttons,presencemines,clickdone,clickable,layout,p,ligne,colonne,nbrMines,numbers,lost,mineLabel,newGameButton,fenetre,reglage, quitter2);
        newsetup.setupI();*/
        setupI();

        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers,quitter2, newGameButton, layout, p, mineLabel, fenetre,reglage,lost);
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
  

        fenetre.setJMenuBar(menubar);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        fenetre.add(sauvquit,BorderLayout.NORTH);
        fenetre.pack();
        fenetre.setVisible(true);
    }
    public static void main(String[] args){
     Fenetre u = new Fenetre();
    u.fenetre1();
    }

}
