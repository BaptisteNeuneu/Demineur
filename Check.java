/**
* @version 26/04/2022
* @author Felix Brineta
*/
//inclusion des bibliothèques
import javax.swing.*;
public class Check{
	        public void doCheck(int x, int y) {
        int cur = (rows * y) + x;
        boolean l = (x - 1) >= 0;
        boolean r = (x + 1) < rows;
        boolean u = (y - 1) >= 0;
        boolean d = (y + 1) < cols;
        int left = (rows * (y)) + (x - 1);
        int right = (rows * (y)) + (x + 1);
        int up = (rows * (y - 1)) + (x);
        int upleft = (rows * (y - 1)) + (x - 1);
        int upright = (rows * (y - 1)) + (x + 1);
        int down = (rows * (y + 1)) + (x);
        int downleft = (rows * (y + 1)) + (x - 1);
        int downright = (rows * (y + 1)) + (x + 1);
 
        clickdone[cur] = true;
        buttons[cur].setEnabled(false);
        if (numbers[cur] == 0 && !mines[cur] && !lost && !won) {
            if (u && !won) {
                if (!clickdone[up] && !mines[up]) {
                    clickdone[up] = true;
                    buttons[up].doClick();
                }
                if (l && !won) {
                    if (!clickdone[upleft] && numbers[upleft] != 0
                            && !mines[upleft]) {
                        clickdone[upleft] = true;
                        buttons[upleft].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[upright] && numbers[upright] != 0
                            && !mines[upright]) {
                        clickdone[upright] = true;
                        buttons[upright].doClick();
                    }
                }
            }
            if (d && !won) {
                if (!clickdone[down] && !mines[down]) {
                    clickdone[down] = true;
                    buttons[down].doClick();
                }
                if (l && !won) {
                    if (!clickdone[downleft] && numbers[downleft] != 0
                            && !mines[downleft]) {
                        clickdone[downleft] = true;
                        buttons[downleft].doClick();
                    }
                }
                if (r && !won) {
                    if (!clickdone[downright]
                            && numbers[downright] != 0
                            && !mines[downright]) {
                        clickdone[downright] = true;
                        buttons[downright].doClick();
                    }
                }
            }
            if (l && !won) {
                if (!clickdone[left] && !mines[left]) {
                    clickdone[left] = true;
                    buttons[left].doClick();
                }
            }
            if (r && !won) {
                if (!clickdone[right] && !mines[right]) {
                    clickdone[right] = true;
                    buttons[right].doClick();
                }
            }
        } else {
            buttons[cur].setText("" + numbers[cur]);
            if (!mines[cur] && numbers[cur] == 0) {
                buttons[cur].setText("");
            }
        }
        if (mines[cur] && !won) {
            buttons[cur].setText("0");
            doLose();
        }
    }
 
    public void checkWin() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                int cur = (rows * y) + x;
                if (!clickdone[cur]) {
                    if (mines[cur]) {
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
                    "you win!nstarting a new game", "you lose",
                    JOptionPane.INFORMATION_MESSAGE);
            newGameButton.doClick();
        }
    }
 
    public void doLose() {
        if (!lost && !won) {
            lost = true;
            for (int i = 0; i < rows * cols; i++) {
                if (!clickdone[i]) {
                    buttons[i].doClick(0);
                }
            }
            JOptionPane.showMessageDialog(null,
                    "you lose!nstarting a new game", "you lose",
                    JOptionPane.ERROR_MESSAGE);
            setup();
        }
    }
}