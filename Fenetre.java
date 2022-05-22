/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
/**inclusion des bibliothèques*/
import java.awt.*;
import javax.swing.*;
import java.io.*;
 
public class Fenetre {
    private JFrame fenetre = new JFrame();
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

    
   public void setFenetre(int ligne,int colonne,int nbrMines,boolean nouveau) {
       this.ligne=ligne;
       this.colonne=colonne;
       this.nbrMines=nbrMines;
       this.nouveau=nouveau;
   }

   public void setupI() {
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
                    nbrMines, numbers,quitter2, newGameButton, layout, p, mineLabel, fenetre,reglage,lost);
            buttons[(ligne * y) + x].addActionListener(newbut);
            buttons[(ligne * y) + x].addMouseListener(newbut);
        }
    } 
Case b = new Case();
b.setCase(colonne,ligne,presencemines,numbers,nbrMines);
b.Mine();
b.fillnumbers();
}
 
    public void fenetre1() {
        JLabel mineLabel = new JLabel("nombre de mines restante : " + nbrMines);
         GridLayout layout = new GridLayout(ligne, colonne);
        p.setLayout(layout);
       /* if(!nouveau){
            try{
                FileInputStream fichier = new FileInputStream("save.dat");
                DataInputStream flux = new DataInputStream(fichier);
                colonne=flux.readInt();
                ligne=flux.readInt(); 
                char a;
                char b= ?;
                char c= ★;
                for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                    a = flux.readChar();
                    if(a == b ){
                        buttons[(ligne*y+x)].setText("?");
                    } else if(a == c){
                        buttons[(ligne*y+x)].setText("★");
                    } else {
                        buttons[ligne *y+x].setText("");
                    }
                    }       
                }
                nbrMines = flux.readInt();
                for(int x=0;x<ligne ;x++){
                    for(int y= 0;y<colonne;y++) {
                        numbers[(ligne*y+x)] = flux.readInt();
                        if(flux.readBoolean() == true){
                            presencemines[ligne*y+x]=true;
                            clickdone[ligne*y+x]=true;
                            clickable[ligne*y+x]=true;
                        } else {
                            presencemines[ligne*y+x]=false;
                            clickdone[ligne*y+x]=false;
                            clickable[ligne*y+x]=false;
                        }
                    }
                }
        }catch(FileNotFoundException e3){
            System.err.println("FileNotFoundException");
        }catch(IOException e2){
            System.err.println("IOException");
        }}	
        else{
        setupI();
        }*/
        setupI();

        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
        nbrMines, numbers,quitter2, newGameButton, layout, p, mineLabel, fenetre,reglage,lost);
        for (int i = 0; i < (ligne * colonne); i++) {
            p.add(buttons[i]);
        }
        JMenuBar menubar = new JMenuBar();
        JMenu menupara = new JMenu("Paramettre");
        
        reglage.addActionListener(newbut);
        newGameButton.addActionListener(newbut);
        quitter2.addActionListener(newbut);
        sauvquit.addActionListener(newbut);
        menupara.add(reglage);
        menupara.add(newGameButton);
        menupara.add(quitter2);
        menubar.add(menupara);
  

        fenetre.setJMenuBar(menubar);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        fenetre.add(sauvquit,BorderLayout.NORTH);
        fenetre.pack();
        fenetre.setVisible(true);
    }
    public static void main(String[] args) {
     Fenetre u = new Fenetre();
    u.fenetre1();
    }

}
