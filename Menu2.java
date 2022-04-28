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
		JPanel panLigne = new JPanel();									
		JLabel txtLigne = new JLabel("Combien de lignes voulez vous ?");
		JTextField newLigne = new JTextField("10");
		newLigne.setBounds(250,100,200,28);
		/*Configuration nombres de colonnes entre 10 et 30*/
		JPanel panColonne = new JPanel();									
		JLabel txtColonne = new JLabel("Combien de colonne voulez vous ?");
		JTextField newColonne = new JTextField("10");
		newColonne.setBounds(250,140,200,28);
		/*Configuration nombres de mines entre (ligne*colonne)-1*/
		JPanel panMines = new JPanel();									
		JLabel txtMines = new JLabel("Combien de mines voulez vous ?");
		JTextField newnbrMines = new JTextField("10");
		newnbrMines.setBounds(250,180,200,28);
		/*Configuration bouton Jouer nombre de : "lignes, colonnes, mines " à la fenetre*/
		JPanel panJouer = new JPanel();									
		JButton btJouer = new JButton();
		btJouer.setText("Jouer");	
		
		ActionMenu2 amenu = new ActionMenu2(btJouer);
		btJouer.addActionListener(amenu);

		panLigne.add(txtLigne);
		panLigne.add(newLigne);
		fenetre2.add(panLigne);

		panColonne.add(txtColonne);
		panColonne.add(newColonne);
		fenetre2.add(panColonne);

		panMines.add(txtColonne);
		panMines.add(newnbrMines);
		fenetre2.add(panMines);
        fenetre2.setLayout(new BorderLayout());
		panJouer.add(btJouer);
		fenetre2.add(panJouer, BorderLayout.SOUTH);
        fenetre2.setVisible(true); /*Afficher menu2*/
}
}	
