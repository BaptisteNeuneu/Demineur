/**
* @version 26/04/2022
* @author Baptiste Nevejans
*/
//inclusion des bibliothèques
public class Mine {
    private int nbrMines;
    private int ligne;
    private int colonne; 
    private boolean[] presencemines;

    public void setMine(int nbrMines,int ligne,int colonne,boolean[] presencemines){
        this.nbrMines=nbrMines;
        this.ligne=ligne;
        this.colonne=colonne;
        this.presencemines=presencemines;

    }

    //On ajoute les mines aléatoirement en vérifiant si elles sont déjà présente où non
    public void Mine1(){
    int minerestant = nbrMines;
        while (minerestant > 0) {
            int x = (int) Math.floor(Math.random() * ligne);
            int y = (int) Math.floor(Math.random() * colonne);
            if (!presencemines[(ligne * y) + x]) {
                presencemines[(colonne * y) + x] = true;
                minerestant--;
            }
        }
    
}
}
