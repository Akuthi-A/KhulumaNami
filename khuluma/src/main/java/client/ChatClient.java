package client;

import java.io.*;
import java.net.Socket;

public class ChatClient {
        private Socket clientSocket = null;
        private BufferedReader userInput = null;
        private PrintWriter out = null;

        public ChatClient(String addr, int port) {
            try {
                System.out.println("Client starting...");
                clientSocket = new Socket(addr, port);

                userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter a message");
                String msg = userInput.readLine();

                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(msg);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String response = in.readLine();
                System.out.println("Response from Server: " + response);
            } catch (IOException e) {
                throw new RuntimeException("Error msg: " + e);
            }
        }

}