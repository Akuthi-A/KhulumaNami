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
            isChatting = false;
//            server.close();
            in.close();
            out.close();
            clientSocket.close();
        }
        else {
            out.println("Server says -> " + msg);
        }

    }
}
