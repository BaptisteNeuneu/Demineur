import java.awt.*;
import javax.swing.*;
 
public class TestFenetre extends JFrame  {
 
    private int rows;
    private int cols;
    private int numMines;
    GridLayout layout = new GridLayout(rows, cols);
    /*type[][] name = new type[rows][cols];
     * type[x][y];
     * is 1d
     * type[] name = new type[rows*cols];
     * type[(rows*y)+x];*/
    private boolean[] mines = new boolean[rows * cols];
    private boolean[] clickable = new boolean[rows * cols];
    private boolean lost = false;
    private boolean won = false;
    private int[] numbers = new int[rows * cols];
    private boolean[] clickdone = new boolean[rows * cols];
    JButton[] buttons = new JButton[rows * cols];
    JMenuItem newGameButton = new JMenuItem("new game");
    JMenuItem reglage = new JMenuItem("options");
    JLabel mineLabel = new JLabel("mines: " + numMines + " marked: 0" + " suposition: 0");
    JPanel p = new JPanel();
 
    public void Fenetre1() {
        p.setLayout(layout);
        setupI();
        for (int i = 0; i < (rows * cols); i++) {
            p.add(buttons[i]);
        }
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Menu");
        //newGameButton.addActionListener(this);
        m.add(newGameButton);
        //reglage.addActionListener(this);
        m.add(reglage);
        mb.add(m);
        this.setJMenuBar(mb);
        this.add(p);
        this.add(mineLabel, BorderLayout.SOUTH);
        this.pack();
        //reglage.addActionListener(this);
        this.setVisible(true);
    }
 
    public void fillMines() {
        int needed = numMines;
        while (needed > 0) {
            int x = (int) Math.floor(Math.random() * rows);
            int y = (int) Math.floor(Math.random() * cols);
            if (!mines[(rows * y) + x]) {
                mines[(rows * y) + x] = true;
                needed--;
            }
        }
    }
 //regarde si il ya une mine autour et attribut un nombre à la case pur le nombre de mine autour de cette case
    public void fillNumbers() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                int cur = (rows * y) + x;
                if (mines[cur]) {
                    numbers[cur] = 0;
                    continue;
                }
                int temp = 0;
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
                if (u) {
                    if (mines[up]) {
                        temp++;
                    }
                    if (l) {
                        if (mines[upleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (mines[upright]) {
                            temp++;
                        }
                    }
                }
                if (d) {
                    if (mines[down]) {
                        temp++;
                    }
                    if (l) {
                        if (mines[downleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (mines[downright]) {
                            temp++;
                        }
                    }
                }
                if (l) {
                    if (mines[left]) {
                        temp++;
                    }
                }
                if (r) {
                    if (mines[right]) {
                        temp++;
                    }
                }
                numbers[cur] = temp;
            }
        }
    }
    public void setupI() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                mines[(rows * y) + x] = false;
                clickdone[(rows * y) + x] = false;
                clickable[(rows * y) + x] = true;
                buttons[(rows * y) + x] = new JButton( "" + ( x * y ));
                buttons[(rows * y) + x].setPreferredSize(new Dimension(
                        45, 45));
                //buttons[(rows * y) + x].addActionListener(this);
                //buttons[(rows * y) + x].addMouseListener(this);
            }
        }
        fillMines();
        fillNumbers();
    }

    public void setupI2() {
        this.remove(p);
        p = new JPanel();
        layout = new GridLayout(rows, cols);
        p.setLayout(layout);
        buttons = new JButton[rows * cols];
        mines = new boolean[rows * cols];
        clickdone = new boolean[rows * cols];
        clickable = new boolean[rows * cols];
        numbers = new int[rows * cols];
        setupI();
        for (int i = 0; i < (rows * cols); i++) {
            p.add(buttons[i]);
        }
        this.add(p);
        this.pack();
        fillMines();
        fillNumbers();
    }
 
    public void setup() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                mines[(rows * y) + x] = false;
                clickdone[(rows * y) + x] = false;
                clickable[(rows * y) + x] = true;
                buttons[(rows * y) + x].setEnabled(true);
                buttons[(rows * y) + x].setText("");
            }
        }
        fillMines();
        fillNumbers();
        lost = false;
        mineLabel.setText("mines: " + numMines + " marked: 0");
    }
    public static void main(String[] args){
    new Fenetre();
    }

 
 
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