package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet18DeleteBook extends Packet {

	public Packet18DeleteBook(byte[] data) {
		super(17);
		
	}

	@Override
	public void writeData(LibClient client) {

	}

	@Override
	public void writeData(LibServer server) {	

	}

	@Override
	public byte[] getData() {
		return ("17").getBytes();
	}

}
