package model.item;

public class Book extends Item {

    private String publisher;
    private int publicationYear, gradeLevel;
    private String ISBN;

    public Book() {
    }

    public Book(String title, String author, int numAvailable) {
        setTitle(title);
        setCreator(author);
        setNumAvailable(numAvailable);
    }

    /**
     * Creates a new book with the following attributes.
     * @param title - Title of book
     * @param author - Author of book
     * @param publisher - Publishing Company
     * @param publicationYear - Year of Publication
     * @param gradeLevel - Grade Level for book (TODO: should change to enum (YA, Adult))
     * @param numAvailable - Number of books available in library
     */
    public Book(String title, String author, String publisher, int publicationYear, int gradeLevel, int numAvailable, String ISBN) {
        setTitle(title);
        setCreator(author);
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.gradeLevel = gradeLevel;
        this.ISBN = ISBN;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String generateID() {
        return null;
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