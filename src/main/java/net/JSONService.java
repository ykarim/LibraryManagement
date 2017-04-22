package net;

import dao.BookDAO;
import model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json/book")
public class JSONService {

    private BookDAO bookDAO = new BookDAO();

    @GET
    @Path("get/books")
    @Produces("application/json")
    public List<Book> getBooksinJSON() {
        return bookDAO.getBooks();
    }

    @GET
    @Path("/get/title/{bookTitle}")
    @Produces("application/json")
    public Book getBookInJSON(@PathParam("bookTitle") String bookName) {
        return bookDAO.getBookByTitle(bookName);
    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createProductInJSON(Book book) {
        boolean success = bookDAO.createBook(book);
        return Response.status(201).entity(success).build();
    }
}