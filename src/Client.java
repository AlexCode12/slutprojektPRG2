import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog(null, "What IP-adress do you want to connect to?", "Connect to..", JOptionPane.QUESTION_MESSAGE);
        int portnr = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?","Connect to..",JOptionPane.QUESTION_MESSAGE));
        String nickname = JOptionPane.showInputDialog(null, "What's your name?", "My name is..", JOptionPane.QUESTION_MESSAGE);
    }
}
