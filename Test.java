/**
* @version 09/05/2022
* @author Baptiste Nevejans
*/
import java.awt.*;
import javax.swing.*;

//import java.util.TimerTask;
//import java.util.Timer;

public class Test  {
    private int ligne;
    private int colonne;
    private boolean[] clickdone;
    private boolean[] presencemines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean lost=false;
    private boolean won = false;
    private JFrame fenetre;
    private JFrame fendefaite;
    private JFrame fenvictoire;
    private JButton remenudef;
    private JButton remenuvic;
    private boolean[] clickable;

    public void setTest(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,boolean[] presencemines,int nbrMines,
    JButton[] buttons,int[] numbers,JMenuItem reglage,JMenuItem newGameButton,GridLayout layout,JPanel p,JLabel mineLabel,JFrame fenetre,boolean lost){
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
        buttons[cur].setBackground(Color.LIGHT_GRAY);
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
            buttons[cur].setText("" + numbers[cur]);
            if (!presencemines[cur] && numbers[cur] == 0) {
                buttons[cur].setText("");
            }
        }
        if (presencemines[cur] && !won) {
            buttons[cur].setText("0");
            doLose();
            return;
        }
        checkWin();
    }
 


    public void checkWin() {
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
    public void doLose() {
        if (lost == false && !won) {
                lost = true;
            
            for (int i = 0; i < ligne * colonne; i++) {
                if (!clickdone[i]) {
                    if(presencemines[i] && clickable[i]){
                    buttons[i].doClick(0);
                } 
                 if(!clickable[i] && !presencemines[i] && !clickdone[i]){
                    buttons[i].doClick(3);
                    buttons[i].doClick(0);
                }
                }
            }
            fendefaite = new JFrame("Defaite");
            fendefaite.setLocation(0,0);

        fendefaite.setSize(500, 200);
                    fendefaite.setSize(500, 200);
            fendefaite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GridLayout apparence = new GridLayout(1,2);
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
            GridLayout apparence = new GridLayout(1,2);
            JPanel f = new JPanel();
            f.setLayout(apparence);
            ActionVdDf clique = new ActionVdDf(remenudef,remenuvic,fenvictoire,fendefaite,fenetre);
            f.add(vic);
            remenuvic.addActionListener(clique);
            f.add(remenuvic);
            fenvictoire.add(f);
            fenvictoire.setVisible(true);
            
            
                    /*Timer timer = new Timer();
                    doClose task = extracted();
                    timer.schedule(task,18000);*/
                    /*Menu newm =new Menu();
                    newm.Menu1();
                    fenetre.setVisible(false);*/
        }
    }
 

}
