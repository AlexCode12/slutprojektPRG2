import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        String ip = (String) JOptionPane.showInputDialog(null,"IP?","Connect to..",JOptionPane.QUESTION_MESSAGE);
        int port = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?","Connect to..",JOptionPane.QUESTION_MESSAGE));
        String nickname = (String) JOptionPane.showInputDialog(null, "Nickname?","What's your name?", JOptionPane.QUESTION_MESSAGE);
    }
}