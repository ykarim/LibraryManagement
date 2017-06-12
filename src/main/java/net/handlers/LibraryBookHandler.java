package net.handlers;

import dao.LibraryDAO;
import model.item.LibraryBook;
import net.packet.model.book.LibraryBookPacket;
import net.packet.requests.RequestLibraryBookPacket;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookHandler {

    private LibraryDAO libraryDAO = new LibraryDAO();

    public boolean parseLibraryBookPacket(LibraryBookPacket packet) {
        switch (packet.getPacketType()) {
            case INVALID:
                break;
            case CREATE:
                return libraryDAO.createBook(packet.getBook());
            case UPDATE_LIBBOOK:
                return libraryDAO.updateLibraryBook(packet.getBook());
            case DELETE:
                return libraryDAO.deleteLibraryBook(packet.getBook());
        }
        return false;
    }

    public List<LibraryBook> parseLibraryBooksPacket() {
        return libraryDAO.getBooks();
    }

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
