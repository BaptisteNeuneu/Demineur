
import java.awt.event.*;
import javax.swing.*;

public class ActionVdDf implements ActionListener {
	private JButton remenudef;
private JButton remenuvic;
private JFrame fenvictoire;
private JFrame fendefaite;
private JFrame fenetre;

	public ActionVdDf(JButton remenudef,JButton remenuvic,JFrame fenvictoire,JFrame fendefaite,JFrame fenetre){
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
			i.setMenu(fenetre);
			fendefaite.setVisible(false);
			fenetre.setVisible(false);
		}
		if(e.getSource() == remenuvic){
			Menu i = new Menu();
			i.setMenu(fenetre);
			i.Menu1();
			fenvictoire.setVisible(false);
			fenetre.setVisible(false);
		}
}
}