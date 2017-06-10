package net;

import net.handlers.LibraryBookHandler;
import net.handlers.ResponseHandler;
import net.packet.Packet;
import net.packet.book.LibraryBookPacket;
import net.packet.book.LibraryBookPropertiesPacket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class LibraryServerThread extends Thread {

    private volatile boolean running;
    private Socket socket;
    private ObjectInputStream inputStream;
    private LibraryBookHandler libraryBookHandler;
    private ResponseHandler responseHandler;

    public LibraryServerThread(Socket socket) {
        running = true;
        this.socket = socket;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            responseHandler = new ResponseHandler(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        libraryBookHandler = new LibraryBookHandler();
    }

    public void run() {
        while (running) {
            try {
                Packet packet = (Packet) inputStream.readObject();
                if (packet != null) {
                    if (packet instanceof LibraryBookPacket) {
                        responseHandler.sendData(libraryBookHandler.parseLibraryBookPacket((LibraryBookPacket) packet));
                    } else if (packet instanceof LibraryBookPropertiesPacket) {
                        responseHandler.sendData(libraryBookHandler.parseBookPropertiesPacket((LibraryBookPropertiesPacket) packet));
                    }
                } else {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
