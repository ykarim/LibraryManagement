package Library;

public class EditUserProps {
	public static void changeFirstName(int id,String name){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.firstName.set(index,name);
		}
	}
	public static void changeLastName(int id,String name){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.lastName.set(index,name);
		}
	}
	public static void changeUsername(int id,String name){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.usernames.set(index,name);
		}
	}
	public static void changePassword(int id,String pass){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.passwords.set(index,pass);
		}
	}
	public static void changeage(int id,int age){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.age.set(index,age);
		}
	}
	public static void changeID(int id,int newID){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.idList.set(index,newID);
		}
	}
	public static void changeCardNumber(int id,int num){
		if(Users.idList.contains(id)){
			int index=Users.idList.indexOf(id);
			Users.cardNumber.set(index,num);
		}
	}
	public static void changeAdminPass(String username,String pass){
		if(Users.admins.contains(username.trim())){
			int index=Users.admins.indexOf(username);
			Users.adminPasswords.set(index,pass);
		}
	}	
}
