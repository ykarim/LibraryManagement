package Library;

import java.util.Date;

public class OOBorrowedBook extends OOBook{

	private Date dueDate;
	//private OOUser owner;
	
	/**
	 * Creates a BorrowedBook given a book
	 * <br> Use Case: Needed to borrow book
	 * @param book
	 */
	public OOBorrowedBook(OOBook book) {
		super(book);
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
	
}
