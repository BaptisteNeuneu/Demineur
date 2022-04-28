/**
* @version 28/04/2022
* @author Brinet Félix
*/
//inclusion des bibliothèques
import java.awt.event.*;
import javax.swing.*;
public class ActionMenu2 implements ActionListener {
private JFrame fenetre2;
private JButton btJouer;

public ActionMenu2(JButton btJouer){
          this.btJouer=btJouer;
      }
    public void actionPerformed(ActionEvent menu2) {
        if(menu2.getSource() == btJouer){
            Fenetre newFenetre =new Fenetre();
            newFenetre.fenetre1();
            fenetre2.setVisible(false); /*Fait disparaître la fenêtre*/
    }
 }
}