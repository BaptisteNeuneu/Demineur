/**
* @version 26/04/2022
* @author Félix Brinet
*/
//inclusion des bibliothèques
import java.awt.*;
import javax.swing.*;

public class Setup1 {
    private int ligne;
    private int colonne;
    private boolean[] presencemines;
    private boolean[] clickdone;
    private boolean[] clickable;
    private JButton[] buttons;
    private int nbrMines;
    private int[] numbers;

    public void setSetup1(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,
    JButton[] buttons,boolean[] presencemines,int nbrMines,int[] numbers){
        this.ligne=ligne;
        this.colonne=colonne;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.buttons=buttons;
        this.presencemines=presencemines;
        this.nbrMines=nbrMines;
        this.numbers=numbers;

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

}
