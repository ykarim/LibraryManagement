package Library;

import java.util.ArrayList;

public class OOUser {
	
	private int age, balance, id;
	private long cardNumber;
	private String firstName, lastName, username, password;
	private ArrayList<String> checkouts, reserves;
	
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
	 * @return the checkouts
	 */
	public ArrayList<String> getCheckouts() {
		return checkouts;
	}
	
	/**
	 * @param checkouts the checkouts to set
	 */
	public void setCheckouts(ArrayList<String> checkouts) {
		this.checkouts = checkouts;
	}
	
	/**
	 * @return the reserves
	 */
	public ArrayList<String> getReserves() {
		return reserves;
	}
	
	/**
	 * @param reserves the reserves to set
	 */
	public void setReserves(ArrayList<String> reserves) {
		this.reserves = reserves;
	}
	
	
}
