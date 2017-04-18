package model;

//Implement Item later on
public class Book {

    private String title, author, publisher;
    private int publicationYear, gradeLevel, numAvailable;
    private long ID;

    /**
     * Creates a new book with the following attributes.
     * Required parameters may not be left null.
     *
     * @param title           REQUIRED
     * @param author
     * @param publisher
     * @param ID              REQUIRED
     * @param publicationYear
     * @param gradeLevel
     * @param numAvailable    REQUIRED
     */
    public Book(String title, String author, String publisher, long ID, int publicationYear, int gradeLevel, int numAvailable) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ID = ID;
        this.publicationYear = publicationYear;
        this.gradeLevel = gradeLevel;
        this.numAvailable = numAvailable;
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
     * @return the ID
     */
    public long getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(long ID) {
        this.ID = ID;
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
}