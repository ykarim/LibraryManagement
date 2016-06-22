package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet25UserNotExists extends Packet {

	public Packet25UserNotExists() {
		super(25);
	}

	public Packet25UserNotExists(byte[]data){
		super(25);
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
		return ("25").getBytes();
	}

}
