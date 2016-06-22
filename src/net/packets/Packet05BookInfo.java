package net.packets;

import net.LibClient;
import net.LibServer;

public class Packet05BookInfo extends Packet {
	
	//send the whole library book by book to user using a for loop
	//send an end of book list once done and have it be received by server. Action when received: login 
	private String title;
	private String author;
	private String publisher;
	private int publicationYear;
	private int id;
	private int gradelevel;
	private String genre;
	private int numberavailable;
	private String condition;
	
	public Packet05BookInfo(String title,String author,String publisher, int publicationYear,int id,int gradelevel,String genre,int numberavailable,String condition) {
		super(05);
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

	public Packet05BookInfo(byte[]data){
		super(05);
		String[]dataArray=readData(data).split("/<>/");
		this.title=(String) dataArray[0];
		this.author=(String)dataArray[1];
		this.publisher=(String)dataArray[2];
		this.publicationYear=Integer.parseInt(dataArray[3]);
		this.id=Integer.parseInt(dataArray[4]);
		this.gradelevel=Integer.parseInt(dataArray[5]);
		this.genre=(String) dataArray[6];
		this.numberavailable=Integer.parseInt(dataArray[7]);
		this.condition=(String)dataArray[8];
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
		return ("05"+this.title + "/<>/" + this.author +"/<>/" + this.publisher + "/<>/" + this.publicationYear + "/<>/" + this.id + "/<>/" + this.gradelevel
				+ "/<>/" + this.genre + "/<>/" + this.numberavailable + "/<>/" + this.condition).getBytes();
	}

	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public int getPublicationYear(){
		return publicationYear;
	}
	
	public int getID(){
		return id;
	}
	
	public int getGradeLevel(){
		return gradelevel;
	}
	
	public String getGenre(){
		return genre;
	}
	
	public int getNumberAvailable(){
		return numberavailable;
	}
	
	public String getCondition(){
		return condition;
	}
}
