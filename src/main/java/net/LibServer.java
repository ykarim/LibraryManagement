package net;

import model.user.LibUser;
import net.handlers.LibraryBookHandler;
import net.packet.LibraryBookPacket;
import net.packet.LibraryBookPropertiesPacket;
import net.packet.Packet;
import util.Constants;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class LibServer extends Thread {

    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    private LibraryBookHandler libraryBookHandler;

    public boolean running = true;
    private ArrayList<LibUser> connectedClients = new ArrayList<LibUser>();

    public LibServer(LibraryBookHandler libraryBookHandler) {
        try {
            this.serverSocket = new ServerSocket(Constants.PORT);
            socket = serverSocket.accept();
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            libraryBookHandler = new LibraryBookHandler();
        } catch (IOException io) {

        }
    }

    public void run() {
        while(running) {
            try {
                Packet packet = (Packet) inputStream.readObject();
                if (packet instanceof LibraryBookPacket) {
                    libraryBookHandler.parseLibraryBookPacket((LibraryBookPacket) packet);
                } else if (packet instanceof LibraryBookPropertiesPacket) {
                    outputStream.writeObject(libraryBookHandler.parseBookPropertiesPacket((LibraryBookPropertiesPacket) packet));
                }
            } catch (IOException ioException) {

            } catch (ClassNotFoundException cnfException) {

            }
        }
    }
}
