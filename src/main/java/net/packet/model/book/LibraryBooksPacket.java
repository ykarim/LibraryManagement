package net.packet.model.book;

import model.item.book.LibraryBook;
import net.packet.Packet;

/**
 * Packet used to send all library books or any group of library books to client
 * Does so by sending position of current Book being sent and the total number of books
 * Client waits until position = size then stops waiting for reply
 */
public class LibraryBooksPacket extends Packet {

    private LibraryBook book;
    private int positionOfBook;
    private int totalBooks;

    public LibraryBooksPacket(LibraryBook book, int positionOfBook, int totalBooks) {
        this.book = book;
        this.positionOfBook = positionOfBook;
        this.totalBooks = totalBooks;
    }

    public LibraryBook getBook() {
        return book;
    }

    public int getPositionOfBook() {
        return positionOfBook;
    }

    public int getTotalBooks() {
        return totalBooks;
    }
}
