package model.item;

import model.user.LibUser;

import java.util.Date;

public class LibraryBook extends Book {

	private Date dueDate;
	private LibUser owner;

    public LibraryBook() {

    }

    public LibraryBook(Book book, Date dueDate, LibUser owner) {
        this(book.getTitle(), book.getCreator(), book.getPublisher(), book.getID(), book.getPublicationYear(),
                book.getGradeLevel(), book.getNumAvailable(), book.getISBN(), dueDate, owner);
    }

    /**
     * Creates a LibraryBook given params of book and :
     *
     * ID - the library's ID of the book for record keeping
     * dueDate - date the borrowed book is due
     * owner - current owner of this book
     */
    public LibraryBook(String title, String author, String publisher, String ID, int publicationYear, int gradeLevel,
                       int numAvailable, String ISBN, Date dueDate, LibUser owner) {
        super(title, author, publisher, publicationYear, gradeLevel, numAvailable, ISBN);
        setID(ID);
        this.dueDate = dueDate;
		this.owner = owner;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

    public LibUser getOwner() {
        return owner;
    }

    public void setOwner(LibUser owner) {
        this.owner = owner;
    }

    @Override
    public String generateID() {
        return "";
    }
}
