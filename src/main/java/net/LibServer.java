package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class LibServer extends Thread {

    private static volatile boolean running = false;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static ArrayList<String> connectedClients = new ArrayList<>();

    public static boolean getRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        LibServer.running = running;
    }

    /**
     * Accepts connection and creates new LibraryServerThread for each client connected
     * Also adds client's IP address to  (arrList) connectedClients for future use
     */
    public static void runServer(int port) {
        running = true;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException io) {
            io.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        socket = serverSocket.accept();
                        connectedClients.add(socket.getRemoteSocketAddress().toString());
                        new LibraryServerThread(socket).start();
                    } catch (SocketException socketException) {
                        //Signals that socket is now closed. Can be ignored though will log closing.
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void stopServer() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
