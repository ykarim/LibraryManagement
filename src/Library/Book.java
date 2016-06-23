package Library;

import java.util.ArrayList;
public class Book {
	public static ArrayList<String>searchAuthor=new ArrayList<String>();
	public static ArrayList<String>searchBook=new ArrayList<String>();
	public static ArrayList<Integer>searchID=new ArrayList<Integer>();
	public static ArrayList<Integer>searchNumberAvailable = new ArrayList<Integer>();
	public static ArrayList<String> authors=new ArrayList<String>();
	public static ArrayList<String> publishers=new ArrayList<String>();
	public static ArrayList<Integer> publicationYears=new ArrayList<Integer>();
	public static ArrayList<String> libraryBooks = new ArrayList<String>();
	public static ArrayList<Integer> gradeLevels=new ArrayList<Integer>();
	public static ArrayList<String> genre=new ArrayList<String>();
	public static ArrayList<Integer> id=new ArrayList<Integer>();
	public static ArrayList<Integer> numberAvailable=new ArrayList<Integer>();
	public static ArrayList<String>owners=new ArrayList<String>();
	public static ArrayList<Boolean> available=new ArrayList<Boolean>();
	//public static ArrayList<Integer> dateDue=new ArrayList<Integer>();//might use actual dates for this. Check if this is used
	public static ArrayList<String>condition=new ArrayList<String>();
	
	/**
	 * Makes a new book with correct properties.  Book must not exist.
	 * @param name
	 * @param author
	 * @param publisher
	 * @param publicationYear
	 * @param gradeLevel
	 * @param numberAvailable
	 * @param genre
	 * @param id
	 * @param condition
	 */
	public static void add(String name,String author,String publisher,int publicationYear,
			int id,int gradeLevel,String genre,int numberAvailable,String condition){
			if(Book.id.contains(id)){
				System.out.println("Book arealdy exists");
			}else{
				name=capitalizeString(name);
				author=capitalizeString(author);
				publisher=capitalizeString(publisher);
				genre=capitalizeString(genre);
				libraryBooks.add(name);
				int index=libraryBooks.indexOf(name);
				authors.add(index,author);
				publishers.add(index, publisher);
				publicationYears.add(index, publicationYear);
				gradeLevels.add(index,gradeLevel);
				Book.numberAvailable.add(index,numberAvailable);
				Book.genre.add(index,genre);
				Book.owners.add(index,"None");
				available.add(index,true);
				Book.id.add(index,id);
				//dateDue.add(index,00);
				Book.condition.add(index,condition);
			}
	}
	/**
	 * Deletes book from library and removes all of its properties. This action can not be undone. 
	 * @param name
	 * @param username
	 */
	public static void delete(String name){
			name=capitalizeString(name);
			if(libraryBooks.contains(name)){
				int index=libraryBooks.indexOf(name);
				libraryBooks.remove(index);
				authors.remove(index);
				publishers.remove(index);
				publicationYears.remove(index);
				gradeLevels.remove(index);
				genre.remove(index);
				id.remove(index);
				numberAvailable.remove(index);
				available.remove(index);
			}else{
				System.out.println("Book not found. Can't delete");
			}
	}
	
