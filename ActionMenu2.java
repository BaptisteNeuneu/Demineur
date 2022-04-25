import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionMenu2  extends JFrame implements TextListener {

    JTextArea newligne;
    JTextArea newcolonne;
    JTextArea newnbrMines;

    public void ActionMenu2(JTextArea newligne,JTextArea newcolonne,JTextArea newnbrMines){
             this.newligne=newligne;
             this.newcolonne=newcolonne;
             this.newnbrMines=newnbrMines;   

    public void actionPerformed(TextEvent xmenu2) {
        if (xmenu2.getSource() == newligne){
            int ligne = Integer.parseInt(newligne);
        }
        if (xmenu2.getSource()== newcolonne){
            int colonne = Integer.parseInt(newcolonne);
        }
        if (xmenu2.getSource()== newnbrMines){
            int nbrMines = Integer.parseInt(newnbrMines);

        }
    }
    }
    }
