package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet33BookChange extends Packet {

	private int CID;
	private String title;
	private String author;
	private String publisher;
	private int publicationYear;
	private int id;
	private int gradelevel;
	private String genre;
	private int numberavailable;
	private String condition;

	public Packet33BookChange(byte[]data) {
		super(33);
		String[]dataArray=readData(data).split("/<>/");
		this.CID=Integer.parseInt(dataArray[0]);
		this.title=(String) dataArray[1];
		this.author=(String)dataArray[2];
		this.publisher=(String)dataArray[3];
		this.publicationYear=Integer.parseInt(dataArray[4]);
		this.id=Integer.parseInt(dataArray[5]);
		this.gradelevel=Integer.parseInt(dataArray[6]);
		this.genre=(String) dataArray[7];
		this.numberavailable=Integer.parseInt(dataArray[8]);
		this.condition=(String)dataArray[9];
	}

	public Packet33BookChange(int CID,String title,String author,String publisher, int publicationYear,int id,int gradelevel,String genre,int numberavailable,String condition) {
		super(33);
		this.CID=CID;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.publicationYear=publicationYear;
		this.id=id;
		this.gradelevel=gradelevel;
		this.genre=genre;
		this.numberavailable=numberavailable;
		this.condition=condition;
	}
	
	public int getCID() {
		return CID;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public int getId() {
		return id;
	}

	public int getGradelevel() {
		return gradelevel;
	}

	public String getGenre() {
		return genre;
	}

	public int getNumberavailable() {
		return numberavailable;
	}

	public String getCondition() {
		return condition;
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
		return ("33" + this.CID + "/<>/" +this.title + "/<>/" + this.author +"/<>/" + this.publisher + "/<>/" + this.publicationYear + "/<>/" + this.id + "/<>/" + this.gradelevel
				+ "/<>/" + this.genre + "/<>/" + this.numberavailable + "/<>/" + this.condition).getBytes();
	}

}
