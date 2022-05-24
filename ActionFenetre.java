/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
/**
 * inclusion des bibliothèques
 */

import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.WindowListener;
import java.io.*;



public class ActionFenetre implements WindowListener {

private JFrame fenetre;
private JButton[][] buttons;
private int[][] numbers;
private boolean[][] presencemines;
private boolean[][] clickable;
private boolean[][] clickdone;
private int ligne;
private int colonne;
private int nbrMines;

public ActionFenetre(JFrame fenetre,JButton[][] buttons, int[][] numbers,boolean[][] presencemines,boolean[][] clickable,boolean[][] clickdone,int ligne, int colonne,int nbrMines) {
    super();
    this.fenetre=fenetre;
    this.colonne=colonne;
    this.ligne=ligne;
    this.numbers=numbers;
    this.buttons=buttons;
    this.presencemines=presencemines;
    this.clickable=clickable;
    this.clickdone=clickdone;
    this.nbrMines=nbrMines;
}


public void windowActivated(WindowEvent evenement) {

}     

public void windowClosed(WindowEvent evenement) {

}       

public void windowClosing(WindowEvent evenement) {
    int n=0;

    try {
        //supprime le fichier existant
        File delete = new File("save.dat");
        delete.delete();
        //crée un nouveau fichier
        FileOutputStream fichier = new FileOutputStream("save.dat");
        //permet de rajouter ce que l'on veut mettre dns ce fichier
        DataOutputStream flux = new DataOutputStream(fichier);
        //ajoute le nombre de colonne
        flux.writeInt(colonne);
        //ajoute le nombre de ligne
        flux.writeInt(ligne);
       
        

        //enregistre le nombre présent dans les cases
        for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
                switch(numbers[x][y]) {
                    case 0:
                    flux.writeByte(9);
                    case 1 :
                    flux.writeByte(1); 
                    case 2 :
                    flux.writeByte(2);
                    case 3 :
                    flux.writeByte(3);
                    case 4 :
                    flux.writeByte(4);
                    case 5 :
                    flux.writeByte(5);
                    case 6 :
                    flux.writeByte(6);
                    case 7 :
                    flux.writeByte(7);
                    case 8 :
                    flux.writeByte(8);
                }   
            }
        }
        //enregistre la présence ou non de mine
        for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if(presencemines[x][y] == true) {
                    flux.writeByte(1);
                } else if ( presencemines[x][y] == false){
                    flux.writeByte(2);
                }
            }
        }
        //enregistre si la case est cliquable ou non
                for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if(clickable[x][y] == true) {
                    flux.writeByte(1);
                } else if ( clickable[x][y] == false){
                    flux.writeByte(2);
                }
            }
        }
        //enregistre si la case a été cliquée ou non
                for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if (clickdone[x][y] == true ) {
                    flux.writeByte(1);
                } else if ( clickdone[x][y] == false){
                    flux.writeByte(2);
                }
            }
        }
        //enregistre le caractere contenue dans la case
                for(int x=0;x<ligne ;x++){
            for(int y= 0;y<colonne;y++) {
            if(buttons[x][y].getText() == "" ){
                flux.writeByte(1);
            }
            if(buttons[x][y].getText() == "?" ){
                flux.writeByte(2);
            }
            if(buttons[x][y].getText() == "★") {
                flux.writeByte(3);
                n++;
            }
            }       
        }
        //enregistre le nombre de mines
        nbrMines = nbrMines - n;
         flux.writeByte(nbrMines);
        flux.close();
        Menu retourmenu = new Menu();
        retourmenu.Menu1();
        fenetre.dispose();
    } catch (FileNotFoundException e1) {
        System.err.println("Erreur pas de fichier");
    } catch (IOException e2) {
        System.err.println("Erreur pas de fichier");
    }

} 


public void windowDeactivated(WindowEvent evenement) {

}  




public void windowDeiconified(WindowEvent evenement) {

}    




public void windowIconified(WindowEvent evenement) {

}     


public void windowOpened(WindowEvent evenement) {

}         
}