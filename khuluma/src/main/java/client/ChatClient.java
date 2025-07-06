package client;

import java.io.*;
import java.net.Socket;

public class ChatClient {
        private Socket clientSocket = null;
        private BufferedReader userInput = null;
        private BufferedReader in = null;
        private PrintWriter out = null;
        private String username = "user";


        public ChatClient(String addr, int port) {
            try {
                System.out.println("Client starting...");
                clientSocket = new Socket(addr, port);

                setupStreams();
                System.out.print("Enter your username: ");
                this.username = userInput.readLine();
                out.println(this.username);
                String welcome = in.readLine();
                System.out.println(welcome);

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
            userInput = new BufferedReader(new InputStreamReader(System.in));
        }


        private void sendMessage() throws IOException {

            System.out.print("["+this.username+"]" + ": ");
            String msg = userInput.readLine();

            if (msg.toLowerCase().equals("quit")) {
//                out.println(this.username + " has left the chat.");
                in.close();
                out.close();
                clientSocket.close();
            }
            else out.println(msg);
        }

        private void readResponse() throws IOException {
            String response = in.readLine();
            if (response == null) {
                System.out.println("Server connection closed");
            }
            else { System.out.println(response); }
        }


    public static void main(String[] args) {
        new ChatClient("localhost", 9929);
    }

}