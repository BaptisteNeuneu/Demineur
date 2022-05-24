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
    private boolean[][] presencemines = new boolean[ligne][colonne];
    private boolean[][] clickable = new boolean[ligne][colonne];
    private int[][] numbers = new int[ligne][colonne];
    private boolean[][] clickdone = new boolean[ligne][colonne];
    private boolean lost;
    private JMenuItem quitter2 = new JMenuItem("quitter");
    private JButton[][] buttons = new JButton[ligne][colonne];
    private JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    private JMenuItem reglage = new JMenuItem("option");
    private JPanel p = new JPanel();
    private boolean nouveau;
    private JButton sauvquit= new JButton("Sauvegarder Quitter");

    
   public void setFenetre(int ligne,int colonne,int nbrMines,boolean nouveau) {
       this.ligne=ligne;
       this.colonne=colonne;
       this.nbrMines=nbrMines;
       this.nouveau=nouveau;
   }
   public void restaurationsauvegarde(JLabel mineLabel){
   int n = 0;
        try{
    FileInputStream fichier = new FileInputStream("save.dat");
    DataInputStream data = new DataInputStream(fichier);
    colonne=data.readInt();
    ligne=data.readInt(); 

    for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
            numbers[x][y] = data.readByte();
            System.out.println("nombre");
        }
    }
    for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
             if(data.readByte() == 1){
                presencemines[x][y]=true;
                System.out.println("true");
            } else if(data.readByte() == 2){
                presencemines[x][y]=false;
                System.out.println("false");
            }
        }
    }
        for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
            if(data.readByte() == 1){
                clickable[x][y]=true;
                System.out.println("true");
            } else if(data.readByte() == 2){
                clickable[x][y]=false;
                System.out.println("false");
            }
        }
    }
    int testplacementbouton = 0;
       for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
            clickdone[x][y] = false;
            buttons[x][y] = new JButton( );
buttons[x][y].setPreferredSize(new Dimension(35, 35));
ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
nbrMines, numbers,quitter2, newGameButton, mineLabel, fenetre,reglage,lost);
buttons[x][y].addActionListener(newbut);
buttons[x][y].addMouseListener(newbut);
testplacementbouton++;


}
}
System.out.println("" + testplacementbouton);


        for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
            if(data.readByte() == 1){
                buttons[x][y].doClick();
                System.out.println("clique");
            } else if(data.readByte() == 2){
            System.out.println("pas clique");
        }
    }
}
    for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
        if(   data.readByte() == 1){
            buttons[x][y].setText("");
            System.out.println("espace");
        } else if(   data.readByte() == 2){
            buttons[x][y].setText("?");
            System.out.println("?");
        } else if(   data.readByte() == 3){
            buttons[x][y].setText("★");
            System.out.println("★");
            n++;
        }
        }       
    }
    
    nbrMines = data.readByte();
    nbrMines = nbrMines - n;
mineLabel.setText("nombre de mines restante : " + nbrMines);
    data.close();
}catch(FileNotFoundException e3){
System.err.println("FileNotFoundException");
}catch(IOException e2){
System.err.println("IOException");
}
   }
   public void generationgrille(JLabel mineLabel){
   for (int x = 0; x < ligne; x++) {
    for (int y = 0; y < colonne; y++) {
        presencemines[x][y] = false;
        clickdone[x][y] = false;
        clickable[x][y] = true;
        buttons[x][y] = new JButton( );
        buttons[x][y].setPreferredSize(new Dimension(35, 35));
                ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
    nbrMines, numbers,quitter2, newGameButton, mineLabel, fenetre,reglage,lost);
        buttons[x][y].addActionListener(newbut);
        buttons[x][y].addMouseListener(newbut);
    }
} 
Case b = new Case();
b.Mine(ligne,colonne,nbrMines,presencemines);
b.fillnumbers(colonne,ligne,presencemines,numbers,nbrMines);
}
 
    public void fenetre1() {
        JLabel mineLabel = new JLabel("nombre de mines restante : " + nbrMines);

       if(!nouveau){
        restaurationsauvegarde(mineLabel);
       }else{
           generationgrille(mineLabel);
       }

         GridLayout layout = new GridLayout(ligne, colonne);
        p.setLayout(layout);

        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
        nbrMines, numbers,quitter2, newGameButton, mineLabel, fenetre,reglage,lost);
        for (int x = 0; x < ligne ; x++) {
            for(int y =0;y<colonne;y++){
            p.add(buttons[x][y]);
        }
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
        ActionFenetre doFenetre = new ActionFenetre(fenetre,buttons,numbers,presencemines,clickable,clickdone,ligne,colonne,nbrMines);
        fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  
        fenetre.addWindowListener(doFenetre);
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
