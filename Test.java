/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
import java.awt.*;
import javax.swing.*;

//import java.util.TimerTask;
//import java.util.Timer;

public class Test {
    private int ligne;
    private int colonne;
    private boolean[] clickdone;
    private boolean[] presencemines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean lost;
    private boolean won = false;
    private JFrame fenetre;
    private JFrame fendefaite;
    private JFrame fenvictoire;
    private JButton remenudef;
    private JButton remenuvic;
    private boolean[] clickable;

    public void setTest(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,boolean[] presencemines,
    JButton[] buttons,int[] numbers,JFrame fenetre,boolean lost){
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
    public void doCheck(int x, int y) {
        int cur = (ligne * y) + x;
        boolean l = (x - 1) >= 0;
        boolean r = (x + 1) < ligne;
        boolean u = (y - 1) >= 0;
        boolean d = (y + 1) < colonne;
        int left = (ligne * (y)) + (x - 1);
        int right = (ligne * (y)) + (x + 1);
        int up = (ligne * (y - 1)) + (x);
        int upleft = (ligne * (y - 1)) + (x - 1);
        int upright = (ligne * (y - 1)) + (x + 1);
        int down = (ligne * (y + 1)) + (x);
        int downleft = (ligne * (y + 1)) + (x - 1);
        int downright = (ligne * (y + 1)) + (x + 1);
 
        clickdone[cur] = true;
        buttons[cur].setEnabled(false);
        if (numbers[cur] == 0 && !presencemines[cur] && !lost && !won) {
            if (u && !won) {
                if (!clickdone[up] && !presencemines[up]) {
                    clickdone[up] = true;
                    buttons[up].doClick();
                }
                if (l && !won) {
                    if (!clickdone[upleft] && numbers[upleft] != 0
                            && !presencemines[upleft]) {
                        clickdone[upleft] = true;
                        buttons[upleft].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[upright] && numbers[upright] != 0
                            && !presencemines[upright]) {
                        clickdone[upright] = true;
                        buttons[upright].doClick();
                    }
                }
            }
            if (d && !won) {
                if (!clickdone[down] && !presencemines[down]) {
                    clickdone[down] = true;
                    buttons[down].doClick();
                }
                if (l && !won) {
                    if (!clickdone[downleft] && numbers[downleft] != 0
                            && !presencemines[downleft]) {
                        clickdone[downleft] = true;
                        buttons[downleft].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[downright]
                            && numbers[downright] != 0
                            && !presencemines[downright]) {
                        clickdone[downright] = true;
                        buttons[downright].doClick();
                    }
                }
            }
            if (l && !won) {
                if (!clickdone[left] && !presencemines[left]) {
                    clickdone[left] = true;
                    buttons[left].doClick();
                }
            }
            if (r && !won) {
                if (!clickdone[right] && !presencemines[right]) {
                    clickdone[right] = true;
                    buttons[right].doClick();
                }
            }
        } else {
            //ajout distinction en fonction du nombres
            switch(numbers[cur]){
   
                case 1: 
                    ImageIcon icon1 = new ImageIcon("Images/1.png");
                    Image image1 = icon1.getImage(); // transform it 
                    Image newimg1 = image1.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon1 = new ImageIcon(newimg1);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);
                    buttons[cur].setIcon(icon1);
                    break;
            
                case 2:
                    ImageIcon icon2 = new ImageIcon("Images/2.png");
                    Image image2 = icon2.getImage(); // transform it 
                    Image newimg2 = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon2 = new ImageIcon(newimg2);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                    buttons[cur].setIcon(icon2);
                    break;
            
            
                case 3:
                    ImageIcon icon3 = new ImageIcon("Images/3.png");
                    Image image3 = icon3.getImage(); // transform it 
                    Image newimg3 = image3.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon3= new ImageIcon(newimg3);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                    buttons[cur].setIcon(icon3);
                    break;
            
                case 4:
                    ImageIcon icon4 = new ImageIcon("Images/4.png");
                    Image image4 = icon4.getImage(); // transform it 
                    Image newimg4 = image4.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon4 = new ImageIcon(newimg4);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                    buttons[cur].setIcon(icon4);
                    break;
                case 5:
                ImageIcon icon5 = new ImageIcon("Images/5.png");
                                    Image image5 = icon5.getImage(); // transform it 
                    Image newimg5 = image5.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon5 = new ImageIcon(newimg5);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                buttons[cur].setIcon(icon5);
                break;

                case 6:
                ImageIcon icon6 = new ImageIcon("Images/6.png");
                                    Image image6 = icon6.getImage(); // transform it 
                    Image newimg6 = image6.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon6 = new ImageIcon(newimg6);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                buttons[cur].setIcon(icon6);
                break;
                
                case 7:
                ImageIcon icon7 = new ImageIcon("Images/7.png");
                                    Image image7 = icon7.getImage(); // transform it 
                    Image newimg7 = image7.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon7 = new ImageIcon(newimg7);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                buttons[cur].setIcon(icon7);
                break;

                case 8:
                ImageIcon icon8 = new ImageIcon("Images/8.png");
                    Image image8 = icon8.getImage(); // transform it 
                    Image newimg8 = image8.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    icon8 = new ImageIcon(newimg8);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

                buttons[cur].setIcon(icon8);
                break;
            }
            if (!presencemines[cur] && numbers[cur] == 0) {
                buttons[cur].setText("");
            }
        }
        if (presencemines[cur] && won == false && lost == false) {
            ImageIcon iconbombe = new ImageIcon("Images/bombe.png");
                    Image imagebombe = iconbombe.getImage(); // transform it 
                    Image newimgbombe = imagebombe.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    iconbombe = new ImageIcon(newimgbombe);  // transform it back
                    buttons[cur].setOpaque(false);
                    buttons[cur].setContentAreaFilled(false);
                    buttons[cur].setBorderPainted(false);

            buttons[cur].setIcon(iconbombe);
            if(presencemines[cur]){
                doLose();
                }
            for (int i = 0; i < ligne * colonne; i++) {
                if (!clickdone[i]) {
                    if(presencemines[i] && clickable[i]){
                    buttons[i].doClick(0);
                }  
                 else if(!clickable[i] && !presencemines[i]){
                    clickable[i] = true;
                    buttons[i].doClick(0);
                }
                }
            }

        }
    }
 


