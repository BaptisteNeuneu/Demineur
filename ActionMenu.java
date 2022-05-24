/**
* @version 25/04/2022
* @author Baptiste Nevejans
*/
/**
 * inclusion des bibliothèques
 */
import java.awt.event.*;
import javax.swing.*;

public class ActionMenu implements ActionListener {
    /**
     * On appelle les "Nouvelle Partie", 
     * "Reprendre la partie" et
     * "Quitter la partie" pour pouvoir
     * leur donner des actions.
     */
private JButton quitter;
private JButton newgame;
private JButton reprendregame;
    /**
     * On appelle la fenetre1 pour pouvoir
     * la fermer plus tard
     */
private JFrame fenetre1;


    public ActionMenu(JButton newgame,JButton reprendregame,JButton quitter,JFrame fenetre1) {

        this.fenetre1=fenetre1;
        this.newgame=newgame;
        this.reprendregame=reprendregame;
        this.quitter=quitter;
    }


    public void actionPerformed(ActionEvent menu1) {
        if(menu1.getSource() == newgame) {
            Menu2 newmenu2 =new Menu2();
            newmenu2.Menu21();
            fenetre1.setVisible(false); 
            /**
             * Fait disparaître la fenêtre
             * */

        }else if(menu1.getSource() == reprendregame){
            Fenetre j = new Fenetre();
            j.fenetre1();
            fenetre1.dispose();
           //Setup reprise = new Setup();
           //reprise.setSetup(buttons, presencemines, clickdone, clickable, layout, p, ligne, colonne, nbrMines, numbers, mineLabel, fenetre, reglage, newGameButton,quitter2);
           //reprise.setupI2();  
        }else if(menu1.getSource() == quitter) {
            System.exit(0);

        }
    }
 }