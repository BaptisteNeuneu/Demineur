/**
* @version 26/04/2022
* @author Félix Brineta
*/
//inclusion des bibliothèques
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionButton implements ActionListener, MouseListener{
    private int ligne;
    private int colonne;
    private boolean[] clickdone;
    private boolean[] clickable;
    private boolean[] presencemines;
    private int nbrMines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean won = false;
    private JMenuItem quitter2;
    private JMenuItem reglage;
    private JMenuItem newGameButton;
    private GridLayout layout;
    private JPanel p;
    private JLabel mineLabel;
    private Test newtest= new Test();
    //private Setup newsetup;
    private JFrame fenetre;
   // private boolean lost;


    public ActionButton(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,
    JButton[] buttons,boolean[] presencemines,int nbrMines,int[] numbers,JMenuItem quitter2,
    JMenuItem newGameButton,GridLayout layout, JPanel p,JLabel mineLabel,JFrame fenetre,JMenuItem reglage){
        this.ligne=ligne;
        this.colonne=colonne;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.buttons=buttons;
        this.presencemines=presencemines;
        this.nbrMines=nbrMines;
        this.numbers=numbers;
        this.quitter2=quitter2;
        this.newGameButton=newGameButton;
        this.layout=layout;
        this.p=p;
        this.mineLabel=mineLabel;
        this.fenetre=fenetre;
        this.reglage=reglage;

       
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reglage) {
        ligne = Integer.parseInt((String) JOptionPane.showInputDialog(
                fenetre, "Ligne", "Ligne", JOptionPane.PLAIN_MESSAGE, null,
                null, 10));
        colonne = Integer.parseInt((String) JOptionPane.showInputDialog(
                fenetre, "Colonne", "Colonne", JOptionPane.PLAIN_MESSAGE,
                null, null, 10));
        nbrMines = Integer.parseInt((String) JOptionPane.showInputDialog(fenetre, "Mines", "Mines",
                JOptionPane.PLAIN_MESSAGE, null, null, 10));
        newGameButton.doClick();
        }
        if (!won) {
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[(ligne * y) + x]
                            && !won && clickable[(ligne * y) + x]) {
                                newtest.setTest(ligne,colonne,clickdone,clickable,presencemines,nbrMines,buttons,numbers,reglage,newGameButton,layout,p,mineLabel,fenetre);
                        newtest.doCheck(x, y);
                        break;
                    }
                }
            }
        }
        if(e.getSource() == quitter2){
            Menu i = new Menu();
            i.setMenu(fenetre);
            i.Menu1();
        }
        if (e.getSource() == newGameButton) {
            fenetre.setVisible(false);
            Fenetre newfenetre = new Fenetre();
            newfenetre.setFenetre(ligne, colonne, nbrMines);
            newfenetre.fenetre1();
            won = false;
            return;
 
        }
         newtest.setTest(ligne,colonne,clickdone,clickable,presencemines,nbrMines,buttons,numbers,reglage,newGameButton,layout,p,mineLabel,fenetre);
         newtest.checkWin();
    }
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            int n = 0;
           /* int s = 0;*/
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[(ligne * y) + x]) {
                        clickable[(ligne * y) + x] = !clickable[(ligne * y)
                                + x];
                    }
                    if (!clickdone[(ligne * y) + x]) {
                        if (!clickable[(ligne * y) + x]) {
    
                            /*if(buttons[(ligne * y+x)] == ){
                            buttons[(ligne * y) + x].setText("?");
                            s++;
                       } else{*/
                            buttons[(ligne * y) + x].setText("★");
                            n++;
                        } else {
                            buttons[(ligne * y) + x].setText("");
                        }
                        mineLabel.setText("mines: " + nbrMines + " marked: "
                                + n /*+ "supposition: " + s*/);
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
