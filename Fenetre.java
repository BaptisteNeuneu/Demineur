/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
/**inclusion des bibliothèques*/
import java.awt.*;
import javax.swing.*;
import java.io.*;
 
public class Fenetre {
    /**
     * initialise la fenetre
     */
    private JFrame fenetre = new JFrame();
    /**
     * initialise le nombre de ligne max
     */
     private int ligne = 30;
    /**
     * initialise le nombre de colonne max
     */
    private int colonne = 30;
    /**
     * initialise le nombre de mine max
     */
    private int nbrMines = 899;
    /**initialise les éléments qui vont se trouver
     * dans le tableau avec les mines,les nombres,
     * les cases cliquables,les cases cliqués
     */
    private boolean[][] presencemines = new boolean[ligne][colonne];
    private boolean[][] clickable = new boolean[ligne][colonne];
    private int[][] numbers = new int[ligne][colonne];
    private boolean[][] clickdone = new boolean[ligne][colonne];
    /**
     * crée la variable booléenne lost
     */
    private boolean lost;
    /**
     * créée l'option de quitter dans le menu paramettre
     */
    private JMenuItem quitter2 = new JMenuItem("quitter");
    /**
     * créé la variable bouton dans le tableau
     * pour qu'il fonctionne avec la grille 
     * et le reste des parametres du tableau
     */
    private JButton[][] buttons = new JButton[ligne][colonne];
    /**
     * crée l'option de crée une nouvelle partie 
     * avec les paramettres actuelle
     */
    private JMenuItem newGameButton = new JMenuItem("nouvelle partie");
    /**
     * crée l'option reglage qui va permettre de crée
     * une nouvelle partie avec des options choisies depuis le jeu
     */
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
            /**
             * On ouvre le fichier save.data
             */
    FileInputStream fichier = new FileInputStream("save.dat");
    /**
     * On récupère ce qui était dans le dossier
     */
    DataInputStream data = new DataInputStream(fichier);
    /**
     * On récupère le nombre de colonne
     */
    colonne=data.readInt();
    /**
     * On récupère le nombre de ligne
     */
    ligne=data.readInt(); 
    /**
     * On récupère la valeur des nombres
     */
    for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
            numbers[x][y] = data.readByte();
            System.out.println("nombre");
        }
    }
    /**
     * On place les mines à l'endroit où 
     * elles étaient au moment de la sauvegarde
     */
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
    /**
     * On met les cases cliquables si elles 
     * le sont et noncliquable si elle ne l'était pas
     */
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
 /**
  * On place les bouttons dans le tableau
  */
       for(int x=0;x<ligne ;x++){
        for(int y= 0;y<colonne;y++) {
            clickdone[x][y] = false;
            buttons[x][y] = new JButton( );
buttons[x][y].setPreferredSize(new Dimension(35, 35));
ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
nbrMines, numbers,quitter2, newGameButton, mineLabel, fenetre,reglage,lost,sauvquit);
buttons[x][y].addActionListener(newbut);
buttons[x][y].addMouseListener(newbut);


}
}


/**
 * On réalise les à l'endroit où l'utilisateur à cliqué
 */
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
/**
 * On récupère le caractere présent sur la case au moment où on a fait un clique droit
 */
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
 /**
  * On recupère le nombre de mines
  */   
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
       /**
        * On créer les boutons en leur passant les paramètres de base
        */
   for (int x = 0; x < ligne; x++) {
    for (int y = 0; y < colonne; y++) {
        presencemines[x][y] = false;
        clickdone[x][y] = false;
        clickable[x][y] = true;
        buttons[x][y] = new JButton( );
        buttons[x][y].setPreferredSize(new Dimension(35, 35));
                ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
    nbrMines, numbers,quitter2, newGameButton, mineLabel, fenetre,reglage,lost,sauvquit);
        buttons[x][y].addActionListener(newbut);
        buttons[x][y].addMouseListener(newbut);
    }
} 
Case b = new Case();
/**
 * On place les mines
 */ 
b.Mine(ligne,colonne,nbrMines,presencemines);
/**
 * On place les numéros en fonction de la position des mines
 */
b.fillnumbers(colonne,ligne,presencemines,numbers,nbrMines);
}
 

/**
 * affiche la fenètre
 */
    public void fenetre1() {
        JLabel mineLabel = new JLabel("nombre de mines restante : " + nbrMines);
/**
 * recupère une sauvegarde existante et/ou génère une nouvelle grille
 */
       if(!nouveau){
        restaurationsauvegarde(mineLabel);
       }else{
           generationgrille(mineLabel);
       }

         GridLayout layout = new GridLayout(ligne, colonne);
        p.setLayout(layout);

        ActionButton newbut = new ActionButton(ligne, colonne, clickdone, clickable, buttons, presencemines, 
        nbrMines, numbers,quitter2, newGameButton, mineLabel, fenetre,reglage,lost,sauvquit);
        for (int x = 0; x < ligne ; x++) {
            for(int y =0;y<colonne;y++){
            p.add(buttons[x][y]);
        }
    }
    /**
     * créée une bar de menu en haut de la fenetre qui contient différend bouton
     */
        JMenuBar menubar = new JMenuBar();
        JMenu menupara = new JMenu("Paramettre");
        //on ajoute les éléments à la fenètre
        reglage.addActionListener(newbut);
        newGameButton.addActionListener(newbut);
        quitter2.addActionListener(newbut);
        sauvquit.addActionListener(newbut);
        menupara.add(reglage);
        menupara.add(newGameButton);
        menupara.add(quitter2);
        menubar.add(menupara);
        /**
         * ajoute le listener de la fenetre pour que lorsque la fenetre 
         * soit fermer le jeu soit enregistré dans le fichiers save.data
         */
        ActionFenetre doFenetre = new ActionFenetre(fenetre,buttons,numbers,
        presencemines,clickable,clickdone,ligne,colonne,nbrMines);
        fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  
        fenetre.addWindowListener(doFenetre);
        fenetre.setJMenuBar(menubar);
        fenetre.add(p);
        fenetre.add(mineLabel, BorderLayout.SOUTH);
        sauvquit.addActionListener(newbut);
        fenetre.add(sauvquit,BorderLayout.NORTH);
        fenetre.pack();
        fenetre.setVisible(true);
    }
    public static void main(String[] args) {
     Fenetre u = new Fenetre();
    u.fenetre1();
    }

}
