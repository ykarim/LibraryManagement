package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet22BookAlreadyExists extends Packet {

	public Packet22BookAlreadyExists() {
		super(22);
	}
	
	public Packet22BookAlreadyExists(byte[]data){
		super(22);
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
		return ("22").getBytes();
	}

}
