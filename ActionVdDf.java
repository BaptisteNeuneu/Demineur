import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

private JButton remenudef;
private JButton remenuvic;
private JFrame fenvictoire;
private JFrame fendefaite;
private JFrame fenetre;


public class ActionVdDf implements ActionListener {
	public ActionVdVf(JButton remenudef,JButton remenuvic,JFrame fenvictoire,JFrame fendefaite,JFrame fenetre){
		this.remenudef=remenudef;
		this.remenuvic=remenuvic;
		this.fenvictoire=fenvictoire;
		this.fendefaite=fendefaite;
		this.fenetre=fenetre;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== remenudef){
			Menu i = new Menu();
			i.Menu1();
			fendefaite.disable();
			fenetre.disable();
		}
		if(e.getSource() == remenuvic){
			Menu i = new Menu();
			i.Menu1();
			fenvictoire.disable();
			fenetre.disable();
		}
}