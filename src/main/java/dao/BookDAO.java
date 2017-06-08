package dao;

import model.item.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static List<Book> books = new ArrayList<Book>();

    public static List<Book> getBooks() {
        return books;
    }

    /**
     * Used to retrieve books with given string in their title
     *
     * @param title
     * @return
     */
    public List<Book> getBooksWithTitle(String title) {
        List<Book> closeBooks = new ArrayList<Book>();
        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    closeBooks.add(book);
                }
            }
        }
        return closeBooks;
    }

    /**
     * Used to retrieve books with given string in their ISBN
     *
     * @param ISBN
     * @return
     */
    public List<Book> getBooksWithISBNString(String ISBN) {
        List<Book> closeBooks = new ArrayList<Book>();
        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getISBN().equalsIgnoreCase(ISBN)) {
                    closeBooks.add(book);
                }
            }
        }
        return closeBooks;
    }

    boolean createBook(Book book) {
        List<String> libraryISBN = new ArrayList<String>();
        for (Book currentBook : books) {
            libraryISBN.add(currentBook.getISBN().trim());
        }

        if (!libraryISBN.contains(book.getISBN())) {
            Book newBook = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setCreator(book.getCreator());
            newBook.setPublisher(book.getPublisher());
            newBook.setPublicationYear(book.getPublicationYear());
            newBook.setGradeLevel(book.getGradeLevel());
            newBook.setISBN(book.getISBN());
            books.add(newBook);
            return true;
        } else {
            for (Book currentBook : books) {
                if (currentBook.getISBN().equalsIgnoreCase(book.getISBN())
                        && currentBook.getTitle().equalsIgnoreCase(book.getTitle())) {
                    currentBook.setNumAvailable(currentBook.getNumAvailable() + 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteBook(Book book) {

        return false;
    }
}
