package Library;

public class OOAdmin {
	//Maybe add firstname and lastname too as well as an id as they are employees.
	private String username, password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Return all of admin's properties as one string
	 * Separator between props: "</sep/>
	 * Order: Username, Password
	 * @return
	 */
	private String getString(){
		String sep = "</sep/>";
		return (this.getUsername() + sep + this.getPassword()).toString();
	}
	
	/**
	 * Give a byte array including all of admin's properties. 
	 * <br>
	 * Separator : </sep/>
	 * @return
	 */
	public byte[] getBytes(){
		return (this.getString()).getBytes();
	}
	
}
