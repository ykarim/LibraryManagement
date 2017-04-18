package model;

public class LibAdmin extends User {

	/**
	 * Creates a new admin with following attributes 
	 * @param username
	 * @param password
	 */
	public LibAdmin(String fname, String lname, String username, String password, long id){
		this.fname = fname;
		this.lname = lname;
	    this.username = username;
		this.password = password;
		this.id = id;
	}

	public long generateID(){
		return 0L;
	}
}