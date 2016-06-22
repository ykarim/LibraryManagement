package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet07AddAdmin extends Packet {

	private String username;
	private String password;
	
	public Packet07AddAdmin(String username,String password) {
		super(07); 
		this.username=username;
		this.password=password;
	}
	
	public Packet07AddAdmin(byte[]data) {
		super(07);
		String[]dataArray=readData(data).split("/<>/");
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
		return ("07" + this.username + "/<>/" + this.password).getBytes();
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}

}
