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
private JFrame fenvictoire = new JFrame("fenenetre victoire");
private JFrame fendefaite = new JFrame("fenetre défaite");
private JFrame fenetre = new JFrame("fenetre");

	public ActionVdDf(JButton remenudef,JButton remenuvic,
	JFrame fenvictoire,JFrame fendefaite,JFrame fenetre) {
		this.remenudef=remenudef;
		this.remenuvic=remenuvic;
		this.fenvictoire=fenvictoire;
		this.fendefaite=fendefaite;
		this.fenetre=fenetre;
	}
/**
 * Création d'une méthode pour la sauvegarde :
 * Supprime la sauvegarde de la partie
 * précédente lors de la défaite ou de la victoire
 *  pour éviter que le joueur puisse sauvegarder
 * juste avant de perdre et recommencer pleins
 * de fois jusqu'à gagner et cette 
 * suppression est fait pour éviter des bugs
 * Si l'utilisateur gagne, il n'a plus non plus
 * revenir sur sa partie
 */
	public void deleteSave (){
		try{
			File file = new File("save.dat");
			file.delete();
			if(file.delete()){
				System.out.println("Opération de suppression echouée");
			}else{
				System.out.println("Le fichier de sauvegarde suivant est supprimé :"+file.getName() );
			 
			}
		   }catch(Exception e){
			e.printStackTrace();
		   }
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== remenudef){
			/**
			 * Appel méthode deleteSave 
			 * afin de supprimer la sauvegarde
			 * lors de la défaite
			 */
			deleteSave();
			Menu i = new Menu();
			i.Menu1();
			fendefaite.dispose();
			fenetre.dispose();
			
        	
		}
		if(e.getSource() == remenuvic) {
			/**
			 * Appel méthode deletesave
			 * afin de supprimer la sauvegarde
			 * lors de la victoire
			 */
			deleteSave();
			Menu i = new Menu();
			i.Menu1();
			fenvictoire.dispose();
			fenetre.dispose();

			
			
		}
}
}