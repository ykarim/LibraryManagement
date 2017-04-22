package model.book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

//Implement Item later on
@XmlRootElement(name = "book")
public class Book implements Serializable {

    private String title, author, publisher;
    private int publicationYear, gradeLevel, numAvailable;
    private long bookID;
    private String ISBN;

    public Book() {
    }

    public Book(String title, String author, long bookID, int numAvailable) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.numAvailable = numAvailable;
    }

    /**
     * Creates a new book with the following attributes.
     * @param title - Title of book
     * @param author - Author of book
     * @param publisher - Publishing Company
     * @param bookID  - Library's ID of the book
     * @param publicationYear - Year of Publication
     * @param gradeLevel - Grade Level for book (TODO: should change to enum (YA, Adult))
     * @param numAvailable - Number of books available in library
     */
    public Book(String title, String author, String publisher, int publicationYear, long bookID, int gradeLevel, int numAvailable, String ISBN) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.bookID = bookID;
        this.publicationYear = publicationYear;
        this.gradeLevel = gradeLevel;
        this.numAvailable = numAvailable;
        this.ISBN = ISBN;
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
    @XmlElement
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
    @XmlElement
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
    @XmlElement
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the bookID
     */
    public long getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    @XmlElement
    public void setBookID(long bookID) {
        this.bookID = bookID;
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
    @XmlElement
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
    @XmlElement
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
    @XmlElement
    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    public String getISBN() {
        return ISBN;
    }

    @XmlElement
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof Book && ((Book) object).getISBN().equals(this.ISBN));
    }

    @Override
    public String toString() {
        return "Book: [name=" + title + ", author=" + author + "]";
    }
}