package net;

import net.handlers.BookResponseHandler;
import net.handlers.LibraryBookHandler;
import net.packet.Packet;
import net.packet.book.LibraryBookPacket;
import net.packet.requests.RequestLibraryBookPacket;
import net.packet.requests.RequestLibraryBooksPacket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class LibraryServerThread extends Thread {

    private volatile boolean running;
    private Socket socket;
    private ObjectInputStream inputStream;
    private LibraryBookHandler libraryBookHandler;
    private BookResponseHandler bookResponseHandler;

    public LibraryServerThread(Socket socket) {
        running = true;
        this.socket = socket;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            bookResponseHandler = new BookResponseHandler(socket.getOutputStream());
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
                        bookResponseHandler.sendData(libraryBookHandler.parseLibraryBookPacket((LibraryBookPacket) packet));
                    } else if (packet instanceof RequestLibraryBookPacket) {
                        bookResponseHandler.sendData(libraryBookHandler.parseBookPropertiesPacket((RequestLibraryBookPacket) packet));
                    } else if (packet instanceof RequestLibraryBooksPacket) {
                        bookResponseHandler.sendBooks(libraryBookHandler.parseLibraryBooksPacket());
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
