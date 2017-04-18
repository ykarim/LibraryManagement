package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
//Replace these with OOLIbrary then access an OOLib instance.
	Library lib = new Library();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<LibUser> users = new ArrayList<LibUser>();
	private ArrayList<LibAdmin> admins = new ArrayList<LibAdmin>();
	
	@Before
	public void setUp() throws Exception {
		Book b1 = new Book("Bob", "Auth", "Pub",  123,   2000,  8, 2);
		Book b2 = new Book("Ojr", "Auti", "Puc",  2312,  2001,  9, 3);
		Book b3 = new Book("afs", "edff", "sdd",  23423, 2002, 10, 4);
		Book b4 = new Book("Iue", "wrwt", "ett",  1233,  2003, 11, 5);
		Book b5 = new Book("asd", "Auth", "sdf",  12346, 2004, 12, 6);
		Book b6 = new Book("Har", "987w", "Pub",  1363,  2005, 13, 7);
		
		lib.addBook(b1); // Bad practice
		lib.addBook(b2); // Relies on method to work
		lib.addBook(b3);
		lib.addBook(b4);
		lib.addBook(b5);
		lib.addBook(b6);
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		books.add(b6);
		
		LibUser u1 = new LibUser("John", "K", "jk", "jk123", 12, 19829, 284291049L);
		LibUser u2 = new LibUser("Carly", "p", "cp", "j3", 32, 3465, 42423423L);
		
		lib.addUser(u1);
		users.add(u1);
		lib.addUser(u2);
		users.add(u2);
		
		LibAdmin a1 = new LibAdmin("andy", "o", 2124);
		LibAdmin a2 = new LibAdmin("iew", "gdsfs", 7583);
		
		lib.addAdmin(a1);
		admins.add(a1);
		lib.addAdmin(a2);
		admins.add(a2);
	}

	@Test
	public void testGetBooks() {
		assertEquals(books, lib.getBooks());
	}

	@Test
	public void testGetBook() {
		Book book = new Book("B", "A", "P",  997,   2446,  4, 2);
		Book bookTest = new Book("B", "A", "P",  997,   2446,  4, 2);
		lib.addBook(book);
		assertEquals(book, lib.getBook(bookTest));  //GetBook keeps coming back null //Diff byte values //Bytes String Prop all diff come back as null
		Book wrongBook = new Book("B", "A", "P",  8271,   2446,  4, 2);
		assertFalse(lib.getBook(book).equals(wrongBook));
		lib.delBook(book);
	}

	@Test
	public void testSetBooks() {
		lib.setBooks(books);
		assertEquals(books, lib.getBooks());
	}

	@Test
	public void testGetUsers() {
		assertEquals(users, lib.getUsers());
	}

	@Test
	public void testGetUser() {
		LibUser user = new LibUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		LibUser userTest = new LibUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		lib.addUser(user);
		assertEquals(user, lib.getUser(userTest));
		//insert false case
	}

	@Test
	public void testSetUsers() {
		lib.setUsers(users);
		assertEquals(users, lib.getUsers());
	}

	@Test
	public void testGetAdmins() {
		assertEquals(admins, lib.getAdmins());
	}

	@Test
	public void testGetAdmin() {
		LibAdmin admin = new LibAdmin("uname", "pass", 8291);
		LibAdmin adminTest = new LibAdmin("uname", "pass", 8291);
		lib.addAdmin(admin);
		assertEquals(admin, lib.getAdmin(adminTest));
		//insert fasle case
	}

	@Test
	public void testSetAdmins() {
		lib.setAdmins(admins);
		assertEquals(admins, lib.getAdmins());
	}

	@Test
	public void testAddBook() {
		Book book = new Book("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.containsBook(book));
	}

	@Test
	public void testDelBook() {
		Book book = new Book("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.containsBook(book));
		lib.delBook(book);
		assertFalse(lib.containsBook(book));
	}
	
	@Test
	public void testContainsBook() {
		Book book = new Book("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.containsBook(book));
		lib.delBook(book);
		assertFalse(lib.containsBook(book));
	}

	@Test
	public void testAddUser() {
		LibUser user = new LibUser("iuih", "sy", "yyb", "cghvj", 8965, 27421, 46721L);
		lib.addUser(user);
		assertTrue(lib.containsUser(user));
	}

	@Test
	public void testDelUser() {
		LibUser user = new LibUser("iuih", "sy", "yyb", "cghvj", 8965, 27421, 46721L);
		lib.addUser(user);
		assertTrue(lib.containsUser(user));
		lib.delUser(user);
		assertFalse(lib.containsUser(user));
	}
	
	@Test
	public void testContainsUser(){
		LibUser user = new LibUser("iuih", "sy", "yyb", "cghvj", 8965, 27421, 46721L);
		lib.addUser(user);
		assertTrue(lib.containsUser(user));
		lib.delUser(user);
		assertFalse(lib.containsUser(user));
	}
	
	@Test
	public void testAddAdmin() {
		LibAdmin admin = new LibAdmin("uyiu", "tfjnj", 86876);
		lib.addAdmin(admin);
		assertTrue(lib.containsAdmin(admin));
	}

	@Test
	public void testDelAdmin() {
		LibAdmin admin = new LibAdmin("uyiu", "tfjnj", 86876);
		lib.addAdmin(admin);
		assertTrue(lib.containsAdmin(admin));
		lib.delAdmin(admin);
		assertFalse(lib.containsAdmin(admin));
	}
	
	@Test
	public void testContainsAdmin(){
		LibAdmin admin = new LibAdmin("uyiu", "tfjnj", 86876);
		lib.addAdmin(admin);
		assertTrue(lib.containsAdmin(admin));
		lib.delAdmin(admin);
		assertFalse(lib.containsAdmin(admin));
	}
	
	/**
	 * Soft test: Check later if its in users checkouts list.
	 */
	@Test
	public void testBorrowBook() {
		Book book = new Book("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		LibUser user = new LibUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		lib.addUser(user);
		Date date = new Date();
		lib.borrowBook(lib.getBook(book), lib.getUser(user), 2, date);
		assertEquals(lib.getBook(book).getNumAvailable(), 3);
	}

	@Test
	public void testReturnBook() {
		Book book = new Book("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		LibUser user = new LibUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		lib.addUser(user);
		Date date = new Date();
		lib.borrowBook(lib.getBook(book), lib.getUser(user), 2, date);
		BorrowedBook bbook = new BorrowedBook(book);//Remove later Replace with checkouts.get(index) or create a etcheckout method to return borrbook
		lib.returnBook(bbook, lib.getUser(user), 2);
		assertEquals(lib.getBook(book).getNumAvailable(), 3); //not working supposed to be 5
	}

	@Test
	public void testIsBookAvailable() {
		Book book = new Book("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.isBookAvailable(lib.getBook(book)));
		Book book2 = new Book("wqwe", "qwt", "sfs",  279,  2351,  774, 0);
		lib.addBook(book2);
		assertFalse(lib.isBookAvailable(lib.getBook(book2)));
	}

	@Test
	public void testSortBooks() {
		lib.sortBooks();
		Book b1 = new Book("Bob", "Auth", "Pub",  123,   2000,  8, 2);
		Book b2 = new Book("Ojr", "Auti", "Puc",  2312,  2001,  9, 3);
		Book b3 = new Book("afs", "edff", "sdd",  23423, 2002, 10, 4);
		Book b4 = new Book("Iue", "wrwt", "ett",  1233,  2003, 11, 5);
		Book b5 = new Book("asd", "Auth", "sdf",  12346, 2004, 12, 6);
		Book b6 = new Book("Har", "987w", "Pub",  1363,  2005, 13, 7);
		
		ArrayList<Book> sortedBooks = new ArrayList<Book>();
		sortedBooks.add(b3);
		sortedBooks.add(b5);
		sortedBooks.add(b1);
		sortedBooks.add(b6);
		sortedBooks.add(b4);
		sortedBooks.add(b2);
		
		assertEquals(lib.getBooks(), sortedBooks);
	}

	@Test
	public void testSearchBooksByProp() {
		ArrayList<Book> matchingBooks = new ArrayList<Book>();
		Book b1 = new Book("Bob", "Auth", "Pub",  123,   2000,  8, 2);
		matchingBooks.add(b1);
		
		Map<BookProperties, Object> props = new HashMap<BookProperties, Object>();
		props.put(BookProperties.Title, "Bob");
		//System.out.println(props.get("Bob"));
		assertEquals(matchingBooks, lib.searchBooksByProp(props));
	}

}
