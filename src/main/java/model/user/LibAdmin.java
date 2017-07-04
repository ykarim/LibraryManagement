package model.user;

public class LibAdmin extends User {

	/**
	 * Creates a new admin with following attributes 
	 * @param username
	 * @param password
	 */
	public LibAdmin(String fname, String lname, String username, String password, long id){
        super(fname, lname, username, password, id);
    }

	public long generateID(){
		return 0L;
	}
}