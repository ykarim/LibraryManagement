package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet17DeleteAdmin extends Packet {
	
	private String name;
	
	public Packet17DeleteAdmin(byte[]data) {
		super(17);
		String[]dataArray=readData(data).split("/<>/");
		this.name=dataArray[0];
	}
	
	public Packet17DeleteAdmin(String name){
		super(17);
		this.name=name;
	}

	@Override
	public void writeData(LibClient client) {
		client.sendData(getData());
	}

	@Override
	public void writeData(LibServer server) {
		server.sendDataToAllClients(getData());
	}

	public String getName() {
		return name;
	}

	@Override
	public byte[] getData() {
		
		return ("17"+this.name).getBytes();
	}

}
