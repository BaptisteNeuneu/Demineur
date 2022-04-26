/**
* @version 25/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques

import java.awt.event.*;
import javax.swing.*;

public class ActionMenu  extends JFrame implements ActionListener {

private JButton quitter;
private JButton newgame;
private JButton reprendregame;
      public ActionMenu(JButton newgame,JButton reprendregame,JButton quitter){
          this.newgame=newgame;
          this.reprendregame=reprendregame;
          this.quitter=quitter;
      }
    public void actionPerformed(ActionEvent menu1) {
        if(menu1.getSource() == newgame){
           Menu2 newmenu2 =new Menu2();
           newmenu2.Menu21();
        }else if (menu1.getSource()== reprendregame){
            System.out.println("la partie reprend");
        }    
        else if(menu1.getSource() == quitter){
            System.exit(0);

        }
    }
 }