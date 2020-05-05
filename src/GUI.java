import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {
    private JButton SAVEButton;
    private JButton LISTENButton;
    private JButton CONNECTButton;
    private JTextField MESSAGE;
    private JTextArea CONVO;
    private JButton SENDButton;
    private JPanel MAINPANEL;
    private JButton HELPButton;
    private JButton SETPORTButton;
    private JButton EXITButton;

    public GUI() {
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileDialog = new JFileChooser();
                File selectedFile;
                selectedFile = new File("dialog.txt");
                fileDialog.setSelectedFile(selectedFile);
                fileDialog.setDialogTitle("Välj vilken fil som ska sparas");
                int option = fileDialog.showSaveDialog(null);
                if (option != JFileChooser.APPROVE_OPTION)
                    return;
            }
        });
        CONNECTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog(null, "What IP adress?");

            }
        });
        SETPORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LISTENButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Är du säker på att du vill avsluta?");

            }
        });
        HELPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Välkommen till denna chat. Detta gör knapparna:  \n" +
                        "SAVE FILE: Sparar konversationen till en fil. \n" +
                        "CONNECT TO IP: Välj vilken IP-adress du vill ansluta till. \n" +
                        "X: Y \n " +
                        "Y: Z \n " +
                        "Z: A \n ");

            }
        });

        SENDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
