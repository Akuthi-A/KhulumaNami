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

            setupStreams();
            handleChat();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupStreams() throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void handleChat() throws IOException {
        String msg = in.readLine();

//            System.out.println("Server: " + out.);
        out.println("Server: " + msg);
    }
}
