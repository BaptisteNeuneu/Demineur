/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.WindowListener;
import java.io.*;



public class ActionFenetre implements WindowListener{

    private JButton[] buttons;
private int[] numbers;
private boolean[] presencemines;
private boolean[] clickable;
private boolean[] clickdone;
private int ligne;
private int colonne;
private int nbrMines;

public ActionFenetre(JButton[] buttons, int[] numbers,boolean[] presencemines,boolean[] clickable,boolean[] clickdone,int ligne, int colonne,int nbrMines) {
    super();
    this.colonne=colonne;
    this.ligne=ligne;
    this.numbers=numbers;
    this.buttons=buttons;
    this.presencemines=presencemines;
    this.clickable=clickable;
    this.clickdone=clickdone;
    this.nbrMines=nbrMines;
}


public void windowActivated(WindowEvent evenement) {}     

public void windowClosed(WindowEvent evenement) {}       

public void windowClosing(WindowEvent evenement) {
    int n=0;
    String a;
    try {
        File delete = new File("save.dat");
        delete.delete();
        FileOutputStream fichier = new FileOutputStream("save.dat");
        DataOutputStream flux = new DataOutputStream(fichier);
        flux.writeInt(colonne);
        flux.writeInt(ligne);
        flux.writeInt(nbrMines);
        for(int x=0;x<ligne ;x++){
            for(int y= 0;y<colonne;y++){
            a = buttons[(ligne * y+x)].getText();
            if(buttons[(ligne * y + x)].getText() == "★"){
                n++;
            }
            flux.writeChars(a); 
            }       
        }
        flux.writeInt(n);
        for(int x=0;x<ligne ;x++){
            for(int y= 0;y<colonne;y++){
                switch(numbers[(ligne * y+x)]){
                    case 0:
                    flux.writeInt(0);
                    case 1 :
                    flux.writeInt(1); 
                    case 2 :
                    flux.writeInt(2);
                    case 3 :
                    flux.writeInt(3);
                    case 4 :
                    flux.writeInt(4);
                    case 5 :
                    flux.writeInt(5);
                    case 6 :
                    flux.writeInt(6);
                    case 7 :
                    flux.writeInt(7);
                    case 8 :
                    flux.writeInt(8);
                }
                if(presencemines[(ligne * y+x)] == true){
                    flux.writeByte(1);
                } else {
                    flux.writeByte(0);
                }
                if(clickable[(ligne * y+x)] == true){
                    flux.writeByte(1);
                } else {
                    flux.writeByte(0);
                }
                if (clickdone[(ligne*y+x)] == true ){
                    flux.writeByte(1);
                } else {
                    flux.writeByte(0);
                }
            }
        }
        

        flux.close();
    } catch (FileNotFoundException e1) {
        System.err.println("Erreur pas de fichier");
    } catch (IOException e2) {
        System.err.println("Erreur pas de fichier");
    }

} 


public void windowDeactivated(WindowEvent evenement){}  




public void windowDeiconified(WindowEvent evenement){}    




public void windowIconified(WindowEvent evenement){}     


public void windowOpened(WindowEvent evenement){}         
}