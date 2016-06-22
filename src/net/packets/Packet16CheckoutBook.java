package net.packets;

import java.util.Date;

import net.LibClient;
import net.LibServer;

public class Packet16CheckoutBook extends Packet {

	private String book,user;
	private Date date;
	
	public Packet16CheckoutBook(String book,String user,Date date){
		super(16);
		this.book=book;
		this.user=user;
		this.date=date;
	}
	
	public Packet16CheckoutBook(byte[]data) {
		super(16);
		Object[]dataArray=readData(data).split("/<>/");
		this.book=(String) dataArray[0];
		this.user=(String) dataArray[1];
		this.date=(Date) dataArray[2];
	}

	public String getBook() {
		return book;
	}

	public String getUser() {
		return user;
	}

	public Date getDate() {
		return date;
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
		return ("16"+this.book+"/<>/"+this.user+"/<>/"+this.date).getBytes();
	}
	
	

}
