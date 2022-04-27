import java.awt.*;
import javax.swing.*;

public class Setup {
    private JButton[] buttons;
    private boolean[] presencemines;
    private boolean[] clickdone;
    private boolean[] clickable;
    private GridLayout layout;
    private JFrame fenetre;
    private Mine newrandMine;
    private FillNumber newsetnumber;
    private JPanel p;
    private int ligne;
    private int colonne;
    private int nbrMines;
    private int[] numbers;
    private boolean lost;
    private JLabel mineLabel;

    public void setSetup(JButton[] buttons,boolean[] presencemines,boolean[] clickdone,boolean[] clickable,GridLayout layout,JFrame fenetre,
    Mine newrandMine,FillNumber newsetnumber,JPanel p,int ligne,int colonne,int nbrMines,int[] numbers,JLabel mineLabel){
        this.buttons=buttons;
        this.presencemines=presencemines;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.layout=layout;
        this.fenetre=fenetre;
        this.newrandMine=newrandMine;
        this.newsetnumber=newsetnumber;
        this.p=p;
        this.ligne=ligne;
        this.colonne=colonne;
        this.nbrMines=nbrMines;
        this.numbers=numbers;
        this.mineLabel=mineLabel;
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
                //buttons[(ligne * y) + x].addActionListener(this); //ajoute les actions des boutons
                //buttons[(ligne * y) + x].addMouseListener(this);  //ajoute les actions de la souris
            }
        }
        Mine newrandMine = new Mine();
    newrandMine.setMine( nbrMines,ligne,colonne,presencemines);
    newrandMine.Mine1();
    FillNumber newsetnumber = new FillNumber();
    newsetnumber.setFillNumber(ligne, colonne, presencemines, numbers);
    newsetnumber.fillnumbers();
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
        newrandMine.setMine( nbrMines,ligne,colonne,presencemines);
    newrandMine.Mine1();
    newsetnumber.setFillNumber(ligne, colonne, presencemines, numbers);
    newsetnumber.fillnumbers();
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
        newrandMine.setMine( nbrMines,ligne,colonne,presencemines);
    newrandMine.Mine1();
    newsetnumber.setFillNumber(ligne, colonne, presencemines, numbers);
    newsetnumber.fillnumbers();
        lost = false;
        mineLabel.setText("mines: " + nbrMines + " marked: 0");
    }
}
