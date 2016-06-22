package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet19DeleteUser extends Packet {

	public Packet19DeleteUser(byte[]data) {
		super(19);
		
	}

	@Override
	public void writeData(LibClient client) {


	}

	@Override
	public void writeData(LibServer server) {
	

	}

	@Override
	public byte[] getData() {
	
		return null;
	}

}
