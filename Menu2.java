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
		GridLayout gestionnaire = new GridLayout(3, 2);
		JPanel panneauligne = new JPanel();
		JPanel panecritligne = new JPanel();
		JPanel panneaucolonne = new JPanel();
		JPanel panecritcolonne = new JPanel();
		JPanel panneaunbrMines = new JPanel();
		JPanel panecritnbrMines = new JPanel();
		TextArea newligne = new TextArea("", 3,3);
		TextArea newcolonne = new TextArea("", 3,3);
		TextArea newnbrMines = new TextArea("", 3,3);
		ActionMenu2 amenu2 = new ActionMenu2(newligne, newcolonne, newnbrMines);
		newligne.textValueChanged(amenu2);
		newcolonne.textValueChanged(amenu2 );
		newnbrMines.textValueChanged(amenu2 );
		fenetre2.add(panneauligne);
		panecritligne.add(newligne);
		fenetre2.add(panecritligne);
		fenetre2.add(panneaucolonne);
		panecritcolonne.add(newcolonne);
		fenetre2.add(panecritcolonne);
		fenetre2.add(panneaunbrMines);
		panecritnbrMines.add(newnbrMines);
		fenetre2.add(panecritnbrMines);
        fenetre2.setVisible(true); /*Afficher la fenêtre*/
	}
}
