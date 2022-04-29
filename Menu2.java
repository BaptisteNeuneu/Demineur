/**
* @version 28/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing.*;
import java.awt.*;

public class Menu2 {
    private JFrame fenetre2 = new JFrame();
    public void Menu21(){

		/*Un objet pour servir de fenetre*/
		
        /*On configure la fenetre*/
        fenetre2.setSize(500,500);
        fenetre2.setMinimumSize(new Dimension(500,500));
        fenetre2.setLocation(200,200);
        fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre2.setTitle("*** Réglages ***");

		/*Configuration nombres de lignes entre 10 et 30*/					
		JLabel txtLigne = new JLabel("Combien de lignes voulez vous ?");
		JTextField newLigne = new JTextField("10");
		/*Configuration nombres de colonnes entre 10 et 30*/			
		JLabel txtColonne = new JLabel("Combien de colonnes voulez vous ?");
		JTextField newColonne = new JTextField("10");
		/*Configuration nombres de mines entre (ligne*colonne)-1*/							
		JLabel txtMines = new JLabel("Combien de mines voulez vous ?");
		JTextField newnbrMines = new JTextField("10");
		/*Configuration bouton Jouer nombre de : "lignes, colonnes, mines " à la fenetre*/								
		JButton btJouer = new JButton();
		btJouer.setText("Jouer");	

		/*Ajout actionlistener pour récupérer actions boutons et JtextField*/
		ActionMenu2 amenu = new ActionMenu2(newLigne,newColonne,newnbrMines,btJouer);
		btJouer.addActionListener(amenu);
		
		/*Créer un JPanel et une grille dedans pour positionner les élements*/
		JPanel panneau = new JPanel();	
		GridLayout grille = new GridLayout(7, 1);
		panneau.setLayout(grille);
		panneau.add(txtLigne);
		panneau.add(newLigne);
		panneau.add(txtColonne);
		panneau.add(newColonne);
		panneau.add(txtMines);
		panneau.add(newnbrMines);
		panneau.add(btJouer);
		/*Centre les éléments dans la grille*/
		txtLigne.setHorizontalAlignment(JLabel.CENTER);
		txtColonne.setHorizontalAlignment(JLabel.CENTER);
		txtMines.setHorizontalAlignment(JLabel.CENTER);
		newLigne.setHorizontalAlignment(JTextField.CENTER);
		newColonne.setHorizontalAlignment(JTextField.CENTER);
		newnbrMines.setHorizontalAlignment(JTextField.CENTER);
		fenetre2.add(panneau);
		/*Afficher menu2*/
        fenetre2.setVisible(true); 
}
}