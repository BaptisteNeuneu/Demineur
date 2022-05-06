/**
* @version 25/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ActionMenu implements ActionListener {
private JButton quitter;
private JButton newgame;
private JButton reprendregame;
private JFrame fenetre1;
private int ligne;
private int colonne;
private boolean[] clickdone;
private boolean[] clickable;
private boolean[] presencemines;
private int nbrMines;
private JButton[] buttons;
private int[] numbers;
private JFrame fenetre;
private JMenuItem reglage;
private JMenuItem newGameButton;
private JMenuItem quitter2;
private GridLayout layout;
private JPanel p;
private JLabel mineLabel;

    public ActionMenu(JButton newgame, JButton reprendregame, JButton quitter, JFrame fenetre1, int ligne,
        int colonne, boolean[] clickdone, boolean[] clickable, JButton[] buttons, boolean[] presencemines,
        int nbrMines, int[] numbers, GridLayout layout, JMenuItem newGameButton, JPanel p,
        JLabel mineLabel, JFrame fenetre, JMenuItem reglage, JMenuItem quitter2) {
            this.newgame=newgame;
            this.reprendregame=reprendregame;
            this.quitter=quitter;
            this.fenetre1=fenetre1;
            this.ligne=ligne;
            this.colonne=colonne;
            this.clickdone=clickdone;
            this.clickable=clickable;
            this.buttons=buttons;
            this.presencemines=presencemines;
            this.nbrMines=nbrMines;
            this.numbers=numbers;
            this.layout=layout;
            this.newGameButton=newGameButton;
            this.p=p;
            this.mineLabel=mineLabel;
            this.fenetre=fenetre;
            this.reglage=reglage;
            this.quitter2=quitter2;
}

    public void actionPerformed(ActionEvent menu1) {
        if(menu1.getSource() == newgame){
            Menu2 newmenu2 =new Menu2();
            newmenu2.Menu21();
            fenetre1.setVisible(false); /*Fait disparaître la fenêtre*/
        //}else if(menu1.getSource() == reprendregame){
           //Setup reprise = new Setup();
           //reprise.setSetup(buttons, presencemines, clickdone, clickable, layout, p, ligne, colonne, nbrMines, numbers, mineLabel, fenetre, reglage, newGameButton,quitter2);
           //reprise.setupI2();
            
        }else if(menu1.getSource() == quitter){
            System.exit(0);

        }
    }
 }