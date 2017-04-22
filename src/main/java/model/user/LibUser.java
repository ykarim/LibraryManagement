package model.user;

import model.item.Book;
import model.item.LibraryBook;

import java.util.ArrayList;

public class LibUser extends User{
	
	private int age, balance;
	private long cardNumber;
    private ArrayList<LibraryBook> checkouts = new ArrayList<LibraryBook>();
    private ArrayList<Book> reserves = new ArrayList<Book>();

	//Have pw be 8-16 or user set num of charac.
	/**
	 * Creates a new user with the following attributes
	 * All attribs cept age required
	 * @param fname
	 * @param lname
	 * @param username
	 * @param password
	 * @param age
	 * @param id
	 * @param cardNumber
	 */
	public LibUser(String fname, String lname, String username, String password,
				   int age, long id, long cardNumber){
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.id = id;
		this.cardNumber = cardNumber;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the cardNumber
	 */
	public long getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 * @return the checkouts
	 */
    public ArrayList<LibraryBook> getCheckouts() {
        return checkouts;
	}
	
	/**
	 * 
	 * @return the reserves
	 */
	public ArrayList<Book> getReserves(){
		return reserves;
	}
	
	/**
     * Takes in LibraryBook and adds it to user's checkouts arraylist.
     * Check if borrowed book has dueDate assigned.
	 * Prev: Used to be setCheckouts and set arraylist checkouts
	 */
    public void addCheckout(LibraryBook book) {
        checkouts.add(book);
		//Add to number of books available once returned. Subtract from num when taken out. 
	}
	
	/**
	 * Returns book and removes it from list of checkouts.
	 * @param book
	 */
    public void removeCheckout(LibraryBook book) {
        checkouts.remove(book);
	}
	
	/**
	 * Clears the checkout list
	 */
	public void clearCheckouts(){
		checkouts.clear();
	}
	//add method to clear checkouts

	public void addReserve(Book book) {
		reserves.add(book);
		//maybe alsos ubtract from num available
	}

	public void removeReserve(Book book) {
		reserves.remove(book);
	}

    @Override
    public long generateID() {
        return 0L;
    }
}