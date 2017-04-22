package dao;

import model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByTitle(String title) {
        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getTitle() != null && book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
        }
        return null;
    }

    public List<Book> getBooksByTitle(String title) {
        List<Book> closeBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                closeBooks.add(book);
            }
        }
        return closeBooks;
    }

    public boolean createBook(Book book) {
        books.add(book);
        return false;
    }

    public boolean updateBook(Book book) {
        return false;
    }

    public boolean deleteBook(Book book) {
        return false;
    }
}
