/**
* @version 28/04/2022
* @author Brinet Félix
*/
//inclusion des bibliothèques
import java.awt.event.*;
import javax.swing.*;
public class ActionMenu2 implements ActionListener {
private JFrame fenetre2;
private JButton btJouer;
private JTextField newLigne;
private JTextField newColonne;
private JTextField newnbrMines;

public ActionMenu2(JTextField newLigne,JTextField newColonne,JTextField newnbrMines,JButton btJouer){
        this.newLigne=newLigne;
        this.newColonne=newColonne;
        this.newnbrMines=newnbrMines;
          this.btJouer=btJouer;
      }
    public void actionPerformed(ActionEvent menu2) {
        
        if(menu2.getSource() == btJouer){
            int ligne = Integer.parseInt(newLigne.getText());
            int colonne = Integer.parseInt(newColonne.getText());
            int nbrMines = Integer.parseInt(newnbrMines.getText());
            Fenetre newFenetre =new Fenetre();
            newFenetre.setFenetre(ligne,colonne,nbrMines);
            newFenetre.fenetre1();
            fenetre2.setVisible(false); /*Fait disparaître la fenêtre*/
    }
 }
}