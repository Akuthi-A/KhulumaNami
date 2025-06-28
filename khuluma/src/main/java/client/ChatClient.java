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
                while (true) {
                    sendMessage();
                    readResponse();
                }


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
            System.out.print("You: ");
            String msg = userInput.readLine();

            if (msg.toLowerCase().equals("quit")) {
                clientSocket.close();
            }
            else out.println(msg);
        }

        private void readResponse() throws IOException {
            String response = in.readLine();
            if (response == null) {
                System.out.println("Server connection closed");
            }
            else { System.out.println("Response from Server: " + response); }
        }


    public static void main(String[] args) {
        new ChatClient("localhost", 9929);
    }

}