package Library;


public class OOBook {
	
	private String title, author, publisher;
	private int ID, publicationYear, gradeLevel, numAvailable; 
	
	/**
	 * Creates a new book with the following attributes. 
	 * Required parameters may not be left null. 
	 * @param title             REQUIRED
	 * @param author            
	 * @param publisher 
	 * @param ID                REQUIRED
	 * @param publicationYear
	 * @param gradeLevel
	 * @param numAvailable      REQUIRED
	 * @param dueDate
	 */
	public OOBook(String title, String author, String publisher, int ID, int publicationYear, int gradeLevel, int numAvailable){
		this.title = title;
		this.author = author; 
		this.publisher = publisher;
		this.ID = ID;
		this.publicationYear = publicationYear;
		this.gradeLevel = gradeLevel; 
		this.numAvailable = numAvailable;
	}
	
	/**
	 * Instantiates a book given a book's parameters
	 * Use Cases: 
	 * @param book
	 */
	public OOBook(OOBook book){
		this.title = book.title;
		this.author = book.author; 
		this.publisher = book.publisher;
		this.ID = book.ID;
		this.publicationYear = book.publicationYear;
		this.gradeLevel = book.gradeLevel; 
		this.numAvailable = book.numAvailable;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @return the publicationYear
	 */
	public int getPublicationYear() {
		return publicationYear;
	}
	
	/**
	 * @param publicationYear the publicationYear to set
	 */
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	/**
	 * @return the gradeLevel
	 */
	public int getGradeLevel() {
		return gradeLevel;
	}
	
	/**
	 * @param gradeLevel the gradeLevel to set
	 */
	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	
	/**
	 * @return the numAvailable
	 */
	public int getNumAvailable() {
		return numAvailable;
	}
	
	/**
	 * @param numAvailable the numAvailable to set
	 */
	public void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
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
				+ sep + this.getGradeLevel() + sep +  this.getNumAvailable()).toString();
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
