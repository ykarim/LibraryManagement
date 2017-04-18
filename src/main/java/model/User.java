package model;

public abstract class User {

    String fname, lname, username, password;
    long id;

    public User() {

    }

    /**
     * Creates user object with randomly generated ID
     * @param username
     * @param password
     */
    public User(String username, String password){

    }

    /**
     * Creates User object with given parameters
     * @param username
     * @param password
     * @param id
     */
    public User(String username, String password, long id) {

    }

    /**
     * Creates User object with given parameters
     * @param username
     * @param password
     * @param id
     */
    public User(String fname, String lname, String username, String password, long id) {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract long generateID();
}
