package Library;

import java.util.ArrayList;
import java.util.Date;

//Have Arraylist of books and users and admins. Maybe use this as a manager class
public class OOLibrary {
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
			
		}else{
			users.add(user);
		}
	}
	
	public void delUser(OOUser user){
		if (users.contains(user)) {
			users.remove(user);
		} else {
			
		}
	}
	
	public void addAdmin(OOAdmin admin){
		if(admins.contains(admin)){
			
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
			OOBook newBook = book;
			newBook.setDueDate(dueDate);
			user.addCheckout(newBook);
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

}
