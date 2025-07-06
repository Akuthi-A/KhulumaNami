package server;

import client.ChatClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {

    private ServerSocket server = null;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    static List<ClientHandler> connectedClients = Collections.synchronizedList(new ArrayList<>());





    public ChatServer(int port) throws IOException {
        System.out.println("Waiting for client...");
        server = new ServerSocket(port);
        while (true) {
            socket = server.accept();
            System.out.println("Connection established");

            //            setupStreams();
            //            while (isChatting) { handleChat(); }
            ClientHandler handler = new ClientHandler(socket);
            connectedClients.add(handler);
            Thread newThread = new Thread(handler);

            newThread.start();
        }
    }


    public static void main(String[] args) throws IOException {
        new ChatServer(9929);
    }
}