    public void checkWin() {
        if(won == false){
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++ ) {
                int cur = (ligne * y) + x;
                if (!clickdone[cur]) {
                    if (presencemines[cur]) {
                        continue;
                    } else {
                        return;
                    }
                } else {
                    if(presencemines[cur]){
                        return;
                    }
                }
            }
        }
        doWin();
    }
    }
    public void doLose() {
        if (lost == false && !won) {
                lost = true;
            
           setTest(ligne, colonne, clickdone, clickable, presencemines, buttons, numbers, fenetre, lost);
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
            ActionVdDf clique = new ActionVdDf(remenudef,remenuvic,fendefaite,fenvictoire,fenetre);
            remenudef.addActionListener(clique);
            f.add(def);
            f.add(remenudef);
            fendefaite.add(f);
            fendefaite.setVisible(true);
        }
    }

            /*JOptionPane.showMessageDialog(null,
                    "Tu as perdue! Retour au menu", "Game over",
                    JOptionPane.ERROR_MESSAGE);
        }
                    fenetre.setVisible(false);
                 Menu newm = new Menu();
                 newm.Menu1();
    }*/
 
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
            ActionVdDf clique = new ActionVdDf(remenudef,remenuvic,fenvictoire,fendefaite,fenetre);
            f.add(vic);
            remenuvic.addActionListener(clique);
            f.add(remenuvic);
            fenvictoire.add(f);
            fenvictoire.setVisible(true);
            
        }
    }
 

}
