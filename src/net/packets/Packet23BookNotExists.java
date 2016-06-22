package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet23BookNotExists extends Packet {

	public Packet23BookNotExists() {
		super(23);
	}
	
	public Packet23BookNotExists(byte[]data){
		super(23);
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
		return ("23").getBytes();
	}

}
