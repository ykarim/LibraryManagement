package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet13NotAccepted extends Packet {
	public int notAceeptedFromID;
	public Packet13NotAccepted() {
		super(13);
	}

	@Override
	public void writeData(LibClient client) {
		// TODO Auto-generated method stub
		client.sendData(getData());
	}

	@Override
	public void writeData(LibServer server) {
		// TODO Auto-generated method stub
		server.sendDataToAllClients(getData());
	}

	@Override
	public byte[] getData() {
		// TODO Auto-generated method stub
		return "13".getBytes();
	}

}
