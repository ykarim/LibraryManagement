package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Library {
	//Maybe have a print method to show whole library as a table in console. for testing only
	//Maybe a check existing method to check if id exists and another to check if firstname+ lastname exist
	//Replace method calls with direct vars 
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<LibUser> users = new ArrayList<LibUser>();
	private ArrayList<LibAdmin> admins = new ArrayList<LibAdmin>();
	
	/**
	 * @return the books
	 */
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	/**
	 * Returns single book given ID
	 * @param ID
	 * @return Book
	 */
	protected Book getBook(int ID){
		for (Book book : books) {
			if (book.getID() == ID) {
				return book;
			}
		}
		return null;
	}

	/**
	 * @param books the books to set
	 */
	protected void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	/**
	 * @return the users
	 */
	protected ArrayList<LibUser> getUsers() {
		return users;
	}
	
	/**
	 * Return a user that has given parameters
	 * If user not found, returns null
	 * @param user
	 * @return LibUser
	 */
	public LibUser getUser(LibUser user){
		for (LibUser u : users){
			if (u.equals(user)){
				return user;
			};
		}
		return null;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<LibUser> users) {
		this.users = users;
	}

	/**
	 * @return the admins
	 */
	public ArrayList<LibAdmin> getAdmins() {
		return admins;
	}
	
	/**
	 * Return a admin that has given parameters
	 * If admin not found, returns null
	 * @param ID
	 * @return LibUser
	 */
	public LibAdmin getAdmin(long ID){
		for (LibAdmin admin : admins){
			if (admin.getId() == ID) {
				return admin;
			}
		}
		return null;
	}
	
	/**
	 * @param admins the admins to set
	 */
	public void setAdmins(ArrayList<LibAdmin> admins) {
		this.admins = admins;
	}
	
	public void addBook(Book book){
		if(books.contains(book)){
			//show error book exists
		}else{
			books.add(book);
		}
	}
	
	public void deleteBook(Book book){
		if (books.contains(book)) {
			books.remove(book);
		}else{

		}
	}
	
	/**
	 * Replace by showing similar matches on creation screen
	 * Checks if book exists by using getBook 
	 * Make more complicated by checking book's props for a match. Filter through all books and find if any of them have all of the same props 
	 */
//	public boolean containsBook(Book newBook){
//		for (Book book : books) {
//			if (book.getID() == new)
//		}
//	}
	
	public void addUser(LibUser user){
		if (users.contains(user)) {
			//do something
		}else{
			users.add(user);
		}
	}
	
	public void delUser(LibUser user){
		if (users.contains(user)) {
			users.remove(user);
		} else {
			//do something
		}
	}

//	/**
	//CHECK ABOVE
//	 * Checks if user exists by using getUser
//	 * Make more complicated by checking book's props for a match. Filter through all books and find if any of them have all of the same props
//	 * @param user
//	 * @return bool
//	 */
//	public boolean containsUser(LibUser user){
//
//	}
	
	public void addAdmin(LibAdmin admin){
		if(admins.contains(admin)){
			//do something
		} else {
			admins.add(admin);
		}
	}
	
	public void delAdmin(LibAdmin admin){
		if (admins.contains(admin)) {
			admins.remove(admin);
		} else {
			
		}
	}

//	/**
//	 * Checks if admin exists by using getAdmin
//	 * Make more complicated by checking book's props for a match. Filter through all books and find if any of them have all of the same props
//	 * @param user
//	 * @return bool
//	 */
//	public boolean containsAdmin(LibAdmin admin){
//		if (getAdmin(admin) !=null /*fails: getUser(user).equals(user)*/){
//			return true;
//		}else{
//			return false;
//		}
//	}

//	/**
//	 * If book is available, gives user a number of book b due by Date dueDate
//	 * Availability takes into account reserv
//	 * es and checkouts
//	 * @param book
//	 * @param user
//	 * @param count
//	 * @param dueDate
//	 */
//	public void borrowBook(Book book, LibUser user, int count, Date dueDate){
//		while (count > 0) {              //Maybe switch to for loop whichever is more efficient. Or send a list of checkouts and loop thru
//			BorrowedBook newBook = new BorrowedBook(book);
//			newBook.setDueDate(dueDate);
//			getBook(book).setNumAvailable(getBook(book).getNumAvailable()-1); //Deducts from number of books currently available
//			user.addCheckout(newBook);
//			count--;
//		}
//	}
//
//	public void returnBook(BorrowedBook book, LibUser user, int count){
//		while (count>0) {
//			//Check for late fee. Let user save charge. Take off checkouts add num
//			getBook(book).setNumAvailable(getBook(book).getNumAvailable() + 1);
//			count--;
//		}
//	}
	
	/**
	 * Checks if book is available and returns bool
	 * @param book
	 * @return true if available
	 * @return false if not available
	 */
	public boolean isBookAvailable(Book book){
		if (book.getNumAvailable() == 0) {
			return false;
		} else if(book.getNumAvailable() > 0) {
			return true;
		}
		return false;
	}
	
	public void sortBooks(){
		for(int i = 0; i < books.size(); i++){ //Either books.size or size-1 or +1 check it out on paper
			for (int num = 0; num < books.size()-1; num++){
				if (books.get(num).getTitle().compareToIgnoreCase(books.get(num + 1).getTitle()) > 0){  //Book 1 is supposed to be after book 2
					//Swap
					Book temp = books.get(num + 1);
					books.set(num + 1, books.get(num));
					books.set(num, temp);
				}
			}
		}
	}
	
	/**
	 * Sorts books by title
	 * Prevents books from having the same title
	 * @deprecated
	 */
	public void sortBookArray(){
		ArrayList<String> bookTitles = new ArrayList<String>(); //Make a new arraylist of type string used to sort titles first
		for (int count = 0; count <= books.size(); count++) {
			bookTitles.set(count, books.get(count).getTitle()); //Fill bookTitles with titles in order
		}
		
		java.util.Collections.sort(bookTitles , String.CASE_INSENSITIVE_ORDER);
		ArrayList<Book> temp_books = new ArrayList<Book>();
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
	@Deprecated
	public Book searchBookByTitle(String title){
		for (int count = 0; count <= books.size(); count++){
			if (books.get(count).getTitle().compareToIgnoreCase(title.trim()) == 0){
				return books.get(count);
			}
		}
		return null;
	}
	
//	/**
//	 * Return books with given properties
//	 * @param prop
//	 * @return
//	 * @Need Testing
//	 * create annotation need for testing, revision, or deletion etc.
//	 */
//	public ArrayList<Book> searchBooksByProp(Map<BookProperties, Object> props) {
//		ArrayList<Book> matchingBooks = new ArrayList<Book>();
//		for (int count = 0; count < books.size(); count++){  //Loops through all books
//			//Book match = null;
//			for(int num = 0; num < props.size(); num++){ //Loops through properties to find matching props
//				if (books.get(count).getProps().get(BookProperties.getProp(num)) == props.get(BookProperties.getProp(num))){
//					//Maybe have a counter of matching props
//					matchingBooks.add(books.get(count));   //Either this or
//					//match = books.get(count);              //this
//					break;
//				}
//			}
//			//matchingBooks.add(match); //with this
//		}
//		return matchingBooks;
//	}
}
