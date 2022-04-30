import java.awt.*;
import javax.swing.*;

public class Test {
    private int ligne;
    private int colonne;
    private boolean[] clickdone;
    private boolean[] clickable;
    private boolean[] presencemines;
    private int nbrMines;
    private JButton[] buttons;
    private int[] numbers;
    private boolean lost = false;
    private boolean won = false;
    private JMenuItem reglage;
    private JMenuItem newGameButton;
    private JMenuItem quitter2;
    private GridLayout layout;
    private JPanel p;
    private JLabel mineLabel;
    private JFrame fenetre;

    public void setTest(int ligne,int colonne,boolean[] clickdone,boolean[] clickable,boolean[] presencemines,int nbrMines,
    JButton[] buttons,int[] numbers,JMenuItem reglage,JMenuItem newGameButton,GridLayout layout,JPanel p,JLabel mineLabel){
        this.ligne=ligne;
        this.colonne=colonne;
        this.clickdone=clickdone;
        this.clickable=clickable;
        this.presencemines=presencemines;
        this.nbrMines=nbrMines;
        this.buttons=buttons;
        this.numbers=numbers;
        this.reglage=reglage;
        this.newGameButton=newGameButton;
        this.layout=layout;
        this.p=p;
        this.mineLabel=mineLabel;
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
            buttons[cur].setText("" + numbers[cur]);
            if (!presencemines[cur] && numbers[cur] == 0) {
                buttons[cur].setText("");
            }
        }
        if (presencemines[cur] && !won) {
            buttons[cur].setText("0");
            doLose();
        }
    }
 
    public void checkWin() {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                int cur = (ligne * y) + x;
                if (!clickdone[cur]) {
                    if (presencemines[cur]) {
                        continue;
                    } else {
                        return;
                    }
                }
            }
        }
 
        doWin();
    }
 
    public void doWin() {
        if (!lost && !won) {
            won = true;
            JOptionPane.showMessageDialog(null,
                    "you win!nstarting a new game", "you win",
                    JOptionPane.INFORMATION_MESSAGE);
        }
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
                    "you lose!nstarting a new game", "you lose",
                    JOptionPane.ERROR_MESSAGE);
                    Setup newsetup = new Setup();
                    newsetup.setSetup(buttons,presencemines,clickdone,clickable,layout,p,ligne,colonne,nbrMines,numbers,lost,mineLabel,reglage,fenetre, newGameButton, quitter2);
            newsetup.setup();
        }
    }
}