	/**
	 * Capitalizes the first letter of each word in a book's title. Used if the librarian does not capitalize or care about punctuation.
	 * @param string
	 * @return Capitalized version of the title.
	 */
	public static String capitalizeString(String string) {
		  char[] chars = string.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) {
		    if (!found && Character.isLetter(chars[i])) {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
		      found = false;
		    }
		  }
		  return String.valueOf(chars);
	}
	
	/**
	 * Check if a book currently exists
	 * @param name
	 * @return
	 * True - if book exists
	 * <br>
	 * False - if book is not found.
	 */
	public boolean exists(String name){
		if(libraryBooks.contains(name)){
			return true;
		}else{
			System.out.println("Book not found");
		}
		return false;
	}
	/**
	 * Gets book name according to its ID.
	 * @param id
	 * @return
	 * Books title.
	 */
	public static String getBookName(int id){
		int index=Book.id.indexOf(id);
		return libraryBooks.get(index);
	}
	/**
	 * Deletes the whole library including all data. This action can not be undone. 
	 * @param username
	 */
	public static void deleteLibrary(String username){
		int index=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(index)==true){
			libraryBooks.clear();
			authors.clear();
			publishers.clear();
			publicationYears.clear();
			gradeLevels.clear();
			genre.clear();
			id.clear();
			numberAvailable.clear();
			owners.clear();
			available.clear();
			condition.clear();
			/*dateDue.clear();*/
		}
	}
	/**
	 * Return the author of the book according to the book's name
	 * @param nameOfBook
	 * @return
	 * Author's Name
	 */
	public static String getAuthor(String nameOfBook){
		int index=libraryBooks.indexOf(nameOfBook);
		return authors.get(index);
	}
	/**
	 * Returns the publisher of the book according to the book's name
	 * @param nameOfBook
	 * @return
	 * Publisher
	 */
	public static String getPublisher(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return publishers.get(index);
	}
	/**
	 * Returns the published year of the book according to the book's name
	 * @param nameOfBook
	 * @return
	 * Published Year
	 */
	public static int getPublishedYear(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return publicationYears.get(index);
	}
	/**
	 * Returns the book's genre according to the book's name
	 * @param nameOfBook
	 * @return
	 */
	public static String getGenre(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return genre.get(index);
	}
	/**
	 * Returns the number of copies of a specific book available at the library according the the book's name
	 * @param nameOfBook
	 * @return
	 * Number of Copies Available
	 */
	public static int getNumberAvailable(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return numberAvailable.get(index);
	}
	/**
	 * Returns the grade level of a book according the the book's name
	 * @param nameOfBook
	 * @return
	 * Grade Level
	 */

	public static int getGradeLevel(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return gradeLevels.get(index);
	}
	/**
	 * Returns the ID of a book according the the book's name
	 * @param nameOfBook
	 * @return
	 * ID
	 */
	public static int getID(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return id.get(index);
	}
	/**
	 * Returns the current owners of a specific book according the the book's name
	 * @param nameOfBook
	 * @return
	 * ALl owners of a book
	 */

	public static String getOwners(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return owners.get(index);
	}
	/**
	 * Returns if a book is available according to a book's name
	 * @param nameOfBook
	 * @return
	 * True - if a book is available and has at least one copy available for pickup at the library.
	 * <br>
	 * False - if no book is available.
	 */
	public static Boolean getAvailability(String nameOfBook) {
		int index=libraryBooks.indexOf(nameOfBook);
		return available.get(index);
	}
	/**
	 * Returns the date due for a specific book according the the book's name.
	 * @param nameOfBook
	 * @return
	 * Date Due in Date Format
	 */
	@Deprecated
	public static int getdateDue(String nameOfBook){
		/*int index=libraryBooks.indexOf(nameOfBook);
		return dateDue.get(index);*/
		return -1;//for now
		
	}
	/**
	 * Returns condition of a specific book according the the book's name
	 * @param nameOfBook
	 * @return
	 * Condition of a book
	 */

	public static String getCondtition(String nameOfBook){
		int index=libraryBooks.indexOf(nameOfBook);
		return condition.get(index);
	}
	/**
	 * Sets the date due for a specific book
	 * @param nameOfBook
	 * @param dateDue
	 */
	@Deprecated
	public static void setdateDue(String book,int dateDue){
		/*int index=libraryBooks.indexOf(book);
		Book.dateDue.set(index,dateDue);*/
	}
	// add a new search binary and add ignorecase
	/**
	 * Prints out all the book's info 
	 * @param nameOfBook
	 * @return
	 * Information about the book including all its properties. 
	 */
	@Deprecated
	public static String displayInfo(String nameOfBook){
		int index=Book.libraryBooks.indexOf(nameOfBook);
		if(Book.libraryBooks.contains(nameOfBook)){
			String info="Name : "+libraryBooks.get(index)+" Author : "+authors.get(index)+" Publisher : "+publishers.get(index)+
					" Year Published : "+publicationYears.get(index)+" Grade Level : "+gradeLevels.get(index)+" Genre : "+ genre.get(index)
					+" ID : "+id.get(index)+" Avalaible : "+numberAvailable.get(index);
			return info;
		}else{
			return null;
		}
	}
	/**
	 * Displays info for all books.
	 */
	public static  void display(){
		if(libraryBooks.isEmpty()==true){
			System.out.println("No books in library.");
		}else{
			int index=0;
			for(index=0;index<libraryBooks.size();index++){
				java.util.Collections.sort(Book.libraryBooks,String.CASE_INSENSITIVE_ORDER);
				String info="Name : "+libraryBooks.get(index)+" Author : "+authors.get(index)+" Publisher : "+publishers.get(index)+
						" Year Published : "+publicationYears.get(index)+" Grade Level : "+gradeLevels.get(index)+" Genre : "+ genre.get(index)
						+" ID : "+id.get(index)+" Avalaible : "+numberAvailable.get(index);
				System.out.println(info);
			}
		}
	}
	/**
	 * Searches for a book and returns all book with characters enetered.
	 * @param character(s)
	 */
	public static void search(String str){
		for(int x=0;x<Book.libraryBooks.size();x++){
			String book=Book.libraryBooks.get(x);
			if(book.toLowerCase().contains(str.toLowerCase())){
				int index=Book.libraryBooks.indexOf(book);
				String author=Book.authors.get(index);
				int ID = Book.id.get(index);
				int numAvailable = Book.numberAvailable.get(index);
				searchAuthor.add(author);
				searchBook.add(book);
				searchID.add(ID);
				searchNumberAvailable.add(numAvailable);
			}
		}
	}
}
