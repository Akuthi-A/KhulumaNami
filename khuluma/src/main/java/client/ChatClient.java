package client;

import java.io.*;
import java.net.Socket;

public class ChatClient {
        private Socket clientSocket = null;
        private BufferedReader userInput = null;
        private BufferedReader in = null;
        private PrintWriter out = null;


        public ChatClient(String addr, int port) {
            try {
                System.out.println("Client starting...");
                clientSocket = new Socket(addr, port);

                setupStreams();
                sendMessage();
                readResponse();

            } catch (IOException e) {
                throw new RuntimeException("Error msg: " + e);
            }
        }

        private void setupStreams() throws IOException {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }


        private void sendMessage() throws IOException {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a message");
            String msg = userInput.readLine();
            out.println(msg);
        }

        private void readResponse() throws IOException {
            String response = in.readLine();
            System.out.println("Response from Server: " + response);
        }

}