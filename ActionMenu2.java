import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionMenu2  extends JFrame implements TextListener {

    TextArea newligne;
    TextArea newcolonne;
    TextArea newnbrMines;

    public void ActionMenu2(TextArea newligne,TextArea newcolonne,TextArea newnbrMines){
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
