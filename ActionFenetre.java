/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.WindowListener;

public class ActionFenetre  extends JFrame implements WindowListener {
    
    public void windowClosing(WindowEvent e){  
        System.exit(0);   
    }
}