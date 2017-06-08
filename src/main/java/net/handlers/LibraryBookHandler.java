package net.handlers;

import dao.LibraryDAO;
import model.item.LibraryBook;
import net.packet.LibraryBookPacket;
import net.packet.LibraryBookPropertiesPacket;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookHandler {

    private LibraryDAO libraryDAO = new LibraryDAO();

    public void parseLibraryBookPacket(LibraryBookPacket packet) {
        switch (packet.getPacketType()) {
            case INVALID:
                break;
            case CREATE:
                libraryDAO.createBook(packet.getBook());
                break;
            case UPDATE_LIBBOOK:
                libraryDAO.updateLibraryBook(packet.getBook());
                break;
            case DELETE:
                break;
        }
    }

    public List<LibraryBook> parseBookPropertiesPacket(LibraryBookPropertiesPacket packet) {
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
