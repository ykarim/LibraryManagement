package net.packets;

import net.LibClient;
import net.LibServer;
//this is the same as bookinfo
@Deprecated
public class Packet02AddBook extends Packet {
	String name,author,publisher,genre,condition;
	int publicationYear,gradeLevel;
	public Packet02AddBook(byte[] data) {
		super(02);
		String[] dataArray = readData(data).split("/<>/");
		this.name=dataArray[0];
		// TODO Auto-generated constructor stub
	}

	public void writeData(LibServer server) {
		// TODO Auto-generated method stub
		server.sendDataToAllClients(getData());
	}

	@Override
	public byte[] getData() {
		// TODO Auto-generated method stub
		return "02".getBytes();
	}

	@Override
	public void writeData(LibClient client) {
		// TODO Auto-generated method stub
		client.sendData(getData());
	}
	
	public String getName(){
		return name;
	}
	
	public String getAuthor(){
		return author;
	}
}
