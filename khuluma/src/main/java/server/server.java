package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) {
        int port = 9929;

        try {
            System.out.println("Waiting for client...");
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            System.out.println("Connection established");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
