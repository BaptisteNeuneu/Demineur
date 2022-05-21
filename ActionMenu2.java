/**
* @version 28/04/2022
* @author Brinet Félix
*/
/**inclusion des bibliothèques*/
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

public ActionMenu2(JTextField newLigne,JTextField newColonne,JTextField newnbrMines,JButton btJouer,JFrame fenetre2) {
        this.newLigne=newLigne;
        this.newColonne=newColonne;
        this.newnbrMines=newnbrMines;
        this.btJouer=btJouer;
        this.fenetre2=fenetre2;
      }
      
    public void actionPerformed(ActionEvent menu2) {
        String sLigne = newLigne.getText(); 
        String sColonne = newColonne.getText(); 
        String sMines = newnbrMines.getText();
        ligne = Integer.parseInt(sLigne);
        colonne = Integer.parseInt(sColonne);
        nbrMines = Integer.parseInt(sMines);
        if(menu2.getSource() == btJouer){

            /**Batterie de test pour vérifier que l'utilisateur met entre 4 et 30 lignes/colonnes
             et moins de bombes que de mines**/
            if(ligne>30 || ligne < 4 ){
              System.out.println("Veuillez mettre entre 4 et 30 lignes");
            }else if (colonne > 30 || colonne < 4){
              System.out.println("Veuillez mettre entre 4 et 30 colonnes");
            }else if (nbrMines >= ligne * colonne ){
              System.out.println("Veuillez mettre moins de bombes que de cases");
            }else {
              Fenetre newFenetre =new Fenetre();
              boolean nouveau = true;
              newFenetre.setFenetre(ligne,colonne,nbrMines,nouveau);
              newFenetre.fenetre1();
              fenetre2.dispose();/**Fait disparaître la fenêtre de réglage**/
              /**Impression du nombre de ligne et colonne dans le terminal**/
              System.out.println("Lignes:"+ligne);
              System.out.println("Colonnes:"+colonne); 
              System.out.println("Mines:"+nbrMines); 
              }
            
    
    }
   
  
    
 }
 }