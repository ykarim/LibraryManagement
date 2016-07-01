package Library;

import java.util.ArrayList;
import java.util.Date;

public class OOLibrary {
	//Maybe a check existing method to check if id exists and another to check if firstname+ lastname exist
	private ArrayList<OOBook> books = new ArrayList<OOBook>();
	private ArrayList<OOUser> users = new ArrayList<OOUser>();
	private ArrayList<OOAdmin> admins = new ArrayList<OOAdmin>();
	
	/**
	 * @return the books
	 */
	public ArrayList<OOBook> getBooks() {
		return books;
	}
	
	/**
	 * Return the book that has given parameters
	 * If book not found, returns null
	 * @param book
	 * @return OOBook
	 */
	public OOBook getBook(OOBook book){
		for (int count = 0; count <= books.size(); count++){
			if (books.get(count).getBytes() == book.getBytes()){
				return book;
			}
		}
		
		return null;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(ArrayList<OOBook> books) {
		this.books = books;
	}

	/**
	 * @return the users
	 */
	public ArrayList<OOUser> getUsers() {
		return users;
	}
	
	/**
	 * Return a user that has given parameters
	 * If user not found, returns null
	 * @param user
	 * @return OOUser
	 */
	public OOUser getUser(OOUser user){
		for (int count = 0; count <= users.size(); count++){
			if (users.get(count).getBytes() == user.getBytes()){
				return user;
			};
		}
		return null;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<OOUser> users) {
		this.users = users;
	}

	/**
	 * @return the admins
	 */
	public ArrayList<OOAdmin> getAdmins() {
		return admins;
	}
	
	/**
	 * Return a admin that has given parameters
	 * If admin not found, returns null
	 * @param user
	 * @return OOUser
	 */
	public OOAdmin getAdmin(OOAdmin admin){
		for (int count = 0; count <= users.size(); count++){
			if (admins.get(count).getBytes() == admin.getBytes()){
				return admin;
			};
		}
		return null;
	}
	
	/**
	 * @param admins the admins to set
	 */
	public void setAdmins(ArrayList<OOAdmin> admins) {
		this.admins = admins;
	}
	
	public void addBook(OOBook book){
		if(books.contains(book)){
			//show error book exists
		}else{
			books.add(book);
		}
	}
	
	public void delBook(OOBook book){
		if (books.contains(book)) {
			books.remove(book);
		}else{
			//do something
		}
	}
	
	public void addUser(OOUser user){
		if (users.contains(user)) {
			//do something
		}else{
			users.add(user);
		}
	}
	
	public void delUser(OOUser user){
		if (users.contains(user)) {
			users.remove(user);
		} else {
			//do something
		}
	}
	
	public void addAdmin(OOAdmin admin){
		if(admins.contains(admin)){
			//do something
		} else {
			admins.add(admin);
		}
	}
	
	public void delAdmin(OOAdmin admin){
		if (admins.contains(admin)) {
			admins.remove(admin);
		} else {
			
		}
	}
	
	/**
	 * If book is available, gives user a number of book b due by Date dueDate
	 * Availability takes into account reserves and checkouts
	 * @param book
	 * @param user
	 * @param count
	 * @param dueDate
	 */
	public void borrowBook(OOBook book, OOUser user, int count, Date dueDate){
		while (count > 0) {              //Maybe switch to for loop whichever is more efficient
			OOBorrowedBook newBook = new OOBorrowedBook(book);
			newBook.setDueDate(dueDate);
			user.addCheckout(newBook);
			count--;
		}
	}
	
	public void returnBook(OOBorrowedBook book, OOUser user, int count){
		while (count>0) {
			//Check for late fee. Let user save charge.
			count--;
		}
	}
	
	/**
	 * Checks if book is available and returns bool
	 * @param book
	 * @return true if available
	 * @return false if not available
	 */
	public boolean isBookAvailable(OOBook book){
		if (book.getNumAvailable() == 0) {
			return false;
		} else if(book.getNumAvailable() > 0) {
			return true;
		}
		return false;
	}
	
	public void sortBooks(){
		ArrayList<String> bookTitles = new ArrayList<String>(); //Make a new arraylist of type string used to sort titles first
		for (int count = 0; count <= books.size(); count++) {
			bookTitles.set(count, books.get(count).getTitle()); //Fill bookTitles with titles in order
		}
		
		java.util.Collections.sort(bookTitles , String.CASE_INSENSITIVE_ORDER);
		ArrayList<OOBook> temp_books = new ArrayList<OOBook>();
		for (int count = 0; count <= bookTitles.size(); count++) {
			temp_books.set(count, searchBookByTitle(bookTitles.get(count)));
		}
		
		books = temp_books;
	}
	 /**
	  * Searches for a given book by its title
	  * @param title
	  * @return Book with given title if found or else null
	  * Prevents books from having the same title. Not good practice.
	  */
	//Make it so that you could search by property instead of just title
	public OOBook searchBookByTitle(String title){
		for (int count = 0; count <= books.size(); count++){
			if (books.get(count).getTitle().compareToIgnoreCase(title.trim()) == 0){
				return books.get(count);
			}
		}
		return null;
	}
}
