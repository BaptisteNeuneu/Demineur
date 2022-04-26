import javax.swing. *;
import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

 public class PetitTest{
     JFrame cadre = new JFrame();
int A;
private JTextField texte;
void main (){
    cadre.setSize(500,500);
        cadre.setMinimumSize(new Dimension(300,300));
        cadre.setLocation(0,0);
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	texte = new JTextField("10");
	JButton bouton = new JButton("OK");
	bouton.setBounds(40, 180, 160, 50);
	texte.setBounds(40, 125, 340, 50);
	cadre.add(texte);
	cadre.add(bouton);
	bouton.addActionListener(action);
    cadre.setVisible(true);
}
 
ActionListener action = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
	         A = Integer.parseInt(texte.getText());
	         System.out.println(A);
        }
};
public static void main(String[] args){
    new PetitTest();
}
 }