/**
* @version 26/04/2022
* @author Baptiste Nevejansa
*/
//inclusion des bibliothèques
public class FillNumber {
    private int ligne;
    private int colonne;
    private boolean[] presencemines;
    private int[] numbers;
    private int nbrMines;
    private Mine newrandMine;

    public void setFillNumber(int ligne,int colonne,boolean[] presencemines,int[] numbers){
        this.ligne=ligne;
        this.colonne=colonne;
        this.presencemines=presencemines;
        this.numbers=numbers;
    }
    public void fillnumbers() {
        newrandMine.setMine( nbrMines,ligne,colonne,presencemines);
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                int cur = (ligne * y) + x;
                if (presencemines[cur]) {
                    numbers[cur] = 0;
                    continue;
                }
                int temp = 0;
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
                if (u) {
                    if (presencemines[up]) {
                        temp++;
                    }
                    if (l) {
                        if (presencemines[upleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (presencemines[upright]) {
                            temp++;
                        }
                    }
                }
                if (d) {
                    if (presencemines[down]) {
                        temp++;
                    }
                    if (l) {
                        if (presencemines[downleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (presencemines[downright]) {
                            temp++;
                        }
                    }
                }
                if (l) {
                    if (presencemines[left]) {
                        temp++;
                    }
                }
                if (r) {
                    if (presencemines[right]) {
                        temp++;
                    }
                }
                numbers[cur] = temp;
            }
        }
    }
}
