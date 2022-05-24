/**
* @version 26/04/2022
* @author Felix Brinetigne
**/
public class Case {

	private int ligne;
    private int colonne;
    private boolean[][] presencemines;
    private int[][] numbers;
    private int nbrMines;

	public void setCase(int colonne,int ligne,boolean[][] presencemines,int[][] numbers,int nbrMines) {
		this.ligne=ligne;
		this.colonne=colonne;
		this.presencemines=presencemines;
		this.numbers=numbers;
		this.nbrMines=nbrMines;
	}

    public void Mine() {
    int minerestant = nbrMines;
        while (minerestant > 0) {
            int x = (int) Math.floor(Math.random() * ligne);
            int y = (int) Math.floor(Math.random() * colonne);
            if (!presencemines[y][x] ) {
                presencemines[y][x]= true;
                minerestant--;
            }
        }
    
}
    public void fillnumbers() {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                if (presencemines[y][x]) {
                    numbers[y][x] = 0;
                    continue;
                }
                int temp = 0;
                boolean l = (y - 1) >= 0;
                boolean r = (y + 1) < colonne;
                boolean u = (x - 1) >= 0;
                boolean d = (x + 1) < ligne;
                int left = (y - 1);
                int right = (y + 1);
                int up = (x -1);
                int down = (x + 1);
                if (u) {
                    if (presencemines[up][y]) {
                        temp++;
                    }
                    if (l) {
                        if (presencemines[up][left]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (presencemines[up][right]) {
                            temp++;
                        }
                    }
                }
                if (d) {
                    if (presencemines[down][y]) {
                        temp++;
                    }
                    if (l) {
                        if (presencemines[down][left]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (presencemines[down][right]) {
                            temp++;
                        }
                    }
                }
                if (l) {
                    if (presencemines[x][left]) {
                        temp++;
                    }
                }
                if (r) {
                    if (presencemines[x][right]) {
                        temp++;
                    }
                }
                numbers[x][y] = temp;
            }
        }
    }

}