package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private ServerSocket server = null;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public ChatServer(int port) {
        try {
            System.out.println("Waiting for client...");
            server = new ServerSocket(port);
            socket = server.accept();
            System.out.println("Connection established");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = in.readLine();
            out = new PrintWriter(socket.getOutputStream(), true);
//            System.out.println("Server: " + out.);
            out.println("Server: " + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
