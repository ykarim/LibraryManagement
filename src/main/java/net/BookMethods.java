package net;

import dao.BookDAO;
import dao.LibraryDAO;
import model.item.Book;
import model.item.LibraryBook;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json")
public class BookMethods {

    private BookDAO bookDAO = new BookDAO();
    private LibraryDAO libraryDAO = new LibraryDAO();

    @GET
    @Path("/get/books")
    @Produces("application/json")
    public List<Book> getBooks() {
        return BookDAO.getBooks();
    }

    @GET
    @Path("/get/books/title/{bookTitle}")
    @Produces("application/json")
    public List<Book> getBooksFromTitle(@PathParam("bookTitle") String bookName) {
        return bookDAO.getBooksWithTitle(bookName);
    }

    @GET
    @Path("/get/books/isbn/{isbn}")
    @Produces("application/json")
    public List<Book> getBooksFromISBN(@PathParam("isbn") String ISBN) {
        return bookDAO.getBooksWithISBN(ISBN);
    }

    @GET
    @Path("/get/lib")
    @Produces("application/json")
    public List<LibraryBook> getLibBooks() {
        return LibraryDAO.getBooks();
    }

    @GET
    @Path("/get/lib/title/{bookTitle}")
    @Produces("application/json")
    public List<Book> getLibBooksFromTitle(@PathParam("bookTitle") String bookName) {
        return libraryDAO.getBooksWithTitle(bookName);
    }

    @GET
    @Path("/get/lib/isbn/{isbn}")
    @Produces("application/json")
    /**
     *
     */
    public List<Book> getLibBooksFromISBN(@PathParam("isbn") String ISBN) {
        return libraryDAO.getBooksWithISBN(ISBN);
    }

    @GET
    @Path("/get/id/{bookID}")
    @Produces("application/json")
    public Book getLibraryBookFromID(@PathParam("bookID") String bookID) {
        return libraryDAO.getBookByID(bookID);
    }

    @POST
    @Path("/post/book")
    @Consumes("application/json")
    public Response createLibraryBook(LibraryBook book) {
        boolean success = libraryDAO.createBook(book);
        return Response.status(201).entity(success).build();
    }
}