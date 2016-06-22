package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet00Login extends Packet {

	private String username;
	private String password;
    
    public Packet00Login(byte[] data) {
        super(00);
        String[] dataArray = readData(data).split("/<>/");
        this.username = dataArray[0];
        this.password = dataArray[1];
    }

	public Packet00Login(String username2, String password2) {
		super(00);
		this.username=username2;
		this.password=password2;
		
	}

	public byte[] getData() {
        return ("00" + this.username +  "/<>/" + this.password).getBytes();
    }

    public String getUsername() {
        return username;
    }


	@Override
	public void writeData(LibClient client) {
		client.sendData(getData());
	}


	@Override
	public void writeData(LibServer server) {
		server.sendDataToAllClients(getData());
		
	}


	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}




}
