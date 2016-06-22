package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet21AdminNotExists extends Packet {

	public Packet21AdminNotExists(byte[]data) {
		super(21);
	}

	public Packet21AdminNotExists() {
		super(21);
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
		return ("21").getBytes();
	}

}
