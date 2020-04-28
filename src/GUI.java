import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton SAVEButton;
    private JButton LISTENButton;
    private JButton CONNECTButton;
    private JTextField MESSAGE;
    private JTextArea CONVO;
    private JButton SENDButton;
    private JPanel MAINPANEL;
    private JButton HELPButton;
    private JButton LISTENTOIPButton;
    private JButton CONNECTONPORTButton;

    public GUI() {
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Under construction!");
            }
        });
        SENDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Under construction!");
            }
        });
        CONNECTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog(null, "What IP adress?");

            }
        });
        LISTENButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog(null, "What IP adress?");
            }
        });
        HELPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "ERROR: No help available at this time.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame GUI = new JFrame("GUI CHAT");
        GUI.setContentPane(new GUI().MAINPANEL);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.pack();
        GUI.setVisible(true);

    }
}
