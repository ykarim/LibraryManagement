package Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class OOLibrary {
	//Maybe have a print method to show whole library as a table in console. for testing only
	//Maybe a check existing method to check if id exists and another to check if firstname+ lastname exist
	//Replace method calls with direct vars 
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
		for (int count = 0; count < books.size(); count++) {
			if (/*books.get(count).getBytes() == book.getBytes()*/ /*books.get(count).getString().equals(book.getString().trim())*/ 
					books.get(count).equals(book)){ 
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
		for (int count = 0; count < users.size(); count++){
			if (users.get(count).equals(user)){
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
		for (int count = 0; count < admins.size(); count++){
			if (admins.get(count).equals(admin)){
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

		}
	}
	
	/**
	 * Checks if book exists by using getBook 
	 * Make more complicated by checking book's props for a match. Filter through all books and find if any of them have all of the same props 
	 * @param book
	 * @return bool
	 */
	public boolean containsBook(OOBook book){ 
		if (getBook(book) !=null /*fails: getBook(book).equals(book)*/){
			return true;
		}else{
			return false;
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
	
	/**
	 * Checks if user exists by using getUser
	 * Make more complicated by checking book's props for a match. Filter through all books and find if any of them have all of the same props 
	 * @param user
	 * @return bool
	 */
	public boolean containsUser(OOUser user){ 
		if (getUser(user) !=null /*fails: getUser(user).equals(user)*/){
			return true;
		}else{
			return false;
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
	 * Checks if admin exists by using getAdmin
	 * Make more complicated by checking book's props for a match. Filter through all books and find if any of them have all of the same props 
	 * @param user
	 * @return bool
	 */
	public boolean containsAdmin(OOAdmin admin){ 
		if (getAdmin(admin) !=null /*fails: getUser(user).equals(user)*/){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * If book is available, gives user a number of book b due by Date dueDate
	 * Availability takes into account reserv
	 * es and checkouts
	 * @param book
	 * @param user
	 * @param count
	 * @param dueDate
	 */
	public void borrowBook(OOBook book, OOUser user, int count, Date dueDate){
		while (count > 0) {              //Maybe switch to for loop whichever is more efficient
			OOBorrowedBook newBook = new OOBorrowedBook(book);
			newBook.setDueDate(dueDate);
			getBook(book).setNumAvailable(getBook(book).getNumAvailable()-1); //Deducts from number of books currently available
			user.addCheckout(newBook);
			count--;
		}
	}
	
	public void returnBook(OOBorrowedBook book, OOUser user, int count){
		while (count>0) {
			//Check for late fee. Let user save charge. Take off checkouts add num
			getBook(book).setNumAvailable(getBook(book).getNumAvailable() + 1);
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
		for(int i = 0; i < books.size(); i++){ //Either books.size or size-1 or +1 check it out on paper
			for (int num = 0; num < books.size()-1; num++){
				if (books.get(num).getTitle().compareToIgnoreCase(books.get(num + 1).getTitle()) > 0){  //Book 1 is supposed to be after book 2
					//Swap
					OOBook temp = books.get(num + 1);
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
	@Deprecated
	public OOBook searchBookByTitle(String title){
		for (int count = 0; count <= books.size(); count++){
			if (books.get(count).getTitle().compareToIgnoreCase(title.trim()) == 0){
				return books.get(count);
			}
		}
		return null;
	}
	
	/**
	 * Return books with given properties
	 * @param prop
	 * @return
	 * @Need Testing
	 * create annotation need for testing, revision, or deletion etc.
	 */
	public ArrayList<OOBook> searchBooksByProp(Map<BookProperties, Object> props) {
		ArrayList<OOBook> matchingBooks = new ArrayList<OOBook>();
		for (int count = 0; count < books.size(); count++){  //Loops through all books
			//OOBook match = null;
			for(int num = 0; num < props.size(); num++){ //Loops through properties to find matching props
				if (books.get(count).getProps().get(BookProperties.getProp(num)) == props.get(BookProperties.getProp(num))){ 
					//Maybe have a counter of matching props
					matchingBooks.add(books.get(count));   //Either this or 
					//match = books.get(count);              //this
					break;
				}
			}
			//matchingBooks.add(match); //with this
		}
		return matchingBooks;
	}
}
