import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonActionAnonym extends JFrame {
    public ButtonActionAnonym() {
        setSize(300, 100);
        getContentPane().setLayout(new FlowLayout());

        JButton okButton = new JButton("OK");
        add(okButton);
        okButton.addActionListener(new ActionListener() { //Klasse wird direkt im Argument der Methode definiert
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK");
            } //Neue Instanz von Listener wird erstellt und Performed überschrieben
        });

        JButton okButton2 = new JButton("OK2");
        add(okButton2);
        //Anoynm= Klasse ohne Namen, die direkt bei Deklaration instantiiert wird

        class Print5Stars implements ActionListener {
            public void actionPerformed(ActionEvent e) { //Lokale wird innerhalb der Methode definiert
                for (int i = 0; i < 5; i++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }//Implementiert interface und überschreibt Performed

        okButton2.addActionListener(new Print5Stars()); //Instanz der lok. Klasse wird hier verwendet

        setVisible(true);
        //Lokale Klasse = wird innerhalb der Methode definiert
    }

    public static void main(String[] args) {
        new ButtonActionAnonym();
    }
}
