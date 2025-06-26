package client;

import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        int port = 9929;

        try {
            System.out.println("Client starting...");
            Socket clientSocket = new Socket("localhost", port);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}