package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet15CheckinBook extends Packet {
	private int id;
	private String book;
	

	public Packet15CheckinBook(String book, int id) {
		super(15);
		this.book=book;
		this.id=id;
	}
	
	public Packet15CheckinBook(byte[]data) {
		super(15);
		String[]dataArray=readData(data).split("/<>/");
		this.book=dataArray[0];
		this.id=Integer.parseInt(dataArray[1]);
	}

	public int getID() {
		return id;
	}


	public String getBook() {
		return book;
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
		return ("15"+this.book+"/<>/"+this.id).getBytes();
	}

}
