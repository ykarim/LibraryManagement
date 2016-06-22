package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet11AcceptedAdmin extends Packet {
	private String username;
	private String password;
	
	public Packet11AcceptedAdmin(String username,String password) {
		super(11);
		this.username=username;
		this.password=password;
	}
	
	public Packet11AcceptedAdmin(byte[]data) {
		super(11);
		String[] dataArray=readData(data).split("/<>/");
		this.username=dataArray[0];
		this.password=dataArray[1];
	}


	@Override
	public void writeData(LibClient client) {
		client.sendData(getData());
	}

	@Override
	public void writeData(LibServer server) {
		server.sendDataToAllClients(getData());
	}

	@Override
	public byte[] getData() {
		// TODO Auto-generated method stub
		return ("11"+this.username+"/<>/"+this.password).getBytes();
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}

}
