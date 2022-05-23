/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.WindowListener;
import java.io.*;



public class ActionFenetre implements WindowListener {

private JFrame fenetre;
private JButton[] buttons;
private int[] numbers;
private boolean[] presencemines;
private boolean[] clickable;
private boolean[] clickdone;
private int ligne;
private int colonne;
private int nbrMines;

public ActionFenetre(JFrame fenetre,JButton[] buttons, int[] numbers,boolean[] presencemines,boolean[] clickable,boolean[] clickdone,int ligne, int colonne,int nbrMines) {
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
        File delete = new File("save.dat");
        delete.delete();
        FileOutputStream fichier = new FileOutputStream("save.dat");
        DataOutputStream flux = new DataOutputStream(fichier);
        flux.writeInt(colonne);
        flux.writeInt(ligne);
       
        


        for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
                switch(numbers[(ligne * y+x)]) {
                    case 0:
                    flux.writeByte(0);
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
        for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if(presencemines[(ligne * y+x)] == true) {
                    flux.writeBoolean(true);
                } else {
                    flux.writeBoolean(false);
                }
            }
        }
                for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if(clickable[(ligne * y+x)] == true) {
                    flux.writeBoolean(true);
                } else {
                    flux.writeBoolean(false);
                }
            }
        }
                for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if (clickdone[(ligne*y+x)] == true ) {
                    flux.writeBoolean(true);
                } else {
                    flux.writeBoolean(false);
                }
            }
        }
                for(int x=0;x<ligne ;x++){
            for(int y= 0;y<colonne;y++) {
            if(buttons[(ligne * y+x)].getText() == "" ){
                flux.writeByte(9);
            }
            if(buttons[(ligne * y+x)].getText() == "?" ){
                flux.writeByte(10);
            }
            if(buttons[(ligne * y + x)].getText() == "★") {
                flux.writeByte(11);
                n++;
            }
            }       
        }
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