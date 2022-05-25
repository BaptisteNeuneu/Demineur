/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
/**
 * inclusion des bibliothèques
 */
import java.awt.*;
import javax.swing.*;

//import java.util.TimerTask;
//import java.util.Timer;

public class Test {
    private int ligne;
    private int colonne;
    private boolean[][] clickdone;
    private boolean[][] presencemines;
    private JButton[][] buttons;
    private int[][] numbers;
    private boolean lost;
    private boolean won = false;
    private JFrame fenetre;
    private JFrame fendefaite;
    private JFrame fenvictoire;
    private JButton remenudef;
    private JButton remenuvic;
    private boolean[][] clickable;

    public void setTest(int ligne,int colonne,boolean[][] clickdone,boolean[][] clickable,boolean[][] presencemines,
    JButton[][] buttons,int[][] numbers,JFrame fenetre,boolean lost){
        this.ligne=ligne;
        this.colonne=colonne;
        this.clickdone=clickdone;
        this.presencemines=presencemines;
        this.buttons=buttons;
        this.numbers=numbers;
        this.fenetre=fenetre;
        this.lost=lost;
        this.clickable=clickable;

        
    }
    /**
     * Effectue les tests pour chaque case lorsqu'elles sont cliquées 
     */
    public void doCheck(int x, int y) {
        /**
         * Vérifie que l'on a pas dépassé la case la plus à gauche
         */
        boolean l = (y - 1) >= 0;
        /**
         * Vérifie que l'on a pas dépassé la case la plus à droite
         */
        boolean r = (y + 1) < colonne;
        /**
         * Vérifie que l'on a pas dépassé la case la plus en haut
         */
        boolean u = (x - 1) >= 0;
        /**
         * Vérifie la case la plus en bas
         */
        boolean d = (x + 1) < ligne;
        /**
         * Permet de regarder la case à gauche
         */
        int left = (y - 1); 
        /**
         * Permet de regarder la case à droite
         */                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        int right = (y + 1);
        /**
         * Permet de regarder la case juste au-dessus
         */
        int up = (x -1);
        /**
         * Permet de regarder la case juste en-dessous
         */
        int down = (x + 1);
        /**
         * Le bouton a été cliqué et il est désactivé
         */
        clickdone[x][y] = true;
        buttons[x][y].setEnabled(false);
        /**
         * vérifie que la case a un nombre de zero , 
         * que ce n'est pas une mine et que l'on a pas gagné 
         */
        if (numbers[x][y] == 0 && !presencemines[x][y]  && !won) {
            /**
             * Vérifie à chaque fois la case en haut,en haut à gauche
             * En haut à droite,en bas,en bas à gauche,en bas à droite
             * à gauche et à droite.
             * On vérifie ensuite que la case n'a pas déja été cliqué.
             * Puis le clique devient vrai et on clique sur la case
             */
            if (u && !won) {
                if (!clickdone[up][y] ) {
                    clickdone[up][y] = true;
                    buttons[up][y].doClick();
                }
                if (l && !won) {
                    if (!clickdone[up][left]  ) {
                        clickdone[up][left] = true;
                        buttons[up][left].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[up][right]) {
                        clickdone[up][right] = true;
                        buttons[up][right].doClick();
                    }
                }
            }
            if (d && !won) {
                if (!clickdone[down][y] ) {
                    clickdone[down][y] = true;
                    buttons[down][y].doClick();
                }
                if (l && !won) {
                    if (!clickdone[down][left]  ) {
                        clickdone[down][left] = true;
                        buttons[down][left].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[down][right] ) {
                        clickdone[down][right] = true;
                        buttons[down][right].doClick();
                    }
                }
            }
            if (l && !won) {
                if (!clickdone[x][left] ) {
                    clickdone[x][left] = true;
                    buttons[x][left].doClick();
                }
            }
            if (r && !won) {
                if (!clickdone[x][right] ) {
                    clickdone[x][right] = true;
                    buttons[x][right].doClick();
                }
            }
        } else {
            /**
             * ajout distinction en fonction du nombres
             */
            switch(numbers[x][y]){
   
                case 1: 
                    ImageIcon icon1 = new ImageIcon("Images/1.png");
                    Image image1 = icon1.getImage(); // transform it 
                    Image newimg1 = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon1 = new ImageIcon(newimg1);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);
                    buttons[x][y].setIcon(icon1);
                    break;
            
                case 2:
                    ImageIcon icon2 = new ImageIcon("Images/2.png");
                    Image image2 = icon2.getImage(); // transform it 
                    Image newimg2 = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon2 = new ImageIcon(newimg2);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                    buttons[x][y].setIcon(icon2);
                    break;
            
            
                case 3:
                    ImageIcon icon3 = new ImageIcon("Images/3.png");
                    Image image3 = icon3.getImage(); // transform it 
                    Image newimg3 = image3.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon3= new ImageIcon(newimg3);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                    buttons[x][y].setIcon(icon3);
                    break;
            
                case 4:
                    ImageIcon icon4 = new ImageIcon("Images/4.png");
                    Image image4 = icon4.getImage(); // transform it 
                    Image newimg4 = image4.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon4 = new ImageIcon(newimg4);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                    buttons[x][y].setIcon(icon4);
                    break;
                case 5:
                ImageIcon icon5 = new ImageIcon("Images/5.png");
                                    Image image5 = icon5.getImage(); // transform it 
                    Image newimg5 = image5.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon5 = new ImageIcon(newimg5);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                buttons[x][y].setIcon(icon5);
                break;

                case 6:
                ImageIcon icon6 = new ImageIcon("Images/6.png");
                                    Image image6 = icon6.getImage(); // transform it 
                    Image newimg6 = image6.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon6 = new ImageIcon(newimg6);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                buttons[x][y].setIcon(icon6);
                break;
                
                case 7:
                ImageIcon icon7 = new ImageIcon("Images/7.png");
                                    Image image7 = icon7.getImage(); // transform it 
                    Image newimg7 = image7.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon7 = new ImageIcon(newimg7);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                buttons[x][y].setIcon(icon7);
                break;

                case 8:
                ImageIcon icon8 = new ImageIcon("Images/8.png");
                    Image image8 = icon8.getImage(); // transform it 
                    Image newimg8 = image8.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon8 = new ImageIcon(newimg8);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

                buttons[x][y].setIcon(icon8);
                break;
            }
            if (!presencemines[x][y] && numbers[x][y] == 0) {
                buttons[x][y].setText("");
            }
        }
        if (presencemines[x][y] && won == false && lost == false) {
            ImageIcon iconbombe = new ImageIcon("Images/bombe.png");
                    Image imagebombe = iconbombe.getImage(); // transform it 
                    Image newimgbombe = imagebombe.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    iconbombe = new ImageIcon(newimgbombe);  // transform it back
                    buttons[x][y].setOpaque(false);
                    buttons[x][y].setContentAreaFilled(false);
                    buttons[x][y].setBorderPainted(false);

            buttons[x][y].setIcon(iconbombe);
            /**
             * Si clique sur la bombe alors la fin ce lance
             */
            if(presencemines[x][y]){
                doLose();
                /**
                 * Revelation des cases demandé mais ouvre plusieur fois doLose
                 */
            for ( x = 0; x < ligne; x++) {
                for( y=0;y<colonne;y++){
                if (!clickdone[x][y]) {
                    if(presencemines[x][y] && clickable[x][y]){
                    buttons[x][y].doClick(0);
                }  
                 else if(!clickable[x][y] && !presencemines[x][y]){
                    clickable[x][y] = true;
                    buttons[x][y].doClick(0);
                }
                }
            }
            }
        }

        }
    }
 

    /**
     * Vérifie la victoire
     */
    public void checkWin() {
        if(won == false){
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++ ) {
                /**
                 * vérifie que les cases qui n'ont pas été cliqué sont des mines et 
                 * que celle qui ont été cliqué ne sont pas des mines
                 */
                if (!clickdone[x][y]) {
                    if (presencemines[x][y]) {
                        continue;
                    } else {
                        return;
                    }
                } else {
                    if(presencemines[x][y]){
                        return;
                    }
                }
            }
        }
        /**
         * réalise la fonction victoire
         */
        doWin();
    }
    }

    /**
     * la fonction doLOse affiche une fenetre de defaite
     */
    public void doLose() {
        if (lost == false && !won) {
                lost = true;
            fendefaite = new JFrame("Defaite");
            fendefaite.setLocation(0,0);

        fendefaite.setSize(500, 200);
                    fendefaite.setSize(500, 200);
            fendefaite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GridLayout apparence = new GridLayout(2,1);
            JPanel f = new JPanel();
            f.setLayout(apparence);
            JLabel def = new JLabel("Tu as perdue! Retour au menu");
            remenudef = new JButton("OK");
            /**
             * ajoute un listener qui va fermer la fenetre de jeu et du message defaite et supprimer la sauvegarde actuelle
             */
            ActionVdDf clique = new ActionVdDf(remenudef,remenuvic,fendefaite,fenvictoire,fenetre);
            remenudef.addActionListener(clique);
            f.add(def);
            f.add(remenudef);
            fendefaite.add(f);
            fendefaite.setVisible(true);
        }
    }
    /**
     * La fonction doWon affiche une fenetre de victoire
     */
    public void doWin() {
        if (lost == false && won == false) {
            won = true;
            fenvictoire = new JFrame("Victoire");
            fenvictoire.setLocation(0,0);
            fenvictoire.setSize(500, 200);
            fenvictoire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenvictoire.setMinimumSize(new Dimension(500, 200));
            JLabel vic = new JLabel("Tu as gagné!Retour au menu");
            remenuvic = new JButton("OK");
            GridLayout apparence = new GridLayout(2,1);
            JPanel f = new JPanel();
            f.setLayout(apparence);
             /**
             * ajoute un listener qui va fermer la fenetre de jeu et du message victire et supprimer la sauvegarde actuelle
             */
            ActionVdDf clique = new ActionVdDf(remenudef,remenuvic,fenvictoire,fendefaite,fenetre);
            f.add(vic);
            remenuvic.addActionListener(clique);
            f.add(remenuvic);
            fenvictoire.add(f);
            fenvictoire.setVisible(true);
            
        }
    }
 

}
