/**
* @version 25/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques
import java.awt.event.*;
import javax.swing.*;
public class ActionMenu implements ActionListener {
private JButton quitter;
private JButton newgame;
private JButton reprendregame;
private JFrame fenetre1;
private JFrame fenetre;



    public ActionMenu(JFrame fenetre,JButton newgame,JButton reprendregame,JButton quitter){
        this.fenetre=fenetre;
        this.newgame=newgame;
        this.reprendregame=reprendregame;
        this.quitter=quitter;
    }


    public void actionPerformed(ActionEvent menu1) {
        if(menu1.getSource() == newgame){
            Menu2 newmenu2 =new Menu2();
            newmenu2.Menu21();
            fenetre1.setVisible(false); /*Fait disparaître la fenêtre*/
        }else if(menu1.getSource() == reprendregame){
            Sauvegarde j = new Sauvegarde();
            j.setSauvegarde(fenetre);
            j.restoresave();
           //Setup reprise = new Setup();
           //reprise.setSetup(buttons, presencemines, clickdone, clickable, layout, p, ligne, colonne, nbrMines, numbers, mineLabel, fenetre, reglage, newGameButton,quitter2);
           //reprise.setupI2();  
        }else if(menu1.getSource() == quitter){
            System.exit(0);

        }
    }
 }