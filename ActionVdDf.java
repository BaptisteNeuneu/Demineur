/**
* @version 11/05/2022
* @author Nevejans Baptiste
*/
/**inclusion des bibliothèques*/
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ActionVdDf implements ActionListener {
private JButton remenudef;
private JButton remenuvic;
private JFrame fenvictoire = new JFrame();
private JFrame fendefaite = new JFrame();
private JFrame fenetre = new JFrame();

	public ActionVdDf(JButton remenudef,JButton remenuvic,JFrame fenvictoire,JFrame fendefaite,JFrame fenetre) {
		this.remenudef=remenudef;
		this.remenuvic=remenuvic;
		this.fenvictoire=fenvictoire;
		this.fendefaite=fendefaite;
		this.fenetre=fenetre;
	}

	// public void deleteSave (){
	// 	try{
	// 		File file = new File("save.dat");
	// 		file.delete();
	// 		if(file.delete()){
	// 		 System.out.println(file.getName() + " est supprimé.");
	// 		}else{
	// 		 System.out.println("Opération de suppression echouée");
	// 		}
	// 	   }catch(Exception e){
	// 		e.printStackTrace();
	// 	   }
	// }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== remenudef){
			Menu i = new Menu();
			i.Menu1();
			fendefaite.dispose();
			fenetre.dispose();
			File delete = new File("save.dat");
        	delete.delete();
			// deleteSave();
        	
		}
		if(e.getSource() == remenuvic) {
			Menu i = new Menu();
			i.Menu1();
			fenvictoire.dispose();
			fenetre.dispose();
			File delete = new File("save.dat");
        	delete.delete();
			// deleteSave();
		}
}
}