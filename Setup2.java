 import java.awt.*;
import javax.swing.*;
 
 public class Setup2{

     private boolean[] buttons;
     private boolean[] presencemines;
     private boolean[] clickdone;
     private boolean[] clickable;
     private GridLayout layout;
     private JFrame fenetre;
     private Mine newrandMine;
     private FillNumber newsetnumber;
     private JPanel p;

     public void setsetupII(boolean[] buttons,boolean[] presencemines,boolean[] clickdone,boolean[] clickable,
     GridLayout layout,JFrame fenetre,Mine newrandMine,FillNumber newsetnumber;JPanel p,){
         this.buttons=buttons;
         this.presencemines=presencemines;
         this.clickdone=clickdone
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
 }