import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.Socket;

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
    Socket socket = null;
    PrintWriter out;

    public GUI() {
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileDialog = new JFileChooser();
                File selectedFile;
                selectedFile = new File("chat.txt");
                fileDialog.setSelectedFile(selectedFile);
                fileDialog.setDialogTitle("Select File to be Saved");
                int option = (int) fileDialog.showSaveDialog(null);
                if (option != JFileChooser.APPROVE_OPTION)
                    return;
                selectedFile = fileDialog.getSelectedFile();
                if (selectedFile.exists()) {
                    int response = JOptionPane.showConfirmDialog( null,
                            "The file \"" + selectedFile.getName()
                                    + "\" already exists.\nDo you want to replace it?",
                            "Confirm Save",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE );
                    if (response != JOptionPane.YES_OPTION)
                        return;
                }
                try {
                    FileWriter stream = new FileWriter(selectedFile);
                    out = new PrintWriter( stream );
                }
                catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,
                            "Sorry, but an error occurred while trying to save the file:\n" + e);
                    return;
                }

            }
        });
        CONNECTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog(null, "What IP adress?");
                JOptionPane.showMessageDialog(null, "IP adress som valts: " + ip);
                String portNR = JOptionPane.showInputDialog(null, "What port number?");
                try {
                    socket = new Socket(ip, Integer.parseInt(portNR));
                    System.out.println("Client connected");
                } catch (Exception e1) {
                    System.out.println("Client failed to connect");
                    System.exit(0);
                }
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
                String s = e.getActionCommand();
                if (s.equals("SEND")) {
                    // set the text of the label to the text of the field
                    CONVO.setText(MESSAGE.getText());
                    MESSAGE.setText("  ");
                }
            }
        });


    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Please restart the server if you haven't done so already.");
        JFrame GUI = new JFrame("GUI CHAT");
        GUI.setContentPane(new GUI().MAINPANEL);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.pack();
        GUI.setVisible(true);

    }
}