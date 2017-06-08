package net;

import model.user.LibUser;
import net.packet.BookPacket;
import net.packet.Packet;
import util.Constants;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LibServer extends Thread {

    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public boolean running = true;
    private ArrayList<LibUser> connectedClients = new ArrayList<LibUser>();

    public void LibServer() {
        try {
            this.serverSocket = new ServerSocket(Constants.PORT);
            socket = serverSocket.accept();
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException io) {

        }
    }

    public void run() {
        while(running) {
            try {
                Packet packet = (Packet) inputStream.readObject();
                if (packet instanceof BookPacket) {

                } else {

                }
            } catch (IOException ioException) {

            } catch (ClassNotFoundException cnfException) {

            }
        }
    }
}
