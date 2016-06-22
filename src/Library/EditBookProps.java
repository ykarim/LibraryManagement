package Library;

public class EditBookProps {
	public static void changeAuthor(int ID,String author,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.authors.set(index,author);
		}
	}
	public static void changePublisher(int ID,String publisher,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.publishers.set(index,publisher);
		}
	}
	public static void changePublishedYear(int ID,int year,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.publicationYears.set(index,year);
		}
	}
	public static void changeGenre(int ID,String genre,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.genre.set(index,genre);
		}
	}
	public static void changeGradeLevel(int ID,int number,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.gradeLevels.set(index,number);
		}
	}
	public static void changeID(int currentID,int newID,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
		int index=Book.id.indexOf(currentID);
		Book.id.set(index,newID);
		}
	}
	public static void changeOwners(String name,String owner,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.libraryBooks.indexOf(name);
			Book.owners.set(index,owner);
		}
	}
	public static void changeName(int ID,String newName,String username){
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			Book.libraryBooks.set(Book.id.indexOf(ID),newName);
		}
	}
	public static void changeNumberAvailable(int ID,int numberAvailable,String username) {
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.numberAvailable.set(index,numberAvailable);
		}
	}
	public static void changeCondition(int ID,String condition,String username) {
		int indexforAdmin=Users.admins.indexOf(username);
		if(Users.loggedAdmin.get(indexforAdmin)){
			int index=Book.id.indexOf(ID);
			Book.condition.set(index,condition);
		}
	}
}
