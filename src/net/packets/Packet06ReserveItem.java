package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet06ReserveItem extends Packet {
	
	private String item;
	public Packet06ReserveItem(String item) {
		super(06);
		this.item=item;
		// TODO Auto-generated constructor stub
	}

	public Packet06ReserveItem(byte[]data) {
		super(06);
		String[]dataArray=readData(data).split("/<>/");
		item=dataArray[0];
	}

	@Override
	public void writeData(LibClient client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeData(LibServer server) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] getData() {
		// TODO Auto-generated method stub
		return ("06"+item).getBytes();
	}
	
	public String getItem(){
		return item;
	}

}
