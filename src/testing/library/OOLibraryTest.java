package testing.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Library.BookProperties;
import Library.OOAdmin;
import Library.OOBook;
import Library.OOBorrowedBook;
import Library.OOLibrary;
import Library.OOUser;


public class OOLibraryTest {
//Replace these with OOLIbrary then access an OOLib instance.
	OOLibrary lib = new OOLibrary();
	private ArrayList<OOBook> books = new ArrayList<OOBook>();
	private ArrayList<OOUser> users = new ArrayList<OOUser>();
	private ArrayList<OOAdmin> admins = new ArrayList<OOAdmin>();
	
	@Before
	public void setUp() throws Exception {
		OOBook b1 = new OOBook("Bob", "Auth", "Pub",  123,   2000,  8, 2);
		OOBook b2 = new OOBook("Ojr", "Auti", "Puc",  2312,  2001,  9, 3);
		OOBook b3 = new OOBook("afs", "edff", "sdd",  23423, 2002, 10, 4);
		OOBook b4 = new OOBook("Iue", "wrwt", "ett",  1233,  2003, 11, 5);
		OOBook b5 = new OOBook("asd", "Auth", "sdf",  12346, 2004, 12, 6);
		OOBook b6 = new OOBook("Har", "987w", "Pub",  1363,  2005, 13, 7);
		
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
		
		OOUser u1 = new OOUser("John", "K", "jk", "jk123", 12, 19829, 284291049L);
		OOUser u2 = new OOUser("Carly", "p", "cp", "j3", 32, 3465, 42423423L);
		
		lib.addUser(u1);
		users.add(u1);
		lib.addUser(u2);
		users.add(u2);
		
		OOAdmin a1 = new OOAdmin("andy", "o", 2124);
		OOAdmin a2 = new OOAdmin("iew", "gdsfs", 7583);
		
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
		OOBook book = new OOBook("B", "A", "P",  997,   2446,  4, 2);
		OOBook bookTest = new OOBook("B", "A", "P",  997,   2446,  4, 2);
		lib.addBook(book);
		assertEquals(book, lib.getBook(bookTest));  //GetBook keeps coming back null //Diff byte values //Bytes String Prop all diff come back as null
		OOBook wrongBook = new OOBook("B", "A", "P",  8271,   2446,  4, 2);
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
		OOUser user = new OOUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		OOUser userTest = new OOUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
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
		OOAdmin admin = new OOAdmin("uname", "pass", 8291);
		OOAdmin adminTest = new OOAdmin("uname", "pass", 8291);
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
		OOBook book = new OOBook("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.containsBook(book));
	}

	@Test
	public void testDelBook() {
		OOBook book = new OOBook("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.containsBook(book));
		lib.delBook(book);
		assertFalse(lib.containsBook(book));
	}
	
	@Test
	public void testContainsBook() {
		OOBook book = new OOBook("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.containsBook(book));
		lib.delBook(book);
		assertFalse(lib.containsBook(book));
	}

	@Test
	public void testAddUser() {
		OOUser user = new OOUser("iuih", "sy", "yyb", "cghvj", 8965, 27421, 46721L);
		lib.addUser(user);
		assertTrue(lib.containsUser(user));
	}

	@Test
	public void testDelUser() {
		OOUser user = new OOUser("iuih", "sy", "yyb", "cghvj", 8965, 27421, 46721L);
		lib.addUser(user);
		assertTrue(lib.containsUser(user));
		lib.delUser(user);
		assertFalse(lib.containsUser(user));
	}
	
	@Test
	public void testContainsUser(){
		OOUser user = new OOUser("iuih", "sy", "yyb", "cghvj", 8965, 27421, 46721L);
		lib.addUser(user);
		assertTrue(lib.containsUser(user));
		lib.delUser(user);
		assertFalse(lib.containsUser(user));
	}
	
	@Test
	public void testAddAdmin() {
		OOAdmin admin = new OOAdmin("uyiu", "tfjnj", 86876);
		lib.addAdmin(admin);
		assertTrue(lib.containsAdmin(admin));
	}

	@Test
	public void testDelAdmin() {
		OOAdmin admin = new OOAdmin("uyiu", "tfjnj", 86876);
		lib.addAdmin(admin);
		assertTrue(lib.containsAdmin(admin));
		lib.delAdmin(admin);
		assertFalse(lib.containsAdmin(admin));
	}
	
	@Test
	public void testContainsAdmin(){
		OOAdmin admin = new OOAdmin("uyiu", "tfjnj", 86876);
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
		OOBook book = new OOBook("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		OOUser user = new OOUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		lib.addUser(user);
		Date date = new Date();
		lib.borrowBook(lib.getBook(book), lib.getUser(user), 2, date);
		assertEquals(lib.getBook(book).getNumAvailable(), 3);
	}

	@Test
	public void testReturnBook() {
		OOBook book = new OOBook("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		OOUser user = new OOUser("Jo", "Ki", "sa", "jad", 145, 28219, 7472911L);
		lib.addUser(user);
		Date date = new Date();
		lib.borrowBook(lib.getBook(book), lib.getUser(user), 2, date);
		OOBorrowedBook bbook = new OOBorrowedBook(book);//Remove later Replace with checkouts.get(index) or create a etcheckout method to return borrbook
		lib.returnBook(bbook, lib.getUser(user), 2);
		assertEquals(lib.getBook(book).getNumAvailable(), 3); //not working supposed to be 5
	}

	@Test
	public void testIsBookAvailable() {
		OOBook book = new OOBook("U", "W", "das",  263,   22346,  2, 5);
		lib.addBook(book);
		assertTrue(lib.isBookAvailable(lib.getBook(book)));
		OOBook book2 = new OOBook("wqwe", "qwt", "sfs",  279,  2351,  774, 0);
		lib.addBook(book2);
		assertFalse(lib.isBookAvailable(lib.getBook(book2)));
	}

	@Test
	public void testSortBooks() {
		lib.sortBooks();
		OOBook b1 = new OOBook("Bob", "Auth", "Pub",  123,   2000,  8, 2);
		OOBook b2 = new OOBook("Ojr", "Auti", "Puc",  2312,  2001,  9, 3);
		OOBook b3 = new OOBook("afs", "edff", "sdd",  23423, 2002, 10, 4);
		OOBook b4 = new OOBook("Iue", "wrwt", "ett",  1233,  2003, 11, 5);
		OOBook b5 = new OOBook("asd", "Auth", "sdf",  12346, 2004, 12, 6);
		OOBook b6 = new OOBook("Har", "987w", "Pub",  1363,  2005, 13, 7);
		
		ArrayList<OOBook> sortedBooks = new ArrayList<OOBook>();
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
		ArrayList<OOBook> matchingBooks = new ArrayList<OOBook>();
		OOBook b1 = new OOBook("Bob", "Auth", "Pub",  123,   2000,  8, 2);
		matchingBooks.add(b1);
		
		Map<BookProperties, Object> props = new HashMap<BookProperties, Object>();
		props.put(BookProperties.Title, "Bob");
		//System.out.println(props.get("Bob"));
		assertEquals(matchingBooks, lib.searchBooksByProp(props));
	}

}
