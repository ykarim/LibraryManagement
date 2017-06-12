package dao;

import model.item.book.Book;
import model.item.book.LibraryBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Accesses the multiple copies of books made by library
 * Library must check in each individual copy of the book they have
 * with unique IDs.
 */
public class LibraryDAO {

    private static List<LibraryBook> books = new ArrayList<LibraryBook>();
    private BookDAO bookDAO = new BookDAO();

    public List<LibraryBook> getBooks() {
        return books;
    }

    /**
     * Returns all copies of a book with given string in their title
     * @param title
     * @return
     */
    public List<LibraryBook> getBooksWithTitle(String title) {
        List<LibraryBook> closeBooks = new ArrayList<LibraryBook>();
        if (books.size() > 0) {
            for (LibraryBook book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    closeBooks.add(book);
                }
            }
        }
        return closeBooks;
    }

    /**
     * Returns all copies of a book with given string in their ISBN
     * @param ISBN
     * @return
     */
    public List<LibraryBook> getBooksWithISBN(String ISBN) {
        List<LibraryBook> closeBooks = new ArrayList<LibraryBook>();
        if (books.size() > 0) {
            for (LibraryBook book : books) {
                if (book.getISBN().equalsIgnoreCase(ISBN)) {
                    closeBooks.add(book);
                }
            }
        }
        return closeBooks;
    }

    /**
     * Returns specific copy of book given ID number
     * @param bookID
     * @return
     */
    public LibraryBook getBookByID(String bookID) {
        if (books.size() > 0) {
            for (LibraryBook book : books) {
                if (book.getID() != null && book.getID().length() != 0 && book.getID().equalsIgnoreCase(bookID)) {
                    return book;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves all copies of a specific book using given book's ISBN
     *
     * @param book
     * @return
     */
    public List<LibraryBook> getCopiesOfBook(Book book) {
        return getBooksWithISBN(book.getISBN());
    }

    /**
     * Creates a new library book and also calls BookDAO.createBook() to
     * increment number of books available for book and add ID of libBook to
     * its respective Book obj.
     * TODO: shouldnt update update things like num avail so call update instead of create for readability
     * if book not made call update if made then create
     *
     * @param book - LibraryBook
     * @return success
     */
    public boolean createBook(LibraryBook book) {
        ArrayList<String> iD = new ArrayList<String>();
        for (LibraryBook currentBook : books) {
            iD.add(currentBook.getID());
        }

        if (!iD.contains(book.getID())) {
            books.add(book);
            bookDAO.createBook(book);
        }
        return true;
    }

    public boolean updateBook(Book book) {
        if (books.size() > 0) {
            for (LibraryBook currentBook : books) {
                if (currentBook.getISBN().equalsIgnoreCase(book.getISBN())) {
                    books.get(books.indexOf(currentBook)).setTitle(book.getTitle());
                    books.get(books.indexOf(currentBook)).setCreator(book.getCreator());
                    books.get(books.indexOf(currentBook)).setPublisher(book.getPublisher());
                    books.get(books.indexOf(currentBook)).setPublicationYear(book.getPublicationYear());
                    books.get(books.indexOf(currentBook)).setGradeLevel(book.getGradeLevel());
                    books.get(books.indexOf(currentBook)).setNumAvailable(book.getNumAvailable());
                }
            }
        }
        return false;
    }

    public boolean updateLibraryBook(LibraryBook book) {
        if (books.size() > 0) {
            for (LibraryBook currentBook : books) {
                if (currentBook.getID().equalsIgnoreCase(book.getID())) {
                    books.set(books.indexOf(currentBook), book);
                }
            }
        }
        return false;
    }

    public boolean deleteLibraryBook(LibraryBook book) {
        if (books.size() > 0) {
            for (LibraryBook currentBook : books) {
                if (currentBook.getID().equalsIgnoreCase(book.getID())) {
                    books.remove(books.indexOf(currentBook));
                }
            }
        }
        return false;
    }
}
