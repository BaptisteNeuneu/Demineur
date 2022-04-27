/**
* @version 26/04/2022
* @author Félix Brinet
*/
//inclusion des bibliothèques
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionButton extends JFrame implements ActionListener, MouseListener{
    private int ligne;
    private int colonne;
    private boolean[] clickdone;
    private boolean[] clickable;
    private boolean[] presencemines;
    private int nbrMines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean lost = false;
    private boolean won = false;
    private JMenuItem reglage;
    private JMenuItem newGameButton;
    private GridLayout layout;
    private JFrame fenetre;
    private Mine newrandMine; 
    private FillNumber newsetnumber;
    private JPanel p;
    private JLabel mineLabel;
    private Test newtest= new Test();
    Setup newsetup;
    
    public ActionButton(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,
    JButton[] buttons,boolean[] presencemines,int nbrMines,int[] numbers,JMenuItem reglage,
    JMenuItem newGameButton,GridLayout layout,JFrame fenetre,Mine newrandMine,FillNumber newsetnumber,
    JPanel p,JLabel mineLabel,Setup newsetup){
        this.ligne=ligne;
        this.colonne=colonne;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.buttons=buttons;
        this.presencemines=presencemines;
        this.nbrMines=nbrMines;
        this.numbers=numbers;
        this.reglage=reglage;
        this.newGameButton=newGameButton;
        this.layout=layout;
        this.fenetre=fenetre;
        this.newrandMine=newrandMine;
        this.newsetnumber=newsetnumber;
        this.p=p;
        this.mineLabel=mineLabel;
        this.newsetup=newsetup;

       
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reglage) {
            ligne = Integer.parseInt((String) JOptionPane.showInputDialog(
                    this, "ligne", "ligne", JOptionPane.PLAIN_MESSAGE, null,
                    null, 10));
            colonne = Integer.parseInt((String) JOptionPane.showInputDialog(
                    this, "Colonne", "Colonne", JOptionPane.PLAIN_MESSAGE,
                    null, null, 10));
            nbrMines = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Mines", "Mines",
                    JOptionPane.PLAIN_MESSAGE, null, null, 10));
                    newsetup.setSetup(buttons, presencemines, clickdone, clickable, layout, fenetre, newrandMine, newsetnumber, p, ligne, colonne, nbrMines, numbers, mineLabel);
            newsetup.setupI2();
        }
        if (!won) {
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[(ligne * y) + x]
                            && !won && clickable[(ligne * y) + x]) {
                        newtest.doCheck(x, y);
                        break;
                    }
                }
            }
        }
        if (e.getSource() == newGameButton) {
            newsetup.setup();
            won = false;
            return;
 
        }
        newtest.checkWin();
    }
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            int n = 0;
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[(ligne * y) + x]) {
                        clickable[(ligne * y) + x] = !clickable[(ligne * y)
                                + x];
                    }
                    if (!clickdone[(ligne * y) + x]) {
                        if (!clickable[(ligne * y) + x]) {
                            buttons[(ligne * y) + x].setText("X");
                            n++;
                        } else {
                            buttons[(ligne * y) + x].setText("");
                        }
                        mineLabel.setText("mines: " + nbrMines + " marked: "
                                + n);
                    }
                }
            }
        }
    }
 
    public void mouseReleased(MouseEvent e) {
    }
 
    public void mouseClicked(MouseEvent e) {
    } 
}
