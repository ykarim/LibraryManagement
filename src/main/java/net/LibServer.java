package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class LibServer extends Thread {

    public boolean running = true;
    private ServerSocket serverSocket;
    private Socket socket;
    private ArrayList<String> connectedClients = new ArrayList<>();

    /**
     * Starts Library Server at specified port
     * @param port
     */
    public LibServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            runServer();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * Accepts connection and creates new LibraryServerThread for each client connected
     * Also adds client's IP address to  (arrList) connectedClients for future use
     */
    private void runServer() {
        while (running) {
            try {
                socket = serverSocket.accept();
                connectedClients.add(socket.getRemoteSocketAddress().toString());
                new LibraryServerThread(socket).start();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
            running = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
