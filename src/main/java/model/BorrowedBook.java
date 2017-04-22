package model;

import java.util.Date;

public class BorrowedBook extends Book {

	private Date dueDate;
	private LibUser owner;
	
	/**
	 * Creates a BorrowedBook given params
     *
	 */
	public BorrowedBook(String title, String author, String publisher, long ID, int publicationYear, int gradeLevel,
                        int numAvailable, Date dueDate, LibUser owner) {
		super(title, author, publisher, publicationYear, ID, gradeLevel, numAvailable);
		this.dueDate = dueDate;
		this.owner = owner;
	}

	public BorrowedBook(Book book, Date dueDate, LibUser owner) {
		this(book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBookID(), book.getPublicationYear(),
				book.getGradeLevel(), book.getNumAvailable(), dueDate, owner);
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

	public boolean equals(Object object) {
		return (object instanceof Book && ((Book) object).getBookID() == getBookID());
	}
}
