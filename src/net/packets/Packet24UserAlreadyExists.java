package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet24UserAlreadyExists extends Packet {

	public Packet24UserAlreadyExists() {
		super(24);
	}

	public Packet24UserAlreadyExists(byte[]data) {
		super(24);
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
		return ("24").getBytes();
	}

}
