package server;

import client.ChatClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private ServerSocket server = null;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    static boolean isChatting = true;

    public ChatServer(int port) {
        try {
            System.out.println("Waiting for client...");
            server = new ServerSocket(port);
            socket = server.accept();
            System.out.println("Connection established");

            setupStreams();
            while (isChatting) { handleChat(); }


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

        if (msg == null) {
            System.out.println("Client connection ayisekho");
            isChatting = false;
            server.close();
        }
        else {
            out.println("Server says -> " + msg);
        }

    }

    public static void main(String[] args) {
        new ChatServer(9929);
    }
}
