package Library;

public class OOAdmin {
	//Maybe add firstname and lastname too as well as an id as they are employees.
	private String username, password;
	private int id;

	/**
	 * Creates a new admin with following attributes 
	 * @param username
	 * @param password
	 */
	public OOAdmin(String username, String password, int id){
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
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
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Return all of admin's properties as one string
	 * Separator between props: "</sep/>
	 * Order: Username, Password, ID
	 * @return
	 */
	private String getString(){
		String sep = "</sep/>";
		return (this.getUsername() + sep + this.getPassword() + sep + id).toString();
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
	
	/**
	 * Returns hashCode
	 * @return hashCode
	 */
	@Override
	public int hashCode(){
		return id;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof OOAdmin){
			if(obj.hashCode() == this.hashCode()){
				return true;
			}else{
				return false;
			}
		}else{
			return (super.equals(obj));
		}
	}
	
}
