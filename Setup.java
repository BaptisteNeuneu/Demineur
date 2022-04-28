import java.awt.*;
import javax.swing.*;

public class Setup  {
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
    private boolean lost;
    private JLabel mineLabel;
    private JMenuItem reglage;
    private JMenuItem newGameButton;
    private JFrame fenetre;

    public void setSetup(JButton[] buttons,boolean[] presencemines,boolean[] clickdone,boolean[] clickable,GridLayout layout,JPanel p,
    int ligne,int colonne,int nbrMines,int[] numbers,boolean lost,JLabel mineLabel,JMenuItem reglage,JMenuItem newGameButton,JFrame fenetre){
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
        this.lost=lost;
        this.mineLabel=mineLabel;
        this.reglage=reglage;
        this.newGameButton=newGameButton;
        this.fenetre=fenetre;
    }

    public void setupI() {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                presencemines[(ligne * y) + x] = false;
                clickdone[(ligne * y) + x] = false;
                clickable[(ligne * y) + x] = true;
                buttons[(ligne * y) + x] = new JButton( "" + ( x * y ));
                buttons[(ligne * y) + x].setPreferredSize(new Dimension(
                        45, 45));
                        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, nbrMines, numbers, reglage, newGameButton, layout, p, mineLabel);
                buttons[(ligne * y) + x].addActionListener(newbut); //ajoute les actions des boutons
                buttons[(ligne * y) + x].addMouseListener(newbut);  //ajoute les actions de la souris
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
                clickdone[(ligne * y) + x] = false;
                clickable[(ligne * y) + x] = true;
                buttons[(ligne * y) + x].setEnabled(true);
                buttons[(ligne * y) + x].setText("");
            }
        }
     Case b = new Case();
     b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
    b.Mine();
    b.fillnumbers();
        lost = false;
        mineLabel.setText("mines: " + nbrMines + " marked: 0");
    }
}
