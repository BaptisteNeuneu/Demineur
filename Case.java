/**
* @version 26/04/2022
* @author Felix Brineta
*/


public class Case {

	private int ligne;
    private int colonne;
    private boolean[] presencemines;
    private int[] numbers;
    private int nbrMines;

	public void setCase(int colonne,int ligne,boolean[] presencemines,int[] numbers,int nbrMines){
		this.ligne=ligne;
		this.colonne=colonne;
		this.presencemines=presencemines;
		this.numbers=numbers;
		this.nbrMines=nbrMines;
	}

    public void Mine(){
    int minerestant = nbrMines;
        while (minerestant > 0) {
            int x = (int) Math.floor(Math.random() * ligne);
            int y = (int) Math.floor(Math.random() * colonne);
            if (!presencemines[y + x]) {
                presencemines[y + x] = true;
                minerestant--;
            }
        }
    
}
    public void fillnumbers() {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                int cur = (y) + x;
                if (presencemines[cur]) {
                    numbers[cur] = 0;
                    continue;
                }
                int temp = 0;
                boolean l = (x - 1) >= 0;
                boolean r = (x + 1) < ligne;
                boolean u = (y - 1) >= 0;
                boolean d = (y + 1) < colonne;
                int left = y + (x - 1);
                int right =y + (x + 1);
                int up =(y - 1) + x;
                int upleft = (y - 1) + (x - 1);
                int upright = (y - 1) + (x + 1);
                int down = (y + 1) + x;
                int downleft = (y + 1) + (x - 1);
                int downright = (y + 1) + (x + 1);
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