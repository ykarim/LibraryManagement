package net;

import log.Logger;

import java.io.IOException;
import java.net.BindException;
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
    public static void runServer(int port) throws IllegalArgumentException {
        try {
            if (isPortAvailable(port)) {
                serverSocket = new ServerSocket(port);
                running = true;

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
            } else {
                throw new IllegalArgumentException(String.format("Port %d is already in use", port));
            }
        } catch (BindException bind) {
            //Port is already in use
            throw new IllegalArgumentException(String.format("Port %d is already in use", port));
        } catch (IOException io) {
            Logger.writeException(null, io);
        }
    }

    /**
     * Checks if given port is available for use by program
     */
    private static boolean isPortAvailable(int port) {
        if (port < 1023 || port > 65535) {
            return false;
        }

        try (Socket test = new Socket("localhost", port)) {
            return false;
        } catch (IOException io) {
            return true;
        }
    }

    public static void stopServer() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            Logger.writeException(null, e);
        }
    }
}
