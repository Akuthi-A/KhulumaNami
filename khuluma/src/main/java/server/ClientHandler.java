package server;

import java.io.*;
import java.net.Socket;


public class ClientHandler implements Runnable{
    /*
    * Client socket */
    private Socket clientSocket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private boolean isChatting = true;
    private String username = "Raskalnikov";



    public ClientHandler(Socket socket) {
        clientSocket = socket;
    }
    @Override
    public void run() {
        try {
            setupStreams();
            this.username = in.readLine();

            System.out.println(this.username + " has joined the chat.");

            out.println("Welcome " + this.username + "!!");


            while (isChatting) { handleChat(); }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void setupStreams() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    private void handleChat() throws IOException {
        String msg = in.readLine();


        if (msg == null) {
            System.out.println("Client connection ayisekho");
            out.println(this.username + " has left the chat");
            ChatServer.connectedClients.remove(this);
            isChatting = false;
            in.close();
            out.close();
            clientSocket.close();
            return;
        }
        String formattedMessage = "["+this.username+"]" + " uthi-> " + msg;

        for (ClientHandler client: ChatServer.connectedClients) {
                client.sendMessage(formattedMessage);
        }



    }

    private void sendMessage(String message) {
        out.println(message);
    }
}
