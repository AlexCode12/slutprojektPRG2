import javax.swing.*;
/*
Denna klass initierar enbart själva programmet, som finns definierat i GUI.
 */
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Please restart the server if you haven't done so already.");
        JFrame GUI = new JFrame("GUI CHAT");
        GUI.setContentPane(new GUI().MAINPANEL);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.pack();
        GUI.setVisible(true);
    }
}
