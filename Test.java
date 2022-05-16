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
        if (!lost && !won) {
            lost = true;
            
            for (int i = 0; i < ligne * colonne; i++) {
                if (!clickdone[i]) {
                    buttons[i].doClick(0);
                }
            }
            JOptionPane.showMessageDialog(null,
                    "Tu as perdue! Recommence une nouvelle partie", "Game over",
                    JOptionPane.ERROR_MESSAGE);
        }
                    fenetre.setVisible(false);
                 Menu newm = new Menu();
                 newm.Menu1();
    }
 
    public void doWin() {
        if (lost == false && won == false) {
            won = true;
            JOptionPane.showMessageDialog(null,
                    "Tu as gagné! Recommence une nouvelle partie", "Victory",
                    JOptionPane.INFORMATION_MESSAGE);
                    /*Timer timer = new Timer();
                    doClose task = extracted();
                    timer.schedule(task,18000);*/
                    Menu newm =new Menu();
                    newm.Menu1();
                    fenetre.setVisible(false);
        }
    }
 

}
