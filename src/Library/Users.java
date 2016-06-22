package Library;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Users {
	public static ArrayList<String>adminPasswords=new ArrayList<String>();
	public static ArrayList<String>admins=new ArrayList<String>();
	public static ArrayList<Integer> age=new ArrayList<Integer>();
	public static ArrayList<Double> balance=new ArrayList<Double>();
	public static ArrayList<Integer>cardNumber=new ArrayList<Integer>();
	public static double charge=0.0;
	public static ArrayList<ArrayList<String>> checkouts=new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<Date>> days=new ArrayList<ArrayList<Date>>();
	public static ArrayList<String> firstName=new ArrayList<String>();
	public static ArrayList<Integer> idList=new ArrayList<Integer>();
	public static ArrayList<String> lastName=new ArrayList<String>();
	public static ArrayList<Boolean> logged=new ArrayList<Boolean>();
	public static ArrayList<Boolean> loggedAdmin=new ArrayList<Boolean>();
	public static ArrayList<String> passwords=new ArrayList<String>();
	public static ArrayList<ArrayList<String>> reserves=new ArrayList<ArrayList<String>>();
	public static ArrayList<String>searchfirstname=new ArrayList<String>();
	public static ArrayList<String>searchlastname=new ArrayList<String>();
	public static ArrayList<String>searchUser=new ArrayList<String>();
	public static ArrayList<String>usercheckouts=new ArrayList<String>();
	public static ArrayList<String> usernames=new ArrayList<String>();
	
	public static void addAdmin(String name,String password){
		if(admins.contains(name) && adminPasswords.contains(passwords)){
			System.out.println("Admin already exists.");
		}else{
			admins.add(name);
			final int index=admins.indexOf(name);
			adminPasswords.add(index,password);
			loggedAdmin.add(index,false);
		}
	}
	public  static void addUser(String firstName,String lastName,String username,String password,int age,int id,int cardNumber){
		if(Users.usernames.contains(username)&&Users.passwords.contains(password)&&Users.idList.contains(id)&&Users.cardNumber.contains(cardNumber)==true){
			System.out.println("User already exists"); 
		}else{
			firstName=capitalizeString(firstName);
			lastName=capitalizeString(lastName);
			Users.firstName.add(firstName);
			final int index=Users.firstName.indexOf(firstName);
			Users.lastName.add(index,lastName);
			Users.cardNumber.add(index,cardNumber);
			Users.age.add(index,age);
			usernames.add(index,username);
			passwords.add(index,password);
			idList.add(index,id);
			balance.add(index,0.0);
			logged.add(index,false);
			final ArrayList<String>empty=new ArrayList<String>();
			final ArrayList<Date>empty2=new ArrayList<Date>();
			days.add(index, empty2);
			reserves.add(index,empty);
			checkouts.add(index,empty);
		}
	}
	public static String capitalizeString(String string) {
		  final char[] chars = string.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) {
		    if (!found && Character.isLetter(chars[i])) {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { 
		      found = false;
		    }
		  }
		  return String.valueOf(chars);
	}
	public static void deleteAdmin(String username){
		if(Users.admins.contains(username)){
			Users.admins.remove(username);
		}else{
			System.out.print("User doesn't exist.");
		}
	}
	public static void deleteAllUsersInfo(){
		admins.clear();
		adminPasswords.clear();
		usernames.clear();
		passwords.clear();
		idList.clear();
		age.clear();
		cardNumber.clear();
		checkouts.clear();
		firstName.clear();
		lastName.clear();
		balance.clear();
		charge=0.0;
		days.clear();
		usercheckouts.clear();
		logged.clear();
		loggedAdmin.clear();
		reserves.clear();
	}
	//add more
	public static void deleteUser(int id,String username){
		final int index=cardNumber.indexOf(id);
		usernames.remove(index);
		reserves.remove(index);
		passwords.remove(index);
		age.remove(index);
		checkouts.remove(index);
		firstName.remove(index);
		lastName.remove(index);
		balance.remove(index);
		days.remove(index);
		usercheckouts.remove(index);
		cardNumber.remove(index);
	}
	public static int isLate(int userID) throws ParseException{
		final int index=Users.idList.indexOf(userID);
		final ArrayList<Date>day=Users.days.get(index);
		final Date dateToday = new Date();
		for(final int x=0;x<day.size();){
			final Date bookDay=day.get(x);
			return bookDay.compareTo(dateToday);
		}
		return 0;
		
	}
	
	public static boolean login(String username,String password){
		username=username.trim();
		if(usernames.contains(username)){
			final int index=usernames.indexOf(username);
			if(passwords.get(index).trim().compareTo(password)==0){
				logged.set(index, true);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static boolean loginAdmin(String username,String password){
		username=username.trim();
		if(admins.contains(username)){
			final int index=admins.indexOf(username);
			if(adminPasswords.get(index).trim().compareTo(password)==0){
				loggedAdmin.set(index, true);
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	public static void logout(String username){
		if(Users.usernames.indexOf(username)!=-1){
			final int index=usernames.indexOf(username);
			logged.set(index,false);
		}else{
			final int index=Users.admins.indexOf(username);
			loggedAdmin.set(index,false);
		}
	}
	public static void returnBook(String book,int userID){
		final int index=Book.libraryBooks.indexOf(book);
		final int indexUser=Users.idList.indexOf(userID);
		final ArrayList<String> newcheck=checkouts.get(indexUser);
		try {
			if(isLate(userID)!=0){
				Double money=Users.balance.get(indexUser);
				try {
					money+=Users.charge*isLate(userID);
				} catch (final ParseException e) {
					e.printStackTrace();
				}
				newcheck.remove(book);
				int bookCount=Book.numberAvailable.get(index);
				bookCount=bookCount-1;
				Book.numberAvailable.set(index, bookCount);
				Users.checkouts.set(indexUser,newcheck);
			}else{
				newcheck.remove(book);
				Users.checkouts.set(indexUser,newcheck);
			}
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void search(String str){
		for(int x=0;x<Users.usernames.size();x++){
			final String user=Users.usernames.get(x);
			if(user.toLowerCase().contains(str.toLowerCase())){
				Users.searchUser.add(user);
				final int index=Users.usernames.indexOf(user);
				final String firstName=Users.firstName.get(index);
				final String lastName=Users.lastName.get(index);
				Users.searchfirstname.add(firstName);
				Users.searchlastname.add(lastName);
			}
		}
	}
	public static void setFee(double fee){
		Users.charge=fee;
	}
	public static void takeBook(String book,String user,Date d){
		if(checkouts.contains(book)){
			System.out.println("Book already exists in checkouts");
		}else{
			if(Book.libraryBooks.contains(book.trim())){
				final int bookIndex=Book.libraryBooks.indexOf(book.trim());
				final int numAvailable=Book.numberAvailable.get(bookIndex)-1;
				if(Book.numberAvailable.get(bookIndex)>0){
					final int index=Users.usernames.indexOf(user);
					ArrayList<String> checkout=new ArrayList<String>();
					if(checkouts.get(index).isEmpty()||checkouts.isEmpty()){
						
					}else{
						checkout=checkouts.get(index);

					}
					checkout.add(book);
					checkouts.set(index,checkout);
					Book.numberAvailable.set(bookIndex,numAvailable);
					final ArrayList<Date> day=days.get(index);
					day.add(d);
					//Below line might not function idk
					days.set(index, day);
					
					
				}
			}
		}
	}
	
	public void extendDays(int daysToKeep){
		
	}
	
	public void logoutAll(){
		for(int count=0;count<Users.loggedAdmin.size();count++){
			Users.loggedAdmin.set(count, false);
		}
		for(int count=0;count<Users.logged.size();count++){
			Users.logged.set(count, false);
		}
	}

	public void payBalance(String user,double money){
		final int index=Users.usernames.indexOf(user);
		if(money>0&&Users.balance.get(index)>0){
			final double current=Users.balance.get(index);
			if(Users.balance.get(index)-money>=0){
				Users.balance.set(index,current-money);
			}
		}
	}
	public void reserveBook(String user, String book){
		if(Book.libraryBooks.contains(book)){
			if(Users.reserves.contains(book)){
				JOptionPane.showMessageDialog(null,"Book is already reserved");
			}else{
				for(int i=0;i<Users.reserves.size();i++){
					final ArrayList<String>res=Users.reserves.get(i);
					if(res.contains(book)){
						JOptionPane.showMessageDialog(null,"Book is already reserved by someone else. Please try again later.");
					}else{
						final int index=Users.usernames.indexOf(user);
						if(Users.usernames.contains(user)){
							if(Users.reserves.get(index).isEmpty()){
								reserves.get(index).add(book);
							}
						}
					}
				}
			}
		}
	}
	public void toString(int id,int cardNumber){
		if(idList.contains(id)){
			final int index=idList.indexOf(id);
			System.out.println(firstName.get(index)+lastName.get(index));
			System.out.println(usernames.get(index));
			System.out.println(passwords.get(index));
			System.out.println(age.get(index));
			System.out.println(Users.cardNumber.get(index));
			System.out.println(checkouts.get(index));
			System.out.println(balance);
		} 
	}
}
