package Library;

import java.util.ArrayList;

public class OOUser {
	
	private int age, balance, id;
	private long cardNumber;
	private String firstName, lastName, username, password;
	private ArrayList<OOBorrowedBook> checkouts = new ArrayList<OOBorrowedBook>();
	private ArrayList<OOBook> reserves = new ArrayList<OOBook>();
	
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return the checkouts
	 */
	public ArrayList<OOBorrowedBook> getCheckouts(){
		return checkouts;
	}
	
	/**
	 * 
	 * @return the reserves
	 */
	public ArrayList<OOBook> getReserves(){
		return reserves;
	}
	
	/**
	 * Takes in BorrowedBook and adds it to user's checkouts arraylist. 
	 * Check if borrowed book has dueDate assigned.
	 * Prev: Used to be setCheckouts and set arraylist checkouts
	 * @param checkouts the checkouts to set
	 */
	public void addCheckout(OOBorrowedBook book) {
		checkouts.add(book);
		//Add to number of books available once returned. Subtract from num when taken out. 
	}
	
	/**
	 * Returns book and removes it from list of checkouts.
	 * @param book
	 */
	public void removeCheckout(OOBorrowedBook book){
		checkouts.remove(book);
	}
	
	/**
	 * Clears the checkout list
	 */
	public void clearCheckouts(){
		checkouts.clear();
	}
	//add method to clear checkouts
	
	/**
	 * @return the reserves
	 */
	public void addReserve(OOBook book) {
		reserves.add(book);
		//maybe alsos ubtract from num available
	}
	
	/**
	 * @param reserves the reserves to set
	 */
	public void removeReserve(OOBook book) {
		reserves.remove(book);
	}
	
	/**
	 * Return all of user's properties as one string
	 * Separator between props: "</sep/>
	 * Order: First Name, Last Name, Username, Password, ID, Card Number, Age, Balance, Checkouts, Reserves
	 * Have a method to convert checkouts arr list to string. (Checkouts Arrlist) -> "Ch[Book1, Book2]" (String) 
	 * @return
	 * Used to be: public toString() but couldn't have it private.
	 */
	private String getString(){
		String sep = "</sep/>";
		return (this.getFirstName() + sep + this.getLastName() + sep + this.getUsername() + sep + this.getPassword()
				+ sep + this.getId() + sep + this.getCardNumber() + sep + this.getAge() + sep + this.getBalance() + sep)
				.toString();	
	}
	
	/**
	 * Give a byte array including all of user's properties. 
	 * <br>
	 * Separator : < /sep/ >
	 * @return
	 */
	public byte[] getBytes(){
		return (this.getString()).getBytes();
	}
	
}
