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
private int ligne; 
private int colonne;
private int nbrMines;  
public ActionMenu2(JTextField newLigne,JTextField newColonne,JTextField newnbrMines,JButton btJouer){
        this.newLigne=newLigne;
        this.newColonne=newColonne;
        this.newnbrMines=newnbrMines;
        this.btJouer=btJouer;
      }
    public void actionPerformed(ActionEvent menu2) {
        String sLigne = newLigne.getText(); 
        String sColonne = newColonne.getText(); 
        String sMines = newnbrMines.getText();
        ligne = Integer.parseInt(sLigne);
        colonne = Integer.parseInt(sColonne);
        nbrMines = Integer.parseInt(sMines);
        if(menu2.getSource() == btJouer){
            System.out.println("Lignes:"+ligne);  
            System.out.println("Colonnes:"+colonne); 
            System.out.println("Mines:"+nbrMines); 
            Fenetre newFenetre =new Fenetre();
            newFenetre.setFenetre(ligne,colonne,nbrMines);
            newFenetre.fenetre1();
            fenetre2.setVisible(false); /*Fait disparaître la fenêtre*/
    }
    
  
    
 }
 }