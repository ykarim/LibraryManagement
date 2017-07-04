package net.handlers;

import dao.LibraryDAO;
import model.item.book.LibraryBook;
import net.packet.model.book.LibraryBookPacket;
import net.packet.requests.RequestLibraryBookPacket;

import java.util.ArrayList;
import java.util.List;

/**
 * Process CRUD operations for LibraryBook objects
 */
public class LibraryBookHandler {

    private LibraryDAO libraryDAO = new LibraryDAO();

    /**
     * Reads information from LibraryBookPacket to process operation requested
     *
     * @param packet
     * @return boolean representing success of operation
     */
    public boolean parseLibraryBookPacket(LibraryBookPacket packet) {
        switch (packet.getPacketType()) {
            case INVALID:
                break;
            case CREATE:
                return libraryDAO.createBook(packet.getBook());
            case UPDATE:
                return libraryDAO.updateLibraryBook(packet.getBook());
            case DELETE:
                return libraryDAO.deleteLibraryBook(packet.getBook());
        }
        return false;
    }

    /**
     * Upon receiving request to send over all library books, returns library book list
     *
     * @return all LibraryBook objs in the form of an arrList
     */
    public List<LibraryBook> parseLibraryBooksPacket() {
        return libraryDAO.getBooks();
    }

    /**
     * Handles get requests by returning list of LibraryBooks matching specified features read from RequestLibraryBookPacket
     *
     * @param packet
     * @return
     */
    public List<LibraryBook> parseBookPropertiesPacket(RequestLibraryBookPacket packet) {
        switch (packet.getProperty()) {
            case TITLE:
                return libraryDAO.getBooksWithTitle(packet.getPropertyValue().toString());
            case ISBN:
                return libraryDAO.getBooksWithISBN(packet.getPropertyValue().toString());
            case ID:
                ArrayList<LibraryBook> libraryBooksFound = new ArrayList<LibraryBook>();
                libraryBooksFound.add(libraryDAO.getBookByID(packet.getPropertyValue().toString()));
                return libraryBooksFound;
        }
        return null;
    }
}
