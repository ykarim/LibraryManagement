package net;

import net.handlers.LibraryBookHandler;
import net.packet.LibraryBookPacket;
import net.packet.LibraryBookPropertiesPacket;
import net.packet.Packet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LibraryServerThread extends Thread {

    private Socket socket;

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private LibraryBookHandler libraryBookHandler;

    public LibraryServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        while (true) {
            try {
                Packet packet = (Packet) inputStream.readObject();
                if (packet instanceof LibraryBookPacket) {
                    libraryBookHandler.parseLibraryBookPacket((LibraryBookPacket) packet);
                } else if (packet instanceof LibraryBookPropertiesPacket) {
                    outputStream.writeObject(libraryBookHandler.parseBookPropertiesPacket((LibraryBookPropertiesPacket) packet));
                    outputStream.flush();
                } else if (packet == null) {
                    //End of connection
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
