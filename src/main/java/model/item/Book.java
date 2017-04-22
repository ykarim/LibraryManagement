package model.item;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "book")
public class Book extends Item implements Serializable {

    private String publisher;
    private int publicationYear, gradeLevel;
    private String ISBN;

    public Book() {
    }

    public Book(String title, String author, long bookID, int numAvailable) {
        setTitle(title);
        setCreator(author);
        setID(bookID);
        setNumAvailable(numAvailable);
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
    public Book(String title, String author, String publisher, int publicationYear, int gradeLevel, int numAvailable, long bookID, String ISBN) {
        setTitle(title);
        setCreator(author);
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.gradeLevel = gradeLevel;
        this.ISBN = ISBN;
        setID(bookID);
        setNumAvailable(numAvailable);
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
        return "Book: [name=" + getTitle() + ", author=" + getCreator() + "]";
    }
}