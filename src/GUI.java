import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class GUI {
    private JButton SAVEButton;
    private JButton LISTENButton;
    private JButton CONNECTButton;
    private JTextField MESSAGE;
    private JTextArea CONVO;
    private JButton SENDButton;
    protected JPanel MAINPANEL;
    private JButton HELPButton;
    private JButton SETPORTButton;
    private JButton EXITButton;
    Socket socket = null;
    PrintWriter out;
    String line;
    String portNR;
    boolean connected;


    public GUI() {

        SENDButton.setVisible(false);
        CONVO.setText("PLEASE CONNECT BEFORE TRYING TO TYPE.");

        SAVEButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter fw = null;
                JFileChooser fileDialog = new JFileChooser();
                File selectedFile;
                selectedFile = new File("chat.txt");
                fileDialog.setSelectedFile(selectedFile);
                fileDialog.setDialogTitle("Välj vilken fil som ska sparas");
                int option = (int) fileDialog.showSaveDialog(null);
                if (option != JFileChooser.APPROVE_OPTION)
                    return;
                selectedFile = fileDialog.getSelectedFile();
                if (selectedFile.exists()) {
                    int response = JOptionPane.showConfirmDialog( null,
                            "Filen \"" + selectedFile.getName()
                                    + "\" finns redan. \nVill du skriva över den?",
                            "Bekräfta",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE );
                    if (response != JOptionPane.YES_OPTION)
                        return;
                }
                try {
                    fw = new FileWriter(selectedFile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter outfile = new PrintWriter(bw);
                    line = CONVO.getText();
                    outfile.println(line);
                    outfile.flush();
                    outfile.close();
                    JOptionPane.showMessageDialog(null, "Filen har nu sparats!");
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
                    connected = true;
                    System.out.println("Client connected");
                    CONVO.setText("YOU ARE NOW CONNECTED.");
                    SENDButton.setVisible(true);
                } catch (Exception e1) {
                    System.out.println("Client failed to connect");
                    JOptionPane.showMessageDialog(null,"Please insert another port number.");
                    CONVO.setText("ERROR: IP ADRESS OR PORT NUMBER WAS NOT VALID.");
                    SENDButton.setVisible(false);
                }
            }
        });
        SETPORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String portNR = JOptionPane.showInputDialog(null, "What port number?");
                int portInt = Integer.parseInt(portNR);
                if (portInt > 65535) {
                    JOptionPane.showMessageDialog(null, "Vänligen sätt ett tillgängligt portnummer.");
                } else {
                    JOptionPane.showMessageDialog(null, "Port OK: " + portInt + " Har valts. ");
                }
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
}