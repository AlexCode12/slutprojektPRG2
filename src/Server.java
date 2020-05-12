import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        int port = 1234;
        ServerSocket serverSocket;
        Socket socket;
        System.out.println("Server started.");

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for connections!");
                socket = serverSocket.accept();
                // Go
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Client connected!");

                //Protocol
                String name = in.readLine();
                if (name.equals("Away")) {
                    out.println("SERVER: Det var ju mindre bra..");
                    in.close();
                    out.close();
                    socket.close();
                    System.out.println("server shutting down...");
                    System.exit(0);
                }

                System.out.println("Client name is \"" + name + "\"");
                System.out.println("Sending feedback");
                out.println("YOU ARE GRET WINNER.");
                out.println("Welcome " + name + "! Keep up the good work");
                in.close();
                out.close();
                socket.close();

                System.out.println("Closing down " + name);
            }
        } catch (Exception e) {
            System.out.println("Server fail");
        }
    }
}