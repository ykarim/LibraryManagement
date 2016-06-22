package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import Library.Book;
import Library.Users;
//FIX
public class Import_Export {
	static OutputStream outputBook = null;
	static OutputStream outputUser = null;
	public static void readSettings(){
		final Properties prop = new Properties();
		final File input1=new File(System.getProperty("user.home")+"/configUser.lib");
		InputStream input = null;
		try {
			input = new FileInputStream(System.getProperty("user.home")+"/configUser.lib");
		} catch (final FileNotFoundException e1) {
			// TODO Auto-generated catch block
			MakeAdmin.main();
		}
		if(input1.exists()){
			try {
				prop.load(input);
				if(prop.getProperty("FirstTime").compareTo("false")==0){
					for(int count=0;count<Integer.parseInt(prop.getProperty("NumberAdmins"));count++){
						final String pass=prop.getProperty("AdminPass"+count).trim();
						final String name=prop.getProperty("AdminName"+count).trim();
						Users.addAdmin(name,pass);
					}
					if(prop.getProperty("UserCount")==null||prop.getProperty("UserCount")==Integer.toString(0)){
						
					}else{
						for(int count=0;count<Integer.parseInt(prop.getProperty("UserCount"));count++){
							final String username=prop.getProperty("Username"+count).trim();
							final String firstName=prop.getProperty("FirstName"+count).trim();
							final String lastName=prop.getProperty("LastName"+count).trim();
							final String password=prop.getProperty("Pasword"+count).trim();
							final String age=prop.getProperty("Age"+count).trim();						
							final String id=prop.getProperty("ID"+count).trim();
							final String cardNumber=prop.getProperty("CardNumber"+count).trim();
							final String charge=prop.getProperty("Charge"+count).trim();
							Users.addUser(firstName, lastName, username, password, Integer.parseInt(age), Integer.parseInt(id), Integer.parseInt(cardNumber));
							Users.setFee(Double.parseDouble(charge));				
						}
						
					}
					input=new FileInputStream(System.getProperty("user.home")+"/configBook.lib");
					prop.load(input);
					if(prop.getProperty("NUM")==null||prop.getProperty("NUM")=="0"){
						
					}else{
						for(int count=0;count<Integer.parseInt(prop.getProperty("NUM"));count++){
							final String title=prop.getProperty("Title"+count).trim();
							final String author=prop.getProperty("Author"+count).trim();
							final String publisher=prop.getProperty("Publisher"+count).trim();
							final int publishedYear=Integer.parseInt(prop.getProperty("Published Year"+count).trim());
							final int Grade=Integer.parseInt(prop.getProperty("GradeLvl"+count));
							final int numAvailable=Integer.parseInt(prop.getProperty("NumAvailable"+count));
							final String genre=prop.getProperty("Genre"+count);
							final int ID=Integer.parseInt(prop.getProperty("ID"+count));
							final String condition=prop.getProperty("Condition"+count);
							Book.add(title, author, publisher, publishedYear, ID, Grade, genre, numAvailable, condition);
						}	
					}
				}else {
					MakeAdmin.main();
				}
		} catch (final IOException ex) {
			System.out.println("Program is Starting For First Time.");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		}
	}
	@SuppressWarnings("unused")
	public static void saveBookSetting(){
		if(/*LoginPage.erased*/false){

		}else{
			final Properties prop = new Properties();
				try {
					outputBook = new FileOutputStream(System.getProperty("user.home")+"/configBook.lib");
				} catch (final FileNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					for(int count=0;count<Book.libraryBooks.size();count++){
						prop.setProperty("NUM",Integer.toString(Book.libraryBooks.size()));
						prop.setProperty("Title"+count,Book.libraryBooks.get(count));
						prop.setProperty("Author"+count,Book.authors.get(count));
						prop.setProperty("Publisher"+count,Book.publishers.get(count));
						prop.setProperty("Published Year"+count,Integer.toString(Book.publicationYears.get(count)));
						prop.setProperty("GradeLvl"+count,Integer.toString(Book.gradeLevels.get(count)));
						prop.setProperty("NumAvailable"+count,Integer.toString(Book.numberAvailable.get(count)));
						prop.setProperty("Genre"+count,Book.genre.get(count));
						prop.setProperty("ID"+count, Integer.toString(Book.id.get(count)));
						prop.setProperty("Condition"+count,Book.condition.get(count));
						//prop.setProperty("Owner", value)
					}
					prop.store(outputBook, null);
				} catch (final IOException io) {
					io.printStackTrace();
				} finally {
					if (outputBook != null) {
						try {
							outputBook.close();
						} catch ( IOException e) {
							e.printStackTrace();
						}
					}
	 
				}
		}
	}

	@SuppressWarnings("unused")
	public static void saveUserSettings(){
		if(/*LoginPage.erased*/false){

		}else{
			final Properties prop = new Properties();
			try {
				outputUser = new FileOutputStream(System.getProperty("user.home")+"/configUser.lib");
			} catch (final FileNotFoundException e1) {
				// TODO Auto-generated catch block		
				e1.printStackTrace();
			};	 
			try {
				prop.setProperty("FirstTime", "false");
				for(int count=0;count<Users.admins.size();count++){
					prop.setProperty("NumberAdmins",Integer.toString(Users.admins.size()));
					prop.setProperty("AdminName"+count,Users.admins.get(count));
					prop.setProperty("AdminPass"+count,Users.adminPasswords.get(count));
				
				}
				for(int count=0;count<Users.usernames.size();count++){
					prop.setProperty("UserCount",Integer.toString(Users.cardNumber.size()));
					prop.setProperty("Username"+count,Users.usernames.get(count));
					prop.setProperty("FirstName"+count,Users.firstName.get(count));
					prop.setProperty("LastName"+count,Users.lastName.get(count));
					prop.setProperty("Pasword"+count,Users.passwords.get(count));
					prop.setProperty("Age"+count,Users.age.get(count).toString());
					prop.setProperty("ID"+count,Users.idList.get(count).toString());
					prop.setProperty("CardNumber"+count,Users.cardNumber.get(count).toString());
					prop.setProperty("Balance"+count,Users.balance.get(count).toString());
					prop.setProperty("Charge"+count,Double.toString(Users.charge));
					final ArrayList<String>res=Users.reserves.get(count);
					for(int j=0;j<res.size();j++){
						prop.setProperty("Reserves"+count,res.get(j));		
					}
				}
				prop.store(outputUser, null);
	 
			} catch (final IOException io) {
				io.printStackTrace();
			} finally {
				if (outputUser != null) {
					try {
						outputUser.close();
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
			
			}
		}
	}
}
