package Library;

import java.net.InetAddress;

public class LibUser {
	public InetAddress ipAddress;
    public int port;
    private String username;
    private String password;

    public LibUser(String username, String password, InetAddress ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.password=password;
        this.username=username;
    }
    public String getUsername(){
    	return username;
    }
    public String getPassword(){
    	return password;
    }

}
