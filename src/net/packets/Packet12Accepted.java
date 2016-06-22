package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet12Accepted extends Packet {

	int index=-1;
	public Packet12Accepted(int index) {
		super(12);
		this.index=index;
		// TODO Auto-generated constructor stub
	}
	
	public Packet12Accepted(byte[]data){
		super(12);
		String[] dataArray = readData(data).split("/<>/");
        this.index = new Integer(dataArray[0]);
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
		return ("12"+this.index).getBytes();
	}
	
	public int getIndex(){
		return index;
	}
}
