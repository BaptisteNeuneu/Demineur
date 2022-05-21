/**
* @version 26/04/2022
* @author Félix Brinet
*/
//inclusion des bibliothèques
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionButton implements ActionListener, MouseListener {
    /**Trois variables, une pour le nombre de lignes
     * une autre pour nombre de colonne et
     * une pour le nombre de mines défini par
     * l'utilisateur
     */
    private int ligne;
    private int colonne;
    private int nbrMines;
    /**Création de trois tableaux
     * pour ranger les boutons clicker,
     * les boutons clickable et
     * les mines
     */
    private boolean[] clickdone;
    private boolean[] clickable;
    private boolean[] presencemines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean won;
    private JMenuItem quitter2;
    private JMenuItem reglage;
    private JMenuItem newGameButton;
    private JLabel mineLabel;
    /**Utilisation de la classe test pour
     * pour vérifier si la partie est terminé ou non
     */
    private Test newtest= new Test();
    private JFrame fenetre;
    private boolean lost;



    public ActionButton(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,
    JButton[] buttons,boolean[] presencemines,int nbrtMines,int[] numbers,
    JMenuItem quitter2,JMenuItem newGameButton,GridLayout layout, JPanel p,
    JLabel mineLabel,JFrame fenetre,JMenuItem reglage,boolean lost) {
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
        this.mineLabel=mineLabel;
        this.fenetre=fenetre;
        this.reglage=reglage;
        this.lost=lost;

       
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reglage) {
        ligne = Integer.parseInt((String) JOptionPane.showInputDialog(
                fenetre, "Ligne", "Ligne", JOptionPane.PLAIN_MESSAGE, null,
                null, 10));
        colonne = Integer.parseInt((String) JOptionPane.showInputDialog(
                fenetre, "Colonne", "Colonne", JOptionPane.PLAIN_MESSAGE,
                null, null, 10));
        nbrMines = Integer.parseInt((String) 
        JOptionPane.showInputDialog(fenetre, "Mines", "Mines",
                JOptionPane.PLAIN_MESSAGE, null, null, 10));
        newGameButton.doClick();
        }
        if (!won) {
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[(ligne * y) + x]
                     && clickable[(ligne * y) + x]) {
                                newtest.setTest(ligne, colonne,clickdone, 
                                clickable, presencemines, buttons, numbers,
                                  fenetre, lost);     
                        newtest.doCheck(x, y);
                            }
                }
            }
        }
        newtest.setTest(ligne, colonne, clickdone, clickable, presencemines,
         buttons, numbers, fenetre, lost);
        newtest.checkWin();
        if(e.getSource() == quitter2) {
            Menu i = new Menu();
            i.Menu1();
        }
        if (e.getSource() == newGameButton) {
            fenetre.setVisible(false);
            Fenetre newfenetre = new Fenetre();
            newfenetre.setFenetre(ligne, colonne, nbrMines);
            newfenetre.fenetre1();
            return;
 
        }
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
                    if (e.getSource() == buttons[(ligne * y+x)]) {
                        if (!clickdone[(ligne * y) + x]) {
                            if(buttons[(ligne * y+x)].getText() == "") {
                            buttons[(ligne * y+x)].setText("★");
                            clickable[(ligne * y+x)]= false;
                            n++;
                        } else if(buttons[(ligne * y+x)].getText() == "★") {
                            buttons[(ligne * y+x)].setText("?");
                        } else if(buttons[(ligne * y+x)].getText() == "?") {
                            buttons[(ligne * y+x)].setText("");
                            clickable[(ligne * y+x)]= true;
                        }
                    }

                    }
                        int k = nbrMines - n;
                        mineLabel.setText("nombres de mines restantes : " + k);
                    }
                }
            }
        }
 
    public void mouseReleased(MouseEvent e) {
    }
 
    public void mouseClicked(MouseEvent e) {
    } 
}
