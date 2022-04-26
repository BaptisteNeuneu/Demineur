import javax.swing. *;
import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionMenu2  extends JFrame implements TextListener {

    JTextField newligne;
    JTextField newcolonne;
    JTextField newnbrMines;

    public void ActionMenue2(JTextField newligne,JTextField newcolonne,JTextField newnbrMines){
             this.newligne=newligne;
             this.newcolonne=newcolonne;
             this.newnbrMines=newnbrMines;
    }

    public void actionPerformed(TextEvent xmenu2) {
        if (xmenu2.getSource() == newligne){
            int ligne = Integer.parseInt(newligne.getText());
        }
        if (xmenu2.getSource()== newcolonne){
            int colonne = Integer.parseInt(newcolonne.getText());
        }
        if (xmenu2.getSource()== newnbrMines){
            int nbrMines = Integer.parseInt(newnbrMines.getTest());

        }
    }
    }
 