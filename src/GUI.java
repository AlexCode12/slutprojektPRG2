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
                JOptionPane.showMessageDialog(null, "IP adress som valts: " + ip);

            }
        });
        SETPORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String port = JOptionPane.showInputDialog(null, "Vilket portnummer vill du sätta?");
                int portInt = Integer.parseInt(port);
                if (portInt > 65535) {
                    JOptionPane.showMessageDialog(null, "Vänligen sätt ett tillgängligt portnummer.");
                } else {
                    JOptionPane.showMessageDialog(null, "Port OK: " + portInt + " Har valts. ");
                }
                // Backend lösning behövs. Än ej klar.
            }
        });
        LISTENButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String port = JOptionPane.showInputDialog(null, "Vilket portnummer vill du sätta?");
                int portInt = Integer.parseInt(port);
                if (portInt > 65535) {
                    JOptionPane.showMessageDialog(null, "Vänligen sätt ett tillgängligt portnummer.");
                } else {
                    JOptionPane.showMessageDialog(null, "Port OK: " + portInt + " Har valts. ");
                }
                // Backend lösning behövs. Än ej klar.
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill avsluta?");
                if (input == 0) {
                System.exit(0);
                }

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