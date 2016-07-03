package Library;

import java.util.HashMap;
import java.util.Map;


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
	 * Private
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
	
	/**
	 * Used to check if a book is equal to another book by checking their ID. 
	 * Multiple copies of the same book have the same ID but may have different bookIDs.
	 */
	@Override
	public int hashCode(){
		return (getID());
	}
	
	/**
	 * Checks if a object(book) is the same as another by comparing ID's.
	 * @param book
	 * @return bool
	 */
	@Override
	public boolean equals(Object obj){
		if(obj instanceof OOBook){
			if(obj.hashCode() == this.hashCode()){
				return true;
			}else{
				return false;
			}
		}else{
			return (super.equals(obj));
		}
	}
	
	/**
	 * Given property (Ex: Author), gives the book's requested property value 
	 * @param prop
	 * @return Requested property value 
	 */
	public Object getProp(BookProperties prop){
		if (prop == BookProperties.Author) {
			return getAuthor();
		} else if (prop == BookProperties.GradeLevel) {
			return getGradeLevel();
		} else if (prop == BookProperties.ID) {
			return getID();
		} else if (prop == BookProperties.NumAvailable){
			return getNumAvailable();
		} else if (prop == BookProperties.Publisher) {
			return getPublisher();
		} else if (prop == BookProperties.PubYear) {
			return getPublicationYear();
		} else if (prop == BookProperties.Title) {
			return getTitle();
		}
 		return null; 
	}
	
	public Map<BookProperties, Object> getProps(){
		Map<BookProperties, Object> prop = new HashMap<BookProperties, Object>();
		prop.put(BookProperties.Author, getProp(BookProperties.Author));
		prop.put(BookProperties.GradeLevel, getProp(BookProperties.GradeLevel));
		prop.put(BookProperties.ID, getProp(BookProperties.ID));
		prop.put(BookProperties.NumAvailable, getProp(BookProperties.NumAvailable));
		prop.put(BookProperties.Publisher, getProp(BookProperties.Publisher));
		prop.put(BookProperties.PubYear, getProp(BookProperties.PubYear));
		prop.put(BookProperties.Title, getProp(BookProperties.Title));
		return prop;
	}
}
