/**
* @version 26/04/2022
* @author Felix Brinetigne
**/
public class Case {

    /**
     * place les mines aleatoirement dans le tableau
     */
    public void Mine(int ligne,int colonne,int nbrMines,boolean[][] presencemines) {
    int minerestant = nbrMines;
        while (minerestant > 0) {
            int x = (int) Math.floor(Math.random() * ligne);
            int y = (int) Math.floor(Math.random() * colonne);
            if (!presencemines[x][y] ) {
                presencemines[x][y]= true;
                minerestant--;
            }
        }
}   
    /**
     * place les nombres dans les cases
     * en fonctions du nobre de mines autour de celle-ci
     */
    public void fillnumbers(int colonne,int ligne,boolean[][] presencemines,
    int[][] numbers,int nbrMines) {
        for (int x = 0; x < ligne; x++) {
            for (int y = 0; y < colonne; y++) {
                if (presencemines[x][y]) {
                    numbers[x][y] = 0;
                    continue;
                }
                /**
                 * la case commence avec la valeur 0
                 * et augmente si il y a des mines autour
                 */
                int temp = 0;
        /**
         * Vérifie que l'on a pas dépassé la case la plus à gauche
         */
        boolean l = (y - 1) >= 0;
        /**
         * Vérifie que l'on a pas dépassé la case la plus à droite
         */
        boolean r = (y + 1) < colonne;
        /**
         * Vérifie que l'on a pas dépassé la case la plus en haut
         */
        boolean u = (x - 1) >= 0;
        /**
         * Vérifie la case la plus en bas
         */
        boolean d = (x + 1) < ligne;
        /**
         * Permet de regarder la case à gauche
         */
        int left = (y - 1); 
        /**
         * Permet de regarder la case à droite
         */                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        int right = (y + 1);
        /**
         * Permet de regarder la case juste au-dessus
         */
        int up = (x -1);
        /**
         * Permet de regarder la case juste en-dessous
         */
        int down = (x + 1);
        /**
         * vérifie pour chaque position utour de la caase si il y a une mine
         */
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
                /**
                 * la case recupère le nombre de mine autour de cette case
                 */
                numbers[x][y] = temp;
            }
        }
    }

}