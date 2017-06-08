package net;

import model.user.LibUser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class LibServer extends Thread {

    public boolean running = true;
    private ServerSocket serverSocket;
    private Socket socket;
    private ArrayList<LibUser> connectedClients = new ArrayList<LibUser>();

    public LibServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException ioException) {

        }
        while (running) {
            try {
                socket = serverSocket.accept();
                new LibraryServerThread(socket).start();
            } catch (IOException io) {

            }
        }
    }
}
