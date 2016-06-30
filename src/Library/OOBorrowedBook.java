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
	
	/**
	 * Return all of book's properties as one string
	 * Separator between props: "</sep/>
	 * Order: 
	 * @return
	 */
	private String getString(){
		String sep = "</sep/>";
		return (this.getTitle() + sep + this.getAuthor() + sep + this.getPublisher() + sep + this.getPublicationYear() + sep + this.getID()
				+ sep + this.getGradeLevel() + sep +  this.getNumAvailable() + sep + this.getDueDate()).toString();
	}
	
	/**
	 * Give a byte array including all of book's properties. 
	 * <br>
	 * Separator : </sep/>
	 * @return
	 */
	public byte[] getBytes(){
		return (this.getString()).getBytes();
	}
}
