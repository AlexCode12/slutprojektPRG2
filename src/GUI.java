import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    public GUI() {
       JButton nev = new JButton ("New");
       nev.setBounds(25,100,30,30);
       JButton listen = new JButton("Listen on port: ");
       JButton connect = new JButton("Connect");
        JFrame frame = new JFrame();
        frame.add(nev);
        frame.setSize(600, 400);
       frame.setLayout(null);
       frame.setVisible(true);

    }
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            Object source = evt.getSource();
            /*
            TÄnkt att behandla alla actions när de uppstår
             */
        }
    }

    public static void main(String[] args) {
        GUI window = new GUI();
        window.setVisible(true);
    }
}
