/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
/**inclusion des bibliothèques*/
import java.awt.*;
import javax.swing.*;
import java.io.*;
 
public class Grille {
    private int ligne = 30;
    private int colonne = 30;
    private int nbrMines = 899;
    private boolean[] presencemines = new boolean[ligne * colonne];
    private boolean[] clickable = new boolean[ligne * colonne];
    private int[] numbers = new int[ligne * colonne];
    private boolean[] clickdone = new boolean[ligne * colonne];
    private boolean lost;
    JMenuItem quitter2 = new JMenuItem("quitter");
    JButton[] buttons = new JButton[ligne * colonne];
    JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    JMenuItem reglage = new JMenuItem("option");
    JPanel p = new JPanel();
    boolean nouveau;
    private JButton sauvquit= new JButton("Sauvegarder Quitter");
    private GridLayout layout;
    private JLabel mineLabel;
    private JFrame fenetre;

    public void reprisepartie(){
        int n = 0;
                    try{
                FileInputStream fichier = new FileInputStream("save.dat");
                DataInputStream flux = new DataInputStream(fichier);
                colonne=flux.readInt();
                ligne=flux.readInt(); 

                for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                        numbers[(ligne*y+x)] = flux.readInt();
                    }
                }
                                for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                         if(flux.readBoolean() == true){
                            presencemines[ligne*y+x]=true;
                        } else {
                            presencemines[ligne*y+x]=false;
                        }
                    }
                }
                    for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                        if(flux.readBoolean() == true){
                            clickable[ligne*y+x]=true;
                        } else {
                            clickable[ligne*y+x]=false;
                        }
                    }
                }
                   for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                        clickdone[(ligne * y) + x] = false;
                        buttons[(ligne * y) + x] = new JButton( );
            buttons[(ligne * y) + x].setPreferredSize(new Dimension(30, 30));
                    ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
                    nbrMines, numbers,quitter2, newGameButton, layout,mineLabel, fenetre,reglage,lost);
            buttons[(ligne * y) + x].addActionListener(newbut);
            buttons[(ligne * y) + x].addMouseListener(newbut);
        }
    }
            for(int x=0;x<ligne ;x++){
            for(int y= 0;y<colonne;y++) {
            if(buttons[(ligne * y + x)].getText() == "★") {
                n++;
            } 
            }       
        }


                    for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                        if(flux.readBoolean() == true){
                            buttons[ligne * y+x].doClick();
                        }
                    }
                }
                for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                    flux.readInt();
                    if(   flux.readInt() == 9){
                        buttons[(ligne*y+x)].setText("");
                    } else if(   flux.readInt() == 10){
                        buttons[(ligne*y+x)].setText("?");
                    } else if(   flux.readInt() == 11){
                        buttons[ligne *y+x].setText("★");
                    }
                    }       
                }
                nbrMines = flux.readInt();
                mineLabel = new JLabel("nombre de mines restante : " + nbrMines );
        }catch(FileNotFoundException e3){
            System.err.println("FileNotFoundException");
        }catch(IOException e2){
            System.err.println("IOException");
        }     
    }

    public void generationgrille(int ligne,int colonne,int nbrMines){
        GridLayout layout = new GridLayout(ligne, colonne);
    JLabel mineLabel = new JLabel("nombre de mines restante : " + nbrMines );
    for (int x = 0; x < ligne; x++) {
        for (int y = 0; y < colonne; y++) {
            presencemines[(ligne * y) + x] = false;
            clickdone[(ligne * y) + x] = false;
            clickable[(ligne * y) + x] = true;
            buttons[(ligne * y) + x] = new JButton( );
            buttons[(ligne * y) + x].setPreferredSize(new Dimension(30, 30));
                    ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
                    nbrMines, numbers,quitter2, newGameButton, layout,mineLabel, fenetre,reglage,lost);
            buttons[(ligne * y) + x].addActionListener(newbut);
            buttons[(ligne * y) + x].addMouseListener(newbut);
        }
    } 
Case b = new Case();
b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
b.Mine();
b.fillnumbers();
    }
}
