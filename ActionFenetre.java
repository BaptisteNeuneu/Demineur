import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionFenetre  extends JFrame,Check implements ActionListener,
MouseListener {
        private boolean[] mines;
        private boolean[] clickable;
        private boolean lost;
        private boolean won;
        private int[] numbers;
        private boolean[] clickdone;
        private int rows = 15;
        private int cols = 10;
        private int numMines = 15;
        public void ActionFenetre(){
        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == difficulty) {
            rows = Integer.parseInt((String) JOptionPane.showInputDialog(
                    this, "Rows", "Rows", JOptionPane.PLAIN_MESSAGE, null,
                    null, 10));
            cols = Integer.parseInt((String) JOptionPane.showInputDialog(
                    this, "Columns", "Columns", JOptionPane.PLAIN_MESSAGE,
                    null, null, 10));
            numMines = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Mines", "Mines",
                    JOptionPane.PLAIN_MESSAGE, null, null, 10));
            setupI2();
        }
        if (!won) {
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (e.getSource() == buttons[(rows * y) + x]
                            && !won && clickable[(rows * y) + x]) {
                        doCheck(x, y);
                        break;
                    }
                }
            }
        }
        if (e.getSource() == newGameButton) {
            setup();
            won = false;
            return;
 
        }
        checkWin();
    }
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            int n = 0;
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (e.getSource() == buttons[(rows * y) + x]) {
                        clickable[(rows * y) + x] = !clickable[(rows * y) + x];
                    }
                    if (!clickdone[(rows * y) + x]) {
                        if (!clickable[(rows * y) + x]) {
                            buttons[(rows * y) + x].setText("X");
                            n++;
                        } else {
                            buttons[(rows * y) + x].setText("");
                        }
                        mineLabel.setText("mines: " + numMines + " marked: "
                                + n);
                    }
                }
            }
        }
    }
 
    public void mouseReleased(MouseEvent e) {
    }
 
    public void mouseClicked(MouseEvent e) {
    }
}
}