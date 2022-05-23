/**
* @version 28/04/2022
* @author Brinet Félix
*/
/**inclusion des bibliothèques*/
import java.awt.event.*;
import javax.swing.*;

public class ActionMenu2 implements ActionListener {
private JFrame fenetre2;
    /**
     * On appelle les zones de textes 
     * + le bouton "jouer" afin de
     * leur donner des actions.
     */
private JButton btJouer;
private JTextField newLigne;
private JTextField newColonne;
private JTextField newnbrMines;
    /**
     * On récupère les variables 
     * de ligne, colonne et nombre 
     * de mines afin de vérifier leurs 
     * tailles
    */
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
               /**
               * affichage message erreur dans le terminal
               * et sur une fenetre d'erreur
               * pour trop ou pas assez de lignes
               */
              System.out.println("Veuillez mettre entre 4 et 30 lignes");
              int errorLigne = JOptionPane.ERROR_MESSAGE;
              JOptionPane.showMessageDialog(fenetre2,"Veuillez mettre entre 4 et 30 lignes",sLigne, errorLigne);
            } if (colonne > 30 || colonne < 4){
              /**
               * affichage message erreur dans le terminal
               * et sur une fenetre d'erreur
               * pour trop ou pas assez de colonnes
               */
              System.out.println("Veuillez mettre entre 4 et 30 colonnes");
              int errorColonne = JOptionPane.ERROR_MESSAGE;
              JOptionPane.showMessageDialog(fenetre2,"Veuillez mettre entre 4 et 30 colonnes",sColonne, errorColonne);
            } if (nbrMines >= ligne * colonne ){
              /**
               * affichage message erreur dans le terminal
               * et sur une fenetre d'erreur
               * pour trop de mines par 
               * rapport au nombre de case ou
               * si il y a autant de mines que de case
               */
              System.out.println("Veuillez mettre moins de bombes que de cases");
              int errorbombe = JOptionPane.ERROR_MESSAGE;
              JOptionPane.showMessageDialog(fenetre2,"Veuillez mettre moins de bombes que de cases",sMines, errorbombe);
            /**
             * Dernière vérification que tous les paramètres au dessus sont bons
             * en même temps sinon le programme se lance alors qu'il y a trop
             * de mines.
            */
            }else if(ligne<30 || ligne > 4 || colonne < 30 || colonne > 4|| nbrMines < ligne * colonne){
              Fenetre newFenetre =new Fenetre();
              boolean nouveau = true;
              newFenetre.setFenetre(ligne,colonne,nbrMines,nouveau);
              newFenetre.fenetre1();
              fenetre2.dispose();
              /**
               * Fait disparaître la fenêtre de réglage après
               * avoir lancé le jeu
               */
              /**
               * Impression du nombre de lignes et colonnes dans le terminal
               * juste pour vérifier que les valeurs sont bonnes.
               */
              System.out.println("Lignes:"+ligne);
              System.out.println("Colonnes:"+colonne); 
              System.out.println("Mines:"+nbrMines); 
              }
            
    
    }
   
  
    
 }
 }