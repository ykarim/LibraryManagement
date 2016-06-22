package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet20AdminAlreadyExists extends Packet {

	public Packet20AdminAlreadyExists(byte[]data) {
		super(20);
	}

	public Packet20AdminAlreadyExists() {
		super(20);
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
		return ("20").getBytes();
	}

}
