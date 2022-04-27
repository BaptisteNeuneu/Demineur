 import java.awt.*;
import javax.swing.*;
 
 public class Setup2{

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
     private Setup1 grille1;

     public void setsetupII(boolean[] presencemines,boolean[] clickdone,boolean[] clickable,
     GridLayout layout,JFrame fenetre,Mine newrandMine,FillNumber newsetnumber,JPanel p,int[] numbers,Setup1 grille1){
         this.presencemines=presencemines;
         this.clickdone=clickdone;
         this.clickable=clickable;
         this.layout=layout;
         this.fenetre=fenetre;
         this.newrandMine=newrandMine;
         this.newsetnumber=newsetnumber;
         this.p=p;
         this.numbers=numbers;
         this.grille1=grille1;

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
        grille1.setupI();
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
 }