 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionMenu  extends JFrame implements ActionListener {

private  JFrame fenetre;
private JButton quitter;
      public ActionMenu(JFrame fenetre, JButton quitter){
          this.fenetre=fenetre;
          this.quitter=quitter;
      }
    public void actionPerformed(ActionEvent menu1) {
        /*if(menu1.getSource == newgame){
            Menu2 menu2 = new Menu2();
        }*/
        if(menu1.getSource() == quitter){
            fenetre.dispose();

        }
    }
 }