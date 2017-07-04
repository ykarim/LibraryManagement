package net.handlers;

import model.item.book.LibraryBook;
import net.packet.Packet;
import net.packet.confirm.ConfirmationPacket;
import net.packet.model.book.LibraryBooksPacket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to results of Book CRUD operations back to client
 */
public class BookResponseHandler {

    private ObjectOutputStream outputStream;

    public BookResponseHandler(OutputStream outputStream) {
        try {
            this.outputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Replies to client packet by sending ConfirmationPacket to client via ObjectOutputStream
     *
     * @param packetToSend
     */
    private void sendData(Packet packetToSend) {
        try {
            outputStream.writeObject(packetToSend);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends ConfirmationPacket with confirmation of operation
     *
     * @param confirmation
     */
    public void sendData(boolean confirmation) {
        sendData(new ConfirmationPacket(confirmation, null));
    }

    /**
     * Sends list of books to client by sending LibraryBooksPacket for each book
     *
     * @param books
     */
    public void sendBooks(List<LibraryBook> books) {
        for (LibraryBook libBook : books) {
            sendData(new LibraryBooksPacket(libBook, books.indexOf(libBook), books.size()));
        }
    }

    /**
     * Sends ConfirmationPacket with Book objects
     *
     * @param booksToSend
     */
    public void sendData(List<LibraryBook> booksToSend) {
        if (booksToSend != null && booksToSend.size() > 0) {
            ArrayList<Object> dataToSend = new ArrayList<>();
            dataToSend.addAll(booksToSend);
            sendData(new ConfirmationPacket(true, dataToSend));
        }
    }

    /**
     * Creates ConfirmationPacket with confirmation and data to relay to method sendData(ConfirmationPacket)
     *
     * @param confirmation
     * @param dataToSend
     */
    public void sendData(boolean confirmation, List<Object> dataToSend) {
        if (dataToSend != null && dataToSend.size() > 0) {
            sendData(new ConfirmationPacket(confirmation, dataToSend));
        }
    }
}
