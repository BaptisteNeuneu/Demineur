/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
import java.awt.*;
import javax.swing.*;

public class Setup  {
    private int ligne;
    private int colonne;
    private boolean[] clickdone;
    private boolean[] presencemines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean[] clickable;
    private GridLayout layout;
    private JPanel p;
    private int nbrMines;
    private JLabel mineLabel;
    private JMenuItem reglage;
    private JMenuItem quitter2;
    private JFrame fenetre;

    public void setSetup(JButton[] buttons,boolean[] presencemines,boolean[] clickdone,boolean[] clickable,GridLayout layout,JPanel p,
    int ligne,int colonne,int nbrMines,int[] numbers,boolean lost,JLabel mineLabel,JMenuItem newGameButton,JFrame fenetre,JMenuItem reglage,
    JMenuItem quitter2){
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
        this.quitter2=quitter2;
    }

    public void setupI() {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                presencemines[y + x] = false;
                clickdone[(y) + x] = false;
                clickable[(y) + x] = true;
                               buttons[y + x] = new JButton( "" );
                buttons[(y) + x].setPreferredSize(new Dimension(
                    45, 45));
                       ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers,quitter2, reglage, layout, p, mineLabel, fenetre,reglage);
                buttons[(y) + x].addActionListener(newbut); //ajoute les actions des boutons
                buttons[(y) + x].addMouseListener(newbut);  //ajoute les actions de la souris
            }
        }
    Case b = new Case();
    b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
    b.Mine();
    b.fillnumbers();
    }


    public void setupI2() {
        fenetre.remove(p);
        p = new JPanel();
        layout = new GridLayout(ligne, colonne);
        p.setLayout(layout);
        buttons = new JButton[ligne * colonne];
        buttons[ligne*colonne].setBackground(Color.LIGHT_GRAY);
        presencemines = new boolean[ligne * colonne];
        clickdone = new boolean[ligne * colonne];
        clickable = new boolean[ligne * colonne];
        numbers = new int[ligne * colonne];
        setupI();
        for (int i = 0; i < (ligne * colonne); i++) {
            p.add(buttons[i]);
        }
        fenetre.add(p);
        fenetre.pack();
      Case b = new Case();
      b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
    b.Mine();
    b.fillnumbers();
    }
    public void setup() {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                presencemines[(ligne * y) + x] = false;
                clickdone[(y) + x] = false;
                clickable[(y) + x] = true;
                buttons[(y) + x].setEnabled(true);
                buttons[(y) + x].setText("");
            }
        }
     Case b = new Case();
     b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
    b.Mine();
    b.fillnumbers();
        mineLabel.setText("mines: " + nbrMines + " marked: 0");
    }

    }
