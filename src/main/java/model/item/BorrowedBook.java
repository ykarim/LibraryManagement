package model.item;

import model.user.LibUser;

import java.util.Date;

public class BorrowedBook extends Book {

	private Date dueDate;
	private LibUser owner;
	
	/**
     * Creates a BorrowedBook given params of book and :
     *
     * dueDate - date the borrowed book is due
     * owner - current owner of this book
     */
	public BorrowedBook(String title, String author, String publisher, long ID, int publicationYear, int gradeLevel,
                        int numAvailable, String ISBN, Date dueDate, LibUser owner) {
        super(title, author, publisher, publicationYear, gradeLevel, numAvailable, ID, ISBN);
        this.dueDate = dueDate;
		this.owner = owner;
	}

	public BorrowedBook(Book book, Date dueDate, LibUser owner) {
        this(book.getTitle(), book.getCreator(), book.getPublisher(), book.getID(), book.getPublicationYear(),
                book.getGradeLevel(), book.getNumAvailable(), book.getISBN(), dueDate, owner);
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
}
