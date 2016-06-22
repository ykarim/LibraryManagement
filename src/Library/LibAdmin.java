package Library;

import java.net.InetAddress;

public class LibAdmin {
	public InetAddress ipAddress;
    public int port;
    private String username;
    private String password;

    public LibAdmin(String username, String password, InetAddress ipAddress, int port) {
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
