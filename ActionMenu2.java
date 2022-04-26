/**
* @version 25/04/2022
* @author Felix Brinet
*/
//inclusion des bibliothèques
import javax.swing. *;
import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionMenu2 implements ActionListener  {

    JButton panecritligne;
    JButton panecritcolonne;
    JButton panecritnbrMines;

    public void ActionMenue2(JButton panecritligne,JButton panecritcolonne,JButton panecritnbrMines){
             this.panecritligne=panecritligne;
             this.panecritcolonne=panecritcolonne;
             this.panecritnbrMines=panecritnbrMines;
    }

    public void actionPerformed(ActionEvent xmenu2) {
        if (xmenu2.getSource() == panecritligne){
            int ligne = Integer.parseInt(panecritligne.getText());
            System.out.println("Le nombre de lignes est de"+ligne);
        }
        if (xmenu2.getSource()== panecritcolonne){
            int colonne = Integer.parseInt(panecritcolonne.getText());
            System.out.println("Le nombre de colonne est de"+colonne);
        }
        if (xmenu2.getSource()== panecritnbrMines){
            int nbrMines = Integer.parseInt(panecritnbrMines.getText());
            System.out.println("Le nombre de mines"+nbrMines);

        }
    }
    }

 