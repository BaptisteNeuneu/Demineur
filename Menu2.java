import javax.swing.*;
import java.awt.*;

public class Menu2{


    public void Menu2(){
		/*Un objet pour servir de fenetre*/
        JFrame fenetre2 = new JFrame();
        /*On configure la fenetre*/
        fenetre2.setSize(500,500);
        fenetre2.setMinimumSize(new Dimension(300,300));
        fenetre2.setLocation(200,200);
        fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panneauligne = new JPanel();
		JButton panecritligne = new JButton();
		JPanel panneaucolonne = new JPanel();
		JButton panecritcolonne = new JButton();
		JPanel panneaunbrMines = new JPanel();
		JButton panecritnbrMines = new JButton();
		JTextField newligne = new JTextField("10");
		JTextField newcolonne = new JTextField("10");
		JTextField newnbrMines = new JTextField("10");
	 	ActionMenu2 amenu2 = new ActionMenu2();
		GridLayout gestionnaire = new GridLayout(3, 3);
		fenetre2.setLayout(gestionnaire);
		fenetre2.add(panneauligne);
		panecritligne.add(newligne);
		fenetre2.add(panecritligne);
		panecritligne.addActionListener(amenu2);
		fenetre2.add(panneaucolonne);
		panecritcolonne.add(newcolonne);
		panecritcolonne.addActionListener(amenu2);
		fenetre2.add(panecritcolonne);
		fenetre2.add(panneaunbrMines);
		panecritnbrMines.add(newnbrMines);
		panecritnbrMines.addActionListener(amenu2);
		fenetre2.add(panecritnbrMines);
        fenetre2.setVisible(true); /*Afficher la fenêtre*/
	}
}
