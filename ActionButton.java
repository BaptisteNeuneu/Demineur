/**
* @version 26/04/2022
* @author Félix Brinet
*/
/**
 * inclusion des bibliothèques
 */
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ActionButton implements ActionListener, MouseListener {
    /**Trois variables, une pour le nombre de lignes
     * une autre pour nombre de colonne et
     * une pour le nombre de mines défini par
     * l'utilisateur
     */
    private int ligne;
    private int colonne;
    private int nbrMines;
    /**Création de trois tableaux
     * pour ranger les boutons clicker,
     * les boutons clickable et
     * les mines
     */
    private boolean[][] clickdone;
    private boolean[][] clickable;
    private boolean[][] presencemines;
    private JButton[][] buttons;
    private int[][] numbers;
    private boolean won;
    private JMenuItem quitter2;
    private JMenuItem reglage;
    private JMenuItem newGameButton;
    private JLabel mineLabel;
    private JButton sauvquit;
    /**Utilisation de la classe test pour
     * pour vérifier si la partie est terminé ou non
     */
    private Test newtest= new Test();
    private JFrame fenetre;
    private boolean lost;
    private boolean nouveau = true;



    public ActionButton(int ligne,int colonne,boolean[][] clickdone,boolean[][] clickable,
    JButton[][] buttons,boolean[][] presencemines,int nbrMines,int[][] numbers,
    JMenuItem quitter2,JMenuItem newGameButton,
    JLabel mineLabel,JFrame fenetre,JMenuItem reglage,boolean lost,JButton sauvquit) {
        this.ligne=ligne;
        this.colonne=colonne;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.buttons=buttons;
        this.presencemines=presencemines;
        this.nbrMines=nbrMines;
        this.numbers=numbers;
        this.quitter2=quitter2;
        this.newGameButton=newGameButton;
        this.mineLabel=mineLabel;
        this.fenetre=fenetre;
        this.reglage=reglage;
        this.lost=lost;
        this.sauvquit=sauvquit;
       
    }
    
    public void actionPerformed(ActionEvent e) {
        /**
         * permet de relancer une partie avec un nombre de ligne,
         * de colonne,de mines différend
         */
        if (e.getSource() == reglage) {

        ligne = Integer.parseInt((String) JOptionPane.showInputDialog(
                fenetre, "Ligne", "Ligne", JOptionPane.PLAIN_MESSAGE, null,
                null, 10));
        colonne = Integer.parseInt((String) JOptionPane.showInputDialog(
                fenetre, "Colonne", "Colonne", JOptionPane.PLAIN_MESSAGE,
                null, null, 10));
        nbrMines = Integer.parseInt((String) 
        JOptionPane.showInputDialog(fenetre, "Mines", "Mines",
                JOptionPane.PLAIN_MESSAGE, null, null, 10));
                String Sligne = Integer.toString(ligne);
                   String Scolonne= Integer.toString(colonne);
                   String SnbrMines= Integer.toString(nbrMines);
                if(ligne>30 || ligne < 4 ){
                    /**
                    * affichage message erreur dans le terminal
                    * et sur une fenetre d'erreur
                    * pour trop ou pas assez de lignes
                    */
                   System.out.println("Veuillez mettre entre 4 et 30 lignes");
                   int errorLigne = JOptionPane.ERROR_MESSAGE;
                   
                   JOptionPane.showMessageDialog(fenetre,"Veuillez mettre entre 4 et 30 lignes",Sligne ,errorLigne);
                 } if (colonne > 30 || colonne < 4){
                   /**
                    * affichage message erreur dans le terminal
                    * et sur une fenetre d'erreur
                    * pour trop ou pas assez de colonnes
                    */
                   System.out.println("Veuillez mettre entre 4 et 30 colonnes");
                   int errorColonne = JOptionPane.ERROR_MESSAGE;
                   JOptionPane.showMessageDialog(fenetre,"Veuillez mettre entre 4 et 30 colonnes",Scolonne, errorColonne);
                 } if (nbrMines >= ligne * colonne ){
                   /**
                    * affichage message erreur dans le terminal
                    * et sur une fenetre d'erreur
                    * pour trop de mines par 
                    * rapport au nombre de case ou
                    * si il y a autant de mines que de case
                    */
                   System.out.println("Veuillez mettre moins de bombes que de cases");
                   int errorbombe = JOptionPane.ERROR_MESSAGE;
                   JOptionPane.showMessageDialog(fenetre,"Veuillez mettre moins de bombes que de cases",SnbrMines, errorbombe);
                 /**
                  * Dernière vérification que tous les paramètres au dessus sont bons
                  * en même temps sinon le programme se lance alors qu'il y a trop
                  * de mines.
                 */
                 }else if(ligne<30 && ligne > 4 && colonne < 30 && colonne > 4 && nbrMines < ligne * colonne){
        newGameButton.doClick();
        }
    }
    /**
     * s'effectue à chaque clique gauche
     */
        if (!won) {
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[x][y]
                     && clickable[x][y]) {
                    newtest.setTest(ligne, colonne,clickdone, clickable, presencemines, buttons, numbers,
                    fenetre, lost);     
                        newtest.doCheck(x, y);
                            }
                }
            }
        }
        newtest.setTest(ligne, colonne, clickdone, clickable, presencemines,
         buttons, numbers, fenetre, lost);
        newtest.checkWin();
        /**
         * revient au menu sans sauvegarder
         */
        if(e.getSource() == quitter2) {
            Menu i = new Menu();
            i.Menu1();
            fenetre.dispose();
        }
        /**
         * relance une partie avec 
         * les mêmes paramètres que la précédentes
         */
        if (e.getSource() == newGameButton) {
            fenetre.setVisible(false);
            Fenetre newfenetre = new Fenetre();
            newfenetre.setFenetre(ligne, colonne, nbrMines,nouveau);
            newfenetre.fenetre1();
            return;
 
        }
        if (e.getSource() == sauvquit){
            int n=0;

    try {
        /**
         * supprime le fichier existant
         */
        File delete = new File("save.dat");
        delete.delete();
        /**
         * crée un nouveau fichier
         */
        FileOutputStream fichier = new FileOutputStream("save.dat");
        /**
         * permet de rajouter ce que l'on veut mettre dns ce fichier
         */
        DataOutputStream flux = new DataOutputStream(fichier);
        /**
         * ajoute le nombre de colonne
         */
        flux.writeInt(colonne);
        /**
         * ajoute le nombre de ligne
         */
        flux.writeInt(ligne);
       
        

        /**
         * enregistre le nombre présent dans les cases
         */
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
        /**
         * enregistre la présence ou non de mine
         */
        for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if(presencemines[x][y] == true) {
                    flux.writeByte(1);
                } else if ( presencemines[x][y] == false){
                    flux.writeByte(2);
                }
            }
        }
        /**
         * enregistre si la case est cliquable ou non
         */
                for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if(clickable[x][y] == true) {
                    flux.writeByte(1);
                } else if ( clickable[x][y] == false){
                    flux.writeByte(2);
                }
            }
        }
        /**
         * enregistre si la case a été cliquée ou non
         */
                for(int x=0;x<ligne ;x++) {
            for(int y= 0;y<colonne;y++) {
        if (clickdone[x][y] == true ) {
                    flux.writeByte(1);
                } else if ( clickdone[x][y] == false){
                    flux.writeByte(2);
                }
            }
        }
        /**
         * enregistre le caractere contenue dans la case
         */
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
        /**
         * enregistre le nombre de mines
         */
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
    }
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
           
            int n = 0;
            for (int x = 0; x < ligne; x++) {
                for (int y = 0; y < colonne; y++) {
                    if (e.getSource() == buttons[x][y]) {
                        if (!clickdone[x][y]) {
                            if(buttons[x][y].getText() == "") {
                            buttons[x][y].setText("★");
                            clickable[x][y]= false;
                            n++;
                        } else if(buttons[x][y].getText() == "★") {
                            buttons[x][y].setText("?");
                        } else if(buttons[x][y].getText() == "?") {
                            buttons[x][y].setText("");
                            clickable[x][y]= true;
                        }
                    }

                    }
                        int k = nbrMines - n;
                        mineLabel.setText("nombres de mines restantes : " + k);
                    }
                }
            }
        }
 
    public void mouseReleased(MouseEvent e) {
    }
 
    public void mouseClicked(MouseEvent e) {
    } 
}
