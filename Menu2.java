import javax.swing.*;
import java.awt.*;

public class Menu2{

    public void Menu(){
		/*Un objet pour servir de fenetre*/
        JFrame fenetre = new JFrame();
        /*On configure la fenetre*/
        fenetre.setSize(500,500);
        fenetre.setMinimumSize(new Dimension(300,300));
        fenetre.setLocation(200,200);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panneaumenu = new JPanel();
		TextArea newrows = new TextArea("", 3,3);
		newrows.textValueChanged(TextEvent this);
		TextArea newcols = new TextArea("", 3,3);
		newcols.textValueChanged(TextEvent this);
		TextArea newnumMines = new TextArea("", 3,3);
		newnumMines.textValueChanged(TextEvent this);
        fenetre.setVisible(true); /*Afficher la fenêtre*/
	}
}
}